package org.example.app.task.service;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TaskServiceTest {

  @Test
  public void testFindTaskList() {

    given().when().get("/task/list/1").then().statusCode(200)
        .body(is("{\"id\":1,\"version\":0,\"title\":\"Shopping List\"}"));
  }
}
