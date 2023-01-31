package com.thermax.cp.salesforce.feign.request;

import com.thermax.cp.salesforce.dto.opportunity.OpportunityRequestDTO;
import com.thermax.cp.salesforce.dto.opportunity.OpportunityResponseDTO;
import com.thermax.cp.salesforce.feign.config.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "OpportunityCreationRequest", url = "${feign.client.thermax.base-url}", configuration = FeignRequestConfiguration.class)
public interface OpportunityCreationRequest {

    @PostMapping("/data/v52.0/composite/tree/Opportunity_Ext__c")
    ResponseEntity<OpportunityResponseDTO> postEnquirytoSFDC(String json);
}
