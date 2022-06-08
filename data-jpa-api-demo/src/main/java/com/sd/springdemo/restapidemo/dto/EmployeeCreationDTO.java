package com.sd.springdemo.restapidemo.dto;

public class EmployeeCreationDTO {
    private int statusCode;

    private String message;

    private int empId;

    public EmployeeCreationDTO() {
    }

    public EmployeeCreationDTO(int statusCode, String message, int empId) {
        this.statusCode = statusCode;
        this.message = message;
        this.empId = empId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
