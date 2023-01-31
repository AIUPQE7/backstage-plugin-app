package com.thermax.cp.salesforce.dto.upload;

import lombok.Data;

import java.util.List;
@Data
public class CompositeFileUploadDTO {

    private Boolean allOrNone;
    private List<Object> compositeRequest;
}

