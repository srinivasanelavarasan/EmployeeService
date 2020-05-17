package com.assignment.service;

import com.assignment.model.Address;

import java.util.List;

public interface AddressService {
    /**
     * add employee address.
     *
     * @param address String
     * @return true, if successful
     */
    public Boolean addEmployeeAddress(long empId, Address address);

    /**
     *
     * @param empId
     * @param address
     * @return
     */
    public Boolean updateEmployeeAddress(long empId, Address address);

    /**
     *
     * @param empId
     * @param addressId
     * @return
     */
    public Boolean deleteEmployeeAddress(long empId, long addressId);

    /**
     *
     * @param empId
     * @return
     */
    public List<Address> getEmployeeAddresses(long empId);

}
