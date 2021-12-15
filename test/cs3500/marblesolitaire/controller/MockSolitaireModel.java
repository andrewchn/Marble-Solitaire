package cs3500.marblesolitaire.controller;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * Represents a mock MS model for testing purposes only.
 */
class MockSolitaireModel implements MarbleSolitaireModel {
  Appendable mockLog;
  Boolean gameOver;
  int size;

  /**
   * creates mock model.
   * @param mockLog logs inputs from controller.
   * @param gameOver whether or not isGameover returns true.
   */
  public MockSolitaireModel(StringBuilder mockLog, Boolean gameOver, int size) {
    this.mockLog = mockLog;
    this.gameOver = gameOver;
    this.size = size;
  }

  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    try {
      mockLog.append("fromRow: " + fromRow + " fromCol: "
              +  fromCol + " toRow: " + toRow + " toCol: " + toCol + " ");
    } catch (IOException i) {
      System.out.print("unable to append to mock log.");
    }

    if (fromRow == 101) {
      throw new IllegalArgumentException("Mock Model \'invalid input\'");
    }
  }

  @Override
  public boolean isGameOver() {
    return gameOver;
  }

  @Override
  public int getBoardSize() {
    return this.size;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    return null;
  }

  @Override
  public int getScore() {
    return 1;
  }
}
