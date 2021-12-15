package cs3500.marblesolitaire.view;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

/**
 * view for displaying a triangle solitaire board.
 */
public class TriangleSolitaireTextView extends AbstractTextView {

  /**
   * default constructor takes in a triangle solitaire model, sets appendable to be System.out.
   * @param state triangle solitaire model to be displayed.
   * @throws IllegalArgumentException if not passed triangle solitaire model.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state)
          throws IllegalArgumentException {
    super(state);

    if (!(state instanceof TriangleSolitaireModel)) {
      throw new IllegalArgumentException("Triangle Text view can only display triangle boards.");
    }
  }

  /**
   * default constructor takes in a triangle solitaire model, sets appendable to be System.out.
   * @param state triangle solitaire model to be displayed.
   * @param appendable appendable to be used.
   * @throws IllegalArgumentException if not passed triangle solitaire model, or if either params
   *     are null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState state, Appendable appendable)
          throws IllegalArgumentException {
    super(state, appendable);
    if (!(state instanceof TriangleSolitaireModel)) {
      throw new IllegalArgumentException("Triangle Text view can only display triangle boards.");
    }
  }

  /**
   * overrides to string to draw a symmetrical triangle board.
   * @return string representing triangle board.
   */
  @Override
  public String toString() {
    String stringSoFar = "";
    int size = this.state.getBoardSize();
    //counts number of values on each row
    int counter = 1;

    for (int i = 0; i < size; i++) {
      for (int empty = 0; empty < size - counter; empty++) {
        stringSoFar = stringSoFar + " ";
      }

      for (int j = 0; j < counter; j++) {
        MarbleSolitaireModelState.SlotState currentSlot = this.state.getSlotAt(i, j);
        if (currentSlot == MarbleSolitaireModelState.SlotState.Marble) {
          stringSoFar = stringSoFar + "O";
        } else {
          stringSoFar = stringSoFar + "_";
        }

        if (j != counter - 1) {
          stringSoFar = stringSoFar + " ";
        }
      }

      if (i != size - 1) {
        stringSoFar = stringSoFar + "\n";
      }

      counter++;
    }
    return stringSoFar;
  }

}
