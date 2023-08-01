package org.example.io;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.models.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFileWriter {

    public static void writeExcelStatistics(List<Statistics> statisticsList, String fileName) {
        Workbook workbook = null;
        if(fileName.toLowerCase().endsWith("xlsx")){
            workbook = new XSSFWorkbook();
        }else if(fileName.toLowerCase().endsWith("xls")){
            workbook = new HSSFWorkbook();
        }
        Sheet sheet = workbook.createSheet("Statistics");

        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setFontName("Calibri");
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        headerFont.setBold(true);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        Cell profileCell = headerRow.createCell(0);
        profileCell.setCellValue("Study profile");
        profileCell.setCellStyle(headerStyle);
        Cell avgScoreCell = headerRow.createCell(1);
        avgScoreCell.setCellValue("Average exam score");
        avgScoreCell.setCellStyle(headerStyle);
        Cell studentNumCell = headerRow.createCell(2);
        studentNumCell.setCellValue("Number of students");
        studentNumCell.setCellStyle(headerStyle);
        Cell universitiesNumCell = headerRow.createCell(3);
        universitiesNumCell.setCellValue("Number of universities");
        universitiesNumCell.setCellStyle(headerStyle);
        Cell namesOfUniversitiesCell = headerRow.createCell(4);
        namesOfUniversitiesCell.setCellValue("Names of universities");
        namesOfUniversitiesCell.setCellStyle(headerStyle);

        for (Statistics statistics : statisticsList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0)
               .setCellValue(statistics.getStudyProfile().getProfileName());
            row.createCell(1)
               .setCellValue(statistics.getAvgExamScore());
            row.createCell(2)
               .setCellValue(statistics.getNumberOfStudents());
            row.createCell(3)
               .setCellValue(statistics.getNumberOfUniversities());
            row.createCell(4)
               .setCellValue(statistics.getNamesOfUniversities());
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
