package com.store.onedaySeed.repository;

import com.store.onedaySeed.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}