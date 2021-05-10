package model.repository.impl;

import model.bean.Student;
import model.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Integer, Student> studentMap = new TreeMap<>();

    static {
        studentMap.put(123, new Student(123, "Nguyen Van A",
                "2000-05-31", 1, 7.5, "/img/pig.jpg"));
        studentMap.put(456, new Student(456, "Nguyen Van C",
                "2001-05-31", 0, 3.0, "/img/pig.jpg"));
        studentMap.put(876, new Student(876, "Nguyen Van B",
                "2002-05-31", 1, 9.0, "/img/pig.jpg"));

    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public boolean save(Student student) {
        int idStudent = (int) (Math.random() * 1000);
        student.setId(idStudent);

        studentMap.put(idStudent, student);

        return true;
    }
}
