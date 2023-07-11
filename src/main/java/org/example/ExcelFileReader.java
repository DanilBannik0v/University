package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



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
                String studyProfile = "";
                String mainProfile = "";

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
                            } else if (studyProfile.equalsIgnoreCase("")) {
                                studyProfile = cell.getStringCellValue().trim();
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
}
