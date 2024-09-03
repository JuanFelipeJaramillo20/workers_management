package com.tg1.tg1.Repositories;

import com.tg1.tg1.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

