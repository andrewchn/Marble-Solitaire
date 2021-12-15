package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.AbstractMSModel;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.AbstractTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

/**
 * contains main class used to play the game.
 */
public final class MarbleSolitaire {

  /**
   * runs the whole Marble Solitaire program.
   */
  public static void main(String[] args) {
    int size = -1;
    int sRow = -1;
    int sCol = -1;

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-size")) {
        size = Integer.parseInt(args[i + 1]);
      }
      if (args[i].equals("-hole")) {
        sRow = Integer.parseInt(args[i + 1]);
        sCol = Integer.parseInt(args[i + 2]);

      }
    }

    AbstractMSModel model;
    AbstractTextView view;

    if (args[0].equals("english")) {
      if (args.length == 3) {
        model = new EnglishSolitaireModel(size);
      } else if (args.length == 4) {
        model = new EnglishSolitaireModel(sRow, sCol);
      } else if (args.length == 6) {
        model = new EnglishSolitaireModel(size, sRow, sCol);
      } else {
        model = new EnglishSolitaireModel();
      }
      view = new MarbleSolitaireTextView(model);
    } else if (args[0].equals("european")) {
      if (args.length == 3) {
        model = new EuropeanSolitaireModel(size);
      } else if (args.length == 4) {
        model = new EuropeanSolitaireModel(sRow, sCol);
      } else if (args.length == 6) {
        model = new EuropeanSolitaireModel(size, sRow, sCol);
      } else {
        model = new EuropeanSolitaireModel();
      }
      view = new MarbleSolitaireTextView(model);
    } else {
      if (args.length == 3) {
        model = new TriangleSolitaireModel(size);
      } else if (args.length == 4) {
        model = new TriangleSolitaireModel(sRow, sCol);
      } else if (args.length == 6) {
        model = new TriangleSolitaireModel(size, sRow, sCol);
      } else {
        model = new TriangleSolitaireModel();
      }
      view = new TriangleSolitaireTextView(model);
    }

    MarbleSolitaireControllerImpl c =
            new MarbleSolitaireControllerImpl(model, view, new InputStreamReader(System.in));

    c.playGame();
  }


}
