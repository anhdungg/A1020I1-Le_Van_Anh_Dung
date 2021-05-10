package model.service.impl;

import model.bean.Student;
import model.repository.StudentRepository;
import model.repository.impl.StudentRepositoryImpl;
import model.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    // DI = Dependency Inversion
    private StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public boolean save(Student student) {

        if (student.getName().matches("[A-Za-z ]+")) {
            return this.studentRepository.save(student);
        }
        return false;
    }
}
