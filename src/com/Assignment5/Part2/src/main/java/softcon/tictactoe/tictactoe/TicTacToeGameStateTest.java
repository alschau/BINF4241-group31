package com.Assignment5.Part2.src.main.java.softcon.tictactoe.tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import softcon.tictactoe.DiscreteGameState;
import softcon.tictactoe.Position;

import java.util.List;


public class TicTacToeGameStateTest {

  private softcon.tictactoe.tictactoe.TicTacToeGameState game;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setup() {
    game = new softcon.tictactoe.tictactoe.TicTacToeGameState();
  }

  // -- constructor

  @Test
  public void startingPlayerIsX() {
    Assert.assertEquals(new softcon.tictactoe.tictactoe.TicTacToeGameState().getCurrentPlayer(), softcon.tictactoe.tictactoe.TicTacToeGameState.Player.X);
  }

  @Test
  public void copyConstructorDeepCopiesBoard() {
    game.play(0, 0);
    softcon.tictactoe.tictactoe.TicTacToeGameState copy = new softcon.tictactoe.tictactoe.TicTacToeGameState(game);
    Assert.assertEquals(copy.getGameBoard(), game.getGameBoard());
    Assert.assertEquals(copy.getLastMove(), game.getLastMove());
    Assert.assertEquals(copy.getCurrentPlayer(), game.getCurrentPlayer());
  }

  // -- availableStates

  @Test
  public void getAvailableStatesEmptyBoard() {
    softcon.tictactoe.tictactoe.TicTacToeGameState game = new softcon.tictactoe.tictactoe.TicTacToeGameState();
    List<DiscreteGameState> states = game.availableStates();
    Assert.assertTrue(states.size() == 9);
  }

  @Test
  public void getAvailableStatesLastOne() {
    softcon.tictactoe.tictactoe.TicTacToeGameState game = new softcon.tictactoe.tictactoe.TicTacToeGameState();
    game.play(0, 0);
    game.play(0, 1);
    game.play(0, 2);
    game.play(1, 0);
    game.play(1, 1);
    game.play(1, 2);
    game.play(2, 0);
    game.play(2, 1);

    List<DiscreteGameState> states = game.availableStates();
    Assert.assertTrue(states.size() == 1);
    softcon.tictactoe.tictactoe.TicTacToeGameState availableState = (softcon.tictactoe.tictactoe.TicTacToeGameState) states.get(0);
    Assert.assertEquals(availableState.getCurrentPlayer(),
        softcon.tictactoe.tictactoe.TicTacToeGameState.Player.opponentOf(game.getCurrentPlayer()));
    Assert.assertEquals(availableState.getLastMove(), (new Position(2, 2)));
  }

  @Test
  public void getAvailableStatesCompleteBoard() {
    softcon.tictactoe.tictactoe.TicTacToeGameState game = new softcon.tictactoe.tictactoe.TicTacToeGameState();
    game.play(0, 0);
    game.play(0, 1);
    game.play(0, 2);
    game.play(1, 0);
    game.play(1, 1);
    game.play(1, 2);
    game.play(2, 0);
    game.play(2, 1);
    game.play(2, 2);

    Assert.assertTrue(game.availableStates().isEmpty());
  }

  // -- hasWin

  @Test
  public void hasWinRow() {
    game.play(0, 0);
    game.play(0, 1);
    game.play(0, 2);
    Assert.assertTrue(game.hasWin(softcon.tictactoe.tictactoe.TicTacToeGameState.Player.X));
  }

  @Test
  public void hasWinCol() {
    game.play(0, 0);
    game.play(1, 0);
    game.play(2, 0);
    Assert.assertTrue(game.hasWin(softcon.tictactoe.tictactoe.TicTacToeGameState.Player.X));
  }

  @Test
  public void hasWinDiagonal() {
    game.play(0, 0);
    game.play(1, 1);
    game.play(2, 2);
    Assert.assertTrue(game.hasWin(softcon.tictactoe.tictactoe.TicTacToeGameState.Player.X));
  }

  // -- isOver

  @Test
  public void isOverWin() {
    game.play(0, 0);
    game.play(0, 1);
    game.play(0, 2);
    Assert.assertTrue(game.isOver());
  }

  @Test
  public void isOverDraw() {
    // XOX
    // OXX
    // OXO
    game.play(0, 0);
    game.play(0, 2);
    game.play(1, 1);
    game.play(1, 2);
    game.play(2, 1);
    game.switchPlayer();
    game.play(0, 1);
    game.play(1, 0);
    game.play(2, 0);
    game.play(2, 2);

    Assert.assertTrue(game.isOver());
  }

  // -- play

  @Test
  public void playOnBoard() {
    Assert.assertTrue(game.play(0, 0));
    Assert.assertEquals(game.getLastMove(), new Position(0, 0));
  }

  @Test
  public void playOffBoard() {
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("(-1,0) is off the board");
    game.play(-1, 0);
  }

  @Test
  public void playSameLocation() {
    Assert.assertTrue(game.play(0, 0));
    Assert.assertTrue(game.play(0, 1));
    // should not affect the last move
    Assert.assertFalse(game.play(0, 0));
    Assert.assertEquals(game.getLastMove(), new Position(0, 1));
  }

  // -- switchPlayer

  @Test
  public void switchPlayer() {
    Assert.assertEquals(game.getCurrentPlayer(), softcon.tictactoe.tictactoe.TicTacToeGameState.Player.X);
    game.switchPlayer();
    Assert.assertEquals(game.getCurrentPlayer(), softcon.tictactoe.tictactoe.TicTacToeGameState.Player.O);
    game.switchPlayer();
    Assert.assertEquals(game.getCurrentPlayer(), softcon.tictactoe.tictactoe.TicTacToeGameState.Player.X);
  }
}
