package com.example.demo.repository;

import com.example.demo.model.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

    Optional<Task> findById(long id);

    Task save(Task task);

    void deleteById(long id);

    Iterable<Task> findAll();

    @Modifying
    @Query("UPDATE Task t SET t.done = TRUE WHERE t.id =:id")
    void markAsDone(@Param("id") Long id);
}
