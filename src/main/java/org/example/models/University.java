package org.example.models;

import com.google.gson.annotations.SerializedName;
import org.example.enums.StudyProfile;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "universityEntry")
public class University {
    @SerializedName("id")
    @XmlElement(name = "universityId")
    private String ID;

    @SerializedName("name")
    @XmlElement(name = "universityName")
    private String fullName;

    @SerializedName("abbreviation")
    @XmlTransient
    private String shortName;

    @SerializedName("address")
    @XmlTransient
    private String address;

    @SerializedName("capacity")
    @XmlTransient
    private int numberOfStudents;

    @SerializedName("foundationYear")
    @XmlTransient
    private int yearOfFoundation;

    @SerializedName("studyProfile")
    @XmlElement(name = "universityName")
    private StudyProfile studyProfile;

    @SerializedName("mainProfile")
    @XmlTransient
    private StudyProfile mainProfile;

    public University() {
    }

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

    public int getYearOfFoundation() {
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

        public UniversityBuilder(String ID, String fullName, String shortName, int yearOfFoundation, StudyProfile studyProfile, StudyProfile mainProfile) {
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
