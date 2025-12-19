package api.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class TaskResponse {
  private Long id;
  private String name;
  private String text;
  private LocalDateTime assignedTo;
}
