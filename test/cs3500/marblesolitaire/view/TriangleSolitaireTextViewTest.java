package cs3500.marblesolitaire.view;

import org.junit.Test;

import java.io.IOException;

import cs3500.marblesolitaire.model.AbstractMSModel;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * tests triangle solitaire text view class.
 */
public class TriangleSolitaireTextViewTest {

  /**
   * tests that view throws proper exception if fed null values or if not passed
   * TriangleSolitaireModel.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testTextViewException() {
    new TriangleSolitaireTextView(null);
    new TriangleSolitaireTextView(new EnglishSolitaireModel());
    new TriangleSolitaireTextView(null, null);
    new TriangleSolitaireTextView(new TriangleSolitaireModel(), null);
    new TriangleSolitaireTextView(null, new StringBuilder());
    new TriangleSolitaireTextView(new EnglishSolitaireModel(), new StringBuilder());
  }


  /**
   * tests that triangle tv's to string method works properly.
   */
  @Test
  public void testToString() {
    AbstractMSModel t1 = new TriangleSolitaireModel();
    AbstractTextView ttv1 = new TriangleSolitaireTextView(t1);
    AbstractMSModel t2 = new TriangleSolitaireModel(3);
    AbstractTextView ttv2 = new TriangleSolitaireTextView(t2);
    AbstractMSModel t3 = new TriangleSolitaireModel(12);
    AbstractTextView ttv3 = new TriangleSolitaireTextView(t3);
    AbstractMSModel t4 = new TriangleSolitaireModel(9);
    AbstractTextView ttv4 = new TriangleSolitaireTextView(t4);

    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", ttv1.toString());
    assertEquals("  _\n" +
            " O O\n" +
            "O O O", ttv2.toString());
    assertEquals("           _\n" +
            "          O O\n" +
            "         O O O\n" +
            "        O O O O\n" +
            "       O O O O O\n" +
            "      O O O O O O\n" +
            "     O O O O O O O\n" +
            "    O O O O O O O O\n" +
            "   O O O O O O O O O\n" +
            "  O O O O O O O O O O\n" +
            " O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O", ttv3.toString());
    assertEquals("        _\n" +
            "       O O\n" +
            "      O O O\n" +
            "     O O O O\n" +
            "    O O O O O\n" +
            "   O O O O O O\n" +
            "  O O O O O O O\n" +
            " O O O O O O O O\n" +
            "O O O O O O O O O", ttv4.toString());

    TriangleSolitaireModel t5 = new TriangleSolitaireModel(3, 2);
    TriangleSolitaireTextView ttv5 = new TriangleSolitaireTextView(t5);
    TriangleSolitaireModel t6 = new TriangleSolitaireModel(1,1);
    TriangleSolitaireTextView ttv6 = new TriangleSolitaireTextView(t6);
    TriangleSolitaireModel t7 = new TriangleSolitaireModel(4,4);
    TriangleSolitaireTextView ttv7 = new TriangleSolitaireTextView(t7);
    TriangleSolitaireModel t8 = new TriangleSolitaireModel(4, 2);
    TriangleSolitaireTextView ttv8 = new TriangleSolitaireTextView(t8);

    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O _ O\n" +
            "O O O O O", ttv5.toString());
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", ttv6.toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O _", ttv7.toString());
    assertEquals("    O\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O _ O O", ttv8.toString());

    TriangleSolitaireModel t9 = new TriangleSolitaireModel(7, 5, 3);
    TriangleSolitaireTextView ttv9 = new TriangleSolitaireTextView(t9);
    TriangleSolitaireModel t10 = new TriangleSolitaireModel(13,7, 6);
    TriangleSolitaireTextView ttv10 = new TriangleSolitaireTextView(t10);
    TriangleSolitaireModel t11 = new TriangleSolitaireModel(2,1,0);
    TriangleSolitaireTextView ttv11 = new TriangleSolitaireTextView(t11);
    TriangleSolitaireModel t12 = new TriangleSolitaireModel(8, 0, 0);
    TriangleSolitaireTextView ttv12 = new TriangleSolitaireTextView(t12);

    assertEquals("      O\n" +
            "     O O\n" +
            "    O O O\n" +
            "   O O O O\n" +
            "  O O O O O\n" +
            " O O O _ O O\n" +
            "O O O O O O O", ttv9.toString());
    assertEquals("            O\n" +
            "           O O\n" +
            "          O O O\n" +
            "         O O O O\n" +
            "        O O O O O\n" +
            "       O O O O O O\n" +
            "      O O O O O O O\n" +
            "     O O O O O O _ O\n" +
            "    O O O O O O O O O\n" +
            "   O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            " O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O", ttv10.toString());
    assertEquals(" O\n" +
            "_ O", ttv11.toString());
    assertEquals("       _\n" +
            "      O O\n" +
            "     O O O\n" +
            "    O O O O\n" +
            "   O O O O O\n" +
            "  O O O O O O\n" +
            " O O O O O O O\n" +
            "O O O O O O O O", ttv12.toString());

  }

  /**
   * tests that render board properly renders board at multiple games states
   * for the triangle game.
   */
  @Test
  public void testRenderBoard() {
    StringBuilder sb1 = new StringBuilder();
    AbstractMSModel model1 = new TriangleSolitaireModel();
    AbstractTextView view1 = new TriangleSolitaireTextView(model1, sb1);
    try {
      //tests that renderBoard can render board at multiple pts in game,
      // also appends messages properly.
      assertEquals("", sb1.toString());
      view1.renderBoard();
      assertEquals("    _\n" +
              "   O O\n" +
              "  O O O\n" +
              " O O O O\n" +
              "O O O O O\n", sb1.toString());
      model1.move(2, 2, 0, 0);
      view1.renderBoard();
      assertEquals("    _\n" +
              "   O O\n" +
              "  O O O\n" +
              " O O O O\n" +
              "O O O O O\n" +
              "    O\n" +
              "   O _\n" +
              "  O O _\n" +
              " O O O O\n" +
              "O O O O O\n", sb1.toString());
      model1.move(4, 4, 2, 2);
      view1.renderBoard();
      assertEquals("    _\n" +
              "   O O\n" +
              "  O O O\n" +
              " O O O O\n" +
              "O O O O O\n" +
              "    O\n" +
              "   O _\n" +
              "  O O _\n" +
              " O O O O\n" +
              "O O O O O\n" +
              "    O\n" +
              "   O _\n" +
              "  O O O\n" +
              " O O O _\n" +
              "O O O O _\n", sb1.toString());
      view1.renderMessage("Test Message\n");
      assertEquals("    _\n" +
              "   O O\n" +
              "  O O O\n" +
              " O O O O\n" +
              "O O O O O\n" +
              "    O\n" +
              "   O _\n" +
              "  O O _\n" +
              " O O O O\n" +
              "O O O O O\n" +
              "    O\n" +
              "   O _\n" +
              "  O O O\n" +
              " O O O _\n" +
              "O O O O _\n" +
              "Test Message\n", sb1.toString());
    } catch (IOException i) {
      System.out.println("unable to render test.");
    }

  }
}