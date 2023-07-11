package org.example;

import java.util.List;
import static org.example.ExcelFileReader.*;

public class Main {
    public static void main(String[] args) {
        List<University> universityListlist = readExcelUniversityData("D:\\JavaProgramming\\Projects\\University\\target\\classes\\universityInfo.xlsx");
        for (University university: universityListlist) {
            System.out.println(university);
        }
        System.out.println("--------------------------------------------------");
        List<Student> studentList = readExcelStudentsData("D:\\JavaProgramming\\Projects\\University\\target\\classes\\universityInfo.xlsx");
        for (Student student: studentList) {
            System.out.println(student);
        }
    }
}