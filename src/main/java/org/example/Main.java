package org.example;

import org.example.enums.StudyProfile;
import org.example.io.ExcelFileWriter;
import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;
import org.example.utility.StatisticsUtility;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.example.enums.StudyProfile.MEDICINE;
import static org.example.io.ExcelFileReader.readExcelStudentsData;
import static org.example.io.ExcelFileReader.readExcelUniversityData;

import static org.example.utility.JAXBUtility.*;
import static org.example.utility.StatisticsUtility.createStatistics;

public class Main {
    private static final Logger logger = Logger.getLogger(StatisticsUtility.class.getName());

    public static void main(String[] args) {
        Student student = new Student.StudentBuilder("Alesha","12",1,4.5f).build();
        String string1 = studentToXml(student);
        System.out.println(string1);
        System.out.println(xmlToStudent(string1));

        University university = new University.UniversityBuilder("12","univer name","name",1991, MEDICINE, MEDICINE).build();
        String string2 = universityToXml(university);
        System.out.println(string2);
        System.out.println(xmlToUniversity(string2));
        /*
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e);
        }

        logger.log(Level.INFO,"Application started");
        List<University> universityList = readExcelUniversityData("universityInfo.xlsx");
        List<Student> studentList = readExcelStudentsData("universityInfo.xlsx");

        List<Statistics> statisticsList = createStatistics(universityList, studentList);
        ExcelFileWriter.writeExcelStatistics(statisticsList,"statistics.xlsx");
        logger.log(Level.INFO,"Application finished");
         */
    }
}