package student_mana.main;

import java.util.ArrayList;
import java.util.List;

import student_mana.model.Student;
import student_mana.ui.ConsoleUI;
import student_mana.utils.FileHandler;

public class App {
    public static void main(String[] args) throws Exception {
        ConsoleUI ui = new ConsoleUI();
        Student s1 = new Student(null, "king husky",
                20, "can tho", "kighusky123@gmail.com", 2.4);
        Student s2 = new Student(null, "king husky 2",
                20, "can tho", "kighusky123@gmail.com", 1.4);
        Student s3 = new Student(null, "king husky 3",
                20, "can tho", "kighusky123@gmail.com", 4.0);
        ui.startMenu();
        
    }
}
