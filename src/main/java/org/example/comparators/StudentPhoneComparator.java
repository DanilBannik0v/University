package org.example.comparators;

import org.apache.commons.lang3.StringUtils;
import org.example.models.Student;

public class StudentPhoneComparator implements StudentComparator {

    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getPhone(),o2.getPhone());
    }
}
