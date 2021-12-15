package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.AbstractMSModel;

/**
 * represents the model for a european solitaire game.
 */
public class EuropeanSolitaireModel extends AbstractMSModel {

  /**
   * creates default euro solitaire board with armthickness of 3.
   */
  public EuropeanSolitaireModel() {
    super();
  }

  /**
   * creates euro solitaire board with given arm thickness.
   * @param armThickness armthickness
   * @throws IllegalArgumentException if armthickness not positive odd num.
   */
  public EuropeanSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness);
  }

  /**
   * represents european solitaire game with given start pt and armthickness
   * of 3.
   * @param sRow start row numb.
   * @param sCol start col numb.
   * @throws IllegalArgumentException if start position is not on the board.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(sRow, sCol);
  }

  /**
   * represents a euro solitaire board with given armthickness and start position.
   * @param armThickness armthickness size.
   * @param sRow start row numb.
   * @param sCol start col numb.
   * @throws IllegalArgumentException if armthickness not positive odd num or
   *     start position is invalid.
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  @Override
  protected boolean onBoard(int row, int col) {
    return !(row < this.armThickness && ((col < this.armThickness - row - 1)
            || (col > this.armThickness + this.armThickness - 2 + row))
            || (row > this.armThickness + this.armThickness - 2)
            && ((col < row - (this.armThickness + this.armThickness - 2))
            || (col > this.armThickness + this.armThickness - 2 + this.size - row - 1)));
  }

}
