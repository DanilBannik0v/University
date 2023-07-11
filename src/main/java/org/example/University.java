package org.example;

public class University {
    private String ID;
    private String fullName;
    private String shortName;
    private String address;       // optional
    private int numberOfStudents; // optional
    private int yearOfFoundation;
    private StudyProfile studyProfile;
    private StudyProfile mainProfile;

    private University(UniversityBuilder universityBuilder) {
        ID = universityBuilder.ID;
        fullName = universityBuilder.fullName;
        shortName = universityBuilder.shortName;
        address = universityBuilder.address;
        numberOfStudents = universityBuilder.numberOfStudents;
        yearOfFoundation = universityBuilder.yearOfFoundation;
        studyProfile = universityBuilder.studyProfile;
        mainProfile = universityBuilder.mainProfile;
    }

    public String getID() {
        return ID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public float getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "ID='" + ID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", address='" + address + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                ", yearOfFoundation=" + yearOfFoundation +
                ", studyProfile=" + studyProfile +
                ", mainProfile=" + mainProfile +
                '}';
    }

    public static class UniversityBuilder {
        private String ID;
        private String fullName;
        private String shortName;
        private String address;
        private int numberOfStudents;
        private int yearOfFoundation;
        private StudyProfile studyProfile;
        private StudyProfile mainProfile;

        public UniversityBuilder(String ID, String fullName, String shortName, int yearOfFoundation,StudyProfile studyProfile,StudyProfile mainProfile) {
            this.ID = ID;
            this.fullName = fullName;
            this.shortName = shortName;
            this.yearOfFoundation = yearOfFoundation;
            this.studyProfile = studyProfile;
            this.mainProfile = mainProfile;
        }

        public UniversityBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UniversityBuilder setNumberOfStudents(int numberOfStudents) {
            this.numberOfStudents = numberOfStudents;
            return this;
        }

        public University build() {
            return new University(this);
        }
    }
}
