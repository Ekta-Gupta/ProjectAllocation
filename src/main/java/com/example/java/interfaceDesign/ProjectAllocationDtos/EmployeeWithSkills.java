package com.example.java.interfaceDesign.ProjectAllocationDtos;

import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeBandLevel;
import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeSkill;
import com.example.java.interfaceDesign.ProjectAllocationEnums.SkillLevel;

public class EmployeeWithSkills {
    private final EmployeeSkill employeeSkill;
    private final int totalPeopleNeeded;
    private final SkillLevel skillLevel;
    private final EmployeeBandLevel bandLevel;

    public EmployeeWithSkills(EmployeeSkill employeeSkill, int totalPeopleNeeded, SkillLevel skillLevel, EmployeeBandLevel bandLevel) {
        this.employeeSkill = employeeSkill;
        this.totalPeopleNeeded = totalPeopleNeeded;
        this.skillLevel = skillLevel;
        this.bandLevel = bandLevel;
    }

    public EmployeeSkill getEmployeeSkill() {
        return employeeSkill;
    }

    public int getTotalPeopleNeeded() {
        return totalPeopleNeeded;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public EmployeeBandLevel getBandLevel() {
        return bandLevel;
    }
}
