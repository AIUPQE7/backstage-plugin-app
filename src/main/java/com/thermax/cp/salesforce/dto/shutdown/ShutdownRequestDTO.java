package com.thermax.cp.salesforce.dto.shutdown;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShutdownRequestDTO {

    private String tH_Account_Name__c;

    public String gettH_Account_Name__c() {
        return tH_Account_Name__c;
    }

    @JsonProperty("TH_Account_Name__c")
    public void settH_Account_Name__c(String tH_Account_Name__c) {
        this.tH_Account_Name__c = tH_Account_Name__c;
    }

    public String gettH_Status__c() {
        return tH_Status__c;
    }

    @JsonProperty("TH_Status__c")
    public void settH_Status__c(String tH_Status__c) {
        this.tH_Status__c = tH_Status__c;
    }

    public String gettH_Type__c() {
        return tH_Type__c;
    }

    @JsonProperty("TH_Type__c")
    public void settH_Type__c(String tH_Type__c) {
        this.tH_Type__c = tH_Type__c;
    }

    public String gettH_Asset__c() {
        return tH_Asset__c;
    }

    @JsonProperty("TH_Asset__c")
    public void settH_Asset__c(String tH_Asset__c) {
        this.tH_Asset__c = tH_Asset__c;
    }

    public String gettH_Planned_Shutdown_date__c() {
        return tH_Planned_Shutdown_date__c;
    }

    @JsonProperty("TH_Planned_Shutdown_date__c")
    public void settH_Planned_Shutdown_date__c(String tH_Planned_Shutdown_date__c) {
        this.tH_Planned_Shutdown_date__c = tH_Planned_Shutdown_date__c;
    }

    public String gettH_Additional_Information__c() {
        return tH_Additional_Information__c;
    }

    @JsonProperty("TH_Additional_Information__c")
    public void settH_Additional_Information__c(String tH_Additional_Information__c) {
        this.tH_Additional_Information__c = tH_Additional_Information__c;
    }

    public String getOwnerId() {
        return ownerId;
    }

    @JsonProperty("OwnerId")
    public void setOwnerId(String OwnerId) {
        this.ownerId = OwnerId;
    }

    private String tH_Status__c;
    private String tH_Type__c;
    private String tH_Asset__c;
    private String tH_Planned_Shutdown_date__c;//2021-06-03
    private String tH_Additional_Information__c;
    private String ownerId;

}

class RecordType {
    private String name;

    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }
}
