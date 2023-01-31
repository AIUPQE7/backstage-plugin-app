package com.thermax.cp.salesforce.feign.request;

import com.thermax.cp.salesforce.dto.contact.ContactRequestDTO;
import com.thermax.cp.salesforce.feign.config.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ContactUpdateRequest", url = "${feign.client.thermax.base-url}", configuration = FeignRequestConfiguration.class)
public interface ContactUpdateRequest {

    @PatchMapping("/data/v52.0/sobjects/Contact/{sfdcContactId}")
    ResponseEntity updateContactDetailsIntoSFDC(@RequestBody ContactRequestDTO contactRequestDTO, @PathVariable String sfdcContactId);
}
