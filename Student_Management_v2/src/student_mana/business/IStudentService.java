package student_mana.business;

import java.util.List;

import student_mana.model.Student;

public interface IStudentService {
    public void addStudent(Student s);

    public boolean findId(String id);

    public boolean updateStudent(String id, Student newData);

    public boolean deleteStudent(String id);

    public List<Student> getAllStudents();

    public List<Student> searchByName(String keyword);

    public double getAverageGPA();
}
