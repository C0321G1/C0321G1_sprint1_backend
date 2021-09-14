package c0321g1_gaming.controller;

import c0321g1_gaming.dto.customer.CustomerDto;
import c0321g1_gaming.model.entity.address.Address;
import c0321g1_gaming.model.entity.customer.Customer;
import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.entity.security.Account;
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

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerRestController_createCustomer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //creator: vinhdn
    @Test
    public void createCustomer_fullName_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFullName(null);
        customerDto.setPhone("0905123123");

        Account account = new Account();
        account.setAccountId((long) 1);
        customerDto.setAccount(account);

        Gender gender = new Gender();
        gender.setGenderId((long) 1);
        customerDto.setGender(gender);

        Address address = new Address();
        address.setAddressId((long) 1);
        customerDto.setAddress(address);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/customer/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(customerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //creator: vinhdn
    @Test
    public void createCustomer_phone_13() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFullName("test");
        customerDto.setPhone(null);

        Account account = new Account();
        account.setAccountId((long) 1);
        customerDto.setAccount(account);

        Gender gender = new Gender();
        gender.setGenderId((long) 1);
        customerDto.setGender(gender);

        Address address = new Address();
        address.setAddressId((long) 1);
        customerDto.setAddress(address);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/customer/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(customerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //creator: vinhdn
    @Test
    public void createCustomer_fullName_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFullName("");
        customerDto.setPhone("0905123123");

        Account account = new Account();
        account.setAccountId((long) 1);
        customerDto.setAccount(account);

        Gender gender = new Gender();
        gender.setGenderId((long) 1);
        customerDto.setGender(gender);

        Address address = new Address();
        address.setAddressId((long) 1);
        customerDto.setAddress(address);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/customer/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(customerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //creator: vinhdn
    @Test
    public void createCustomer_phone_14() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFullName("test");
        customerDto.setPhone("");

        Account account = new Account();
        account.setAccountId((long) 1);
        customerDto.setAccount(account);

        Gender gender = new Gender();
        gender.setGenderId((long) 1);
        customerDto.setGender(gender);

        Address address = new Address();
        address.setAddressId((long) 1);
        customerDto.setAddress(address);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/customer/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(customerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //creator: vinhdn
    @Test
    public void createCustomer_phone_15() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFullName("test");
        customerDto.setPhone("123");

        Account account = new Account();
        account.setAccountId((long) 1);
        customerDto.setAccount(account);

        Gender gender = new Gender();
        gender.setGenderId((long) 1);
        customerDto.setGender(gender);

        Address address = new Address();
        address.setAddressId((long) 1);
        customerDto.setAddress(address);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/customer/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(customerDto)))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //creator: vinhdn
    @Test
    public void createCustomer_18() throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFullName("test2");
        customerDto.setPhone("0905123123");

        Account account = new Account();
        account.setAccountId((long) 1);
        customerDto.setAccount(account);

        Gender gender = new Gender();
        gender.setGenderId((long) 1);
        customerDto.setGender(gender);

        Address address = new Address();
        address.setAddressId((long) 1);
        customerDto.setAddress(address);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/customer/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(customerDto)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
