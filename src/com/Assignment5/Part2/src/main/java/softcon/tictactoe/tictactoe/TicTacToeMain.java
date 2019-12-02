package com.Assignment5.Part2.src.main.java.softcon.tictactoe.tictactoe;

import com.Assignment5.Part2.src.main.java.softcon.tictactoe.ai.GameIntelligenceAgent;
import com.Assignment5.Part2.src.main.java.softcon.tictactoe.ai.MinimaxAgent;
import com.Assignment5.Part2.src.main.java.softcon.tictactoe.tictactoe.TicTacToeGameState.Player;

import java.util.Scanner;

public class TicTacToeMain {

  /**
   * @param args
   */
  public static void main(String[] args) {
    softcon.tictactoe.ai.heuristic.tictactoe.TicTacToeEvaluator evaluator = new softcon.tictactoe.ai.heuristic.tictactoe.TicTacToeEvaluator(Player.O);
    GameIntelligenceAgent<TicTacToeGameState> agent =
            (GameIntelligenceAgent<TicTacToeGameState>) new MinimaxAgent<TicTacToeGameState>(evaluator);
    Scanner scanner = new Scanner(System.in);
    TicTacToeGameRunner game = new TicTacToeGameRunner(agent, scanner, System.out);

    game.run();
  }

}
