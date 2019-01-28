package com.example.java.interfaceDesign.ProjectAllocationDtos;

import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeSkill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ProjectAllocationInput {
    private final Date startDate;

    private final Map<EmployeeSkill,List<EmployeeWithSkills>> employeesNeeded;

    private final List<EmployeeWithSkills> employeeSkills;

    private final int teamSize;

    private final String projectName;

    private final String managerName;

    public ProjectAllocationInput(Date startDate, Map<EmployeeSkill, List<EmployeeWithSkills>> employeesNeeded, List<EmployeeWithSkills> employeeSkills, int teamSize, String projectName, String managerName) {
        this.startDate = startDate;
        this.employeesNeeded = employeesNeeded;
        this.employeeSkills = employeeSkills;
        this.teamSize = teamSize;
        this.projectName = projectName;
        this.managerName = managerName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public List<EmployeeWithSkills> getEmployeeSkills() {
        return employeeSkills;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getManagerName() {
        return managerName;
    }

    public Map<EmployeeSkill, List<EmployeeWithSkills>> getEmployeesNeeded() {
        return employeesNeeded;
    }
}
