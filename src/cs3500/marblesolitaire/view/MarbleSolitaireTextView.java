package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents Marble solitaire board with text.
 */
public class MarbleSolitaireTextView extends AbstractTextView {

  /**
   * takes in state, initializes if valid, throws error if null.
   *
   * @param state state of marble game.
   * @throws IllegalArgumentException if state is null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state) throws IllegalArgumentException {
    super(state);
  }

  /**
   * takes in state, initializes if valid, throws error if null.
   *
   * @param state state of marble game.
   * @throws IllegalArgumentException if state is null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState state, Appendable appendable)
          throws IllegalArgumentException {
    super(state, appendable);
  }

  /**
   * Converts board to string.
   *
   * @return string representing Marble board.
   */
  public String toString() {
    String stringSoFar = "";
    int size = this.state.getBoardSize();

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        MarbleSolitaireModelState.SlotState currentSlot = this.state.getSlotAt(i, j);

        if (currentSlot == MarbleSolitaireModelState.SlotState.Marble) {
          stringSoFar = stringSoFar + ("O");

          if (j < size - 1) {
            MarbleSolitaireModelState.SlotState nextSlot = this.state.getSlotAt(i, j + 1);

            if (nextSlot == MarbleSolitaireModelState.SlotState.Invalid) {
              break;
            } else {
              stringSoFar = stringSoFar + " ";
            }
          }

        } else if (currentSlot == MarbleSolitaireModelState.SlotState.Empty) {
          stringSoFar = stringSoFar + "_";
          if (j < size - 1) {
            MarbleSolitaireModelState.SlotState nextSlot = this.state.getSlotAt(i, j + 1);

            if (nextSlot == MarbleSolitaireModelState.SlotState.Invalid) {
              break;
            } else {
              stringSoFar = stringSoFar + " ";
            }
          }

        } else {
          stringSoFar = stringSoFar + "  ";
        }

      }

      if (i < size - 1) {
        stringSoFar = stringSoFar + "\n";
      }
    }
    return stringSoFar;

  }

}

