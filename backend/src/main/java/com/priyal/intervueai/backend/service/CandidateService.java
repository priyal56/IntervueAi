package com.priyal.intervueai.backend.service;

import com.priyal.intervueai.backend.entity.Candidate;
import com.priyal.intervueai.backend.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public Candidate saveUser(Candidate candidate) {
        if(candidateRepository.existsByEmail(candidate.getEmail())) {
            throw new IllegalArgumentException("User with email " + candidate.getEmail() + " already exists.");
        }
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getAllUsers() {
        return candidateRepository.findAll();
    }

    public Candidate getUserById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found."));
    }

    public void deleteUserById(Long id) {
        if(!candidateRepository.existsById(id)) {
            throw new IllegalArgumentException("User with id " + id + " not found.");
        }
        candidateRepository.deleteById(id);
    }

    public Candidate updateUser(Long id, Candidate updatedCandidate) {
        Candidate existingCandidate = candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found."));
        existingCandidate.setName(updatedCandidate.getName());
        existingCandidate.setEmail(updatedCandidate.getEmail());
        existingCandidate.setPassword(updatedCandidate.getPassword());
        existingCandidate.setExperienceYears(updatedCandidate.getExperienceYears());
        existingCandidate.setCurrentCompany(updatedCandidate.getCurrentCompany());
        existingCandidate.setTargetCompany(updatedCandidate.getTargetCompany());

        return candidateRepository.save(existingCandidate);
    }
}
