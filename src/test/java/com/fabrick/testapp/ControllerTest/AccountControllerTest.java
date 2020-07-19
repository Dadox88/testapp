package com.fabrick.testapp.ControllerTest;

import com.fabrick.testapp.Application;
import com.fabrick.testapp.model.operation.json.balanceandmovments.AccountBalance;
import com.fabrick.testapp.model.operation.json.balanceandmovments.AccountTransaction;
import com.fabrick.testapp.service.FabrickRestConnectorAccountService;
import com.fabrick.testapp.service.FabrickRestConnectorTransferService;
import com.fabrick.testapp.utility.JsonMapperUtil;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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
    JsonMapperUtil jsonMapperUtil;

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
        String uri = "/api/gbs/banking/v4.0/accounts/14537780/balance";
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                        .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        AccountBalance accountBalance = jsonMapperUtil.mapFromJson(content, AccountBalance.class);

        assertEquals(200, status);
        assertThat(accountBalance.getStatus().equals("OK"));
       // assertThat(accountBalance.getPayload().getBalance()).isEqualTo(-256.32);
      //  assertThat(accountBalance.getPayload().getAvailableBalance()).isEqualTo(-256.32);

        logger.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getAccountTransactionTest() throws Exception {
        String uri = "/api/gbs/banking/v4.0/accounts/14537780/transactions?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01";
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                        .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
        AccountTransaction accountTransaction  = jsonMapperUtil.mapFromJson(content, AccountTransaction.class);
        assertEquals(200, status);
        assertThat(accountTransaction.getStatus().equals("OK"));
        logger.info(mvcResult.getResponse().getContentAsString());

    }


}
