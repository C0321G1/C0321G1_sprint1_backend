<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/ServicesRestController_findById.java
package c0321g1_gaming.controller;
=======
package c0321g1_gaming;
>>>>>>> f1bfef594c6a6c100693f42c19e02a324f2284f5:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/EmployeeRestController_deleteEmployee.java

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/ServicesRestController_findById.java
 class ServicesRestController_findById {
=======
public class EmployeeRestController_deleteEmployee {

>>>>>>> f1bfef594c6a6c100693f42c19e02a324f2284f5:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/EmployeeRestController_deleteEmployee.java
    @Autowired
    private MockMvc mockMvc;

    // khue write test case delete employee while id null
    @Test
<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/ServicesRestController_findById.java
     void findById_1() throws Exception {
=======
    public void deleteEmployee_1() throws Exception {
>>>>>>> f1bfef594c6a6c100693f42c19e02a324f2284f5:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/EmployeeRestController_deleteEmployee.java
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/employee/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // khue write test case delete employee while id not found
    @Test
<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/ServicesRestController_findById.java
     void findById_3() throws Exception {
=======
    public void deleteEmployee_2() throws Exception {
>>>>>>> f1bfef594c6a6c100693f42c19e02a324f2284f5:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/EmployeeRestController_deleteEmployee.java
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/employee/{id}", 25))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    // khue write test case delete employee success
    @Test
<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/ServicesRestController_findById.java
     void findById_4() throws Exception {
=======
    public void deleteEmployee_3() throws Exception {
>>>>>>> f1bfef594c6a6c100693f42c19e02a324f2284f5:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/EmployeeRestController_deleteEmployee.java
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/employee/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/ServicesRestController_findById.java

=======
>>>>>>> f1bfef594c6a6c100693f42c19e02a324f2284f5:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/EmployeeRestController_deleteEmployee.java
    }
}
