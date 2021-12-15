package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * represents controller for marble solitaire, passes input to a Marble Solitaire
 * Model, grabs the output from the model, and then passes it to a Marble Solitaire view
 * to display the results.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final MarbleSolitaireModel model;
  private final MarbleSolitaireView view;
  private final Readable in;

  /**
   * constructs MS Controller Implmentation.
   *
   * @param model the MS model we are using.
   * @param view  The MS view we are using.
   * @param in    the Readable we are using to read inputs.
   * @throws IllegalArgumentException if any of the fields are null.
   */
  public MarbleSolitaireControllerImpl(
          MarbleSolitaireModel model, MarbleSolitaireView view, Readable in)
          throws IllegalArgumentException {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("Controller args cannot be null.");
    }

    this.model = model;
    this.view = view;
    this.in = in;

  }

  /**
   * runs through the process of playing a game.
   *
   * @throws IllegalStateException if asked to display something that is undisplayable.
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner scan = new Scanner(this.in);

    while (true) {
      //draws board and score
      if (this.model.isGameOver()) {
        try {
          this.view.renderMessage("Game over!\n");
          this.view.renderBoard();
          this.view.renderMessage("Score: " + this.model.getScore());
        } catch (IOException error) {
          throw new IllegalStateException("Can't display quit message.");
        }
        scan.close();
        return;
      }

      try {
        this.view.renderBoard();
        this.view.renderMessage("Score: " + this.model.getScore() + "\n");
      } catch (IOException error) {
        throw new IllegalStateException("Invalid display.");
      }

      List<Integer> inputList = new ArrayList<Integer>();

      while (inputList.size() <= 4) {

        if (inputList.size() == 4) {
          try {
            this.model.move(inputList.get(0), inputList.get(1), inputList.get(2), inputList.get(3));
            break;
          } catch (IllegalArgumentException i) {
            try {
              this.view.renderMessage("Invalid move. Play again. " + i.getMessage() + "\n");
            } catch (IOException io) {
              throw new IllegalStateException("Can't display error message.");
            }
          }
          inputList.clear();
        }

        if (!scan.hasNext()) {
          throw new IllegalStateException("No more inputs to read.");
        }
        String input = scan.next();

        int inputAsInt;

        if (input.equalsIgnoreCase("q")) {
          try {
            this.view.renderMessage("Game quit!\n");
            this.view.renderMessage("State of game when quit:\n");
            this.view.renderBoard();
            this.view.renderMessage("Score: " + this.model.getScore());
          } catch (IOException error) {
            throw new IllegalStateException("Can't display quit message.");
          }
          scan.close();
          return;
        }

        //check that input is a number
        try {
          inputAsInt = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
          try {
            this.view.renderMessage("please input integer\n");
            continue;
          } catch (IOException error) {
            throw new IllegalStateException("Can't display error message.");
          }
        }

        if (inputAsInt < 1) {
          try {
            this.view.renderMessage("please input integer greater than or equal to 1.\n");
            continue;
          } catch (IOException error) {
            throw new IllegalStateException("Can't display error message.");
          }
        }

        //minus one since inputs start at 1
        inputList.add(Integer.parseInt(input) - 1);

      }
    }


  }
}

