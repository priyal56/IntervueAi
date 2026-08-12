package com.priyal.intervueai.backend.controller;

import com.priyal.intervueai.backend.entity.Candidate;
import com.priyal.intervueai.backend.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping
    public Candidate saveUser(@RequestBody Candidate candidate) {
        return candidateService.saveUser(candidate);
    }

    @GetMapping
    public List<Candidate> getAllUsers() {
        return candidateService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Candidate getUserById(@PathVariable Long id) {
        return candidateService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        candidateService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public Candidate updateUser(@PathVariable Long id, @RequestBody Candidate candidate) {
        return candidateService.updateUser(id, candidate);
    }
}
