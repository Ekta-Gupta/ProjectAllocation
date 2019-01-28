package com.example.java.interfaceDesign.ProjectAllocationImp;

import com.example.java.interfaceDesign.ProjectAllocationDtos.EmployeeWithSkills;
import com.example.java.interfaceDesign.ProjectAllocationDtos.ProjectAllocationInput;
import com.example.java.interfaceDesign.ProjectAllocationDtos.ProjectAllocationResponse;
import com.example.java.interfaceDesign.ProjectAllocationEnums.AllocationStatus;
import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeBandLevel;
import com.example.java.interfaceDesign.ProjectAllocationEnums.EmployeeSkill;
import com.example.java.interfaceDesign.ProjectAllocationEnums.SkillLevel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProjectAllocationImpTest {

    @Test
    public void provideProjectTeamTest() throws ParseException {
        ProjectAllocationImp projectAllocationImp = new ProjectAllocationImp();

        String string = "January 2, 2019";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date startDate = format.parse(string);

        List<EmployeeWithSkills> employeeWithSkillsList = new ArrayList<>();

        EmployeeWithSkills employeeWithSkills1 = new EmployeeWithSkills(EmployeeSkill.SKILL_JAVA,2, SkillLevel.INTERMEDIATE, EmployeeBandLevel.B7);
        employeeWithSkillsList.add(employeeWithSkills1);

        EmployeeWithSkills employeeWithSkills2 = new EmployeeWithSkills(EmployeeSkill.SKILL_JAVA,1,SkillLevel.EXPERT,EmployeeBandLevel.B6H);
        employeeWithSkillsList.add(employeeWithSkills2);

        Map<EmployeeSkill,List<EmployeeWithSkills>> employeesNeeded = new HashMap<>();
        employeesNeeded.put(EmployeeSkill.SKILL_JAVA,employeeWithSkillsList);

        ProjectAllocationInput projectAllocationInput = new ProjectAllocationInput(startDate, employeesNeeded, employeeWithSkillsList,3,"CSA","test");

        ProjectAllocationResponse allocationResponse = projectAllocationImp.provideProjectTeam(projectAllocationInput);

        assertEquals(allocationResponse.getAllocationStatus().get(EmployeeSkill.SKILL_JAVA), AllocationStatus.PARTIALLY);


        System.out.println("test pass");




    }

}