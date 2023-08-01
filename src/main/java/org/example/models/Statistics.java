package org.example.models;

import org.example.enums.StudyProfile;

public class Statistics {
    private StudyProfile studyProfile;
    private float avgExamScore;
    private int numberOfStudents;
    private int numberOfUniversities;
    private String namesOfUniversities;

    public Statistics() {
    }

    public Statistics(StudyProfile studyProfile, float avgExamScore, int numberOfStudents, int numberOfUniversities, String namesOfUniversities) {
        this.studyProfile = studyProfile;
        this.avgExamScore = avgExamScore;
        this.numberOfStudents = numberOfStudents;
        this.numberOfUniversities = numberOfUniversities;
        this.namesOfUniversities = namesOfUniversities;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfUniversities() {
        return numberOfUniversities;
    }

    public void setNumberOfUniversities(int numberOfUniversities) {
        this.numberOfUniversities = numberOfUniversities;
    }

    public String getNamesOfUniversities() {
        return namesOfUniversities;
    }

    public void setNamesOfUniversities(String namesOfUniversities) {
        this.namesOfUniversities = namesOfUniversities;
    }
}
