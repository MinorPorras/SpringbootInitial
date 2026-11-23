package com.minor.springboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository repository;

    public SoftwareEngineerService(SoftwareEngineerRepository repository) {
        this.repository = repository;
    }

    public List<SoftwareEngineer> getSoftwareEngineers() {
        return repository.findAll();
    }

    public void addSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        repository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return repository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Software engineer not found"));
    }

}
