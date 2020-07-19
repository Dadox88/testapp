package com.fabrick.testapp.model.operation.json.transfer;

import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "creditor",
        "executionDate",
        "uri",
        "description",
        "amount",
        "currency",
        "isUrgent",
        "isInstant",
        "feeType",
        "feeAccountId",
        "taxRelief"
})
public class MoneyTransfersRequest {

    @JsonProperty("creditor")
    private Creditor creditor;
    @JsonProperty("executionDate")
    private String executionDate;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("description")
    private String description;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("isUrgent")
    private Boolean isUrgent;
    @JsonProperty("isInstant")
    private Boolean isInstant;
    @JsonProperty("feeType")
    private String feeType;
    @JsonProperty("feeAccountId")
    private String feeAccountId;
    @JsonProperty("taxRelief")
    private TaxRelief taxRelief;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("creditor")
    public Creditor getCreditor() {
        return creditor;
    }

    @JsonProperty("creditor")
    public void setCreditor(Creditor creditor) {
        this.creditor = creditor;
    }

    @JsonProperty("executionDate")
    public String getExecutionDate() {
        return executionDate;
    }

    @JsonProperty("executionDate")
    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("amount")
    public Double getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Double amount) {
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

    @JsonProperty("isUrgent")
    public Boolean getIsUrgent() {
        return isUrgent;
    }

    @JsonProperty("isUrgent")
    public void setIsUrgent(Boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    @JsonProperty("isInstant")
    public Boolean getIsInstant() {
        return isInstant;
    }

    @JsonProperty("isInstant")
    public void setIsInstant(Boolean isInstant) {
        this.isInstant = isInstant;
    }

    @JsonProperty("feeType")
    public String getFeeType() {
        return feeType;
    }

    @JsonProperty("feeType")
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    @JsonProperty("feeAccountId")
    public String getFeeAccountId() {
        return feeAccountId;
    }

    @JsonProperty("feeAccountId")
    public void setFeeAccountId(String feeAccountId) {
        this.feeAccountId = feeAccountId;
    }

    @JsonProperty("taxRelief")
    public TaxRelief getTaxRelief() {
        return taxRelief;
    }

    @JsonProperty("taxRelief")
    public void setTaxRelief(TaxRelief taxRelief) {
        this.taxRelief = taxRelief;
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
