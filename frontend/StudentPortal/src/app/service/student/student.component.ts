// student.component.ts
import { Component, OnInit } from '@angular/core';
import { StudentService, Student } from './student.service';

@Component({
  selector: 'app-student',
  template: `
    <ul>
      <li *ngFor="let student of students">{{ student.name }} - {{ student.email }}</li>
    </ul>
  `
})
export class StudentComponent implements OnInit {
  students: Student[] = [];

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.studentService.getStudents().subscribe(data => this.students = data);
  }
}
