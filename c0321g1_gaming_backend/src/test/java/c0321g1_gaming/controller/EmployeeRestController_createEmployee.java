package c0321g1_gaming.controller;

import c0321g1_gaming.dto.employee.EmployeeDto;
import c0321g1_gaming.model.entity.employee.Position;
import c0321g1_gaming.model.entity.gender.Gender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Linh create class EmployeeRestController_createEmployee
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeRestController_createEmployee {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createEmployee_code_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode(null);
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_code_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_code_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_fullName_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0005");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName(null);

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_fullName_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0005");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_fullName_16() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0005");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_fullName_17() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0005");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("Nguyễn Văn Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_yearOfExp_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(null);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    @Test
    public void createEmployee_yearOfExp_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(-1L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_level_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(null);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    @Test
    public void createEmployee_level_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(0L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988224466");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_phone_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone(null);
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_phone_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_phone_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("098822446633a");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_email_13() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail(null);
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988135777");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_email_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988135777");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_email_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail");
        employeeDto.setStartWorkDate("2021-09-14");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988135777");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_startWorkDate_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988135777");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_startWorkDate_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2000-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-01");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988135777");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_dateOfBirth_14() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-20");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988135777");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void createEmployee_dateOfBirth_15() throws Exception {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setCode("EMP-0001");
        employeeDto.setDateOfBirth("2005-01-01");
        employeeDto.setEmail("a@gmail.com");
        employeeDto.setStartWorkDate("2021-09-20");
        employeeDto.setLevel(1L);
        employeeDto.setYearOfExp(0L);
        employeeDto.setPhone("0988135777");
        employeeDto.setFullName("Nguyễn Văn A");

        Gender gender = new Gender();
        gender.setGenderId(1L);
        employeeDto.setGender(gender);

        Position position = new Position();
        position.setPositionId(1L);
        employeeDto.setPosition(position);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/employee")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(employeeDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
}
