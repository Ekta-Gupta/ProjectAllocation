package com.example.java.interfaceDesign.ProjectAllocationDtos;

import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeBandLevel;
import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeSkill;
import com.example.java.interfaceDesign.ProjectAllocationEnums.SkillLevel;
import org.hibernate.mapping.Set;

import java.util.List;
import java.util.Map;

public class Employee {
    private final int employeeId;
    private final String employeeName;
    private final Map<EmployeeSkill,SkillLevel> employeeSkills;
    private Map<String,Integer> allocatedProjectWithPercentage;
    private final EmployeeBandLevel employeeBandLevel;

    public Employee(int employeeId, String employeeName, Map<EmployeeSkill, SkillLevel> employeeSkills, Map<String, Integer> allocatedProjectWithPercentage, EmployeeBandLevel employeeBandLevel) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSkills = employeeSkills;
        this.allocatedProjectWithPercentage = allocatedProjectWithPercentage;
        this.employeeBandLevel = employeeBandLevel;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Map<EmployeeSkill, SkillLevel> getEmployeeSkills() {
        return employeeSkills;
    }

    public Map<String, Integer> getAllocatedProjectWithPercentage() {
        return allocatedProjectWithPercentage;
    }

    public EmployeeBandLevel getEmployeeBandLevel() {
        return employeeBandLevel;
    }

    public void setAllocatedProjectWithPercentage(Map<String, Integer> allocatedProjectWithPercentage) {
        this.allocatedProjectWithPercentage = allocatedProjectWithPercentage;
    }
}
