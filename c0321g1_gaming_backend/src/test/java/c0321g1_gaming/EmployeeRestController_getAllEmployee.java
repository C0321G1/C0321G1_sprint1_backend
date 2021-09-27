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
public class EmployeeRestController_getAllEmployee {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    EmployeeRestController employeeRestController;

    // khue write test case list null
    @Test
    public void getAllEmployee_1() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/employee"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // khue write test case get list success
    @Test
    public void getAllEmployee_2() {
        ResponseEntity<Page<Employee>> pageResponseEntity = this.employeeRestController.getAllEmployee(
                PageRequest.of(0, 5));
        Page<Employee> employeePage = pageResponseEntity.getBody();
        int statusCode = pageResponseEntity.getStatusCodeValue();

        Assertions.assertEquals(200, statusCode);
        Assertions.assertEquals(8, employeePage.getTotalElements());
        Assertions.assertEquals(2, employeePage.getTotalPages());
        Assertions.assertEquals("Nguyen Vu", employeePage.getContent().get(0).getFullName());
        Assertions.assertEquals("EMP0001", employeePage.getContent().get(0).getCode());
        Assertions.assertEquals("EMP0001", employeePage.getContent().get(0).getCode());
        Assertions.assertEquals("Nam", employeePage.getContent().get(0).getGender().getName());
    }
}
