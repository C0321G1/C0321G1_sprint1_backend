package c0321g1_gaming;

import c0321g1_gaming.controller.employee.EmployeeRestController;
import c0321g1_gaming.model.entity.employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_searchEmployee {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    EmployeeRestController employeeRestController;

    // khue write test case search employee return list null
    @Test
    public void searchEmployee_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee/search?page=0&employeeId=&dateBirthFrom=&dateBirthTo=&dateWorkFrom=&dateWorkTo=&position=323&province=232"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // khue write test case search employee return list success
    @Test
    public void searchEmployee_2() {
        ResponseEntity<Page<Employee>> pageResponseEntity = this.employeeRestController.getSearchEmployee(
                PageRequest.of(0, 5), "EMP0001", "2000-09-09", "2000-12-09",
                "2020-03-24", "2020-05-24", "", "");
        Page<Employee> employeePage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(1, employeePage.getTotalElements());
        Assertions.assertEquals(1, employeePage.getTotalPages());
        Assertions.assertEquals("Nguyen Vu", employeePage.getContent().get(0).getFullName());
        Assertions.assertEquals("EMP0001", employeePage.getContent().get(0).getCode());
        Assertions.assertEquals("Nam", employeePage.getContent().get(0).getGender().getName());
    }
}
