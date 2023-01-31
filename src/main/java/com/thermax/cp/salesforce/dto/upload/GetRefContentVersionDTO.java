package com.thermax.cp.salesforce.dto.upload;

import lombok.Data;

@Data
public class GetRefContentVersionDTO {
    private String method;
    private String url;
    private String referenceId;
}
