package com.fabrick.testapp.controller;

import com.fabrick.testapp.exception.BalanceNotfoundException;
import com.fabrick.testapp.exception.TransactionNotFoundException;
import com.fabrick.testapp.model.operation.json.balanceandmovments.AccountBalance;
import com.fabrick.testapp.model.operation.json.balanceandmovments.AccountTransaction;
import com.fabrick.testapp.service.FabrickRestConnectorAccountService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api", produces = MediaType.APPLICATION_JSON_VALUE )
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private  FabrickRestConnectorAccountService fabrickRestConnectorAccountService;

    @GetMapping(value = "/gbs/banking/v4.0/accounts/{accountId}/balance", produces = "application/json")
    @ApiOperation(value = "Retrieves the balance of a specific cash account.")
    @ResponseStatus(HttpStatus.OK)
    public AccountBalance getAccountBalance(@PathVariable Long accountId){
        AccountBalance accountBalance = fabrickRestConnectorAccountService.accountBalance(accountId);
        if (accountBalance != null) {
            return accountBalance;
        } else {
            throw new BalanceNotfoundException();
        }
    }

    @GetMapping(value = "gbs/banking/v4.0/accounts/{accountId}/transactions")
    @ApiOperation(value = "Retrieves the transactions of a specific cash account.")
    @ResponseStatus(HttpStatus.OK)
    public AccountTransaction getAccountTransaction(@PathVariable Long accountId, @RequestParam String fromAccountingDate, @RequestParam String toAccountingDate){
        AccountTransaction accountTransaction = fabrickRestConnectorAccountService.accountTransaction(accountId,fromAccountingDate,toAccountingDate);
        if (accountTransaction != null) {
            return accountTransaction;
        } else {
            throw new TransactionNotFoundException();
        }
    }

}
