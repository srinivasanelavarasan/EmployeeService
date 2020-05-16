package com.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void getAllEmployees_ValidInput_ReturnAllEmployees() {

    }

    @Test
    public void getAllEmployees_NoRecords_ReturnEmptyResultsWithMessage() {

    }

    @Test
    public void getEmployeeById_ValidId_FetchTheEmployeeDetails() {

    }

    @Test
    public void getEmployeeById_InvalidId_ReturnNoRecordFound() {

    }

    @Test
    public void deleteEmployee_ValidId_DeleteTheEmployeeSuccessfully() {

    }

    @Test
    public void deleteEmployee_InvalidId_ReturnNoRecordFound() {

    }

    @Test
    public void createEmployee_ValidEmployeeDetails_AddRecordToXML() {

    }

    @Test
    public void createEmployee_AddAlreadyExistingRecord_DuplicateRecordMessage() {

    }

    @Test
    public void updateEmployee_ValidEmployee_UpdateEmployeeSuccessfully() {

    }

    @Test
    public void updateEmployee_InValidEmployee_ReturnNoRecordFound() {

    }

    @Test
    public void updateEmployee_ValidEmployeeAddressAdd_UpdateEmployeeSuccessfully() {

    }

    @Test
    public void updateEmployee_ValidEmployeeAddressDelete_UpdateEmployeeSuccessfully() {

    }
}
