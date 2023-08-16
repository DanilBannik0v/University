package org.example.io;

import org.example.models.Info;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.example.jsonutil.JsonUtil.listToJson;

public class JsonWriter {
    private static Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void writeJsonReq(Info info) {
        logger.log(Level.INFO, "JSON writing started");
        try {
            Files.createDirectories(Paths.get("target\\jsonReqs"));
            logger.log(Level.INFO, "Directory created");
        } catch (IOException ioEx) {
            logger.log(Level.FINE, "Directory already created", ioEx);
        }
        writeStudents(info);
        writeUniversities(info);
        writeStatisticsList(info);
        logger.log(Level.INFO, "JSON writing finished");
    }

    private static void writeStudents(Info info) {
        String studentsJson = listToJson(info.getStudentList());
        try(FileOutputStream outputStream = new FileOutputStream("target\\jsonReqs\\students" + info.getCreationDate().getTime() + ".json")) {
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON writing failed", e);
        }
    }

    private static void writeUniversities(Info info) {
        String universitiesJson = listToJson(info.getUniversityList());
        try(FileOutputStream outputStream = new FileOutputStream("target\\jsonReqs\\universities" + info.getCreationDate().getTime() + ".json")) {
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON writing failed", e);
        }
    }

    private static void writeStatisticsList(Info info) {
        String statisticsList = listToJson(info.getStatisticsList());
        try(FileOutputStream outputStream = new FileOutputStream("target\\jsonReqs\\statistics" + info.getCreationDate().getTime() + ".json")) {
            outputStream.write(statisticsList.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON writing failed", e);
        }
    }
}
