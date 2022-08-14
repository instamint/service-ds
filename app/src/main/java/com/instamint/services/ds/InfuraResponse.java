package com.instamint.services.ds;

import jakarta.json.bind.annotation.JsonbProperty;
import lombok.Data;

@Data
public class InfuraResponse {
    @JsonbProperty("Name") private String name;
    @JsonbProperty("Hash") private String hash;
    @JsonbProperty("Size") private long size;
}
