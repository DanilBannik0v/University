package org.example;

import org.example.comparators.StudentComparator;
import org.example.comparators.UniversityComparator;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;
import org.example.models.Student;
import org.example.models.University;

import java.util.List;

import static org.example.io.ExcelFileReader.readExcelStudentsData;
import static org.example.io.ExcelFileReader.readExcelUniversityData;
import static org.example.utility.Utility.getStudentComparator;
import static org.example.utility.Utility.getUniversityComparator;

public class Main {
    public static void main(String[] args) {
        List<University> universityList = readExcelUniversityData("D:\\JavaProgramming\\Projects\\University\\target\\classes\\universityInfo.xlsx");
        List<Student> studentList = readExcelStudentsData("D:\\JavaProgramming\\Projects\\University\\target\\classes\\universityInfo.xlsx");

        UniversityComparator universityComparator = getUniversityComparator(UniversityComparatorType.SHORT_NAME);
        StudentComparator studentComparator = getStudentComparator(StudentComparatorType.FULL_NAME);

        universityList.stream().sorted(universityComparator).forEach(System.out::println);
        System.out.println("-----------------------------------------------------");
        studentList.stream().sorted(studentComparator).forEach(System.out::println);

    }
}