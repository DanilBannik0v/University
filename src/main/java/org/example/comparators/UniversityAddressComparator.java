package org.example.comparators;

import org.apache.commons.lang3.StringUtils;
import org.example.models.University;

public class UniversityAddressComparator implements UniversityComparator {

    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getAddress(),o2.getAddress());
    }
}
