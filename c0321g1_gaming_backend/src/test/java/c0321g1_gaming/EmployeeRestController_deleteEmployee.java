package c0321g1_gaming;

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
<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/game/GameRestController_deleteGame.java
class GameRestController_deleteGame {
    //    Creator: Thúy
=======
public class EmployeeRestController_deleteEmployee {

>>>>>>> f1bfef594c6a6c100693f42c19e02a324f2284f5:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/EmployeeRestController_deleteEmployee.java
    @Autowired
    private MockMvc mockMvc;

    // khue write test case delete employee while id null
    @Test
<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/game/GameRestController_deleteGame.java
    void deleteGame_id_25() throws Exception {
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
<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/game/GameRestController_deleteGame.java
    void deleteGame_id_27() throws Exception {
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
<<<<<<< HEAD:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/controller/game/GameRestController_deleteGame.java
    void deleteGame_id_28() throws Exception {
=======
    public void deleteEmployee_3() throws Exception {
>>>>>>> f1bfef594c6a6c100693f42c19e02a324f2284f5:c0321g1_gaming_backend/src/test/java/c0321g1_gaming/EmployeeRestController_deleteEmployee.java
        mockMvc.perform(
                MockMvcRequestBuilders.delete("/employee/{id}", 2))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
