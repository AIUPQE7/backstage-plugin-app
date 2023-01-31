package com.thermax.cp.salesforce.dto.upload;

import com.thermax.cp.salesforce.entity.ContentLinkEntity;
import lombok.Data;

@Data
public class PostContentDocumentLinkDTO {
    private String method;
    private String url;
    private String referenceId;
    private ContentLinkEntity body;
}
