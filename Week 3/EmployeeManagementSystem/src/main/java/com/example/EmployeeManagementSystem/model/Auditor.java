package com.example.EmployeeManagementSystem.model;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class Auditor implements AuditorAware<String> {

    public Optional<String> getCurrentAuditor() {
        return Optional.of("Ayan Chatterjee");
    }
}
