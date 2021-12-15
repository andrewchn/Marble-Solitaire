package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * abstract text view with given renderboard and rendermessage functions
 * for passing board to apendable.
 */
public abstract class AbstractTextView implements MarbleSolitaireView {

  protected final MarbleSolitaireModelState state;
  protected final Appendable appendable;

  /**
   * takes in state, initializes if valid, throws error if null.
   *
   * @param state state of marble game.
   * @throws IllegalArgumentException if state is null.
   */
  public AbstractTextView(MarbleSolitaireModelState state) throws IllegalArgumentException {

    if (state == null) {
      throw new IllegalArgumentException("Text view cannot display null MS Model State.");
    }

    this.state = state;
    this.appendable = System.out;
  }

  /**
   * takes in state, initializes if valid, throws error if null.
   *
   * @param state state of marble game.
   * @throws IllegalArgumentException if state is null.
   */
  public AbstractTextView(MarbleSolitaireModelState state, Appendable appendable)
          throws IllegalArgumentException {

    if (state == null || appendable == null) {
      throw new IllegalArgumentException("Fields cannot be null.");
    }

    this.state = state;
    this.appendable = appendable;
  }

  /**
   * renders the board from to string and adds it to the appendable field.
   * @throws IOException if unable to transmit board.
   */
  @Override
  public void renderBoard() throws IOException {
    this.appendable.append(this.toString() + "\n");
  }

  /**
   * addes a message to the appendable field.
   * @param message the message to be transmitted.
   * @throws IOException if unable to transmit message.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    this.appendable.append(message);
  }

}
