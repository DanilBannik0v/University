package org.example.utility;

import org.example.comparators.*;
import org.example.enums.StudentComparatorType;
import org.example.enums.UniversityComparatorType;

public class Utility {
    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {
        return switch (studentComparatorType) {
            case FULL_NAME -> new StudentFullNameComparator();
            case UNIVERSITY_ID -> new StudentUniversityIdComparator();
            case PHONE -> new StudentPhoneComparator();
            case EMAIL -> new StudentEmailComparator();
            case CURRENT_COURSE -> new StudentCurrentCourseComparator();
            case AVG_EXAM_SCORE -> new StudentAvgExamScoreComparator();
        };
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {
        return switch (universityComparatorType) {
            case ID -> new UniversityIdComparator();
            case FULL_NAME -> new UniversityFullNameComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case ADDRESS -> new UniversityAddressComparator();
            case NUMBER_OF_STUDENTS -> new UniversityNumberOfStudentsComparator();
            case YEAR_OF_FOUNDATION -> new UniversityYearOfFoundationComparator();
            case STUDY_PROFILE -> new UniversityStudyProfileComparator();
        };
    }

}
