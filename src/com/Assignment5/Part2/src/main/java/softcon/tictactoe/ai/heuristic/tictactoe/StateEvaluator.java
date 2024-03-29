package com.Assignment5.Part2.src.main.java.softcon.tictactoe.ai.heuristic.tictactoe;

import com.Assignment5.Part2.src.main.java.softcon.tictactoe.DiscreteGameState;

/**
 * An evaluator that examines a {@link DiscreteGameState} and calculates a simple heuristic score.
 * 
 * @param <T> the type of game state that this evaluator examines
 */
public interface StateEvaluator<T extends DiscreteGameState> {

  /**
   * Computes the heuristic score for a given game state.
   * 
   * @param state the {@link DiscreteGameState} to evaluate
   * @return an integer score
   */
  int evaluate(T state);
}
