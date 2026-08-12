package com.priyal.intervueai.backend.repository;

import com.priyal.intervueai.backend.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data JPA reads the method name and generates JPA helps to directly push stuff to db
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    boolean existsByEmail(String email); // Spring creates query automatically

}
