package com.fabrick.testapp.service.impl;

import com.fabrick.testapp.model.operation.json.transfer.MoneyTransfersRequest;
import com.fabrick.testapp.model.operation.json.transfer.MoneyTransfersResponse;
import com.fabrick.testapp.service.FabrickRestConnectorTransferService;
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
public class FabrickRestConnectorTransferServiceImpl implements FabrickRestConnectorTransferService {

    private static final Logger log = LoggerFactory.getLogger(FabrickRestConnectorTransferServiceImpl.class);

    @Value("${fabrick.test.endpoint.moneyTransfers}")
    private String moneyTransferEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public MoneyTransfersResponse moneyTransfers(Long id, MoneyTransfersRequest moneyTransfersRequest) {

        Map<String, Long> map = new HashMap<String, Long>();
        map.put("accountId", id);
        HttpHeaders headers = new HeaderInitializer().invoke();
        HttpEntity<MoneyTransfersRequest> entity = new HttpEntity(moneyTransfersRequest, headers);
        ResponseEntity<MoneyTransfersResponse> response =
                restTemplate.exchange(
                        moneyTransferEndpoint, HttpMethod.POST, entity, MoneyTransfersResponse.class, map);
        if (response != null) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
