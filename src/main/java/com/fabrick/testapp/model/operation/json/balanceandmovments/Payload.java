package com.fabrick.testapp.model.operation.json.balanceandmovments;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "balance",
        "availableBalance",
        "currency"
})
public class Payload implements Serializable {

    private static final long serialVersionUID = -1295402984226741965L;

    @JsonProperty("date")
    private String date;
    @JsonProperty("balance")
    private Double balance;
    @JsonProperty("availableBalance")
    private Double availableBalance;
    @JsonProperty("currency")
    private String currency;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("balance")
    public Double getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @JsonProperty("availableBalance")
    public Double getAvailableBalance() {
        return availableBalance;
    }

    @JsonProperty("availableBalance")
    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
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
