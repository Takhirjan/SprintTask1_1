package com.takhir.SprintTask1.Controller;

import com.takhir.SprintTask1.DBConnect.DBConnector;
import com.takhir.SprintTask1.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
@Controller
public class HomeController {
@GetMapping(value = "/students")
  public String indexPage(Model model){
  ArrayList<Student> students= DBConnector.getStudents();
  model.addAttribute("students",students);
  return "index";
}
@PostMapping(value = "/add-student")
  public String addStudent(Student student){
  DBConnector.addStudent(student);
  if(student.getExam()>=80){
    student.setMark("A");
  } else if (student.getExam()>=75) {
    student.setMark("B");
  }else if(student.getExam()>=60){
    student.setMark("C");
  }else if(student.getExam()>=50){
    student.setMark("D");
  }else{
    student.setMark("F");
  }
  return "redirect:/students";
}
  @GetMapping(value = "/add-student")
  public String addStudentPage(Model model) {
    return "addExam";
  }
}
