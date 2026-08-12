package com.priyal.intervueai.backend.repository;

import com.priyal.intervueai.backend.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}