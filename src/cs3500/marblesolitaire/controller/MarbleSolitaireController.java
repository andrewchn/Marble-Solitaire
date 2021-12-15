package cs3500.marblesolitaire.controller;

/**
 * this interface represents the controller for a game of Marble Solitaire. It
 * reads in the user input, passes it to the model, and calls the view to
 * display the output as well.
 */
public interface MarbleSolitaireController {

  /**
   * This method should play a new game of Marble Solitaire.
   * It should throw an IllegalStateException only if the controller is unable
   * to successfully read input or transmit output.
   * Exceptions should be documented as per standard Javadoc requirements and formatting.
   * The nature of input/output will be an implementation detail.
   *
   * @throws IllegalStateException if failed to display board.
   */
  void playGame() throws IllegalStateException;
}
