package com.fabrick.testapp.service;

import com.fabrick.testapp.model.operation.json.transfer.MoneyTransfersRequest;
import com.fabrick.testapp.model.operation.json.transfer.MoneyTransfersResponse;

public interface FabrickRestConnectorTransferService {

    MoneyTransfersResponse moneyTransfers(Long id, MoneyTransfersRequest moneyTransfersRequest);
}
