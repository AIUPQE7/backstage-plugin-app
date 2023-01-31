package com.thermax.cp.salesforce.feign.request;

import com.thermax.cp.salesforce.dto.upload.CompositeFileRequestDTO;
import com.thermax.cp.salesforce.dto.upload.CompositeFileResponseDTO;
import com.thermax.cp.salesforce.dto.upload.CompositeFileUploadDTO;
import com.thermax.cp.salesforce.feign.config.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CompositeUploadRequest", url = "${feign.client.thermax.base-url}", configuration = FeignRequestConfiguration.class)
public interface CompositeUploadRequest {
    @PostMapping("/data/v52.0/composite")
    ResponseEntity<Object> uploadFilestoSFDC(@RequestBody CompositeFileUploadDTO dto);
}
