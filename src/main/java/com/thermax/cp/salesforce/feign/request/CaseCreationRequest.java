package com.thermax.cp.salesforce.feign.request;

import com.thermax.cp.salesforce.dto.complaint.CaseRequestDTO;
import com.thermax.cp.salesforce.dto.complaint.CaseResponseDTO;
import com.thermax.cp.salesforce.feign.config.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CaseCreationRequest", url = "${feign.client.thermax.base-url}", configuration = FeignRequestConfiguration.class)
public interface CaseCreationRequest {
    @PostMapping("/data/v52.0/sobjects/Case")
    ResponseEntity<CaseResponseDTO> postCasetoSFDC(@RequestBody CaseRequestDTO dto);
}
