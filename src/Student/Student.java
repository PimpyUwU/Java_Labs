package Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student {
    private int id;
    private String studentName;
    private String studentLastName;
    private String studentPatronymic;
    private Date studentBirthDate;
    private String studentAddress;
    private String studentPhoneNumber;
    private String studentFaculty;
    private int studentCourse;
    private String studentGroup;

    private static final Scanner scanner = new Scanner(System.in);

    public Student(int id, String studentName, String studentLastName, String studentPatronymic, Date studentBirthDate, String studentAddress, String studentPhoneNumber, String studentFaculty, int studentCourse, String studentGroup) {
        this.id = id;
        this.studentName = studentName;
        this.studentLastName = studentLastName;
        this.studentPatronymic = studentPatronymic;
        this.studentBirthDate = studentBirthDate;
        this.studentAddress = studentAddress;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentFaculty = studentFaculty;
        this.studentCourse = studentCourse;
        this.studentGroup = studentGroup;
    }

    public Student() {
        System.out.print("Введіть Id студента: ");
        this.id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введіть ім'я студента: ");
        this.studentName = scanner.nextLine();

        System.out.print("Введіть прізвище студента: ");
        this.studentLastName = scanner.nextLine();

        System.out.print("Введіть по батькові студента: ");
        this.studentPatronymic = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        boolean validDate = false;

        while (!validDate) {
            System.out.print("Введіть дату народження студента (у форматі yyyy-MM-dd): ");
            try {
                parsedDate = dateFormat.parse(scanner.nextLine());
                validDate = true; // Введена дата правильно розпізнана, виходимо з циклу
            } catch (ParseException e) {
                System.out.println("Неправильний формат дати. Будь ласка, використовуйте формат yyyy-MM-dd.");
            }
        }
        this.studentBirthDate = parsedDate;

        System.out.print("Введіть адресу студента: ");
        this.studentAddress = scanner.nextLine();

        System.out.print("Введіть номер телефону студента: ");
        this.studentPhoneNumber = scanner.nextLine();

        System.out.print("Введіть факультет студента: ");
        this.studentFaculty = scanner.nextLine();

        System.out.print("Введіть курс студента: ");
        this.studentCourse = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введіть групу студента: ");
        this.studentGroup = scanner.nextLine();
    }

    public Student(Student inStudent){
        this.id = inStudent.id;
        this.studentGroup = inStudent.studentGroup;
        this.studentCourse = inStudent.studentCourse;
        this.studentFaculty = inStudent.studentFaculty;
        this.studentPhoneNumber = inStudent.studentPhoneNumber;
        this.studentBirthDate = inStudent.studentBirthDate;
        this.studentAddress = inStudent.studentAddress;
        this.studentPatronymic = inStudent.studentPatronymic;
        this.studentName = inStudent.studentName;
        this.studentLastName = inStudent.studentLastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getStudentPatronymic() {
        return studentPatronymic;
    }

    public void setStudentPatronymic(String studentPatronymic) {
        this.studentPatronymic = studentPatronymic;
    }

    public Date getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(Date studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentFaculty() {
        return studentFaculty;
    }

    public void setStudentFaculty(String studentFaculty) {
        this.studentFaculty = studentFaculty;
    }

    public int getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(int studentCourse) {
        this.studentCourse = studentCourse;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String toString() {
        return "Student{" +
                "ID: " + id +
                "\nLast Name: " + studentLastName +
                "\nFirst Name: " + studentName +
                "\nMiddle Name: " + studentPatronymic +
                "\nBirth Date: " + formDateToSring(studentBirthDate) +
                "\nAddress: " + studentAddress +
                "\nPhone Number: " + studentPhoneNumber +
                "\nFaculty: " + studentFaculty +
                "\nCourse: " + studentCourse +
                "\nGroup: " + studentGroup +
                '}';
    }

    private String formDateToSring(Date date){
        return  (studentBirthDate.getYear() >= 100 ? "200" + studentBirthDate.getYear() % 100 : "19" + studentBirthDate.getYear()) + "." + (studentBirthDate.getMonth() >= 10 ? studentBirthDate.getMonth() : "0" + studentBirthDate.getMonth()) + "." + studentBirthDate.getDay();
    }

}
