package com.example.java.interfaceDesign.ProjectAllocationDtos;

import com.example.java.interfaceDesign.ProjectAllocationEnums.AllocationStatus;
import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeSkill;

import java.util.Map;

public class ProjectAllocationResponse {
    Map<EmployeeSkill,AllocationStatus> allocationStatus;

    public Map<EmployeeSkill, AllocationStatus> getAllocationStatus() {
        return allocationStatus;
    }

    public void setAllocationStatus(Map<EmployeeSkill, AllocationStatus> allocationStatus) {
        this.allocationStatus = allocationStatus;
    }
}
