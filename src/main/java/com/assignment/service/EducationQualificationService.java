package com.assignment.service;

import com.assignment.model.EducationQualification;
import java.util.List;

public interface EducationQualificationService {
    /**
     * @param empId
     * @param educationQualification
     * @return
     */
    public Boolean addEmployeeEducationalQualification(long empId, EducationQualification educationQualification);

    /**
     * @param empId
     * @param educationQualification
     * @return
     */
    public Boolean updateEmployeeEducationalQualification(long empId, EducationQualification educationQualification);

    /**
     * @param empId
     * @param educationQualification
     * @return
     */
    public Boolean deleteEmployeeEducationalQualification(long empId, EducationQualification educationQualification);

    /**
     * @param empId
     * @return
     */
    public List<EducationQualification> getEmployeeEducationalQualifications(long empId, EducationQualification educationQualification);
}
