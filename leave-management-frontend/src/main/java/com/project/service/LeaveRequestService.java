package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.LeaveRequest;
import com.project.repository.LeaveRequestRepository;

@Service

public class LeaveRequestService {
	@Autowired
    private LeaveRequestRepository leaveRequestRepository;

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest approveLeaveRequest(Long id, boolean manager1, boolean manager2) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("LeaveRequest not found"));
        if (manager1) leaveRequest.setApprovedByManager1(true);
        if (manager2) leaveRequest.setApprovedByManager2(true);

        if (leaveRequest.isApprovedByManager1() && leaveRequest.isApprovedByManager2()) {
            leaveRequest.setStatus(LeaveRequest.LeaveStatus.APPROVED);
        }
        
        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest rejectLeaveRequest(Long id) {
		
    	LeaveRequest leaveRequest=leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("leaveRequest not found"));
    	
    	leaveRequest.setStatus(LeaveRequest.LeaveStatus.REJECTED);
    	 return leaveRequestRepository.save(leaveRequest);

    	
    }

	public List<LeaveRequest> getAllLeaveRequests() {
		// TODO Auto-generated method stub
		return leaveRequestRepository.findAll();
	}


}
