package org.example.comparators;

import org.example.models.Student;

public class StudentCurrentCourseComparator implements StudentComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getCurrentCourseNumber() - o2.getCurrentCourseNumber();
    }
}
