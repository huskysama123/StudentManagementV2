package student_mana.data;

import java.util.List;

import student_mana.model.Student;

public interface IStudentREpository {
    public boolean save(Student s);

    public Student findById(String id);

    public List<Student> findAll();

    public boolean update(Student s);

    public boolean delete(String id);

}
