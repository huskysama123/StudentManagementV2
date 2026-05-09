package student_mana.business;

import java.util.List;

import student_mana.data.IStudentREpository;
import student_mana.data.StudentFileRepository;
import student_mana.model.Student;
import student_mana.utils.ValidationUtils;

public class StudentService implements IStudentService {
    private IStudentREpository respository = new StudentFileRepository();

    @Override
    public void addStudent(Student s) {
        s.setStudentID(generateID());
        respository.save(s);
    }

    // Check if email is duplicated
    public boolean isDuplicateEmail(String email) {
        // Check duplicated email
        for (Student student : respository.findAll()) {
            if (student.getEmail().equals(email)) {
                // System.out.println("Duplicated Email!");
                return true;
            }
        }
        return false;
    }

    /**
     * Generates a new Student ID based on the maximum existing ID.
     * The new ID will have the format "SV" followed by 3 digits (e.g., SV001,
     * SV012).
     *
     * @return The new Student ID as a String.
     */
    private String generateID() {
        int maxId = 0;
        int newId = 0;
        List<Student> list = respository.findAll();
        for (Student s : list) {
            String id = s.getStudentID();
            // Check if the ID is valid and starts with the prefix "SV"
            if (id != null && id.startsWith("SV")) {
                // Extract the numeric part form the ID
                String numParts = id.substring(2);
                int num = Integer.parseInt(numParts);
                // Update the maximum ID found
                if (num > maxId) {
                    maxId = num;
                }
            }
        }
        newId = maxId + 1;
        // Format the number to a 3-digit string, adding leading zeros if necessary
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
        return respository.findAll();
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
