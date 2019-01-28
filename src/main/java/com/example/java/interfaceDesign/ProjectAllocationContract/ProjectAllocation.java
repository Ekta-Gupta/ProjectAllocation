package com.example.java.interfaceDesign.ProjectAllocationContract;

import com.example.java.interfaceDesign.ProjectAllocationDtos.ProjectAllocationInput;
import com.example.java.interfaceDesign.ProjectAllocationDtos.ProjectAllocationResponse;

public interface ProjectAllocation {
    public ProjectAllocationResponse provideProjectTeam(ProjectAllocationInput projectAllocationInput);
}
