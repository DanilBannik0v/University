package org.example;

import java.util.List;
import static org.example.ExcelFileReader.*;

public class Main {
    public static void main(String[] args) {
        List<University> list = readExcelUniversityData("D:\\JavaProgramming\\Projects\\University\\target\\classes\\universityInfo.xlsx");
        for (University university: list) {
            System.out.println(university);
        }
    }
}