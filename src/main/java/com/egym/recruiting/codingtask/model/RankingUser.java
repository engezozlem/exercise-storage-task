package com.egym.recruiting.codingtask.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Points from exercises that started or finished in the past 28 days count toward the ranking.
 * <p>
 * See more about calculation in {@link com.egym.recruiting.codingtask.service.ExerciseService}.
 */
public class RankingUser {

  /**
   * User who did the exercises.
   */
  private Long userId;

  /**
   * Points from exercises that user did.
   */
  private double points;

  /**
   * The end date and time of the latest user exercise.
   */
  private LocalDateTime latestExerciseTime;

  public static RankingUser of(final Long userId) {
    RankingUser rankingUser = new RankingUser();
    rankingUser.userId = userId;
    rankingUser.points = 0.0;
    rankingUser.latestExerciseTime = LocalDateTime.MIN;
    return rankingUser;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public double getPoints() {
    return points;
  }

  public void setPoints(final double points) {
    this.points = points;
  }

  public LocalDateTime getLatestExerciseTime() {
    return latestExerciseTime;
  }

  public void setLatestExerciseTime(final LocalDateTime latestExerciseTime) {
    this.latestExerciseTime = latestExerciseTime;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final RankingUser that = (RankingUser) o;
    return userId.equals(that.userId) && (points == that.points) && latestExerciseTime.equals(
        that.latestExerciseTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, points, latestExerciseTime);
  }

  @Override
  public String toString() {
    return "RankingUser{" + "userId=" + userId + ", points=" + points + ", latestExerciseTime="
        + latestExerciseTime + '}';
  }
}
