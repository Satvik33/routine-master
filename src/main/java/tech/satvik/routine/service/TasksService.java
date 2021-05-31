package tech.satvik.routine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.satvik.routine.exception.UserNotFoundException;
import tech.satvik.routine.model.Tasks;
import tech.satvik.routine.repo.TasksRepo;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;
import java.util.TimeZone;

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
        long d = System.currentTimeMillis();
        //d+=19800000;
        Date date = new Date(d);
        tasks.setStartTime(date);
        System.out.println(date);
        tasks.setCompleted(false);
        return tasksRepo.save(tasks);
    }

    public List<Tasks> findAllTasks() {
        return tasksRepo.findAllByOrderByStartTimeDesc();
    }

    public List<Tasks> findAllTasksByPriority() {
        return tasksRepo.findTasksbyPriority();
    }


    public Tasks updateTasks(Tasks tasks) {
        Tasks newTasks = tasksRepo.save(tasks);
        /*Date date=java.util.Calendar.getInstance().getTime();*/
        long d = System.currentTimeMillis();
        //d+=19800000;
        Date date = new Date(d);
         if(newTasks.isCompleted())
             newTasks.setEndTime(date);
         return newTasks;
    }

    public Tasks findTaskById(Long id) {
        return tasksRepo.findTaskById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
    public Tasks findTaskByTaskName(String taskName){
        return tasksRepo.findTaskByTaskName(taskName)
                .orElseThrow(() -> new UserNotFoundException("User by id " + taskName + " was not found"));
    }

    public void deleteTasks(Long id){
        tasksRepo.deleteTaskById(id);
    }
}
