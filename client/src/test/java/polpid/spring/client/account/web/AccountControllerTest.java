package polpid.spring.client.account.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import polpid.spring.client.ClientApplication;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ClientApplication.class
)

@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.yml"
)
public class AccountControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void findAll() throws Exception {
       MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();


        String contentAsString = mvcResult.getResponse().getContentAsString();

        System.out.println(contentAsString);
    }
}
