package cs3500.marblesolitaire.model;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * abstracts out functions and constructors from english and european solitaire due to
 * much code duplication.
 * represents some kind of marble solitaire with a square board.
 */
public abstract class AbstractMSModel implements MarbleSolitaireModel {

  protected int armThickness;
  protected int sRow;
  protected int sCol;
  protected SlotState[][] board;
  protected int size;

  /**
   * intiallizes Abstract Solitaire game w armthickness of 3 and empty space at (3,3).
   */
  public AbstractMSModel() {
    this.armThickness = 3;
    this.sRow = 3;
    this.sCol = 3;

    this.size = this.getBoardSize();
    this.board = new SlotState[this.size][this.size];
    this.initiateBoard();
  }

  /**
   * Generates Abstract Solitaire Model w empty in center and given arm thickness.
   *
   * @param armThickness arm thickness of board.
   * @throws IllegalArgumentException if arm thickness is not pos odd num.
   */
  public AbstractMSModel(int armThickness) throws IllegalArgumentException {
    if (armThickness % 2 == 0 || armThickness < 0) {
      throw new IllegalArgumentException("Arm thickness cannot be even or negative");
    }
    this.armThickness = armThickness;
    int center = this.armThickness / 2 + this.armThickness - 1;
    this.sRow = center;
    this.sCol = center;

    this.size = this.getBoardSize();
    this.board = new SlotState[this.size][this.size];
    this.initiateBoard();
  }

  /**
   * initializes Abstract Solitaire Model with given start space. throws
   * new Illegal arg exception if the start space coordinates are not on the gameboard.
   *
   * @param sRow start row.
   * @param sCol start col.
   * @throws IllegalArgumentException if the start coordinates are invalid.
   */
  public AbstractMSModel(int sRow, int sCol) throws IllegalArgumentException {

    this.armThickness = 3;
    this.size = this.getBoardSize();

    if (this.outsideOfBox(sRow, sCol) || !this.onBoard(sRow, sCol)) {
      String error = String.format("Invalid empty cell position (%1$s,%2$s)", sRow, sCol);
      throw new IllegalArgumentException(error);
    }

    this.sRow = sRow;
    this.sCol = sCol;

    this.board = new SlotState[this.size][this.size];
    this.initiateBoard();
  }

  /**
   * initializes Abstract Solitaire Model with given armthickness and given
   * start position. Throws exception if armthickness not positive odd num, or if start space
   * is not on the game board.
   *
   * @param armThickness armthickness.
   * @param sRow         start row val.
   * @param sCol         start col val.
   * @throws IllegalArgumentException if armthickness or start position is invalid.
   */
  public AbstractMSModel(int armThickness, int sRow, int sCol) throws IllegalArgumentException {
    if (armThickness % 2 == 0 || armThickness < 0) {
      throw new IllegalArgumentException("Arm thickness cannot be even");
    }

    this.armThickness = armThickness;
    this.size = this.getBoardSize();

    if (this.outsideOfBox(sRow, sCol) || !this.onBoard(sRow, sCol)) {
      String error = String.format("Invalid empty cell position (%1$s,%2$s)", sRow, sCol);
      throw new IllegalArgumentException(error);
    }

    this.sRow = sRow;
    this.sCol = sCol;

    this.board = new SlotState[this.size][this.size];
    this.initiateBoard();
  }

  //sets enum values in the board.
  protected void initiateBoard() {
    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size; j++) {

        if (!this.onBoard(i, j)) {
          board[i][j] = SlotState.Invalid;

        } else if (i == this.sRow && j == this.sCol) {
          board[i][j] = SlotState.Empty;

        } else {
          board[i][j] = SlotState.Marble;

        }
      }
    }
  }

  //helper method for move.
  protected void moveHelp(int fromRow, int fromCol, int toRow, int toCol,
                          SlotState fromSquare, SlotState toSquare) {
    SlotState betweenSquare;
    if (this.outsideOfBox(fromRow, fromCol) || this.outsideOfBox(toRow, toCol)) {
      throw new IllegalArgumentException("must input valid move values.");
    }

    if (fromSquare == SlotState.Invalid || toSquare == SlotState.Invalid) {
      throw new IllegalArgumentException("Cannot input invalid space.");
    }
    if (fromSquare != SlotState.Marble || toSquare != SlotState.Empty) {
      throw new IllegalArgumentException("from space must have marble and to space must be empty.");
    }

    if (fromRow == toRow && fromCol < toCol) {
      betweenSquare = board[fromRow][fromCol + 1];
      if (betweenSquare == SlotState.Empty) {
        throw new IllegalArgumentException("there must be a marble to hop over.");
      }
      board[fromRow][fromCol + 1] = SlotState.Empty;
    } else if (fromRow == toRow && fromCol > toCol) {
      betweenSquare = board[fromRow][fromCol - 1];
      if (betweenSquare == SlotState.Empty) {
        throw new IllegalArgumentException("there must be a marble to hop over.");
      }
      board[fromRow][fromCol - 1] = SlotState.Empty;
    } else if (fromCol == toCol && fromRow < toRow) {
      betweenSquare = board[fromRow + 1][fromCol];
      if (betweenSquare == SlotState.Empty) {
        throw new IllegalArgumentException("there must be a marble to hop over.");
      }
      board[fromRow + 1][fromCol] = SlotState.Empty;
    } else if (fromCol == toCol && fromRow > toRow) {
      betweenSquare = board[fromRow - 1][fromCol];
      if (betweenSquare == SlotState.Empty) {
        throw new IllegalArgumentException("there must be a marble to hop over.");
      }
      board[fromRow - 1][fromCol] = SlotState.Empty;

    }
  }

  /**
   * extending classes must implement- returns true if given space represented
   * by row and col numbers is on the board, else false.
   *
   * @param row row num.
   * @param col col num.
   * @return true if given space is on the game board, false if not.
   */
  protected abstract boolean onBoard(int row, int col);

  /**
   * returns true if given space is outside of game array.
   *
   * @param row row num.
   * @param col col num.
   * @return true if given space not in the gameboard world, else false.
   */
  protected boolean outsideOfBox(int row, int col) {
    return row < 0 || col < 0 || row > this.size - 1 || col > this.size - 1;
  }

  /**
   * Moves a marble from one square to another on the board.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0).
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0).
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0).
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0).
   * @throws IllegalArgumentException if from square and to square do not
   *                                  follow specified requirements.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.outsideOfBox(fromRow, fromCol) || this.outsideOfBox(toRow, toCol)) {
      throw new IllegalArgumentException("square must be inside board dimensions");
    }

    SlotState fromSquare = board[fromRow][fromCol];
    SlotState toSquare = board[toRow][toCol];

    if (fromSquare == SlotState.Invalid || toSquare == SlotState.Invalid) {
      throw new IllegalArgumentException("Cannot input invalid space.");
    }
    if (fromSquare != SlotState.Marble || toSquare != SlotState.Empty) {
      throw new IllegalArgumentException("from space must have marble and to space must be empty.");
    }
    if (!((fromRow == toRow && Math.abs(fromCol - toCol) == 2)
            || (fromCol == toCol && Math.abs(fromRow - toRow) == 2))) {
      throw new IllegalArgumentException("from and to square must be on same row/column.");
    }

    this.moveHelp(fromRow, fromCol, toRow, toCol, fromSquare, toSquare);

    board[fromRow][fromCol] = SlotState.Empty;
    board[toRow][toCol] = SlotState.Marble;


  }

  /**
   * checks if game is over.
   *
   * @return bool representing whether or not game is over.
   */
  public boolean isGameOver() {
    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size; j++) {
        if (board[i][j] == SlotState.Marble) {
          if (!(this.outsideOfBox(i - 1, j) || this.outsideOfBox(i - 2, j))) {
            if (board[i - 1][j] == SlotState.Marble && board[i - 2][j] == SlotState.Empty) {
              return false;
            }
          }
          if (!(this.outsideOfBox(i + 1, j) || this.outsideOfBox(i + 2, j))) {
            if (board[i + 1][j] == SlotState.Marble && board[i + 2][j] == SlotState.Empty) {
              return false;
            }
          }
          if (!(this.outsideOfBox(i, j - 1) || this.outsideOfBox(i, j - 2))) {
            if (board[i][j - 1] == SlotState.Marble && board[i][j - 2] == SlotState.Empty) {
              return false;
            }
          }
          if (!(this.outsideOfBox(i, j + 1) || this.outsideOfBox(i, j + 2))) {
            if (board[i][j + 1] == SlotState.Marble && board[i][j + 2] == SlotState.Empty) {
              return false;
            }
          }

        }

      }
    }
    return true;
  }

  /**
   * returns the board size.
   *
   * @return int representing board size.
   */
  @Override
  public int getBoardSize() {
    return this.armThickness * 3 - 2;
  }

  /**
   * gets slot at specified position.
   *
   * @param row the row of the position sought, starting at 0.
   * @param col the column of the position sought, starting at 0.
   * @return the SlotState of the specified square.
   * @throws IllegalArgumentException if the inputted values are not within
   *                                  the game board.
   */
  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (row < 0 || row > this.size - 1 || col < 0 || col > this.size - 1) {
      throw new IllegalArgumentException("Must input valid slot values for getSlotAt. ");
    }
    return this.board[row][col];
  }

  /**
   * gets the current score of game.
   *
   * @return int representing the game score.
   */
  @Override
  public int getScore() {
    int score = 0;
    for (int i = 0; i < this.size; i++) {
      for (int j = 0; j < this.size; j++) {
        if (this.board[i][j] == SlotState.Marble) {
          score = score + 1;
        }
      }
    }
    return score;
  }
}
