package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.LeaveRequest;
@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long>{

}
