package model.repository;

import model.bean.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> findAll();
    boolean save(Student student);
}
