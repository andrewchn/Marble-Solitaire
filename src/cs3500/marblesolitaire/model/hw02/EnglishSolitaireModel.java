package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.AbstractMSModel;

/**
 * Represents the model for the English Solitaire Game.
 */
public class EnglishSolitaireModel extends AbstractMSModel {

  /**
   * intiallizes ES game w armthickness of 3 and empty space at (3,3).
   */
  public EnglishSolitaireModel() {
    super();
  }

  /**
   * Takes in row and column value of empty square, generates
   * ES game with arm thickness of 3 and empty at that loc.
   *
   * @param sRow represents empty squares row val.
   * @param sCol represents empty squares col val.
   * @throws IllegalArgumentException if values are invalid.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
  }

  /**
   * Generates ES game w empty in center and given arm thickness.
   *
   * @param armThickness arm thickness of board.
   * @throws IllegalArgumentException if arm thickness is not pos odd num.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness);
  }

  /**
   * Generates ES game w given arm thickness and given empty space.
   *
   * @param armThickness arm thickness of board.
   * @param sRow         row val of empty.
   * @param sCol         col val of empty.
   * @throws IllegalArgumentException if arm thickness not odd or row and col values invalid.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  @Override
  protected boolean onBoard(int row, int col) {
    return !((row < armThickness - 1 && col < armThickness - 1)
            || (row < armThickness - 1 && col > this.size - armThickness)
            || (row > this.size - armThickness && col < armThickness - 1)
            || (row > this.size - armThickness && col > this.size - armThickness));
  }


}
