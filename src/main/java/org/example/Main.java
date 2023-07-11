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
        List<Student> studentListt = readExcelStudentsData("D:\\JavaProgramming\\Projects\\University\\target\\classes\\universityInfo.xlsx");
        for (Student student: studentListt) {
            System.out.println(student);
        }
    }
}