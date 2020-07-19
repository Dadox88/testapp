package com.fabrick.testapp.ControllerTest;

import com.fabrick.testapp.Application;
import com.fabrick.testapp.model.operation.json.transfer.MoneyTransfersResponse;
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
public class TransferControllerTest {

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

    String jsonReq ="{\n" +
            "  \"creditor\": {\n" +
            "    \"name\": \"John Doe\",\n" +
            "    \"account\": {\n" +
            "      \"accountCode\": \"IT23A0336844430152923804660\",\n" +
            "      \"bicCode\": \"SELBIT2BXXX\"\n" +
            "    },\n" +
            "    \"address\": {\n" +
            "      \"address\": null,\n" +
            "      \"city\": null,\n" +
            "      \"countryCode\": null\n" +
            "    }\n" +
            "  },\n" +
            "  \"executionDate\": \"2020-03-03\",\n" +
            "  \"uri\": \"REMITTANCE_INFORMATION\",\n" +
            "  \"description\": \"Payment invoice 75/2020\",\n" +
            "  \"amount\": 800,\n" +
            "  \"currency\": \"EUR\",\n" +
            "  \"isUrgent\": false,\n" +
            "  \"isInstant\": false,\n" +
            "  \"feeType\": \"SHA\",\n" +
            "  \"feeAccountId\": \"45685475\",\n" +
            "  \"taxRelief\": {\n" +
            "    \"taxReliefId\": \"L449\",\n" +
            "    \"isCondoUpgrade\": false,\n" +
            "    \"creditorFiscalCode\": \"56258745832\",\n" +
            "    \"beneficiaryType\": \"NATURAL_PERSON\",\n" +
            "    \"naturalPersonBeneficiary\": {\n" +
            "      \"fiscalCode1\": \"MRLFNC81L04A859L\",\n" +
            "      \"fiscalCode2\": null,\n" +
            "      \"fiscalCode3\": null,\n" +
            "      \"fiscalCode4\": null,\n" +
            "      \"fiscalCode5\": null\n" +
            "    },\n" +
            "    \"legalPersonBeneficiary\": {\n" +
            "      \"fiscalCode\": null,\n" +
            "      \"legalRepresentativeFiscalCode\": null\n" +
            "    }\n" +
            "  }\n" +
            "}";

    @Test
    public void moneyTransferTest() throws Exception
    {
        MvcResult mvcResult =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/gbs/banking/v4.0/accounts/14537780/payments/money-transfers")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(jsonReq))
                        .andReturn();

        int status = mvcResult.getResponse().getStatus();
        String str = mvcResult.getResponse().getContentAsString();
        MoneyTransfersResponse moneyTransfersResponse =
                jsonMapperUtil.mapFromJson(str, MoneyTransfersResponse.class);
        assertEquals(500, status);
        assertThat(moneyTransfersResponse.getStatus().equals("KO"));
        logger.info(mvcResult.getResponse().getContentAsString());
    }
}
