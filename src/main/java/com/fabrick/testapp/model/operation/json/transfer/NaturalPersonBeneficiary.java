package com.fabrick.testapp.model.operation.json.transfer;

import com.fasterxml.jackson.annotation.*;
import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fiscalCode1",
    "fiscalCode2",
    "fiscalCode3",
    "fiscalCode4",
    "fiscalCode5"
})
public class NaturalPersonBeneficiary {

    @JsonProperty("fiscalCode1")
    private String fiscalCode1;
    @JsonProperty("fiscalCode2")
    private String fiscalCode2;
    @JsonProperty("fiscalCode3")
    private String fiscalCode3;
    @JsonProperty("fiscalCode4")
    private String fiscalCode4;
    @JsonProperty("fiscalCode5")
    private String fiscalCode5;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fiscalCode1")
    public String getFiscalCode1() {
        return fiscalCode1;
    }

    @JsonProperty("fiscalCode1")
    public void setFiscalCode1(String fiscalCode1) {
        this.fiscalCode1 = fiscalCode1;
    }

    @JsonProperty("fiscalCode2")
    public String getFiscalCode2() {
        return fiscalCode2;
    }

    @JsonProperty("fiscalCode2")
    public void setFiscalCode2(String fiscalCode2) {
        this.fiscalCode2 = fiscalCode2;
    }

    @JsonProperty("fiscalCode3")
    public String getFiscalCode3() {
        return fiscalCode3;
    }

    @JsonProperty("fiscalCode3")
    public void setFiscalCode3(String fiscalCode3) {
        this.fiscalCode3 = fiscalCode3;
    }

    @JsonProperty("fiscalCode4")
    public String getFiscalCode4() {
        return fiscalCode4;
    }

    @JsonProperty("fiscalCode4")
    public void setFiscalCode4(String fiscalCode4) {
        this.fiscalCode4 = fiscalCode4;
    }

    @JsonProperty("fiscalCode5")
    public String getFiscalCode5() {
        return fiscalCode5;
    }

    @JsonProperty("fiscalCode5")
    public void setFiscalCode5(String fiscalCode5) {
        this.fiscalCode5 = fiscalCode5;
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
