class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Convert to file format
    public String toFileString() {
        return rollNumber + "," + name + "," + grade;
    }

    // Display student
    public void display() {
        System.out.println("Roll No: " + rollNumber + " | Name: " + name + " | Grade: " + grade);
    }
}
