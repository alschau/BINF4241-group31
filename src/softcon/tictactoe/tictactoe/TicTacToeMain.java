package softcon.tictactoe.tictactoe;

import softcon.tictactoe.ai.GameIntelligenceAgent;
import softcon.tictactoe.ai.MinimaxAgent;
import softcon.tictactoe.ai.heuristic.tictactoe.TicTacToeEvaluator;
import softcon.tictactoe.tictactoe.TicTacToeGameState.Player;

import java.util.Scanner;

public class TicTacToeMain {

  /**
   * @param args
   */
  public static void main(String[] args) {
    TicTacToeEvaluator evaluator = new TicTacToeEvaluator(Player.O);
    GameIntelligenceAgent<softcon.tictactoe.tictactoe.TicTacToeGameState> agent =
            (GameIntelligenceAgent<softcon.tictactoe.tictactoe.TicTacToeGameState>) new MinimaxAgent<softcon.tictactoe.tictactoe.TicTacToeGameState>(evaluator);
    Scanner scanner = new Scanner(System.in);
    softcon.tictactoe.tictactoe.TicTacToeGameRunner game = new softcon.tictactoe.tictactoe.TicTacToeGameRunner(agent, scanner, System.out);

    game.run();
  }

}
