package com.fabrick.testapp.model.operation.json.balanceandmovments;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "list"
})
public class PayloadTransaction {

    @JsonProperty("list")
    private List<ListTransaction> list = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("list")
    public List<ListTransaction> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(List<ListTransaction> list) {
        this.list = list;
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
