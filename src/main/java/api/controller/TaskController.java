package api.controller;

import api.dto.task.TaskFilter;
import api.dto.task.TaskResponse;
import api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
  private final TaskService taskService;

  @GetMapping
  public ResponseEntity<List<TaskResponse>> getTasks(TaskFilter taskFilter) {
    List<TaskResponse> tasks = taskService.getTasks(taskFilter.getName());
    return ResponseEntity.ok(tasks);
  }
}
