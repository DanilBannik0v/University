package org.example;

import org.example.enums.StudyProfile;
import org.example.jsonutil.JsonUtil;
import org.example.models.Student;
import org.example.models.University;

import java.util.List;

import static org.example.enums.StudyProfile.*;
import static org.example.io.ExcelFileReader.readExcelStudentsData;
import static org.example.io.ExcelFileReader.readExcelUniversityData;
import static org.example.jsonutil.JsonUtil.*;


public class Main {
    public static void main(String[] args) {
        List<University> universityList = readExcelUniversityData("universityInfo.xlsx");
        List<Student> studentList = readExcelStudentsData("universityInfo.xlsx");

        String jsonUniversityList = universityListToJson(universityList);
        String jsonStudentList = studentListToJson(studentList);

        System.out.println(jsonUniversityList);
        System.out.println(jsonStudentList);
        System.out.println("---------------------------");

        System.out.println(jsonToUniversityList(jsonUniversityList));
        System.out.println(jsonToStudentList(jsonStudentList));
        System.out.println("---------------------------");

        universityList.stream()
                .filter(x -> x.getStudyProfile().equals(MEDICINE))
                .forEach(x ->  {
                    String json = universityToJson(x);
                    System.out.println(json);
                    University university  = jsonToUniversity(json);
                    System.out.println(university);
                });
    }
}