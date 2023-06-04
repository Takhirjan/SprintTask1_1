package com.takhir.SprintTask1.DBConnect;

import com.takhir.SprintTask1.model.Student;
import java.util.ArrayList;

public class DBConnector {
  private static final ArrayList<Student> students=new ArrayList<>();
  private static Long id=6L;
  static{
    students.add(new Student(1L,"Takhirzhan","Imenov",88,"B"));
    students.add(new Student(2L,"Sayat","Orynbassarov",98,"A"));
    students.add(new Student(3L,"Aybek","Serikovich",40,"F"));
    students.add(new Student(4L,"Madina","Erkekyzy",33,"F"));
    students.add(new Student(5L,"Beka","Sekosh",65,"c"));
  }
  public static ArrayList<Student> getStudents(){
    return students;
  }
  public static void addStudent(Student student){
    student.setId(id);
    id++;
    students.add(student);
  }

  public static Student getStudent(int id){
    return students.stream()
        .filter(student -> student.getId()==id)
        .findFirst().orElse(null);
  }
}
