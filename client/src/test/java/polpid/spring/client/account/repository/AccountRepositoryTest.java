package polpid.spring.client.account.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import polpid.spring.client.domain.Account;
import polpid.spring.client.enums.EnableStatus;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountRepositoryTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountRepository accountRepository;

    @Test
    public void findAll() throws Exception {
        when(accountRepository.findAll()).thenReturn(
                Arrays.asList(new Account("testId", "testName", "testPw", "testEmail", EnableStatus.TRUE))
        );

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();


        String contentAsString = mvcResult.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        List<Account> accounts = mapper.readValue(contentAsString, List.class);

        System.out.println(accounts);
        assertTrue(1 == accounts.size());

        verify(accountRepository).findAll();
    }

}
