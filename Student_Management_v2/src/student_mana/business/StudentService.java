package student_mana.business;

import java.util.List;

import student_mana.data.IStudentREpository;
import student_mana.model.Student;
import student_mana.utils.ValidationUtils;

public class StudentService implements IStudentService {
    private IStudentREpository respository;

    @Override
    public void addStudent(Student s) {
        // Check duplicated email
        for (Student student : respository.findAll()) {
            if (student.getEmail().equals(s.getEmail())) {
                System.out.println("Duplicated Email!");
                return;
            }
        }
        s.setStudentID(generateID());
        respository.save(s);
    }

    private boolean isDuplicateEmail(String email) {
        return false;
    }

    private String generateID() {
        int maxId = 0;
        int newId = 0;
        List<Student> list = respository.findAll();
        for (Student s : list) {
            String id = s.getStudentID();
            if (id != null && id.startsWith("SV")) {
                String numParts = id.substring(2);
                int num = Integer.parseInt(numParts);
                if (num > maxId) {
                    maxId = num;
                }
            }
        }
        newId = maxId + 1;
        return "SV" + String.format("%03d", newId);
    }

    @Override
    public boolean findId(String id) {
        return false;
    }

    @Override
    public boolean updateStudent(String id, Student newData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStudent'");
    }

    @Override
    public boolean deleteStudent(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }

    @Override
    public List<Student> getAllStudents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllStudents'");
    }

    @Override
    public List<Student> searchByName(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByName'");
    }

    @Override
    public double getAverageGPA() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAverageGPA'");
    }

}
