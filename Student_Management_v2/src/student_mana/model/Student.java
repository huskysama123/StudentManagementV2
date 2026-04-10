package student_mana.model;

public class Student {
    private String studentID;
    private String name;
    private int age;
    private String address;
    private String email;
    private double gpa;

    // Default constructor
    public Student() {
    }

    public Student(String studentID, String name, int age, String address, String email, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.address = address;
        this.email = email;
        this.gpa = gpa;
    }

    // Gettters & setters for all
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [studentID=" + studentID + ", name=" + name + ", age=" + age + ", address=" + address
                + ", email=" + email + ", gpa=" + gpa + "]";
    }
}
