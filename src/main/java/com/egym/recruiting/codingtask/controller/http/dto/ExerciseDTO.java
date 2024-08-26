package com.egym.recruiting.codingtask.controller.http.dto;

import com.egym.recruiting.codingtask.model.Exercise;
import com.egym.recruiting.codingtask.model.ExerciseType;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Data transfer object for {@link Exercise}.
 */
public class ExerciseDTO {

  private Long id;

  /**
   * User who did the exercise.
   */
  private Long userId;

  /**
   * Type of the exercise.
   */
  private ExerciseType type;

  /**
   * Description of the exercise.
   */
  private String description;

  /**
   * Date and time when the user started the exercise.
   */
  private OffsetDateTime startTime;

  /**
   * Duration of the exercise in seconds.
   */
  private Long duration;

  /**
   * Calories burnt in the exercise.
   */
  private Double calories;

  public static Exercise toExercise(final ExerciseDTO dto) {
    final Exercise e = new Exercise();
    e.setUserId(dto.userId);
    if (dto.description != null) {
      e.setDescription(dto.description.trim());
    }
    e.setType(dto.type);
    if (dto.startTime != null) {
      e.setStartTime(dto.startTime.toLocalDateTime());
    }
    e.setDuration(dto.duration);
    e.setCalories(dto.calories);
    return e;
  }

  public static ExerciseDTO fromExercise(final Exercise e) {
    final ExerciseDTO dto = new ExerciseDTO();
    dto.id = e.getId();
    dto.userId = e.getUserId();
    dto.description = e.getDescription();
    dto.type = e.getType();
    if (e.getStartTime() != null) {
      dto.startTime = e.getStartTime().atOffset(ZoneOffset.UTC);
    }
    dto.duration = e.getDuration();
    dto.calories = e.getCalories();
    return dto;
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(final Long userId) {
    this.userId = userId;
  }

  public ExerciseType getType() {
    return type;
  }

  public void setType(final ExerciseType type) {
    this.type = type;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(final String description) {
    this.description = description;
  }

  public OffsetDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(final OffsetDateTime startTime) {
    this.startTime = startTime;
  }

  public Long getDuration() {
    return duration;
  }

  public void setDuration(final Long duration) {
    this.duration = duration;
  }

  public Double getCalories() {
    return calories;
  }

  public void setCalories(final Double calories) {
    this.calories = calories;
  }
}
