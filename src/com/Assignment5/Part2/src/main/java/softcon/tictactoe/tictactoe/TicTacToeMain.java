package com.Assignment5.Part2.src.main.java.softcon.tictactoe.tictactoe;

import softcon.tictactoe.ai.GameIntelligenceAgent;
import softcon.tictactoe.ai.MinimaxAgent;
import softcon.tictactoe.ai.heuristic.tictactoe.TicTacToeEvaluator;
import com.Assignment5.Part2.src.main.java.softcon.tictactoe.tictactoe.TicTacToeGameState.Player;

import java.util.Scanner;

public class TicTacToeMain {

  /**
   * @param args
   */
  public static void main(String[] args) {
    TicTacToeEvaluator evaluator = new TicTacToeEvaluator(Player.O);
    GameIntelligenceAgent<TicTacToeGameState> agent =
            (GameIntelligenceAgent<TicTacToeGameState>) new MinimaxAgent<TicTacToeGameState>(evaluator);
    Scanner scanner = new Scanner(System.in);
    TicTacToeGameRunner game = new TicTacToeGameRunner(agent, scanner, System.out);

    game.run();
  }

}
