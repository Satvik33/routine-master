package tech.satvik.routine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.satvik.routine.exception.UserNotFoundException;
import tech.satvik.routine.model.Tasks;
import tech.satvik.routine.repo.TasksRepo;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TasksService {
    private final TasksRepo tasksRepo;

    @Autowired
    public TasksService(TasksRepo tasksRepo) {
        this.tasksRepo = tasksRepo;
        System.out.println("inside service");
    }

    public Tasks addTask(Tasks tasks) {
        Date date=java.util.Calendar.getInstance().getTime();
        tasks.setStartTime(date);
        tasks.setCompleted(false);
        return tasksRepo.save(tasks);
    }

    public List<Tasks> findAllTasks() {
        return tasksRepo.findAll();
    }

    public List<Tasks> findAllTasksByPriority() {
        return tasksRepo.findTasksbyPriority();
    }


    public Tasks updateTasks(Tasks tasks) {
        Tasks newTasks = new Tasks();
         newTasks = tasksRepo.save(tasks);
        Date date=java.util.Calendar.getInstance().getTime();
         if(newTasks.isCompleted())
             newTasks.setEndTime(date);
         return newTasks;
    }

    public Tasks findTaskById(Long id) {
        return tasksRepo.findTaskById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteTasks(Long id){
        tasksRepo.deleteTaskById(id);
    }
}
