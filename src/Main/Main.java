//Student: id, Прізвище, Ім'я, По батькові, Дата народження, Адреса, Телефон, Факультет, Курс, Група.
//Скласти масив об'єктів. Вивести:
//
//a) список студентів заданого факультету;
//b) список студентів, які народились після заданого року;
//c) список навчальної групи.

package Main;

import Student.Student;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Student[] array = formStudArray();
        scanner.nextLine();

        System.out.println("\nЗадайте факултет : ");
        String filtFaculty = scanner.nextLine();

        //Зчитування та перевірка дати на валідність
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate = null;
        boolean validDate = false;

        System.out.println("Задайте дату :");
        while (!validDate) {
            try {
                parsedDate = dateFormat.parse(scanner.nextLine());
                validDate = true; // Введена дата правильно розпізнана, виходимо з циклу
            } catch (ParseException e) {
                System.out.println("Неправильний формат дати. Будь ласка, використовуйте формат yyyy-MM-dd.");
            }
        }

        System.out.println("Задайте групу : ");
        String filtGroup = scanner.nextLine();

        System.out.println("\nСписок студентів які народились після " + parsedDate + " :");
        printStArray(getStudentsAfterYear(array, parsedDate));

        System.out.println("\nСписок студентів факультету " + filtFaculty + " :");
        printStArray(getStudentsFromFaculty(array, filtFaculty));

        System.out.println("\nСписок студентів групи " + filtGroup + " :");
        printStArray(getStudentsFromGroup(array, filtGroup));
    }

    public static Student[] formStudArray() {
        System.out.println("Задайте розмір масиву який має бути сформований : ");
        int size = scanner.nextInt();
        Student[] array = new Student[size];

        for (int i = 0; i < size; i++) {
            array[i] = new Student();
        }

        return array;
    }

    public static Student[] getStudentsFromFaculty(Student[] inputArray, String faculty) {
        int inputArrSize = Array.getLength(inputArray);
        int resultArrSize = 0;

        //Обрахунок розміру результуючого масиву

        for (int i = 0; i < inputArrSize; i++){
            if(inputArray[i].getStudentFaculty().equals(faculty)){
                resultArrSize++;
            }
        }

        Student[] resultArray = new Student[resultArrSize];

        for (int i = 0, j = 0; i < inputArrSize; i++){
            if(inputArray[i].getStudentFaculty().equals(faculty)){
                resultArray[j] = new Student(inputArray[i]);
                j++;
            }
        }

        return resultArray;
    }

    public static Student[] getStudentsAfterYear(Student[] inputArray, Date year) {
        int inputArrSize = Array.getLength(inputArray);
        int resultArrSize = 0;

        //Обрахунок розміру результуючого масиву

        for (int i = 0; i < inputArrSize; i++){
            if(inputArray[i].getStudentBirthDate().compareTo(year) > 0){
                resultArrSize++;
            }
        }

        Student[] resultArray = new Student[resultArrSize];

        for (int i = 0, j = 0; i < inputArrSize; i++){
            if(inputArray[i].getStudentBirthDate().compareTo(year) > 0){
                resultArray[j] = new Student(inputArray[i]);
                j++;
            }
        }

        return resultArray;
    }

    public static Student[] getStudentsFromGroup(Student[] inputArray, String group) {
        int inputArrSize = Array.getLength(inputArray);
        int resultArrSize = 0;

        //Обрахунок розміру результуючого масиву

        for (int i = 0; i < inputArrSize; i++){
            if(inputArray[i].getStudentGroup().equals(group)){
                resultArrSize++;
            }
        }

        Student[] resultArray = new Student[resultArrSize];

        for (int i = 0, j = 0; i < inputArrSize; i++){
            if(inputArray[i].getStudentGroup().equals(group)){
                resultArray[j] = new Student(inputArray[i]);
                j++;
            }
        }

        return resultArray;
    }

    public static void printStArray(Student[] array){
        int size = Array.getLength(array);
        for(int i = 0; i < size; i++){
            System.out.println(array[i] + "\n");
        }
    }
}