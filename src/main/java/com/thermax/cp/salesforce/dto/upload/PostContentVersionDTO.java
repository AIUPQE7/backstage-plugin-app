package com.thermax.cp.salesforce.dto.upload;

import com.thermax.cp.salesforce.entity.FileEntity;
import lombok.Data;
@Data
public class PostContentVersionDTO {

        private String method;
        private String url;
        private String referenceId;
        private FileEntity body;

}
