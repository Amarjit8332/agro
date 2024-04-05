import { Component } from '@angular/core';
import { LeaveRequestService } from '../leave-request.service';

@Component({
  selector: 'app-leave-application',
  templateUrl: './leave-application.component.html',
  styleUrl: './leave-application.component.css'
})
export class LeaveApplicationComponent {
  leaveRequest = { employeeId: '', reason: '' };

  constructor(private leaveRequestService: LeaveRequestService) { }

  applyForLeave() {
    this.leaveRequestService.createLeaveRequest(this.leaveRequest).subscribe((response: any) => {
      console.log('Leave request submitted:', response);
    });
  }
}

