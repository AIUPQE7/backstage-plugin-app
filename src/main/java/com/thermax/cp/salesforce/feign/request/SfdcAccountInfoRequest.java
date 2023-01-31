package com.thermax.cp.salesforce.feign.request;

import com.thermax.cp.salesforce.dto.account.AccountListDTO;
import com.thermax.cp.salesforce.feign.config.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "SfdcAccountInfoFeignClient", url = "${feign.client.thermax.base-url}", configuration = FeignRequestConfiguration.class)
public interface SfdcAccountInfoRequest {

    @GetMapping("/data/v52.0/query/?q={query}")
    ResponseEntity<AccountListDTO> getAccountInfo(@RequestParam("q") String query);
}
