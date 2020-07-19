package com.fabrick.testapp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Slf4j
public class ExceptionHandlers extends BaseExceptionHandler {
    public ExceptionHandlers() {
        super(log);
    }

    @ExceptionHandler(BalanceNotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleBalanceNotFoundException(final BalanceNotfoundException ex) {
        log.error("Balance not found thrown", ex);
        return new ErrorResponse("BALANCE_NOT_FOUND", "The balance was not found");
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleTransactionNotFoundException(final TransactionNotFoundException ex) {
        log.error("Transactions not found thrown", ex);
        return new ErrorResponse("TRANSACTIONS_NOT_FOUND", "The transactions was not found");
    }

    @ExceptionHandler(TransferException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleTransferException(final TransferException ex) {
        log.error("unable to transfer money thrown", ex);
        return new ErrorResponse("UNABLE_TO_TRANSFER", "Transfer failed");
    }

}
