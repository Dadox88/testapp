package com.fabrick.testapp.model.operation.json.balanceandmovments;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "errors",
        "payload"
})
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 2719144016354107381L;

    @JsonProperty("status")
    private String status;

    @JsonProperty("errors")
    private List<Error> errors;

    @JsonProperty("payload")
    private PayloadTransaction payload = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("errors")
    public List<Error> getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    @JsonProperty("payload")
    public PayloadTransaction getPayload() {
        return payload;
    }

    @JsonProperty("payload")
    public void setPayload(PayloadTransaction payload) {
        this.payload = payload;
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
