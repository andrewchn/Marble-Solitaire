package cs3500.marblesolitaire.model.hw04;

import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.AbstractMSModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * represents tests for the European Solitaire Model. Since it extends the Abstract Solitaire Model
 * class, the abstracted methods are all already tested in the English solitaire model tests.
 * So all this test class covers the European Solitaire constructors.
 */
public class EuropeanSolitaireModelTest {

  AbstractMSModel em1;
  AbstractMSModel em2;
  AbstractMSModel em3;
  AbstractMSModel em4;
  AbstractMSModel em5;
  AbstractMSModel em6;
  AbstractMSModel em7;
  AbstractMSModel em8;
  AbstractMSModel em9;
  AbstractMSModel em10;
  AbstractMSModel em11;
  AbstractMSModel em12;
  AbstractMSModel em13;

  @Before
  public void setUp() {
    this.em1 = new EuropeanSolitaireModel();
    this.em2 = new EuropeanSolitaireModel(3);
    this.em3 = new EuropeanSolitaireModel(5);
    this.em4 = new EuropeanSolitaireModel(7);
    this.em5 = new EuropeanSolitaireModel(9);
    this.em6 = new EuropeanSolitaireModel(1,1);
    this.em7 = new EuropeanSolitaireModel(5,1);
    this.em8 = new EuropeanSolitaireModel(1, 5);
    this.em9 = new EuropeanSolitaireModel(5,5);
    this.em10 = new EuropeanSolitaireModel(7, 3, 4);
    this.em11 = new EuropeanSolitaireModel(9, 6,2);
    this.em12 = new EuropeanSolitaireModel(5, 4,3);
    this.em13 = new EuropeanSolitaireModel(11, 10, 5);


  }

  /**
   * tests default constructor using toString method to check if everything is
   * in the correct place.
   */
  @Test
  public void testConstructor1() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.em1).toString());
  }

  /**
   * test constructor that accepts one args throws exception  if
   * invalid armthickness.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructor2Exception() {
    new TriangleSolitaireModel(2);
    new TriangleSolitaireModel(4);
    new TriangleSolitaireModel(-12);
    new TriangleSolitaireModel(8);

  }

  /**
   * test constructor that accepts one args creates right board.
   */
  @Test
  public void testConstructor2() {
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.em2).toString());
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", new MarbleSolitaireTextView(this.em3).toString());
    assertEquals("            O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "            O O O O O O O", new MarbleSolitaireTextView(this.em4).toString());
    assertEquals("                O O O O O O O O O\n" +
            "              O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O _ O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O\n" +
            "                O O O O O O O O O", new MarbleSolitaireTextView(this.em5).toString());
  }

  /**
   * tests that constructor that takes in starting position
   * throws exceptino if starting position is invalid.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructor3Exception() {
    new EuropeanSolitaireModel(0, 0);
    new EuropeanSolitaireModel(5, 1);
    new EuropeanSolitaireModel(4, 0);
    new EuropeanSolitaireModel(5, 5);

  }

  /**
   * test constructor that accepts two args creates right board.
   */
  @Test
  public void testConstructor3() {
    assertEquals("    O O O\n" +
            "  _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.em6).toString());
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  _ O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.em7).toString());
    assertEquals("    O O O\n" +
            "  O O O O _\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", new MarbleSolitaireTextView(this.em8).toString());
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O _\n" +
            "    O O O", new MarbleSolitaireTextView(this.em9).toString());
  }

  /**
   * tests that constructor throws exception if invalid
   * armthickness or start position.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testConstructor4Exception() {
    new TriangleSolitaireModel(3, 0, 2);
    new TriangleSolitaireModel(5, 0, 4);
    new TriangleSolitaireModel(7, 6, 0);
    new TriangleSolitaireModel(9, 8, 8);
    new TriangleSolitaireModel(11, 0, 4);
    new TriangleSolitaireModel(-1, 0, 2);
    new TriangleSolitaireModel(2, 0, 2);

  }

  /**
   * tests that constructor with three args creates proper game board.
   */
  @Test
  public void testConstructor4() {
    assertEquals("            O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "      O _ O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O\n" +
            "          O O O O O O O O O\n" +
            "            O O O O O O O", new MarbleSolitaireTextView(this.em10).toString());
    assertEquals("                O O O O O O O O O\n" +
            "              O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O\n" +
            "    _ O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O\n" +
            "                O O O O O O O O O", new MarbleSolitaireTextView(this.em11).toString());
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O _ O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", new MarbleSolitaireTextView(this.em12).toString());
    assertEquals("                    O O O O O O O O O O O\n" +
            "                  O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O _ O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "    O O O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "      O O O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "        O O O O O O O O O O O O O O O O O O O O O O O\n" +
            "          O O O O O O O O O O O O O O O O O O O O O\n" +
            "            O O O O O O O O O O O O O O O O O O O\n" +
            "              O O O O O O O O O O O O O O O O O\n" +
            "                O O O O O O O O O O O O O O O\n" +
            "                  O O O O O O O O O O O O O\n" +
            "                    O O O O O O O O O O O",
            new MarbleSolitaireTextView(this.em13).toString());
  }

}