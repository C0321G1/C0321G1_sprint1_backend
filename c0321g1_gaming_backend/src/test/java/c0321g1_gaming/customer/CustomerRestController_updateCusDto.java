package c0321g1_gaming.customer;

import c0321g1_gaming.dto.customer.CusDTO;
import c0321g1_gaming.model.service.customer.CustomerService;
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
public class CustomerRestController_updateCusDto {
    @Autowired
    CustomerService customerService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateNewCusDto_name_18() throws Exception {

        CusDTO cusDTO = new CusDTO();
        cusDTO.setFullName("Poli16-9");
        cusDTO.setEmail("A@gmail.com");
        cusDTO.setDateOfBirth("");
        cusDTO.setPhone("");

        cusDTO.setAddressId((long) 1);
        cusDTO.setGenderId((long) 1);
        cusDTO.setCustomerStatusId((long) 1);

        cusDTO.setPassword("16-9");
        cusDTO.setUsername("11a");
        cusDTO.setCustomerId((long) 1);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .patch("/edit")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(cusDTO)))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
