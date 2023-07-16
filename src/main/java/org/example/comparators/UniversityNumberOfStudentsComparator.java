package org.example.comparators;

import org.example.models.University;

public class UniversityNumberOfStudentsComparator implements UniversityComparator {

    @Override
    public int compare(University o1, University o2) {
        return Integer.compare(o1.getNumberOfStudents(),o2.getNumberOfStudents());
    }
}
