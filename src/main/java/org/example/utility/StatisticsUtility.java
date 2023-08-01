package org.example.utility;

import org.example.enums.StudyProfile;
import org.example.models.Statistics;
import org.example.models.Student;
import org.example.models.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtility {
    public static List<Statistics> createStatistics(List<University> universityList, List<Student> studentList) {
        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universityList.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statistics.setStudyProfile(profile);

            List<String> profileUniversityIDs = universityList.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getID)
                    .toList();
            statistics.setNumberOfUniversities(profileUniversityIDs.size());

            statistics.setNamesOfUniversities("");
            universityList.stream()
                    .filter(university -> profileUniversityIDs.contains(university.getID()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setNamesOfUniversities(
                            statistics.getNamesOfUniversities() + fullNameUniversity + ";"));

            List<Student> profileStudents = studentList.stream()
                    .filter(student -> profileUniversityIDs.contains(student.getUniversityId()))
                    .toList();
            statistics.setNumberOfStudents(profileStudents.size());

            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(3, RoundingMode.HALF_UP).doubleValue()));

            statisticsList.add(statistics);
        });
        return statisticsList;
    }
}
