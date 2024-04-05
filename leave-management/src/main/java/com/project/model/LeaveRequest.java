package com.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Data
@AllArgsConstructor
public class LeaveRequest {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    private Long employeeId;
	    private String reason;
	    private boolean approvedByManager1 = false;
	    private boolean approvedByManager2 = false;

	    @Enumerated(EnumType.STRING)
	    private LeaveStatus status = LeaveStatus.PENDING;

	    public enum LeaveStatus {
	        PENDING, APPROVED, REJECTED
	    }


}
