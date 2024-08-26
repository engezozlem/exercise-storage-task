package com.egym.recruiting.codingtask.service;

import com.egym.recruiting.codingtask.dao.ExerciseRepository;
import com.egym.recruiting.codingtask.model.Exercise;
import com.egym.recruiting.codingtask.model.RankingUser;
import com.egym.recruiting.codingtask.service.exception.ConflictException;
import com.egym.recruiting.codingtask.service.exception.NotFoundException;
import com.egym.recruiting.codingtask.service.exception.SecurityException;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Service that coordinates persistence of exercises and user ranking.
 * <p>
 * It is able to save and update exercises. The overlapping exercises per user are not allowed.
 * <p>
 * Exercises that started or finished in the past 28 days count toward the ranking. Order is
 * according to the user's points in descending order. When two users have the same amount of
 * points, the user with the latest done exercise is ranked first in the list.
 * <p>
 * Number of points of the exercise is equal to the burned calories, or the duration of exercise
 * multiplied to the coefficient from the exercise's type if the `calories` is empty.
 * <p>
 * Note: the past 28 days are the days between the beginning of the day that is 28 days in past and
 * the beginning of today in UTC timezone. Let's assume that today is 24 June 2021 at 2PM, then the
 * range will be 27 May 2021 00:00 UTC until 24 June 2021 00:00 UTC.
 */
@Service
public class ExerciseService {

  private final ExerciseRepository exerciseRepository;

  public ExerciseService(final ExerciseRepository exerciseRepository) {
    this.exerciseRepository = exerciseRepository;
  }

  /**
   * Persists the exercise.
   * <p>
   * The method checks that there is no other exercise already present for the user id, in the
   * period (start + duration) where the new exercise will take place.
   *
   * @param exercise the exercise object.
   * @return the persisted exercise.
   * @throws ConflictException if there is an existing exercise for the exercise's period.
   */
  public Exercise insert(final Exercise exercise) throws ConflictException {
    return null;
  }

  /**
   * Saves the exercise for a given id. Not all fields can be updated, only description, startTime,
   * duration, calories.
   * <p>
   * The method checks that there is no other exercise already present for the user id, in the
   * period (start + duration) where the new exercise will take place.
   *
   * @param exerciseId the id of the exercise to update.
   * @param exercise   the exercise object.
   * @return the save exercise.
   * @throws IllegalArgumentException if the exercise type is different to a persisted one.
   * @throws NotFoundException        if the given exercise id is not present in the database.
   * @throws SecurityException        if the exercise's user is different to a persisted one.
   * @throws ConflictException        if there is an existing exercise for the exercise's period.
   */
  public Exercise update(final Long exerciseId, final Exercise exercise)
      throws IllegalArgumentException, NotFoundException, SecurityException, ConflictException {
    return null;
  }

  /**
   * Calculates ranking for a list of users. Exercises that started or finished in the past 28 days
   * count toward the ranking.
   * <p>
   * The resulting list also contain users who didn't train in the period with 0.0 points and
   * {@link LocalDateTime#MIN} end date and time of the latest user exercise.
   *
   * @param userIds the list of user ids.
   * @return the list of {@link RankingUser} sorted in descending order by points or the end of last
   * exercise if points are the same.
   */
  public List<RankingUser> ranking(final Collection<Long> userIds) {
    return Collections.emptyList();
  }
}
