package api.service;

import api.dto.task.TaskResponse;
import api.model.Task;
import api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TaskService {
  private final TaskRepository taskRepository;

  public List<TaskResponse> getTasks(String name) {
    List<Task> tasks;
    if (name != null && !name.isEmpty()) {
      tasks = taskRepository.findByNameContainingIgnoreCase(name);
    } else {
      tasks = taskRepository.findAll();
    }

    return tasks.stream()
        .map(this::mapToDto)
        .collect(Collectors.toList());
  }

  private TaskResponse mapToDto(Task task) {
    return new TaskResponse(
        task.getId(),
        task.getName(),
        task.getText(),
        task.getAssignedTo()
    );
  }
}
