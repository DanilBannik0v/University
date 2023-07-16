package org.example.models;

public class Student {
    private String fullName;
    private String universityId;
    private String phone;
    private String email;
    private int currentCourseNumber;
    private float avgExamScore;

    private Student(StudentBuilder studentBuilder) {
        fullName = studentBuilder.fullName;
        universityId = studentBuilder.universityId;
        phone = studentBuilder.phone;
        email = studentBuilder.email;
        currentCourseNumber = studentBuilder.currentCourseNumber;
        avgExamScore = studentBuilder.avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", phone='" + phone + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                '}';
    }

    public static class StudentBuilder {
        private String fullName;
        private String universityId;
        private String phone;
        private String email;
        private int currentCourseNumber;
        private float avgExamScore;

        public StudentBuilder(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
            this.fullName = fullName;
            this.universityId = universityId;
            this.currentCourseNumber = currentCourseNumber;
            this.avgExamScore = avgExamScore;
        }

        public StudentBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
