package org.example.models;

public class Employee {
    private int empId;
    private String name;
    private String job;

    public Employee() {
        this.empId = empId;
        this.name = name;
        this.job = job;
    }

    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
