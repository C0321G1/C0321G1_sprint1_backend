package c0321g1_gaming.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Linh create class EmployeeRestController_getEmployee
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_getEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getEmployee_id_1() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/employee/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //getEmployee_id with case id = '' not test, data type of id is Long

    @Test
    public void getEmployee_id_3() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/employee/{id}", 50))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getEmployee_id_4() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/employee/{id}", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.employeeId").value(1))
                .andExpect(jsonPath("$.code").value("EMP0001"))
                .andExpect(jsonPath("$.dateOfBirth").value("2000-08-29"))
                .andExpect(jsonPath("$.email").value("a@gmail.com"))
                .andExpect(jsonPath("$.fullName").value("Nguyễn Văn A"))
                .andExpect(jsonPath("$.level").value(1))
                .andExpect(jsonPath("$.phone").value("0988123456"))
                .andExpect(jsonPath("$.startWorkDate").value("2021-09-04"))
                .andExpect(jsonPath("$.yearOfExp").value(0))
                .andExpect(jsonPath("$.address.addressId").value(2))
                .andExpect(jsonPath("$.gender.genderId").value(1))
                .andExpect(jsonPath("$.position.positionId").value(1));

    }
}
