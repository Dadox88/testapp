package com.fabrick.testapp.model.operation.json.transfer;

import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "debtorAmount",
    "debtorCurrency",
    "creditorAmount",
    "creditorCurrency",
    "creditorCurrencyDate",
    "exchangeRate"
})
public class Amount {

    @JsonProperty("debtorAmount")
    private Double debtorAmount;
    @JsonProperty("debtorCurrency")
    private String debtorCurrency;
    @JsonProperty("creditorAmount")
    private Double creditorAmount;
    @JsonProperty("creditorCurrency")
    private String creditorCurrency;
    @JsonProperty("creditorCurrencyDate")
    private String creditorCurrencyDate;
    @JsonProperty("exchangeRate")
    private Double exchangeRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("debtorAmount")
    public Double getDebtorAmount() {
        return debtorAmount;
    }

    @JsonProperty("debtorAmount")
    public void setDebtorAmount(Double debtorAmount) {
        this.debtorAmount = debtorAmount;
    }

    @JsonProperty("debtorCurrency")
    public String getDebtorCurrency() {
        return debtorCurrency;
    }

    @JsonProperty("debtorCurrency")
    public void setDebtorCurrency(String debtorCurrency) {
        this.debtorCurrency = debtorCurrency;
    }

    @JsonProperty("creditorAmount")
    public Double getCreditorAmount() {
        return creditorAmount;
    }

    @JsonProperty("creditorAmount")
    public void setCreditorAmount(Double creditorAmount) {
        this.creditorAmount = creditorAmount;
    }

    @JsonProperty("creditorCurrency")
    public String getCreditorCurrency() {
        return creditorCurrency;
    }

    @JsonProperty("creditorCurrency")
    public void setCreditorCurrency(String creditorCurrency) {
        this.creditorCurrency = creditorCurrency;
    }

    @JsonProperty("creditorCurrencyDate")
    public String getCreditorCurrencyDate() {
        return creditorCurrencyDate;
    }

    @JsonProperty("creditorCurrencyDate")
    public void setCreditorCurrencyDate(String creditorCurrencyDate) {
        this.creditorCurrencyDate = creditorCurrencyDate;
    }

    @JsonProperty("exchangeRate")
    public Double getExchangeRate() {
        return exchangeRate;
    }

    @JsonProperty("exchangeRate")
    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
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
