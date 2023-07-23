package org.example.jsonutil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import org.example.models.Student;
import org.example.models.University;

import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }

    public static String studentToJson(Student student){
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String universityToJson(University university){
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static Student jsonToStudent(String json){
        return new Gson().fromJson(json, Student.class);
    }

    public static University jsonToUniversity(String json){
        return new Gson().fromJson(json, University.class);
    }

    public static String studentListToJson(List<Student> studentList){
        return new GsonBuilder().setPrettyPrinting().create().toJson(studentList);
    }

    public static String universityListToJson(List<University> universityList){
        return new GsonBuilder().setPrettyPrinting().create().toJson(universityList);
    }

    public static List<Student> jsonToStudentList(String json){
        return new Gson().fromJson(json, new TypeToken<List<Student>>(){}.getType());
    }

    public static List<University> jsonToUniversityList(String json){
        return new Gson().fromJson(json, new TypeToken<List<University>>(){}.getType());
    }
}
