package com.egym.recruiting.codingtask.controller.http;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class ExerciseApiControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void insert() throws Exception {
    final String body = """
        {
          "calories": 10.6,
          "description": "Swimming exercise",
          "duration": 10,
          "startTime": "2022-07-21T15:00:00Z",
          "type": "SWIMMING",
          "userId": 256
        }
        """;

    mockMvc.perform(post("/exercise")
            .accept(MediaType.APPLICATION_JSON_VALUE)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content(body))
        .andExpect(status().isCreated());
  }
}