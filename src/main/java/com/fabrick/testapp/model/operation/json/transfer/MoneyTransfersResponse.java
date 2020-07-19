package com.fabrick.testapp.model.operation.json.transfer;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "errors",
        "payload"
})
public class MoneyTransfersResponse {
    @JsonProperty("status")
    private String status;

    @JsonProperty("errors")
    private List<Error> errors;

    @JsonProperty("payload")
    private PayloadResponse payload = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6315109676905922712L;

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
    public PayloadResponse getPayload() {
        return payload;
    }

    @JsonProperty("payload")
    public void setPayload(PayloadResponse payload) {
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
