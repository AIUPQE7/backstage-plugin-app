package com.thermax.cp.salesforce.feign.request;

import com.thermax.cp.salesforce.dto.contact.ContactCreationResponseDTO;
import com.thermax.cp.salesforce.dto.contact.ContactRequestDTO;
import com.thermax.cp.salesforce.feign.config.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ContactCreationRequest", url = "${feign.client.thermax.base-url}", configuration = FeignRequestConfiguration.class)
public interface ContactCreationRequest {

    @PostMapping("/data/v52.0/sobjects/Contact")
    ResponseEntity<ContactCreationResponseDTO> createContactIntoSFDC(@RequestBody ContactRequestDTO contactRequestDTO);
}
