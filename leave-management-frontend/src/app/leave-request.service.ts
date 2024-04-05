import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LeaveRequestService {
  getAllLeaveRequests() {
    throw new Error('Method not implemented.');
  }

  private apiUrl = 'http://localhost:8080/api/leave-requests';

  constructor(private http: HttpClient) { }
  createLeaveRequest(leaveRequest: any): Observable<any> {
    return this.http.post(this.apiUrl, leaveRequest);
  }
  approveLeaveRequest(id: number, manager1: boolean, manager2: boolean): Observable<any> {
    return this.http.put('${this.apiUrl}/${id}/approve?manager1=${manager1}&manager2=${manager2}', {});
  }

  rejectLeaveRequest(id: number): Observable<any> {
    return this.http.put('${this.apiUrl}/${id}/reject', {});
  }

}
