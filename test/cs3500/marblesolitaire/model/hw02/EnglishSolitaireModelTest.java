package cs3500.marblesolitaire.model.hw02;

import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * tests ESM class.
 */
public class EnglishSolitaireModelTest {
  private EnglishSolitaireModel esm1;
  private EnglishSolitaireModel esm2;
  private EnglishSolitaireModel esm3;
  private EnglishSolitaireModel esm4;
  private EnglishSolitaireModel esm5;

  private EnglishSolitaireModel esm6;
  private EnglishSolitaireModel esm7;
  private EnglishSolitaireModel esm8;
  private EnglishSolitaireModel esm9;

  private EnglishSolitaireModel esm10;
  private EnglishSolitaireModel esm11;
  private EnglishSolitaireModel esm12;
  private EnglishSolitaireModel esm13;

  @Before
  public void setup() {
    esm1 = new EnglishSolitaireModel(3,3);
    esm2 = new EnglishSolitaireModel(0,2);
    esm3 = new EnglishSolitaireModel(3, 0);
    esm4 = new EnglishSolitaireModel(5, 3);
    esm5 = new EnglishSolitaireModel(2, 6);

    esm6 = new EnglishSolitaireModel(3);
    esm7 = new EnglishSolitaireModel(5);
    esm8 = new EnglishSolitaireModel(7);
    esm9 = new EnglishSolitaireModel(9);

    esm10 = new EnglishSolitaireModel(3,4,3);
    esm11 = new EnglishSolitaireModel(5,8,5);
    esm12 = new EnglishSolitaireModel(7,2,9);
    esm13 = new EnglishSolitaireModel(9,10,15);
  }

  /**
   * tests default constructor using toString method to check if everything is
   * in the correct place.
   */
  @Test
  public void testConstructor1() {
    EnglishSolitaireModel esm = new EnglishSolitaireModel();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", new MarbleSolitaireTextView(esm).toString());
  }

  /**
   * tests ESM constructor exception for constructor
   * that takes in the empty space coordinates.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2Exception() {
    EnglishSolitaireModel badconstructor1 = new EnglishSolitaireModel(-1, 1);
    EnglishSolitaireModel badconstructor2 = new EnglishSolitaireModel(6, 1);
    EnglishSolitaireModel badconstructor3 = new EnglishSolitaireModel(7, 0);
    EnglishSolitaireModel badconstructor4 = new EnglishSolitaireModel(6, 7);
  }

  /**
   * tests that ES constructor places empty space in correct place
   * using toString method since game fields are private.
   */
  @Test
  public void testConstructor2Empty() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.esm1).toString());
    assertEquals("    _ O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.esm2).toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "_ O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.esm3).toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O _ O\n" +
            "    O O O", new MarbleSolitaireTextView(this.esm4).toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.esm5).toString());
  }

  /**
   * tests ESM constructor that takes in armThickness and leaves empty at center.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor3Exception() {
    EnglishSolitaireModel badconstructor1 = new EnglishSolitaireModel(-3);
    EnglishSolitaireModel badconstructor2 = new EnglishSolitaireModel(-4);
    EnglishSolitaireModel badconstructor3 = new EnglishSolitaireModel(8);
    EnglishSolitaireModel badconstructor4 = new EnglishSolitaireModel(100);
  }

  /**
   * tests that ES constructor places empty space in correct place
   * using toString method since the fields of game are private.
   */
  @Test
  public void testConstructor3Empty() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.esm6).toString());
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", new MarbleSolitaireTextView(this.esm7).toString());
    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O", new MarbleSolitaireTextView(this.esm8).toString());
    assertEquals("                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O _ O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O", new MarbleSolitaireTextView(this.esm9).toString());

  }

  /**
   * tests ESM constructor that takes in armThickness and sRow/sCol values for empty space.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor4Exception() {
    EnglishSolitaireModel badconstructor1 = new EnglishSolitaireModel(-3,3,2);
    EnglishSolitaireModel badconstructor2 = new EnglishSolitaireModel(-4,5,4);
    EnglishSolitaireModel badconstructor3 = new EnglishSolitaireModel(8,6,12);
    EnglishSolitaireModel badconstructor4 = new EnglishSolitaireModel(100,4,7);
    EnglishSolitaireModel badconstructor5 = new EnglishSolitaireModel(9,4,5);
    EnglishSolitaireModel badconstructor6 = new EnglishSolitaireModel(7,12,2);
    EnglishSolitaireModel badconstructor7 = new EnglishSolitaireModel(3,8,3);

  }

  /**
   * tests that ES constructor places empty space in correct place using
   * toString funct since cant directly access fields of game.
   */
  @Test
  public void testConstructor4Empty() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.esm10).toString());
    assertEquals("        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O\n" +
            "        O O O O O", new MarbleSolitaireTextView(this.esm11).toString());
    assertEquals("            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O _ O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O\n" +
            "            O O O O O O O", new MarbleSolitaireTextView(this.esm12).toString());
    assertEquals("                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O\n" +
            "                O O O O O O O O O",
            new MarbleSolitaireTextView(this.esm13).toString());
  }

  /**
   * tests that move throws proper exceptions.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMoveExceptionValidSquares() {
    EnglishSolitaireModel esm = new EnglishSolitaireModel();
    //squares outside board
    esm.move(-2,0,3,3);
    esm.move(0,43,3,3);
    esm.move(3,3,3,7);
    esm.move(3,4,12,3);

    //invalid squares
    esm.move(0,0,3,3);
    esm.move(3,3,0,0);
    esm.move(6,0,3,3);
    esm.move(3,3,0,0);

    //to not empty or from not marble
    esm.move(3,3,3,5);
    esm.move(3,2,3,4);
    esm.move(6,4,4,4);
    esm.move(5,4,5,2);

    //not on same row/col
    esm.move(2,0,3,4);
    esm.move(3,4,5,2);
    esm.move(6,0,3,3);
    esm.move(4,4,3,2);

    //not two away from ea other
    esm.move(2,3,5,3);
    esm.move(4,3,4,6);
    esm.move(6,2,3,2);
    esm.move(6,4,4,1);

    //no marble in between
    esm.move(3,2,3,4);
    esm.move(2,3,4,3);
    esm.move(3,4,3,2);
    esm.move(4,3,2,3);
  }

  /**
   * tests that move function properly assigns slotstate values.
   */
  @Test
  public void testMove() {
    EnglishSolitaireModel esm = new EnglishSolitaireModel();
    esm.move(3,1,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,esm.getSlotAt(3,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,esm.getSlotAt(3,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,esm.getSlotAt(3,3));
    esm.move(5,2,3,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,esm.getSlotAt(5,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,esm.getSlotAt(4,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,esm.getSlotAt(3,2));
    esm.move(4,0,4,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,esm.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,esm.getSlotAt(4,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,esm.getSlotAt(4,2));

  }

  @Test
  public void testIsGameOver() {
    EnglishSolitaireModel esm = new EnglishSolitaireModel();
    assertEquals(false, esm.isGameOver());
    esm.move(3,1,3,3);
    assertEquals(false, esm.isGameOver());
    esm.move(5,2,3,2);
    assertEquals(false, esm.isGameOver());
    esm.move(4,0,4,2);
    assertEquals(false, esm.isGameOver());
    esm.move(4,3,4,1);
    assertEquals(false, esm.isGameOver());
    esm.move(2,3,4,3);
    assertEquals(false, esm.isGameOver());
    esm.move(0,3,2,3);
    assertEquals(false, esm.isGameOver());
    esm.move(5,3,3,3);
    assertEquals(false, esm.isGameOver());
    esm.move(2,3,4,3);
    assertEquals(false, esm.isGameOver());
    esm.move(2,1,2,3);
    assertEquals(false, esm.isGameOver());
    esm.move(4,4,4,2);
    assertEquals(false, esm.isGameOver());
    esm.move(4,1,4,3);
    assertEquals(false, esm.isGameOver());
    esm.move(6,4,4,4);
    assertEquals(false, esm.isGameOver());
    esm.move(4,4,4,2);
    assertEquals(false, esm.isGameOver());
    esm.move(4,6,4,4);
    assertEquals(false, esm.isGameOver());
    esm.move(3,4,5,4);
    assertEquals(false, esm.isGameOver());
    esm.move(1,4,3,4);
    assertEquals(false, esm.isGameOver());
    esm.move(0,2,2,2);
    assertEquals(false, esm.isGameOver());
    esm.move(3,2,5,2);
    assertEquals(false, esm.isGameOver());
    esm.move(6,2,4,2);
    assertEquals(false, esm.isGameOver());
    esm.move(2,0,4,0);
    assertEquals(false, esm.isGameOver());
    esm.move(2,3,2,1);
    assertEquals(false, esm.isGameOver());
    esm.move(3,5,3,3);
    assertEquals(false, esm.isGameOver());
    esm.move(2,6,2,4);
    assertEquals(true, esm.isGameOver());
  }


  /**
   * tests that function returns the correct board size.
   */
  @Test
  public void testGetBoardSize() {
    assertEquals(7, this.esm1.getBoardSize());
    assertEquals(7, this.esm2.getBoardSize());
    assertEquals(7, this.esm3.getBoardSize());

    assertEquals(7, this.esm6.getBoardSize());
    assertEquals(13, this.esm7.getBoardSize());
    assertEquals(19, this.esm8.getBoardSize());
    assertEquals(25, this.esm9.getBoardSize());

    assertEquals(7, this.esm10.getBoardSize());
    assertEquals(13, this.esm11.getBoardSize());
    assertEquals(19, this.esm12.getBoardSize());
    assertEquals(25, this.esm13.getBoardSize());
  }

  /**
   * tests that getSlotAtEmpty returns exception if inputted values are
   * invalid.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testGetSlotAtEmpty() {
    this.esm1.getSlotAt(15,10);
    this.esm1.getSlotAt(-3,5);
    this.esm7.getSlotAt(23,-5);
    this.esm8.getSlotAt(0,18);
    this.esm9.getSlotAt(-29,-209);
    this.esm11.getSlotAt(1,65);
    this.esm12.getSlotAt(-3,10);
  }

  /**
   * Tests that getSlotAt returns correct slot value.
   */
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.esm1.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.esm1.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,this.esm1.getSlotAt(6,6));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.esm8.getSlotAt(9,9));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,this.esm8.getSlotAt(4,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.esm8.getSlotAt(4,9));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty,this.esm13.getSlotAt(10,15));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid,this.esm13.getSlotAt(24,2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble,this.esm13.getSlotAt(12,16));
  }

  /**
   * tests the getScore function.
   */
  @Test
  public void testGetScore() {
    assertEquals(32, this.esm1.getScore());
    assertEquals(32, this.esm2.getScore());
    assertEquals(32, this.esm6.getScore());
    assertEquals(104, this.esm7.getScore());
    assertEquals(216, this.esm8.getScore());
    assertEquals(368, this.esm9.getScore());
    assertEquals(32, this.esm10.getScore());
    assertEquals(104, this.esm11.getScore());
    assertEquals(216, this.esm12.getScore());
    assertEquals(368, this.esm13.getScore());

  }
}