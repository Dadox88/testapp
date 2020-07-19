package com.fabrick.testapp.model.operation.json.balanceandmovments;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "enumeration",
        "value"
})
public class TypeTransaction {

    @JsonProperty("enumeration")
    private String enumeration;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("enumeration")
    public String getEnumeration() {
        return enumeration;
    }

    @JsonProperty("enumeration")
    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
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
