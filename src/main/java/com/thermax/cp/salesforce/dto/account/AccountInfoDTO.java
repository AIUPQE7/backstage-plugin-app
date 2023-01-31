package com.thermax.cp.salesforce.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountInfoDTO {

    private AccountAttributeDTO attributes;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("TH_GST_Number__c")
    private String th_GST_Number__c;

    @JsonProperty("TH_CIN_Number__c")
    private String th_CIN_Number__c;

    @JsonProperty("Rating")
    private String rating;

    @JsonProperty("TH_Status__c")
    private String th_Status__c;

}
