package gmail.roadtojob2019.brewery.controller.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource("classpath:application-test.properties")
class ProduceRequestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSalesProduceRequestIsCreated() throws Exception {
        mockMvc.perform(post("/brewery/sales/requests")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"date\" : \"2020-02-05\",\n" +
                        "  \"term\" : \"2020-02-10\",\n" +
                        "  \"status\" : \"NEW\",\n" +
                        "  \"produceRequestItemDtos\" : [\n" +
                        "                                 {\"productId\" : 1,\n" +
                        "                                  \"amount\" : 150 }\n" +
                        "                               ]\n" +
                        "}"))
                .andExpect(status().isCreated())
                .andExpect(content().json("2"));
    }

    @Test
   public void testGetProduceRequestsByStatusIsOk() throws Exception {
        mockMvc.perform(get("/brewery/brewer/requests/?status=new"))
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "  {\n" +
                        "  \"date\" : \"02.02.2020\",\n" +
                        "  \"term\" : \"04.02.2020\",\n" +
                        "  \"status\" : \"NEW\",\n" +
                        "  \"produceRequestItemDtos\" : [\n" +
                        "                                 {\"productId\" : 1,\n" +
                        "                                  \"amount\" : 350.0 }\n" +
                        "                               ]\n" +
                        "  }\n" +
                        "]"));
    }

    @Test
    public void testGetProduceRequestIsOk() throws Exception {
        mockMvc.perform(get("/brewery/brewer/requests/1"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"date\" : \"02.02.2020\",\n" +
                        "  \"term\" : \"04.02.2020\",\n" +
                        "  \"produceRequestItemDtos\" : [\n" +
                        "                                 {\"productId\" : 1,\n" +
                        "                                  \"amount\" : 350.0 }\n" +
                        "                               ]\n" +
                        "  }\n"));
    }

    @Test
    public void testChangeProduceRequestStatusIsOk() throws Exception {
        mockMvc.perform(patch("/brewery/brewer/requests/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("  {\n" +
                        "  \"status\" : \"In_progress\"\n" +
                        "  }\n"))
                .andExpect(status().isOk())
                .andExpect(content().json("1"));
    }

}