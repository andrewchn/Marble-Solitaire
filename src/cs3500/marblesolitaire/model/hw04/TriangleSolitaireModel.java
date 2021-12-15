package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.AbstractMSModel;

/**
 * represents the model for a triangle solitaire game.
 */
public class TriangleSolitaireModel extends AbstractMSModel {

  /**
   * initializes default triangle solitaire board with base size of five.
   */
  public TriangleSolitaireModel() {
    this.sRow = 0;
    this.sCol = 0;
    this.armThickness = 5;
    this.size = this.getBoardSize();

    this.board = new SlotState[this.size][this.size];

    this.initiateBoard();
  }

  /**
   * initializes triangle solitaire board with custom base size.
   * @param dimensions base size of board.
   * @throws IllegalArgumentException if dimensions are not greater than 1.
   */
  public TriangleSolitaireModel(int dimensions) throws IllegalArgumentException {

    if (dimensions < 2) {
      throw new IllegalArgumentException("dimensions must be greater than 1");
    }

    this.sRow = 0;
    this.sCol = 0;
    this.armThickness = dimensions;
    this.size = getBoardSize();
    this.board = new SlotState[this.size][this.size];
    this.initiateBoard();
  }

  /**
   * creates triangle solitaire board with base size 5 and given start position.
   * @param sRow row of start position.
   * @param sCol col of start position.
   * @throws IllegalArgumentException if start position is not on the board.
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this.armThickness = 5;
    this.size = this.getBoardSize();

    if (this.outsideOfBox(sRow, sCol) || !this.onBoard(sRow, sCol)) {
      throw new IllegalArgumentException("Please input valid starting point.");
    }

    this.sRow = sRow;
    this.sCol = sCol;
    this.board = new SlotState[this.size][this.size];
    this.initiateBoard();
  }

  /**
   * creates new triangle solitaire with given base size and start position.
   * @param dimensions base size of board.
   * @param sRow start row.
   * @param sCol start col.
   * @throws IllegalArgumentException if size less than 2 or start position not on board.
   */
  public TriangleSolitaireModel(int dimensions, int sRow, int sCol)
          throws IllegalArgumentException {

    if (dimensions < 2) {
      throw new IllegalArgumentException("dimensions must be greater than 1");
    }
    this.armThickness = dimensions;
    this.size = this.getBoardSize();

    if (this.outsideOfBox(sRow, sCol) || !this.onBoard(sRow, sCol)) {
      throw new IllegalArgumentException("Please input valid starting point.");
    }

    this.sRow = sRow;
    this.sCol = sCol;
    this.board = new SlotState[this.size][this.size];

    this.initiateBoard();

  }

  @Override
  protected boolean onBoard(int row, int col) {
    return row >= col;
  }

  /**
   * overrides the move method in abstract since the board construction is different.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0).
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0).
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0).
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0).
   * @throws IllegalArgumentException if from or to are invalid or if the move itself is invalid.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if (this.outsideOfBox(fromRow, fromCol) || this.outsideOfBox(toRow, toCol)) {
      throw new IllegalArgumentException("must input valid move values.");
    }

    SlotState fromSquare = board[fromRow][fromCol];
    SlotState toSquare = board[toRow][toCol];
    SlotState betweenSquare;

    if (fromSquare != SlotState.Marble || toSquare != SlotState.Empty) {
      throw new IllegalArgumentException(
              "from space must have marble and to space must be empty.");
    }
    if (!((fromRow == toRow && Math.abs(fromCol - toCol) == 2)
            || (fromCol == toCol && Math.abs(fromRow - toRow) == 2)
            || (Math.abs(fromRow - toRow) == 2 && Math.abs(fromCol - toCol) == 2))) {
      throw new IllegalArgumentException("from and to square must be on same row/column.");
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

    } else if (fromCol < toCol && fromRow < toRow) {
      betweenSquare = board[fromRow + 1][fromCol + 1];
      if (betweenSquare == SlotState.Empty) {
        throw new IllegalArgumentException("there must be a marble to hop over.");
      }
      board[fromRow + 1][fromCol + 1] = SlotState.Empty;
    } else if (fromCol > toCol && fromRow > toRow) {
      betweenSquare = board[fromRow - 1][fromCol - 1];
      if (betweenSquare == SlotState.Empty) {
        throw new IllegalArgumentException("there must be a marble to hop over.");
      }
      board[fromRow - 1][fromCol - 1] = SlotState.Empty;

    }
    board[fromRow][fromCol] = SlotState.Empty;
    board[toRow][toCol] = SlotState.Marble;


  }

  @Override
  public boolean isGameOver() {
    for (int i = 0; i < this.armThickness; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
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

          if (!(this.outsideOfBox(i + 1, j + 1) || this.outsideOfBox(i + 2, j + 2))) {
            if (board[i + 1][j + 1] == SlotState.Marble && board[i + 2][j + 2] == SlotState.Empty) {
              return false;
            }
          }

          if (!(this.outsideOfBox(i - 1, j - 1) || this.outsideOfBox(i - 2, j - 2))) {
            if (board[i - 1][j - 1] == SlotState.Marble && board[i - 2][j - 2] == SlotState.Empty) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return this.armThickness;
  }

  @Override
  public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    if (this.outsideOfBox(row, col)) {
      throw new IllegalArgumentException("Please input valid board location.");
    }
    return this.board[row][col];
  }

  @Override
  public int getScore() {
    int counter = 0;

    for (SlotState[] row : this.board) {
      for (SlotState s : row) {
        if (s == SlotState.Marble) {
          counter++;
        }
      }
    }
    return counter;
  }
}
