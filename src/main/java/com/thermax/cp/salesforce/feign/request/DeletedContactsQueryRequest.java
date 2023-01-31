package com.thermax.cp.salesforce.feign.request;

import com.thermax.cp.salesforce.dto.contact.DeletedContactListDTO;
import com.thermax.cp.salesforce.feign.config.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "DeletedContactsQueryRequest", url = "${feign.client.thermax.base-url}", configuration = FeignRequestConfiguration.class)
public interface DeletedContactsQueryRequest {
    @GetMapping("/data/v52.0/queryAll/?q={query}")
    ResponseEntity<DeletedContactListDTO> getDeletedSFDCContacts(@RequestParam("q") String query);
}
