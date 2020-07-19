package com.fabrick.testapp.ControllerTest;

import com.fabrick.testapp.Application;
import com.fabrick.testapp.service.FabrickRestConnectorAccountService;
import com.fabrick.testapp.service.FabrickRestConnectorTransferService;
import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountControllerTest {

    private MockMvc mockMvc;

    private static final Logger logger =
            Logger.getLogger(AccountControllerTest.class);

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    FabrickRestConnectorAccountService fabrickRestConnectorAccountService;

    @Autowired
    FabrickRestConnectorTransferService fabrickRestConnectorTransferService;

    @Before
    public void setup()
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void getAccountBalanceTest() throws Exception {

      mockMvc.perform(MockMvcRequestBuilders.get("/api/gbs/banking/v4.0/accounts/14537780/balance")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.payload.balance").value("3.51"))
                .andExpect(jsonPath("$.payload.availableBalance").value("3.51"))
                .andExpect(jsonPath("$.payload.currency").value("EUR"))
                .andReturn();
    }

    @Test
    public void getAccountTransactionTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/gbs/banking/v4.0/accounts/14537780/transactions?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value("OK"))
                .andReturn();
    }

}
