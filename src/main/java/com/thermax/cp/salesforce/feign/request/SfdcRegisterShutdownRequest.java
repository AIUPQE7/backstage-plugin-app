package com.thermax.cp.salesforce.feign.request;


import com.thermax.cp.salesforce.dto.shutdown.ShutdownRequestDTO;
import com.thermax.cp.salesforce.feign.config.FeignRequestConfiguration;
import com.thermax.cp.salesforce.dto.shutdown.ShutdownResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "SfdcRegisterShutdownClient", url = "${feign.client.thermax.base-url}", configuration = FeignRequestConfiguration.class)
public interface SfdcRegisterShutdownRequest {

    @PostMapping(value = "/data/v52.0/sobjects/TH_Interaction__c")
    ResponseEntity<ShutdownResponseDTO> registerShutdown(@RequestBody ShutdownRequestDTO dto);


}
