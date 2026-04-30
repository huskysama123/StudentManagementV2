package student_mana.ui;

import java.io.IO;
import java.util.Scanner;

import student_mana.business.IStudentService;
import student_mana.business.StudentService;
import student_mana.model.Student;

public class ConsoleUI {
    private int choice;
    private IStudentService service = new StudentService();
    private Scanner ip = new Scanner(System.in);

    private boolean isValid = true; // Flag for loop of validate

    // public ConsoleUI() {
    // }

    public void startMenu() {
        boolean isKeepUsing = true;
        while (!isKeepUsing) {
            printMenu();
            choice = inputInt("Enter your Choice: ");
            switch (choice) {
                case 1:
                    inputInformation();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:

                    break;

                default:
                    break;
            }
            isKeepUsing = false;
        }
    }

    private void printMenu() {
        System.out.println("===== STUDENT MANGEMENT =====");
        System.out.println("1. Add student");
        System.out.println("2. Update");
        System.out.println("3. Find student by id");
        System.out.println("4. Delete student");
        System.out.println("5. Show statictisc");
        System.out.println("0. Exit program");
    }

    // Check validate input an integer number
    private int inputInt(String prompt) {
        while (!isValid) {
            try {
                System.out.print(prompt);
                String num = ip.nextLine().trim();
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please eneter an integer!.");
                isValid = false;
            }
        }
        return 0;
    }

    // Check validate a String from users input
    private String intputString(String prompt) {
        String inputAString;
        while (!isValid) {
            System.out.print(prompt);
            inputAString = ip.nextLine().trim();
            if (!inputAString.matches("^[\\p{L} ]+$")) {
                System.out.println("Enter must be letters only!");
                isValid = false;
            } else {
                return inputAString;
            }
        }
        return null;
    }

    // Check validate input an integer number
    private double inputDouble(String prompt) {
        while (!isValid) {
            try {
                System.out.print(prompt);
                String num = ip.nextLine().trim();
                return Double.parseDouble(num);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please eneter double number!.");
                isValid = false;
            }
        }
        return 0;
    }

    // Input information of student
    public void inputInformation() {
        String name = intputString("Enter your name: ");
        int age = inputInt("Enter your age: ");
        String address = intputString("Enter your address: ");
        String email = intputString("Enter your email: ");
        double gpa = inputDouble("Enter your GPA: ");
        Student s = new Student(null, name, age, address, email, gpa);
        service.addStudent(s);
    }
}
