package org.example.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;
import org.example.models.Student;
import org.example.models.University;

public class ExcelFileReader {
    private static Logger logger = Logger.getLogger(ExcelFileReader.class.getName());
    private static final int STUDENTS_SHEET_NUMBER = 0;
    private static final int UNIVERSITY_SHEET_NUMBER = 1;

    public static final List<University> readExcelUniversityData(String fileName) {
        List<University> universityList = new ArrayList<>();
        try {
            logger.log(Level.INFO, "Excel reading started");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(fileName);
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(is);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(is);
            }
            Sheet sheet = workbook.getSheetAt(UNIVERSITY_SHEET_NUMBER);

            Iterator<Row> rowIterator = sheet.iterator();
            //skip row with column names
            rowIterator.next();

            while (rowIterator.hasNext()) {
                String ID = "";
                String fullName = "";
                String shortName =  "";
                int yearOfFoundation = 0;
                StudyProfile studyProfile = null;
                StudyProfile mainProfile = null;

                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    //check the cell type and process accordingly
                    switch (cell.getCellType()) {
                        case STRING -> {
                            if (ID.equalsIgnoreCase("")) {
                                ID = cell.getStringCellValue().trim();
                            } else if (fullName.equalsIgnoreCase("")) {
                                fullName = cell.getStringCellValue().trim();
                            } else if (shortName.equalsIgnoreCase("")) {
                                shortName = cell.getStringCellValue().trim();
                            } else if (studyProfile == null) {
                                studyProfile = StudyProfile.valueOf(cell.getStringCellValue().trim().toUpperCase());
                                mainProfile = studyProfile;
                            }
                        }
                        case NUMERIC -> yearOfFoundation = (int) cell.getNumericCellValue();
                    }
                }
                University university = new University.UniversityBuilder(ID, fullName, shortName, yearOfFoundation, studyProfile, mainProfile).build();
                universityList.add(university);
            }
        is.close();
        } catch (IOException | NullPointerException e) {
            logger.log(Level.SEVERE, "Excel reading failed");
        }
        logger.log(Level.INFO, "Excel reading finished");
        return universityList;
    }

    public static List<Student> readExcelStudentsData(String fileName) {
        List<Student> studentList = new ArrayList<>();
        try {
            logger.log(Level.INFO, "Excel reading started");
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(fileName);
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(is);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(is);
            }
            Sheet sheet = workbook.getSheetAt(STUDENTS_SHEET_NUMBER);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();
            while (rowIterator.hasNext()) {
                String fullName = "";
                String universityId =  "";
                int currentCourseNumber = 0;
                float avgExamScore = 0;

                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING -> {
                            if (universityId.equalsIgnoreCase("")) {
                                universityId = cell.getStringCellValue().trim();
                            } else if (fullName.equalsIgnoreCase("")) {
                                fullName = cell.getStringCellValue().trim();
                            }
                        }
                        case NUMERIC -> {
                            if (currentCourseNumber == 0) {
                                currentCourseNumber = (int) cell.getNumericCellValue();
                            } else if (avgExamScore == 0) {
                                avgExamScore = (float) cell.getNumericCellValue();
                            }
                        }
                    }
                }
                Student student = new Student.StudentBuilder( fullName, universityId, currentCourseNumber, avgExamScore).build();
                studentList.add(student);
            }
            is.close();
        } catch (IOException | NullPointerException e) {
            logger.log(Level.SEVERE, "Excel reading failed");
        }
        logger.log(Level.INFO, "Excel reading finished");
        return studentList;
    }
}
