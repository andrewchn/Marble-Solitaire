package cs3500.marblesolitaire.view;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * tests MarbleSolitaireTextView class methods.
 */
public class MarbleSolitaireTextViewTest {

  private MarbleSolitaireView tv1;
  private MarbleSolitaireView tv2;
  private MarbleSolitaireView tv3;
  private MarbleSolitaireView tv4;
  private MarbleSolitaireView tv5;
  private MarbleSolitaireView tv6;
  private MarbleSolitaireView tv7;
  private MarbleSolitaireView tv8;
  private MarbleSolitaireView tv9;

  /**
   * initializes the esm and mstv values.
   */
  @Before
  public void setup() {
    EnglishSolitaireModel esm1 = new EnglishSolitaireModel(3, 3);
    EnglishSolitaireModel esm2 = new EnglishSolitaireModel(0, 2);
    EnglishSolitaireModel esm3 = new EnglishSolitaireModel(3, 0);
    EnglishSolitaireModel esm4 = new EnglishSolitaireModel(5, 3);
    EnglishSolitaireModel esm5 = new EnglishSolitaireModel(2, 6);

    EnglishSolitaireModel esm6 = new EnglishSolitaireModel(3);
    EnglishSolitaireModel esm7 = new EnglishSolitaireModel(5);
    EnglishSolitaireModel esm8 = new EnglishSolitaireModel(7);
    EnglishSolitaireModel esm9 = new EnglishSolitaireModel(9);

    EnglishSolitaireModel esm10 = new EnglishSolitaireModel(3, 4, 3);
    EnglishSolitaireModel esm11 = new EnglishSolitaireModel(5, 8, 5);
    EnglishSolitaireModel esm12 = new EnglishSolitaireModel(7, 2, 9);
    EnglishSolitaireModel esm13 = new EnglishSolitaireModel(9, 10, 15);

    tv1 = new MarbleSolitaireTextView(esm1);
    tv2 = new MarbleSolitaireTextView(esm2);

    tv3 = new MarbleSolitaireTextView(esm6);
    tv4 = new MarbleSolitaireTextView(esm7);
    tv5 = new MarbleSolitaireTextView(esm8);

    tv6 = new MarbleSolitaireTextView(esm10);
    tv7 = new MarbleSolitaireTextView(esm11);
    tv8 = new MarbleSolitaireTextView(esm12);

  }

  /**
   * tests that view throws proper exception if fed null values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTextViewException() {
    new MarbleSolitaireTextView(null);
    new MarbleSolitaireTextView(null, null);
    new MarbleSolitaireTextView(new EnglishSolitaireModel(), null);
    new MarbleSolitaireTextView(null, new StringBuilder());
  }

  /**
   * tests that toString prints correct board view.
   */
  @Test
  public void printBoard() {
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.tv1.toString());
    assertEquals("    _ O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.tv2.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.tv3.toString());
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
            "        O O O O O", this.tv4.toString());
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
            "            O O O O O O O", this.tv5.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O O O\n" +
            "    O O O", this.tv6.toString());
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
            "        O O O O O", this.tv7.toString());
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
            "            O O O O O O O", this.tv8.toString());

  }

  /**
   * tests rendermessage function in tv.
   */
  @Test
  public void testRenderMessage() {
    StringBuilder s = new StringBuilder();
    MarbleSolitaireView view = new MarbleSolitaireTextView(new EnglishSolitaireModel(), s);
    try {
      view.renderMessage("Hello\n");
      assertEquals("Hello\n", s.toString());
      view.renderMessage("Game Over!\n");
      assertEquals("Hello\nGame Over!\n", s.toString());
      view.renderMessage("123455\n");
      assertEquals("Hello\nGame Over!\n123455\n", s.toString());
      view.renderMessage("This is a test.\n");
      assertEquals("Hello\nGame Over!\n123455\nThis is a test.\n", s.toString());
    } catch (IOException i) {
      System.out.println("unable to render test.");
    }
    assertEquals("Hello\nGame Over!\n123455\nThis is a test.\n", s.toString());
  }

  /**
   * tests that renderboard works correctly, assuming that the
   * MSTV toString is overwritten properly.
   */
  @Test
  public void testRenderBoard() {
    StringBuilder sb1 = new StringBuilder();
    MarbleSolitaireModel model1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView view1 = new MarbleSolitaireTextView(model1, sb1);
    try {
      //tests that renderBoard can render board at multiple pts in game,
      // also appends messages properly.
      assertEquals("", sb1.toString());
      view1.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n", sb1.toString());
      model1.move(3, 1, 3, 3);
      view1.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O _ _ O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n", sb1.toString());
      model1.move(1, 2, 3, 2);
      view1.renderBoard();
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O _ _ O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    _ O O\n" +
              "O O _ O O O O\n" +
              "O _ O O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n", sb1.toString());
      view1.renderMessage("Test Message\n");
      assertEquals("    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O O O _ O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "O O O O O O O\n" +
              "O _ _ O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "    _ O O\n" +
              "O O _ O O O O\n" +
              "O _ O O O O O\n" +
              "O O O O O O O\n" +
              "    O O O\n" +
              "    O O O\n" +
              "Test Message\n", sb1.toString());
    } catch (IOException i) {
      System.out.println("unable to render test.");
    }
  }
}