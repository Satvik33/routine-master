package tech.satvik.routine.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.satvik.routine.model.Tasks;

import java.util.List;
import java.util.Optional;

public interface TasksRepo extends JpaRepository<Tasks, Long> {
    void deleteTaskById(Long id);

    Optional<Tasks> findTaskById(Long id);
    @Query("FROM Tasks ORDER BY priority ASC")
    List<Tasks> findTasksbyPriority();
}
