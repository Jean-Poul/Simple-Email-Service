package com.example.emailservice.repository;

import com.example.emailservice.model.UserComplaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserComplaintRepository extends JpaRepository<UserComplaint, Long> {
    // Make unique queries here if needed
}
