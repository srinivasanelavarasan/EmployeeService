package com.assignment.model;

import lombok.Data;

/**
 * Instantiates a new address.
 */
@Data
public class Address {

    /** The address id. */
    private long addressId;

    /** The door no. */
    private String doorNo;

    /** The street. */
    private String street;

    /** The town. */
    private String town;

    /** The state. */
    private String state;

}
