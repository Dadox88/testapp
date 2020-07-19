package com.fabrick.testapp.service.impl;

import com.fabrick.testapp.model.operation.json.balanceandmovments.AccountBalance;
import com.fabrick.testapp.model.operation.json.balanceandmovments.AccountTransaction;
import com.fabrick.testapp.service.FabrickRestConnectorAccountService;
import com.fabrick.testapp.utility.HeaderInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class FabrickConnectorAccountServiceImpl implements FabrickRestConnectorAccountService {

    private static final Logger log = LoggerFactory.getLogger(FabrickConnectorAccountServiceImpl.class);

    @Value("${fabrick.test.endpoint.balance}")
    private String balanceEndpoint;

    @Value("${fabrick.test.endpoint.Transaction}")
    private String transactionEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public AccountBalance accountBalance(Long id) {
        Map<String, Long> map = new HashMap<String, Long>();
        map.put("accountId", id);
        HttpHeaders headers = new HeaderInitializer().invoke();
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<AccountBalance> response = restTemplate.exchange(balanceEndpoint, HttpMethod.GET, entity, AccountBalance.class, map);
        if (response != null) {
            return response.getBody();
        } else {
            return null;
        }
    }

    @Override
    public AccountTransaction accountTransaction(Long id, String fromDate, String toDate) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("accountId", id.toString());
        map.put("fromAccountingDate", fromDate );
        map.put("toAccountingDate", toDate );
        HttpHeaders headers = new HeaderInitializer().invoke();
        HttpEntity entity = new HttpEntity(headers);
        ResponseEntity<AccountTransaction> response = restTemplate.exchange(transactionEndpoint, HttpMethod.GET, entity, AccountTransaction.class, map);
        if (response != null) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
