package com.cmitche.api.customerapi.vo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    // FIELDS
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long customerId;
    private String firstName;
    private Integer numberOfRewardPoints;

    // CONSTRUCTOR
    public Customer(){

    }

    public Customer(Long customerId, String firstName, Integer numberOfRewardPoints) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.numberOfRewardPoints = numberOfRewardPoints;
    }

    // METHODS
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getNumberOfRewardPoints() {
        return numberOfRewardPoints;
    }

    public void setNumberOfRewardPoints(Integer numberOfRewardPoints) {
        this.numberOfRewardPoints = numberOfRewardPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", numberOfRewardPoints=" + numberOfRewardPoints +
                '}';
    }
}
