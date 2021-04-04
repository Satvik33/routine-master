package tech.satvik.routine.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.satvik.routine.model.Tasks;
import tech.satvik.routine.service.TasksService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
        System.out.println("inside resource");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tasks>> getAllEmployees () {
        List<Tasks> tasks = tasksService.findAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/priority")
    public ResponseEntity<List<Tasks>> getEmployeesByPriority () {
        List<Tasks> tasks = tasksService.findAllTasksByPriority();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Tasks> getEmployeeById (@PathVariable("id") Long id) {
        Tasks tasks = tasksService.findTaskById(id);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Tasks> addEmployee(@RequestBody Tasks tasks) {
        Tasks newTasks = tasksService.addTask(tasks);
        return new ResponseEntity<>(newTasks, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Tasks> updateEmployee(@RequestBody Tasks tasks) {
        Tasks updateTasks = tasksService.updateTasks(tasks);
        return new ResponseEntity<>(updateTasks, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        tasksService.deleteTasks(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
