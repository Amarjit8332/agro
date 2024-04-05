package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.LeaveRequest;
import com.project.service.LeaveRequestService;

@RestController
@RequestMapping("/api/leave-requests")

public class LeaveRequestController {

	 @Autowired
	    private LeaveRequestService leaveRequestService;
	 @GetMapping
	 public List<LeaveRequest> getAllLeaveRequests() {
	     return leaveRequestService.getAllLeaveRequests();
	 }

	    @PostMapping
	    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
	        return leaveRequestService.createLeaveRequest(leaveRequest);
	    }

	    @PutMapping("/{id}/approve")
	    public LeaveRequest approveLeaveRequest(@PathVariable Long id, @RequestParam boolean manager1, @RequestParam boolean manager2) {
	        return leaveRequestService.approveLeaveRequest(id, manager1, manager2);
	    }

	    @PutMapping("/{id}/reject")
	    public LeaveRequest rejectLeaveRequest(@PathVariable Long id) {
			return leaveRequestService.rejectLeaveRequest(id);
			}

}
