package cs3500.marblesolitaire.model.hw04;

import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.AbstractMSModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.view.AbstractTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * tests for triangle solitaire model.
 */
public class TriangleSolitaireModelTest {

  AbstractMSModel t1;
  AbstractMSModel t2;
  AbstractMSModel t3;
  AbstractMSModel t4;
  AbstractMSModel t5;

  AbstractMSModel t6;
  AbstractMSModel t7;
  AbstractMSModel t8;
  AbstractMSModel t9;

  AbstractMSModel t10;
  AbstractMSModel t11;
  AbstractMSModel t12;
  AbstractMSModel t13;

  @Before
  public void setup() {
    t1 = new TriangleSolitaireModel();
    t2 = new TriangleSolitaireModel(2);
    t3 = new TriangleSolitaireModel(4);
    t4 = new TriangleSolitaireModel(7);
    t5 = new TriangleSolitaireModel(9);

    t6 = new TriangleSolitaireModel(1, 0);
    t7 = new TriangleSolitaireModel(4,2);
    t8 = new TriangleSolitaireModel(3,3);
    t9 = new TriangleSolitaireModel(2,1);

    t10 = new TriangleSolitaireModel(2,0,0);
    t11 = new TriangleSolitaireModel(9, 4, 3);
    t12 = new TriangleSolitaireModel(12, 10,9);
    t13 = new TriangleSolitaireModel(6, 5,0);


  }

  /**
   * tests taht constructor with no arguments returns correct board.
   */
  @Test
  public void testConstructor1() {
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", new TriangleSolitaireTextView(this.t1).toString());
  }

  /**
   * tests that inputting dimensions less than two will throw exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2Exception() {
    new TriangleSolitaireModel(-1);
    new TriangleSolitaireModel(0);
    new TriangleSolitaireModel(1);

  }

  /**
   * tests that constructor that takes in one argument outputs correct board.
   */
  @Test
  public void testConstructor2() {
    assertEquals(" _\n" +
            "O O", new TriangleSolitaireTextView(this.t2).toString());
    assertEquals("   _\n" +
            "  O O\n" +
            " O O O\n" +
            "O O O O", new TriangleSolitaireTextView(this.t3).toString());
    assertEquals("      _\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O O O O\n" +
            "O O O O O O O", new TriangleSolitaireTextView(this.t4).toString());
    assertEquals("        _\n" +
            "       O O\n" +
            "      O O O\n" +
            "     O O O O\n" +
            "    O O O O O\n" +
            "   O O O O O O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O", new TriangleSolitaireTextView(this.t5).toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3Exception() {
    new TriangleSolitaireModel(-1, 3);
    new TriangleSolitaireModel(5, 3);
    new TriangleSolitaireModel(2, 3);
    new TriangleSolitaireModel(2, -9);
    new TriangleSolitaireModel(9, 9);

  }

  /**
   * tests taht constructor that takes in two args returns correct board.
   */
  @Test
  public void testConstructor3() {
    assertEquals("    O\n" +
            "   _ O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", new TriangleSolitaireTextView(this.t6).toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O _ O O", new TriangleSolitaireTextView(this.t7).toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O _\n" +
            "O O O O O", new TriangleSolitaireTextView(this.t8).toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O _ O\n" +
            " O O O O\n" +
            "O O O O O", new TriangleSolitaireTextView(this.t9).toString());
  }

  /**
   * tests constructor with three args throws exception when passed invalid values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4Exception() {
    new TriangleSolitaireModel(1, 0, 0);
    new TriangleSolitaireModel(5, 0, 1);
    new TriangleSolitaireModel(7, 9, 2);
    new TriangleSolitaireModel(4, 2, 3);
    new TriangleSolitaireModel(8, -1, 4);
    new TriangleSolitaireModel(10, 2, 5);

  }

  /**
   * tests that the constructor that takes in three args returns correct board.
   */
  @Test
  public void testConstructor4() {
    assertEquals(" _\n" +
            "O O", new TriangleSolitaireTextView(this.t10).toString());
    assertEquals("        O\n" +
            "       O O\n" +
            "      O O O\n" +
            "     O O O O\n" +
            "    O O O _ O\n" +
            "   O O O O O O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O", new TriangleSolitaireTextView(this.t11).toString());
    assertEquals("           O\n" +
            "          O O\n" +
            "         O O O\n" +
            "        O O O O\n" +
            "       O O O O O\n" +
            "      O O O O O O\n" +
            "     O O O O O O O\n" +
            "    O O O O O O O O\n" +
            "   O O O O O O O O O\n" +
            "  O O O O O O O O O O\n" +
            " O O O O O O O O O _ O\n" +
            "O O O O O O O O O O O O", new TriangleSolitaireTextView(this.t12).toString());
    assertEquals("     O\n" +
            "    O O\n" +
            "   O O O\n" +
            "  O O O O\n" +
            " O O O O O\n" +
            "_ O O O O O", new TriangleSolitaireTextView(this.t13).toString());
  }

  /**
   * tests that move function correctly modifies the board.
   */
  @Test
  public void testMove() {
    AbstractMSModel tm = new TriangleSolitaireModel();
    AbstractTextView tv = new TriangleSolitaireTextView(tm);
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", tv.toString());
    //up and to the left
    tm.move(2, 2, 0,0);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", tv.toString());
    //same row to right
    tm.move(2, 0, 2,2);
    assertEquals("    O\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " O O O O\n" +
            "O O O O O", tv.toString());
    //up to left again
    tm.move(3, 3, 1,1);
    assertEquals("    O\n" +
            "   O O\n" +
            "  _ _ _\n" +
            " O O O _\n" +
            "O O O O O", tv.toString());
    //up and to right
    tm.move(4, 2, 2,2);
    assertEquals("    O\n" +
            "   O O\n" +
            "  _ _ O\n" +
            " O O _ _\n" +
            "O O _ O O", tv.toString());
    //down to right
    tm.move(1, 1, 3,3);
    assertEquals("    O\n" +
            "   O _\n" +
            "  _ _ _\n" +
            " O O _ O\n" +
            "O O _ O O", tv.toString());
    //down to right again
    tm.move(4, 4, 2,2);
    assertEquals("    O\n" +
            "   O _\n" +
            "  _ _ O\n" +
            " O O _ _\n" +
            "O O _ O _", tv.toString());
    //up to right
    tm.move(4, 0, 2,0);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O _ O\n" +
            " _ O _ _\n" +
            "_ O _ O _", tv.toString());
    //down to the left
    tm.move(1, 0, 3,0);
    assertEquals("    O\n" +
            "   _ _\n" +
            "  _ _ O\n" +
            " O O _ _\n" +
            "_ O _ O _", tv.toString());
    tm.move(4, 1, 2,1);
    assertEquals("    O\n" +
            "   _ _\n" +
            "  _ O O\n" +
            " O _ _ _\n" +
            "_ _ _ O _", tv.toString());
    tm.move(2, 2, 2,0);
    assertEquals("    O\n" +
            "   _ _\n" +
            "  O _ _\n" +
            " O _ _ _\n" +
            "_ _ _ O _", tv.toString());
    tm.move(2, 0, 4,0);
    assertEquals("    O\n" +
            "   _ _\n" +
            "  _ _ _\n" +
            " _ _ _ _\n" +
            "O _ _ O _", tv.toString());

  }

  /**
   * tests that illegal moves trigger Illegal argument exception.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMoves() {
    //test move from within board to outside board
    this.t1.move(2, 2, 7, 12);

    //test move from outside board to within board
    this.t1.move(24, 3, 5,4);

    //test move from spaces not two away from ea other
    this.t1.move(3,3,4,1);

    //test move for two spaces with no marble in between
    this.t6.move(2,0,0,0);

    //test move for two spaces with marble in to space
    this.t1.move(3,1,3,3);

    //test move with from being empty
    this.t1.move(0,0, 2,0);


  }

  /**
   * tests that gameOver flags properly when game is over.
   */
  @Test
  public void testIsGameOver() {
    AbstractMSModel tm = new TriangleSolitaireModel();
    assertEquals(false, tm.isGameOver());
    tm.move(2, 2, 0,0);
    assertEquals(false, tm.isGameOver());
    tm.move(2, 0, 2,2);
    assertEquals(false, tm.isGameOver());
    tm.move(3, 3, 1,1);
    assertEquals(false, tm.isGameOver());
    tm.move(4, 2, 2,2);
    assertEquals(false, tm.isGameOver());
    tm.move(1, 1, 3,3);
    assertEquals(false, tm.isGameOver());
    tm.move(4, 4, 2,2);
    assertEquals(false, tm.isGameOver());
    tm.move(4, 0, 2,0);
    assertEquals(false, tm.isGameOver());
    tm.move(1, 0, 3,0);
    assertEquals(false, tm.isGameOver());
    tm.move(4, 1, 2,1);
    assertEquals(false, tm.isGameOver());
    tm.move(2, 2, 2,0);
    assertEquals(false, tm.isGameOver());
    tm.move(2, 0, 4,0);
    assertEquals(true, tm.isGameOver());
  }

  /**
   * tests that get board size returns correct size of board.
   */

  @Test
  public void testGetBoardSize() {
    assertEquals(5, this.t1.getBoardSize());
    assertEquals(2, this.t2.getBoardSize());
    assertEquals(4, this.t3.getBoardSize());
    assertEquals(7, this.t4.getBoardSize());
    assertEquals(9, this.t5.getBoardSize());
    assertEquals(5, this.t6.getBoardSize());
    assertEquals(5, this.t7.getBoardSize());
    assertEquals(5, this.t8.getBoardSize());
    assertEquals(5, this.t9.getBoardSize());
    assertEquals(2, this.t10.getBoardSize());
    assertEquals(9, this.t11.getBoardSize());
    assertEquals(12, this.t12.getBoardSize());
    assertEquals(6, this.t13.getBoardSize());

  }

  /**
   * tests that getSlotAt throws Illegal arg exception if given invalid slot position.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testGetSlotAtEmpty() {
    this.t1.getSlotAt(6,21);
    this.t3.getSlotAt(5,1);
    this.t7.getSlotAt(-13,4);
    this.t10.getSlotAt(1,4);
    this.t13.getSlotAt(5,-12);
  }

  /**
   * test that getSlotAt returns accurate values.
   */
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.t1.getSlotAt(0,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.t2.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.t3.getSlotAt(2,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.t6.getSlotAt(3,4));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.t10.getSlotAt(0,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.t11.getSlotAt(4,3));

  }

  /**
   * tests that getScore returns correct score for different board
   * sizes.
   */
  @Test
  public void testGetScore() {
    assertEquals(14, this.t1.getScore());
    assertEquals(2, this.t2.getScore());
    assertEquals(9, this.t3.getScore());
    assertEquals(27, this.t4.getScore());
    assertEquals(44, this.t5.getScore());
    assertEquals(14, this.t6.getScore());
    assertEquals(14, this.t7.getScore());
    assertEquals(14, this.t8.getScore());
    assertEquals(14, this.t9.getScore());
    assertEquals(2, this.t10.getScore());
    assertEquals(44, this.t11.getScore());
    assertEquals(77, this.t12.getScore());
    assertEquals(20, this.t13.getScore());
  }
}