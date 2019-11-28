package com.Assignment5.Part2.src.main.java.softcon.tictactoe.tictactoe;

import softcon.tictactoe.Position;
import softcon.tictactoe.ai.GameIntelligenceAgent;
import softcon.tictactoe.tictactoe.TicTacToeGameState.Player;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * A class for configuring and running a TicTacToe game.
 *
 * 
 */
public class TicTacToeGameRunner {

  /**
   * The instructions for valid human input.
   */
  static final String INSTRUCTION_TEXT =
      "Enter '<row>,<col>' to play a position. For example, '0,2'.";

  private softcon.tictactoe.tictactoe.TicTacToeGameState game;

  private TicTacToeBoardPrinter boardPrinter;
  private GameIntelligenceAgent<softcon.tictactoe.tictactoe.TicTacToeGameState> agent;
  private Scanner scanner;
  private PrintStream printStream;

  /**
   * Creates a new game runner.
   * 
   * @param agent a {@link GameIntelligenceAgent} for choosing the computer opponent's moves
   * @param scanner a {@link Scanner} for collecting user input
   * @param printStream the {@link PrintStream} for displaying text to the user
   */
  public TicTacToeGameRunner(GameIntelligenceAgent<softcon.tictactoe.tictactoe.TicTacToeGameState> agent, Scanner scanner,
                             PrintStream printStream) {
    this.game = new softcon.tictactoe.tictactoe.TicTacToeGameState();
    this.boardPrinter = new TicTacToeBoardPrinter(printStream);
    this.agent = agent;
    this.scanner = scanner;
    this.printStream = printStream;
  }

  /**
   * Runs the TicTacToe game, alternating between human and computer moves until the game is over.
   */
  public void run() {
    printInstructions();
    while (!game.isOver()) {
      moveHuman();
      moveComputer();
      boardPrinter.printGameBoard(game.getGameBoard());
    }
    printGameOver();
  }

  /**
   * Gets the current game state.
   * 
   * @return the game
   */
  softcon.tictactoe.tictactoe.TicTacToeGameState getGame() {
    return game;
  }

  void moveComputer() {
    softcon.tictactoe.tictactoe.TicTacToeGameState nextState = agent.evaluateNextState(game);
    if (nextState == null) {
      return;
    }
    Position nextMove = nextState.getLastMove();
    game.play(nextMove.getRow(), nextMove.getCol());
    game.switchPlayer();
  }

  void moveHuman() {
    Position userPosition;
    while (true) {
      do {
        printStream.print("Player X [row,col]: ");
        String input = scanner.nextLine();
        userPosition = parseUserInput(input);
      } while (userPosition == null);

      try {
        if (game.play(userPosition.getRow(), userPosition.getCol())) {
          game.switchPlayer();
          return;
        } else {
          printStream.printf("(%d,%d) has already been taken. ", userPosition.getRow(),
              userPosition.getCol());
          printInstructions();
        }
      } catch (IllegalArgumentException e) {
        printStream.printf("(%d,%d) is not on the board. ", userPosition.getRow(),
            userPosition.getCol());
        printInstructions();
      }
    }
  }

  private void printGameOver() {
    if (game.hasWin(Player.X)) {
      ((PrintStream) printStream).println("Player X won.");
    } else if (game.hasWin(Player.O)) {
      printStream.println("Player O won.");
    } else {
      printStream.println("Game ended in a draw.");
    }
  }

  private void printInstructions() {
    printStream.println(INSTRUCTION_TEXT);
  }

  private Position parseUserInput(String input) {
    String[] posInput = input.split(",");
    if (posInput.length != 2) {
      printInstructions();
      return null;
    }
    int row, col;
    try {
      row = Integer.parseInt(posInput[0]);
      col = Integer.parseInt(posInput[1]);
    } catch (NumberFormatException e) {
      printInstructions();
      return null;
    }
    return new Position(row, col);
  }

}
