# Student Management System

A console-based Student Management System built with **Java** using **3-Tier Architecture**. 
Supports full CRUD operations, file storage, and data export.

---

## 📌 Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Installation & Setup](#installation--setup)
- [How to Run](#how-to-run)
- [Usage Guide](#usage-guide)
- [UML Diagram](#uml-diagram)
- [Future Improvements](#future-improvements)
- [Author](#author)

---

## 📖 Overview

This is a **Student Management System** that allows users to:
- Add, view, update, and delete student records
- Search students by ID or name
- View statistics (average GPA, top students)
- Export data to CSV file
- Data persistence using file storage

The system follows **3-Tier Architecture** to ensure separation of concerns and maintainability.

---

## 🏗️ Architecture

The project is structured into **3 distinct layers**:

| Layer             | Package   | Responsibility                              |
|-------------------|-----------|---------------------------------------------|
| **Presentation**  | `ui`      | Console menu, user input/output             |
| **Business**      | `business`| Business logic, validation, GPA calculation |
| **Data**          | `data`    | CRUD operations, file storage               |
| **Model**         | `model`   | Student entity (data carrier)               |
| **Utils**         | `utils`   | File handling, validation helpers           |

### Layer Communication Flow:
User → UI → Service → Repository → File

text

- **UI** only communicates with **Service**
- **Service** contains business logic and calls **Repository**
- **Repository** handles data storage (file)
- **Model** is used across all layers

---

## ✨ Features

| Feature               | Description                            |
|-----------------------|----------------------------------------|
| ➕ **Add Student**    | Add new student with auto-generated ID |
| 🔍 **Find by ID**     | Search student using unique ID         |
| ✏️ **Update Student** | Modify existing student information    |
| 🗑️ **Delete Student** | Remove student from system             |
| 📋 **View All**       | Display all students in formatted table|
| 🔎 **Search by Name** | Find students by name (partial match)  |
| 📊 **Statistics**     | View average GPA and top 3 students    |
| 💾 **Export CSV**     | Export all data to CSV file            |
| 💿 **File Storage**   | Automatic save/load using serialization|

### Validation Rules:

- **ID**: Auto-generated (SV001, SV002...)
- **Name**: Cannot be empty, minimum 2 characters
- **Age**: 18 - 100 years
- **Email**: Valid email format (name@domain.com)
- **GPA**: 0.0 - 4.0

---

## 🛠️ Tech Stack

| Technology           | Purpose                          |
|----------------------|----------------------------------|
| **Java 11+**         | Core programming language        |
| **File I/O**         | Data persistence (serialization) |
| **Java Collections** | Data storage (HashMap, List)     |
| **Console**          | User interface                   |
| **VS Code**          | Development environment          |

---

## 📁 Project Structure
StudentManagement/
├── src/
│   ├── model/
│   │   └── Student.java             # Student entity class
│   ├── data/
│   │   ├── IStudentRepository.java  # Repository interface
│   │   └── StudentFileRepository.java # File-based implementation of Repository
│   ├── business/
│   │   ├── IStudentService.java     # Service interface
│   │   └── StudentService.java      # Business logic implementation
│   ├── ui/
│   │   └── StudentUI.java           # Console-based User Interface
│   ├── utils/
│   │   ├── FileHandler.java         # Utilities for file I/O operations
│   │   └── ValidationUtils.java     # Input validation logic
│   └── main/
│       └── App.java                 # Main entry point of the application
├── bin/                             # Compiled .class files (auto-generated)
├── lib/                             # External dependencies/libraries (if any)
├── students.dat                     # Data storage file (auto-generated)
└── README.md                        # Project documentation

text

> **Note:** The `bin` folder contains compiled `.class` files. The `src` folder maintains all source code.

---

## 🔧 Installation & Setup

### Prerequisites

- **JDK 11** or higher
- **Visual Studio Code** with Java extensions installed:
  - Extension Pack for Java (Microsoft)

### Steps for VS Code

1. **Clone or download** the project

2. **Open in VS Code**
   - `File → Open Folder → Select StudentManagement`

3. **VS Code will automatically:**
   - Detect Java project
   - Build and compile source code
   - Create `bin` folder for compiled files

4. **Ensure your folder structure looks like:**
📁 StudentManagement
├── 📁 src
│ ├── 📁 model
│ ├── 📁 data
│ ├── 📁 business
│ ├── 📁 ui
│ ├── 📁 utils
│ └── 📁 main
├── 📁 bin (auto-generated)
└── 📁 lib (if needed)


---

## 🚀 How to Run

### Option 1: Using VS Code (Recommended)

1. Navigate to `src/main/App.java`
2. Click the **Run** button (▶️) above the `main` method
3. Or right-click → `Run Java`

### Option 2: Using Terminal in VS Code

```bash
# Open VS Code terminal (Ctrl + `)

# Compile all Java files
javac -d bin src/**/*.java

# Run the application
java -cp bin main.App
Option 3: Using System Terminal
bash
# Navigate to project root
cd StudentManagement

# Compile
javac -d bin src/main/*.java src/model/*.java src/data/*.java src/business/*.java src/ui/*.java src/utils/*.java

# Run
java -cp bin main.App
📖 Usage Guide
Main Menu
Upon running, you'll see:

text
==================================================
      STUDENT MANAGEMENT SYSTEM
==================================================
1. ➕ Add Student
2. 🔍 Find Student by ID
3. ✏️ Update Student
4. 🗑️ Delete Student
5. 📋 Display All Students
6. 🔎 Search Student by Name
7. 📊 Show Statistics
8. 💾 Export to CSV
0. ❌ Exit
==================================================
Example: Adding a Student
text
--- ADD NEW STUDENT ---
Enter Name: John Doe
Enter Age: 20
Enter Email: john.doe@example.com
Enter GPA (0.0-4.0): 3.5

✅ Student added successfully! (Auto-generated ID: SV001)
Example: Display All Students
text
+----------+----------------------+-----+----------------------------+-------+
| ID       | Name                 | Age | Email                      | GPA   |
+----------+----------------------+-----+----------------------------+-------+
| SV001    | John Doe             | 20  | john.doe@example.com       | 3.50  |
| SV002    | Jane Smith           | 22  | jane.smith@example.com     | 3.80  |
+----------+----------------------+-----+----------------------------+-------+
Total: 2 student(s)
Average GPA: 3.65
📊 UML Diagram
Class Diagram
text
┌─────────────────┐         ┌──────────────────────┐
│   <<interface>> │         │    <<interface>>     │
│ IStudentService │         │  IStudentRepository  │
├─────────────────┤         ├──────────────────────┤
│ +addStudent()   │         │ +save()              │
│ +findById()     │         │ +findById()          │
│ +update()       │◄────┐    │ +findAll()           │
│ +delete()       │     │    │ +update()            │
│ +getAll()       │     │    │ +delete()            │
└────────┬────────┘     │    └──────────┬───────────┘
         │              │               │
         │ implements   │               │ implements
         │              │               │
┌────────▼────────┐     │    ┌──────────▼───────────┐
│  StudentService │     │    │ StudentFileRepository│
├─────────────────┤     │    ├──────────────────────┤
│ -repository     │─────┘    │ -fileHandler         │
├─────────────────┤          │ -students: Map       │
│ +addStudent()   │          ├──────────────────────┤
│ +findById()     │          │ +save()              │
│ +update()       │          │ +findById()          │
│ +delete()       │          │ +findAll()           │
└─────────────────┘          └──────────────────────┘
         │                              │
         │ uses                         │ uses
         ▼                              ▼
┌─────────────────┐          ┌──────────────────────┐
│      Student    │          │     FileHandler      │
├─────────────────┤          ├──────────────────────┤
│ -id             │          │ +saveToFile()        │
│ -name           │          │ +loadFromFile()      │
│ -age            │          │ +exportToCSV()       │
│ -email          │          └──────────────────────┘
│ -gpa            │
├─────────────────┤
│ +getters/setters│
│ +toString()     │
└─────────────────┘
🔮 Future Improvements
Database Integration (MySQL/PostgreSQL) - Switch from file to database

Web Interface using Servlet/JSP or Spring Boot

REST API for third-party integration

Authentication (login system with roles)

Course Management (add courses, enroll students)

Grade Management (grades per subject)

Search Filters (filter by GPA range, age)

Pagination for large datasets

Unit Tests (JUnit)

Logging (Log4j/SLF4J)

❓ Troubleshooting
Issue	Solution
"Class not found" error	Run javac -d bin src/**/*.java to recompile
File not saving	Check write permissions in project folder
VS Code not recognizing Java	Install "Extension Pack for Java"
Compilation errors	Ensure JDK 11+ is installed: java -version
👨‍💻 Author
Your Name

GitHub: yourusername

Email: your.email@example.com

📄 License
This project is licensed under the MIT License - free to use, modify, and distribute.