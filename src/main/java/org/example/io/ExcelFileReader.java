package org.example.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;
import org.example.models.Student;
import org.example.models.University;

public class ExcelFileReader {

    private static final int STUDENTS_SHEET_NUMBER = 0;
    private static final int UNIVERSITY_SHEET_NUMBER = 1;

    public static List<University> readExcelUniversityData(String fileName) {
        List<University> universityList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fis);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            }
            Sheet sheet = workbook.getSheetAt(UNIVERSITY_SHEET_NUMBER);

            //every sheet has rows, iterate over them
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

                //Every row has columns, get the column iterator and iterate over them
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
        fis.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return universityList;
    }

    public static List<Student> readExcelStudentsData(String fileName) {
        List<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fis);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
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
            fis.close();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
