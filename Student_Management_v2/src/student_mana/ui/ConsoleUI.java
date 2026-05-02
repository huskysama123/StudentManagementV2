package student_mana.ui;

import java.io.IO;
import java.util.Scanner;
import java.util.function.Function;

import student_mana.business.IStudentService;
import student_mana.business.StudentService;
import student_mana.data.StudentFileRepository;
import student_mana.model.Student;
import student_mana.utils.ValidationUtils;

public class ConsoleUI {
    private int choice;
    private IStudentService service = new StudentService();
    private StudentFileRepository stFile;
    private ValidationUtils validCheck;
    private Scanner ip = new Scanner(System.in);

    private boolean isValid;

    public ConsoleUI() {
        // stFile = new StudentFileRepository();
    }

    public void startMenu() {
        boolean isKeepUsing = true;
        while (isKeepUsing) {
            printMenu();
            choice = Integer.parseInt(ip.nextLine().trim());
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
                    System.out.println("Invalid choice. Please enter an integer!");
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

    // Input information of student
    public void inputInformation() {
        String name = intputString("Enter your name: ",
    "Name must contain letters only!",
        validCheck::isValidName);
        int age = inputInt("Enter your age: ");
        String address = intputString("Enter your address: ","",s->true);
        String email = intputString("Enter your email: ","Invalid email format!", validCheck::isValidEmail);
        double gpa = inputDouble("Enter your GPA: ");
        Student s = new Student(null, name, age, address, email, gpa);
        service.addStudent(s);
    }

    // Check validate input an integer number
    private int inputInt(String prompt) {
        int num = 0;
        do {
            isValid = true;
            try {
                System.out.print(prompt);
                num = Integer.parseInt(ip.nextLine().trim());
                if (!validCheck.isValidAge(num)) {
                    System.out.println("Please enter age in range 18 - 100");
                    isValid = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer!");
                isValid = false;
            }
        } while (!isValid);
        return num;
    }

    // Check validate a String from users input
    private String intputString(String prompt, String errorMsg, Function<String, Boolean> validator) {
        // String inputAString = "";
        // do {
        // isValid = true;
        // System.out.println(prompt);
        // inputAString = ip.nextLine().trim();
        // // Call function isValidName to check input if
        // if (!validCheck.isValidName(inputAString)) {
        // System.out.println("Input is only letters!");
        // isValid = false;
        // }
        // } while (!isValid);
        // return inputAString;

        String input = "";
        boolean isValid;
        do {
            isValid = true;
            System.out.println(prompt);
            input = ip.nextLine().concat(input);
            if (!validator.apply(input)) {
                System.out.println(errorMsg);
                isValid = false;
            }
        } while (!isValid);
        return input;
    }

    // Check validate input an integer number
    private double inputDouble(String prompt) {
        double num = 0;
        do {
            isValid = true;
            try {
                System.out.print(prompt);
                num = Double.parseDouble(ip.nextLine().trim());
                if (num < 0 || num > 4.0) {
                    System.out.println("GPA is invalid in range 0 - 4.0");
                    isValid = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid GPA. Please enter a double number!");
                isValid = false;
            }
        } while (!isValid);
        return num;
    }
}
