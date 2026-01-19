import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {

        loadFromFile();

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    removeStudent(sc);
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    editStudent(sc);
                    break;

                case 5:
                    displayAll();
                    break;

                case 6:
                    saveToFile();
                    System.out.println("👋 Exiting... Data saved.");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }

    // ADD STUDENT
    static void addStudent(Scanner sc) {
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        if (findStudent(roll) != null) {
            System.out.println("❌ Student already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        if (name.isEmpty()) {
            System.out.println("❌ Name cannot be empty.");
            return;
        }

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        if (grade.isEmpty()) {
            System.out.println("❌ Grade cannot be empty.");
            return;
        }

        students.add(new Student(name, roll, grade));
        System.out.println("✅ Student added successfully.");
    }

    // REMOVE STUDENT
    static void removeStudent(Scanner sc) {
        System.out.print("Enter Roll Number to remove: ");
        int roll = sc.nextInt();

        Student s = findStudent(roll);

        if (s == null) {
            System.out.println("❌ Student not found.");
        } else {
            students.remove(s);
            System.out.println("✅ Student removed.");
        }
    }

    // SEARCH STUDENT
    static void searchStudent(Scanner sc) {
        System.out.print("Enter Roll Number to search: ");
        int roll = sc.nextInt();

        Student s = findStudent(roll);

        if (s == null) {
            System.out.println("❌ Student not found.");
        } else {
            s.display();
        }
    }

    // EDIT STUDENT
    static void editStudent(Scanner sc) {
        System.out.print("Enter Roll Number to edit: ");
        int roll = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(roll);

        if (s == null) {
            System.out.println("❌ Student not found.");
            return;
        }

        System.out.print("Enter new Name: ");
        String name = sc.nextLine();

        System.out.print("Enter new Grade: ");
        String grade = sc.nextLine();

        if (!name.isEmpty())
            s.setName(name);

        if (!grade.isEmpty())
            s.setGrade(grade);

        System.out.println("✅ Student updated successfully.");
    }

    // DISPLAY ALL
    static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("⚠ No students found.");
            return;
        }

        System.out.println("\n----- Student List -----");
        for (Student s : students) {
            s.display();
        }
    }

    // FIND STUDENT
    static Student findStudent(int roll) {
        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                return s;
            }
        }
        return null;
    }

    // SAVE TO FILE
    static void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Student s : students) {
                bw.write(s.toFileString());
                bw.newLine();
            }

            bw.close();
        } catch (Exception e) {
            System.out.println("❌ Error saving data.");
        }
    }

    // LOAD FROM FILE
    static void loadFromFile() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists())
                return;

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int roll = Integer.parseInt(data[0]);
                String name = data[1];
                String grade = data[2];

                students.add(new Student(name, roll, grade));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("⚠ No previous data found.");
        }
    }
}
