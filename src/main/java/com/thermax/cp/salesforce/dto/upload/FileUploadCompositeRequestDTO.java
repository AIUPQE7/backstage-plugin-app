package com.thermax.cp.salesforce.dto.upload;

import lombok.Data;

@Data
public class FileUploadCompositeRequestDTO {
    private String pathOnClient;
    private String versionData;
    private String linkedEntityId;
}
