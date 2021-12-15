package cs3500.marblesolitaire.controller;

import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;


/**
 * tests the MS ControllerImpl.
 */
public class MarbleSolitaireControllerImplTest {

  /**
   * tests that illegalArgeException called when null inputs.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    Readable readable = new StringReader("A");
    MarbleSolitaireModel model = new MockSolitaireModel(new StringBuilder(), false, 0);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, new StringBuilder());
    new MarbleSolitaireControllerImpl(null, view, readable);
    new MarbleSolitaireControllerImpl(model, null, readable);
    new MarbleSolitaireControllerImpl(model, view, null);
    new MarbleSolitaireControllerImpl(null, null, null);

  }

  /**
   * tests that if Readable runs out of inputs playGame throws IllegalStateException.
   */
  @Test(expected = IllegalStateException.class)
  public void testReadableRunOut() {
    Readable input = new StringReader("");
    Appendable viewInput = new StringBuilder();
    StringBuilder mockLog = new StringBuilder();
    MarbleSolitaireModel model = new MockSolitaireModel(mockLog, false, 0);
    MarbleSolitaireView view = new MarbleSolitaireTextView(model, viewInput);
    MarbleSolitaireControllerImpl controller =
            new MarbleSolitaireControllerImpl(model, view, input);
    controller.playGame();
  }

  /**
   * tests taht controller quits game when passed "q".
   */
  @Test
  public void testQuitGame() {

    //test proper inputs in sequence affecting mock model
    //test message sent when invalid numbers

    ArrayList<String> inputs =
            new ArrayList<String>(Arrays.asList("q",
                    "1 2 3 4 q",
                    "1 2 3 4 1 2 3 4 1 2 3 4 1 2 3 4 q",
                    "alskdjc q", "-1 -23 dkd q"));
    String[] expectedOutputs = {"\nScore: 1\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "\n" +
            "Score: 1",
                                "\nScore: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "please input integer\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\nScore: 1\n" +
                                        "please input integer greater than or equal to 1.\n" +
                                        "please input integer greater than or equal to 1.\n" +
                                        "please input integer\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1" };

    for (String s : inputs) {
      Readable input = new StringReader(s);
      Appendable viewInput = new StringBuilder();
      StringBuilder mockLog = new StringBuilder();
      MarbleSolitaireModel model = new MockSolitaireModel(mockLog, false, 0);
      MarbleSolitaireView view = new MarbleSolitaireTextView(model, viewInput);
      MarbleSolitaireControllerImpl controller =
              new MarbleSolitaireControllerImpl(model, view, input);
      controller.playGame();
      assertEquals(expectedOutputs[inputs.indexOf(s)], viewInput.toString());
    }
  }

  /**
   * tests that any input other than integer greater than 0
   * is rejected and message printed.
   */
  @Test
  public void testInvalidInput() {

    ArrayList<String> inputs = new ArrayList<String>(Arrays.asList("-1 2 3 4 q",
            "1 2 3 -4 4 a 5 4 q",
            "1 2 akljd 4 5 q",
            "1 * 3 3 0 q",
            "1 2 3 4 5 2.39 q"));

    String[] expectedOutputs = {"\n" +
            "Score: 1\n" +
            "please input integer greater than or equal to 1.\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "\n" +
            "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "please input integer greater than or equal to 1.\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "please input integer\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "please input integer\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "please input integer\n" +
                                        "please input integer greater than or equal to 1.\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "please input integer\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" + "\n" +
                                        "Score: 1" };

    for (String s : inputs) {
      Readable input = new StringReader(s);
      Appendable viewInput = new StringBuilder();
      StringBuilder mockLog = new StringBuilder();
      MarbleSolitaireModel model = new MockSolitaireModel(mockLog, false, 0);
      MarbleSolitaireView view = new MarbleSolitaireTextView(model, viewInput);
      MarbleSolitaireControllerImpl controller =
              new MarbleSolitaireControllerImpl(model, view, input);
      controller.playGame();
      assertEquals(expectedOutputs[inputs.indexOf(s)], viewInput.toString());
    }
  }

  /**
   * tests that after some valid move if model says game is over
   * game over message is sent.
   */
  @Test
  public void testGameOverMessage() {
    ArrayList<String> inputs = new ArrayList<String>(Arrays.asList("1 2 3 4",
            "1 2 3 4 3 3 4 3", "8 5 5 7 2 3 5 7 5 3 3 2"));
    String[] expectedOutputs = {"Game over!\n" +
            "\n" +
            "Score: 1",
                                "Game over!\n" +
                                        "\n" +
                                        "Score: 1",
                                "Game over!\n" +
                                        "\n" +
                                        "Score: 1" };

    for (String s : inputs) {
      Readable input = new StringReader(s);
      Appendable viewInput = new StringBuilder();
      StringBuilder mockLog = new StringBuilder();
      MarbleSolitaireModel model = new MockSolitaireModel(mockLog, true, 0);
      MarbleSolitaireView view = new MarbleSolitaireTextView(model, viewInput);
      MarbleSolitaireControllerImpl controller =
              new MarbleSolitaireControllerImpl(model, view, input);
      controller.playGame();
      assertEquals(expectedOutputs[inputs.indexOf(s)], viewInput.toString());
    }
  }

  /**
   * tests that if controller passes values that model move method throws illegal
   * argument exception for, controller will call view to indicate values are no
   * bueno.
   */
  @Test
  public void testInvalidMove() {
    ArrayList<String> inputs = new ArrayList<String>(Arrays.asList("1 2 3 4 102 3 4 5 q",
            "102 2 5 6 102 3 4 5 3 4 5  q",
            "23 1 3 4 102 3 4 3 102 3 2 3 q",
            "102 1 3 4 12 3 4 3 102 3 2 3 q",
            "102 1 3 4 102 3 4 3 102 3 2 3 q",
            "102 1 3 4 1 3 4 3 3 3 2 3 q"));

    String[] expectedInputs = {"fromRow: 0 fromCol: 1 toRow: 2 toCol: 3 " +
            "fromRow: 101 fromCol: 2 toRow: 3 toCol: 4 ",
                               "fromRow: 101 fromCol: 1 toRow: 4 toCol: 5 " +
                                       "fromRow: 101 fromCol: 2 toRow: 3 toCol: 4 ",
                               "fromRow: 22 fromCol: 0 toRow: 2 toCol: 3 " +
                                       "fromRow: 101 fromCol: 2 toRow: 3 toCol: 2 " +
                                       "fromRow: 101 fromCol: 2 toRow: 1 toCol: 2 ",
                               "fromRow: 101 fromCol: 0 toRow: 2 toCol: 3" +
                                       " fromRow: 11 fromCol: 2 toRow: 3 toCol: 2 " +
                                       "fromRow: 101 fromCol: 2 toRow: 1 toCol: 2 ",
                               "fromRow: 101 fromCol: 0 toRow: 2 toCol: 3 " +
                                       "fromRow: 101 fromCol: 2 toRow: 3 toCol: 2 " +
                                       "fromRow: 101 fromCol: 2 toRow: 1 toCol: 2 ",
                               "fromRow: 101 fromCol: 0 toRow: 2 toCol: 3 " +
                                       "fromRow: 0 fromCol: 2 toRow: 3 toCol: 2 " +
                                       "fromRow: 2 fromCol: 2 toRow: 1 toCol: 2 " };

    String[] expectedOutputs = {"\n" +
            "Score: 1\n" +
            "\n" +
            "Score: 1\n" +
            "Invalid move. Play again. Mock Model 'invalid input'\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "\n" +
            "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "Invalid move. Play again. Mock Model 'invalid input'\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1" };

    for (String s : inputs) {
      Readable input = new StringReader(s);
      Appendable viewInput = new StringBuilder();
      StringBuilder mockLog = new StringBuilder();
      MarbleSolitaireModel model = new MockSolitaireModel(mockLog, false, 0);
      MarbleSolitaireView view = new MarbleSolitaireTextView(model, viewInput);
      MarbleSolitaireControllerImpl controller =
              new MarbleSolitaireControllerImpl(model, view, input);
      controller.playGame();

      //test that values are passed in correctly
      assertEquals(expectedInputs[inputs.indexOf(s)], mockLog.toString());

      assertEquals(expectedOutputs[inputs.indexOf(s)], viewInput.toString());
    }
  }

  /**
   * tests that model receives the correct values from controller (user inputs
   * are subtracted by one to be used by the move method).
   */
  @Test
  public void testInputsToModel() {
    ArrayList<String> inputs = new ArrayList<String>(Arrays.asList("1 2 3 4 38 2 6 5 q",
            "9 5 4 3 6 7 4 4 3 2 5 7 54 3 q",
            "2 4 6 4 6 7 8 53 23 234 6 6 q",
            "3 5 7 3 6 4 6 7 6 4 3 2 3 4 5 6 7 8 6 5 q",
            "33 4 5 34 6 34 4 5 2 1 2 3 3 4 5 6 4 6 8 4 q",
            "1 2 3 6 8 6 8 9 6 6 4 5 3 6 4 5 q"));

    String[] expectedInputs = {"fromRow: 0 fromCol: 1 toRow: 2 toCol: 3 " +
            "fromRow: 37 fromCol: 1 toRow: 5 toCol: 4 ",
                               "fromRow: 8 fromCol: 4 toRow: 3 toCol: 2 " +
                                       "fromRow: 5 fromCol: 6 toRow: 3 toCol: 3 " +
                                       "fromRow: 2 fromCol: 1 toRow: 4 toCol: 6 ",
                               "fromRow: 1 fromCol: 3 toRow: 5 toCol: 3 " +
                                       "fromRow: 5 fromCol: 6 toRow: 7 toCol: 52 " +
                                       "fromRow: 22 fromCol: 233 toRow: 5 toCol: 5 ",
                               "fromRow: 2 fromCol: 4 toRow: 6 toCol: 2 " +
                                       "fromRow: 5 fromCol: 3 toRow: 5 toCol: 6 " +
                                       "fromRow: 5 fromCol: 3 toRow: 2 toCol: 1 " +
                                       "fromRow: 2 fromCol: 3 toRow: 4 toCol: 5 " +
                                       "fromRow: 6 fromCol: 7 toRow: 5 toCol: 4 ",
                               "fromRow: 32 fromCol: 3 toRow: 4 toCol: 33 " +
                                       "fromRow: 5 fromCol: 33 toRow: 3 toCol: 4 " +
                                       "fromRow: 1 fromCol: 0 toRow: 1 toCol: 2 " +
                                       "fromRow: 2 fromCol: 3 toRow: 4 toCol: 5 " +
                                       "fromRow: 3 fromCol: 5 toRow: 7 toCol: 3 ",
                               "fromRow: 0 fromCol: 1 toRow: 2 toCol: 5 " +
                                       "fromRow: 7 fromCol: 5 toRow: 7 toCol: 8 " +
                                       "fromRow: 5 fromCol: 5 toRow: 3 toCol: 4 " +
                                       "fromRow: 2 fromCol: 5 toRow: 3 toCol: 4 "};
    String[] expectedOutputs = {"\n" +
            "Score: 1\n" +
            "\n" +
            "Score: 1\n" +
            "\n" +
            "Score: 1\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "\n" +
            "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1",
                                "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "\n" +
                                        "Score: 1\n" +
                                        "Game quit!\n" +
                                        "State of game when quit:\n" +
                                        "\n" +
                                        "Score: 1" };

    for (String s : inputs) {
      Readable input = new StringReader(s);
      Appendable viewInput = new StringBuilder();
      StringBuilder mockLog = new StringBuilder();
      MarbleSolitaireModel model = new MockSolitaireModel(mockLog, false, 0);
      MarbleSolitaireView view = new MarbleSolitaireTextView(model, viewInput);
      MarbleSolitaireControllerImpl controller =
              new MarbleSolitaireControllerImpl(model, view, input);
      controller.playGame();

      //test that values are passed in correctly
      assertEquals(expectedInputs[inputs.indexOf(s)], mockLog.toString());

      assertEquals(expectedOutputs[inputs.indexOf(s)], viewInput.toString());
    }
  }

  /**
   * test that valid sequence into controller with real model and view will return real
   * game outputs.
   */
  @Test
  public void testPlayRealGame() {
    Readable in1 = new StringReader(
            "4 2 4 4 6 3 4 3 5 1 5 3 5 4 5" +
                    " 2 5 6 5 4 7 5 5 5 4 5 6 5 7 3 7" +
                    " 5 7 5 5 5 3 3 5 3 1 3 3 3 2 5 4 5" +
                    " 4 5 6 5 6 5 6 3 6 3 4 3 4 3 2 3 3 " +
                    "1 5 1 5 1 5 3 5 3 5 5 3 7 3 5 3 4 3" +
                    " 6 5 7 3 7 3 7 3 5 1 5 1 3 1 3 3 3 3" +
                    " 2 3 4 3 4 3 6 3 6 5 6 5 6 5 4 5 4 3 " +
                    "4 2 4 4 4");
    Appendable vInput1 = new StringBuilder();
    EnglishSolitaireModel esm1 = new EnglishSolitaireModel();
    MarbleSolitaireTextView v1 = new MarbleSolitaireTextView(esm1, vInput1);
    MarbleSolitaireControllerImpl c1 = new MarbleSolitaireControllerImpl(esm1, v1, in1);
    c1.playGame();

    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O O _ O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ _ O O O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ O _ _ O O O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ O O\n" +
            "    O O O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "_ O _ O O _ O\n" +
            "    _ O _\n" +
            "    O O _\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "Score: 25\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "Score: 24\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 23\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O _ O O O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 22\n" +
            "    _ O O\n" +
            "    _ O O\n" +
            "O O O O O O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 21\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ _ O O O O\n" +
            "_ O O O O _ O\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "Score: 20\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O _ _ O\n" +
            "    _ O O\n" +
            "    _ _ _\n" +
            "Score: 19\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ _ O _ O O\n" +
            "_ O O O _ _ O\n" +
            "    O _ _\n" +
            "    _ _ _\n" +
            "Score: 18\n" +
            "    _ O O\n" +
            "    _ O _\n" +
            "O O O O _ O O\n" +
            "O _ O O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 17\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "O O _ O _ O O\n" +
            "O _ _ O _ O O\n" +
            "_ O _ O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 16\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ O _ O O\n" +
            "_ _ _ O _ O O\n" +
            "O O _ O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 15\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ O _ O O\n" +
            "_ _ _ O _ O O\n" +
            "_ _ O O _ _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 14\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ O _ O O\n" +
            "_ _ _ O _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 13\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ O O _ _\n" +
            "_ _ _ O _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 12\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ _ _ O _\n" +
            "_ _ _ O _ O O\n" +
            "_ _ _ _ O _ O\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 11\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ _ _ O O\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 10\n" +
            "    _ O O\n" +
            "    O O _\n" +
            "_ O _ _ O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 9\n" +
            "    O _ _\n" +
            "    O O _\n" +
            "_ O _ _ O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 8\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ O O _ O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 7\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ O O _ _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 6\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ O _\n" +
            "_ _ _ O _ O _\n" +
            "_ _ _ _ O _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 5\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ O O _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 4\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 3\n" +
            "    _ _ _\n" +
            "    _ O _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 2\n" +
            "Game over!\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "_ _ _ O _ _ _\n" +
            "_ _ _ _ _ _ _\n" +
            "    _ _ _\n" +
            "    _ _ _\n" +
            "Score: 1", vInput1.toString());
  }
}