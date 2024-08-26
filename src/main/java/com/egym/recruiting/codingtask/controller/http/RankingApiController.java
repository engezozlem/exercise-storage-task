package com.egym.recruiting.codingtask.controller.http;

import com.egym.recruiting.codingtask.controller.http.dto.RankingUserDTO;
import com.egym.recruiting.codingtask.model.RankingUser;
import com.egym.recruiting.codingtask.service.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Ranking", description = "The Ranking API.")
@Controller
@RequestMapping("/ranking")
public class RankingApiController {

  private final ExerciseService exerciseService;

  public RankingApiController(final ExerciseService exerciseService) {
    this.exerciseService = exerciseService;
  }

  @Operation(summary = "Get ranking for a set of users.", description = "Calculate the ranking for the given user ids. The calculation is based on the exercises the user has done in the last 28 days. The list is sorted in descending order by user points.")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "successful operation")})
  @GetMapping(produces = {"application/json"})
  public ResponseEntity<List<RankingUserDTO>> ranking(
      @Parameter(description = "List of user ids to rank", required = true) @Valid @RequestParam(value = "userIds") final Set<Long> userIds) {
    List<RankingUser> userRanking = exerciseService.ranking(userIds);
    return ResponseEntity.ok(
        userRanking.stream().map(RankingUserDTO::of).collect(Collectors.toList()));
  }
}
