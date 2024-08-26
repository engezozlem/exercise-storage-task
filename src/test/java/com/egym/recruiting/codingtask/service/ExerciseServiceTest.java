package com.egym.recruiting.codingtask.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.egym.recruiting.codingtask.dao.ExerciseRepository;
import com.egym.recruiting.codingtask.model.Exercise;
import com.egym.recruiting.codingtask.service.exception.NotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExerciseServiceTest {

  @Mock
  private ExerciseRepository exerciseRepository;

  @Test
  void insert_simpleReturn() {
    Exercise exercise = new Exercise();
    exercise.setUserId(0L);
    exercise.setStartTime(LocalDateTime.now());
    exercise.setDuration(0L);

    when(exerciseRepository.save(exercise)).thenReturn(exercise);

    ExerciseService exerciseService = new ExerciseService(exerciseRepository);
    Exercise result = exerciseService.insert(exercise);
    Assertions.assertEquals(exercise, result);
  }

  @Test
  void update_notFound() {
    final Long exerciseId = ThreadLocalRandom.current().nextLong();
    Exercise exercise = new Exercise();
    exercise.setUserId(0L);
    exercise.setStartTime(LocalDateTime.now());
    exercise.setDuration(0L);

    when(exerciseRepository.findById(exerciseId)).thenReturn(Optional.empty());

    ExerciseService exerciseService = new ExerciseService(exerciseRepository);
    assertThrows(NotFoundException.class, () -> exerciseService.update(exerciseId, exercise));
  }
}
