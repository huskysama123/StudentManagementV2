package student_mana.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import student_mana.model.Student;
import student_mana.utils.FileHandler;

public class StudentFileRepository implements IStudentREpository {

    private FileHandler filehander;
    private Map<String, Student> studentsMap;

    public StudentFileRepository() {
        this.studentsMap = new HashMap<>();
        this.filehander = new FileHandler();
        loadDataFromFile();
    }

    private void loadDataFromFile() {
        List<Student> studentList = filehander.loadFromFile();
        for (Student student : studentList) {
            studentsMap.put(student.getStudentID(), student);
        }
    }

    private void saveDataToFile() {
        List<Student> students = new ArrayList<>(studentsMap.values());
        filehander.saveToFile(students);
    }

    @Override
    public boolean save(Student s) {
        if (studentsMap.containsKey(s.getStudentID())) {
            return false;
        }
        studentsMap.put(s.getStudentID(), s);
        saveDataToFile();
        return true;
    }

    @Override
    public boolean update(Student s) {
        if (!studentsMap.containsKey(s.getStudentID())) {
            return false;
        }
        studentsMap.put(s.getStudentID(), s);
        saveDataToFile();
        return true;
    }

    @Override
    public boolean delete(String id) {
        Student removed = studentsMap.remove(id);
        if(removed != null){
            saveDataToFile();
            return true;
        }
        return false;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentsMap.values());
    }

    @Override
    public Student findById(String id) {
        return studentsMap.get(id);
    }

}
