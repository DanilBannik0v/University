package org.example.jsonutil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

    public static String listToJson(List<?> list){
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }

    public static List<?> jsonToList(String json){
        return new Gson().fromJson(json, new TypeToken<List<?>>(){}.getType());
    }

}
