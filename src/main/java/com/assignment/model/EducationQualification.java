package com.assignment.model;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * Instantiates a new education qualification.
 */
@Data
public class EducationQualification {

    /** The qualifications. */
    private List<Map<String, String>> qualifications;

}
