package com.fabrick.testapp.service;

import com.fabrick.testapp.model.operation.json.balanceandmovments.AccountBalance;
import com.fabrick.testapp.model.operation.json.balanceandmovments.AccountTransaction;


public interface FabrickRestConnectorAccountService {

    AccountBalance accountBalance(Long id);

    AccountTransaction accountTransaction(Long id, String fromDate, String toDate);

}
