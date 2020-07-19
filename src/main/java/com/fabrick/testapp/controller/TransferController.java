package com.fabrick.testapp.controller;

import com.fabrick.testapp.exception.TransferException;
import com.fabrick.testapp.model.operation.json.transfer.MoneyTransfersRequest;
import com.fabrick.testapp.model.operation.json.transfer.MoneyTransfersResponse;
import com.fabrick.testapp.service.FabrickRestConnectorTransferService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransferController {

    @Autowired
    private FabrickRestConnectorTransferService fabrickRestConnectorTransferService;

    @PostMapping(value = "gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers",
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(
            value = "Money Transfer like Client from Web Service Rest Banking Account ",
            code = 201)
    @ResponseStatus(HttpStatus.CREATED)
    public MoneyTransfersResponse moneyTransfer(
            @PathVariable Long accountId,
            @ApiParam(value = "Contains the json representation of the moneyTransfer", required = true)
            @RequestBody MoneyTransfersRequest moneyTransfersRequest) {

        MoneyTransfersResponse moneyTransfersResponse =
                fabrickRestConnectorTransferService.moneyTransfers(accountId, moneyTransfersRequest);

        if (moneyTransfersResponse != null) {

            /*TODO persiste on db */

            return moneyTransfersResponse;
        } else {
            throw new TransferException();
        }
    }
}
