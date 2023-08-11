package org.example;

import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;
import org.example.utility.StatisticsUtility;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static org.example.io.ExcelFileReader.readExcelStudentsData;
import static org.example.io.ExcelFileReader.readExcelUniversityData;
import static org.example.io.ExcelFileWriter.writeExcelStatistics;

import static org.example.utility.StatisticsUtility.createStatistics;

public class Main {
    private static final Logger logger = Logger.getLogger(StatisticsUtility.class.getName());

    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e);
        }

        logger.log(Level.INFO,"Application started");
        List<University> universityList = readExcelUniversityData("universityInfo.xlsx");
        List<Student> studentList = readExcelStudentsData("universityInfo.xlsx");

        List<Statistics> statisticsList = createStatistics(universityList, studentList);
        writeExcelStatistics(statisticsList,"statistics.xlsx");
        logger.log(Level.INFO,"Application finished");
    }
}