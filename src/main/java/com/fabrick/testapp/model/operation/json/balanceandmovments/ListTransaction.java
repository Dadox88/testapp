package com.fabrick.testapp.model.operation.json.balanceandmovments;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "transactionId",
        "operationId",
        "accountingDate",
        "valueDate",
        "type",
        "amount",
        "currency",
        "description"
})
public class ListTransaction {

    @JsonProperty("transactionId")
    private String transactionId;
    @JsonProperty("operationId")
    private String operationId;
    @JsonProperty("accountingDate")
    private String accountingDate;
    @JsonProperty("valueDate")
    private String valueDate;
    @JsonProperty("type")
    private TypeTransaction type;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("description")
    private String description;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty("operationId")
    public String getOperationId() {
        return operationId;
    }

    @JsonProperty("operationId")
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    @JsonProperty("accountingDate")
    public String getAccountingDate() {
        return accountingDate;
    }

    @JsonProperty("accountingDate")
    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    @JsonProperty("valueDate")
    public String getValueDate() {
        return valueDate;
    }

    @JsonProperty("valueDate")
    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    @JsonProperty("type")
    public TypeTransaction getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(TypeTransaction type) {
        this.type = type;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
