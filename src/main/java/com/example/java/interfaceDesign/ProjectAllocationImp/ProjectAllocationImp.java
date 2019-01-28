package com.example.java.interfaceDesign.ProjectAllocationImp;

import com.example.java.interfaceDesign.ProjectAllocationContract.ProjectAllocation;
import com.example.java.interfaceDesign.ProjectAllocationDtos.Employee;
import com.example.java.interfaceDesign.ProjectAllocationDtos.EmployeeWithSkills;
import com.example.java.interfaceDesign.ProjectAllocationDtos.ProjectAllocationInput;
import com.example.java.interfaceDesign.ProjectAllocationDtos.ProjectAllocationResponse;
import com.example.java.interfaceDesign.ProjectAllocationEnums.AllocationStatus;
import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeBandLevel;
import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeSkill;
import com.example.java.interfaceDesign.ProjectAllocationEnums.SkillLevel;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectAllocationImp implements ProjectAllocation {

    ProjectAllocationResponse projectAllocationResponse = new ProjectAllocationResponse();

    Map<EmployeeSkill,AllocationStatus> employeeWithSkillsAllocationStatusMap = new HashMap<>();

    @Override
    public ProjectAllocationResponse provideProjectTeam(ProjectAllocationInput projectAllocationInput) {
        AllocateProjectBasedOnSkills(projectAllocationInput.getEmployeesNeeded(),projectAllocationInput.getProjectName());
        projectAllocationResponse.setAllocationStatus(employeeWithSkillsAllocationStatusMap);
        return projectAllocationResponse;
    }

    protected void AllocateProjectBasedOnSkills(Map<EmployeeSkill,List<EmployeeWithSkills>> requiredEmployeeWithSkill,String projectName) {
        //Iterate over map based on skill
        for(EmployeeSkill employeeSkill:requiredEmployeeWithSkill.keySet()){
            List<EmployeeWithSkills> employeeWithSkillsList = requiredEmployeeWithSkill.get(employeeSkill);
            boolean isPartiallyAllocated = false;
            boolean isDenyForAllocation = false;
            for(EmployeeWithSkills employeeWithSkill:employeeWithSkillsList) {
                AllocationStatus allocationStatus = fullFillAllocationWithExactMatch(employeeWithSkill,projectName);
                if(AllocationStatus.PARTIALLY.equals(allocationStatus))
                {
                    isPartiallyAllocated = true;
                }
                else if(AllocationStatus.DENY.equals(allocationStatus)){
                    isDenyForAllocation = true;
                }
                // To Do:
                //fullFillAllocationWithSimilarMatch(employeeWithSkill,projectName);
            }
            if((isDenyForAllocation && isPartiallyAllocated) || isPartiallyAllocated){
                employeeWithSkillsAllocationStatusMap.put(employeeSkill,AllocationStatus.PARTIALLY);

            }
            else if(isDenyForAllocation){
                employeeWithSkillsAllocationStatusMap.put(employeeSkill,AllocationStatus.DENY);
            }
            else {
                employeeWithSkillsAllocationStatusMap.put(employeeSkill,AllocationStatus.COMPLETELY);
            }
        }


    }

    private void fullFillAllocationWithSimilarMatch(EmployeeWithSkills employeeWithSkill, String projectName) {
        // To Do: allocation based on similar skill
    }

    private AllocationStatus fullFillAllocationWithExactMatch(EmployeeWithSkills employeeSkillAndBandNeeded,String projectName) {
        List<Employee> employeesWithSkillBandAndLevel = findEmployeeWithSkillBandAndLevel(employeeSkillAndBandNeeded.getEmployeeSkill(),employeeSkillAndBandNeeded.getBandLevel(),employeeSkillAndBandNeeded.getSkillLevel());
        if(employeesWithSkillBandAndLevel.size() == 0)
        {
            return AllocationStatus.DENY;
        }
        int neededEmployees = employeeSkillAndBandNeeded.getTotalPeopleNeeded();
        int totalAllocatedEmployee = allocateEmployeesThisProject(projectName,employeesWithSkillBandAndLevel,neededEmployees);
        if(totalAllocatedEmployee == neededEmployees){
            return AllocationStatus.COMPLETELY;
        }
        else {
            return AllocationStatus.PARTIALLY;
        }

    }

    private int allocateEmployeesThisProject(String projectName, List<Employee> employeesWithSkillBandAndLevel,int neededEmployees) {

        int i=1;
        while (employeesWithSkillBandAndLevel.size()>=i && neededEmployees>=i){
            Employee employee = employeesWithSkillBandAndLevel.get(i-1);
            Map<String,Integer> projectAllocation = new HashMap<>();
            projectAllocation.put(projectName,100);
            employee.setAllocatedProjectWithPercentage(projectAllocation);
            i++;

        }
        return (i-1);

    }

    private List<Employee> findEmployeeWithSkillBandAndLevel(EmployeeSkill employeeSkill, EmployeeBandLevel bandLevel, SkillLevel skillLevel) {
        // To do: Database query based on all three + employee should be free
        List<Employee> employeesWithB6H = new ArrayList<>();
        List<Employee> employeesWithB7 = new ArrayList<>();

        Map<EmployeeSkill,SkillLevel> employeeSkillSkillLevelMap = new HashMap<>();
        employeeSkillSkillLevelMap.put(EmployeeSkill.SKILL_JAVA,SkillLevel.EXPERT);
        employeeSkillSkillLevelMap.put(EmployeeSkill.SKILL_REACT,SkillLevel.BEGINNER);
        Employee employeeWithB6H = new Employee(123,"test1",employeeSkillSkillLevelMap,null,EmployeeBandLevel.B6H);

        employeesWithB6H.add(employeeWithB6H);

        Map<EmployeeSkill,SkillLevel> employeeSkillSkillLevelMap2 = new HashMap<>();
        employeeSkillSkillLevelMap2.put(EmployeeSkill.SKILL_JAVA,SkillLevel.INTERMEDIATE);
        employeeSkillSkillLevelMap2.put(EmployeeSkill.SKILL_REACT,SkillLevel.BEGINNER);
        Employee employeeWithB7 = new Employee(123,"test2",employeeSkillSkillLevelMap,null,EmployeeBandLevel.B7);
        employeesWithB7.add(employeeWithB7);

        if(bandLevel == EmployeeBandLevel.B7)
        {
            return employeesWithB7;
        }
        return employeesWithB6H;

    }

}
