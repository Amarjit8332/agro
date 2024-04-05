import { Component } from '@angular/core';
import { LeaveRequestService } from '../leave-request.service';

@Component({
  selector: 'app-manager-approval',
  templateUrl: './manager-approval.component.html',
  styleUrl: './manager-approval.component.css'
})
export class ManagerApprovalComponent {
leaveRequestId: any;
  

  constructor(private leaveRequestService: LeaveRequestService) { }

  approveLeaveRequest(manager1: boolean, manager2: boolean) {
    this.leaveRequestService.approveLeaveRequest(this.leaveRequestId, manager1, manager2).subscribe(response => {
      console.log('Leave request updated:', response);
    });
  }

  rejectLeaveRequest() {
    this.leaveRequestService.rejectLeaveRequest(this.leaveRequestId).subscribe(response => {
      console.log('Leave request updated:', response);
    });
  }
}

