package com.thermax.cp.salesforce.feign.request;

import com.thermax.cp.salesforce.dto.account.AccountRequestDTO;
import com.thermax.cp.salesforce.feign.config.FeignRequestConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SfdcUpdateAccountRequestFeignClient", url = "${feign.client.thermax.base-url}", configuration = FeignRequestConfiguration.class)
public interface SfdcUpdateAccountRequest {
    @PatchMapping(value = "/data/v52.0/sobjects/Account/{accountId}")
    ResponseEntity updateAccount(@RequestBody AccountRequestDTO requestDTO, @PathVariable(value = "accountId") String accountId);
}
