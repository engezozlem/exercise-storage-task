package com.egym.recruiting.codingtask.controller.http;

import com.egym.recruiting.codingtask.controller.http.dto.ExerciseDTO;
import com.egym.recruiting.codingtask.model.Exercise;
import com.egym.recruiting.codingtask.service.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Exercises", description = "The Exercises API.")
@Controller
@RequestMapping("/exercise")
public class ExerciseApiController {

  private final ExerciseService exerciseService;

  public ExerciseApiController(final ExerciseService exerciseService) {
    this.exerciseService = exerciseService;
  }

  @Operation(summary = "Insert a new exercise for a user.", description = "Persist a new exercise and generate its id.")
  @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Exercise created")})
  @PostMapping(produces = {"application/json"}, consumes = {"application/json"})
  public ResponseEntity<ExerciseDTO> insert(@Valid @RequestBody final ExerciseDTO dto) {
    Exercise exercise = ExerciseDTO.toExercise(dto);
    Exercise insertedExercise = exerciseService.insert(exercise);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(ExerciseDTO.fromExercise(insertedExercise));
  }

  @Operation(summary = "Update an existing exercise for a user.", description = "Update an already persisted exercise. Exercise id, user id and exercise type are excluded from the update.")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Exercise updated")})
  @PutMapping(value = "/{exerciseId}", produces = {"application/json"}, consumes = {
      "application/json"})
  public ResponseEntity<ExerciseDTO> update(
      @Parameter(description = "ID of the exercise to update", required = true) @PathVariable("exerciseId") final Long exerciseId,
      @Parameter(description = "", required = true) @Valid @RequestBody final ExerciseDTO dto) {
    Exercise exercise = ExerciseDTO.toExercise(dto);
    Exercise updateExercise = exerciseService.update(exerciseId, exercise);
    return ResponseEntity.ok(ExerciseDTO.fromExercise(updateExercise));
  }

}
