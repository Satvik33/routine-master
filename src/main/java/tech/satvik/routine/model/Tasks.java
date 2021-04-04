package tech.satvik.routine.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Tasks implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String taskName;
    private String description;
    private int duration;
    @Column(nullable = false)
    private Date StartTime;
    private Date EndTime;
    private int priority;
    @Column(nullable = false)
    private boolean isCompleted;

    public Tasks() {
    }

    public Tasks(Long id, String taskName, String description, int duration, Date startTime, Date endTime, int priority, boolean isCompleted) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.duration = duration;
        StartTime = startTime;
        EndTime = endTime;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", StartTime=" + StartTime +
                ", EndTime=" + EndTime +
                ", Priority=" + priority +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
