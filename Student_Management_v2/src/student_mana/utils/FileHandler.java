package student_mana.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import student_mana.model.Student;

public class FileHandler {
    private String fileName = "students.txt";
    public FileHandler() {
    }

    // Write data to file
    public void saveToFile(List<Student> studentList) {
        File file = new File(fileName);
        File parentDir = file.getParentFile();
        // Check if the parent folder(utils) does not have, then create new file
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : studentList) {
                String line = s.getStudentID() + "|" +
                        s.getAge() + "|" +
                        s.getAddress() + "|" +
                        s.getEmail() + "|" +
                        s.getGpa();
                bw.write(line);
                bw.newLine();
                // bw.close();
            }
            System.out.println("File is saved in " + fileName + " sucessfull!");
        } catch (IOException e) {
            System.out.println("Error while saving file: " + e.getMessage());
        }
    }

    // Load data from file
    public List<Student> loadFromFile() {
        List<Student> sData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("|");
                Student s = new Student(data[0], // student id
                        data[1], // student name
                        Integer.parseInt(data[2]), // Student age
                        data[3], // address
                        data[4], // email
                        Double.parseDouble(data[5])); // gpa
                sData.add(s);
            }

        } catch (IOException e) {
            System.out.println("No file found!" + e.getMessage());
        }
        return sData;
    }
    // Export to csv file
}
