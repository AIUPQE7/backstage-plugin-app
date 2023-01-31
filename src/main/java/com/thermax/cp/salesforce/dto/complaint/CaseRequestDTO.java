package com.thermax.cp.salesforce.dto.complaint;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CaseRequestDTO {

    private String subject;
    private String description;
    private String tHS_Source__c;
    private String contactId;
    private String origin;
    private String tH_Region__c;
    private String tHS_Type__c;
    private String accountId;
    private String assetId;
    private String tHS_Division__c;
    private String tHS_Sub_Division__c;
    private String tHS_Case_Source__c;
    private String tHC_Country__c;
    private String tHS_Asset_Status__c;
    private String ownerId;
    private String pO_Number__c;

    public String getSubject() {
        return subject;
    }
    @JsonProperty("Subject")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }
    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String gettHS_Source__c() {
        return tHS_Source__c;
    }
    @JsonProperty("THS_Source__c")
    public void settHS_Source__c(String tHS_Source__c) {
        this.tHS_Source__c = tHS_Source__c;
    }

    public String getContactId() {
        return contactId;
    }
    @JsonProperty("ContactId")
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getOrigin() {
        return origin;
    }
    @JsonProperty("Origin")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String gettH_Region__c() {
        return tH_Region__c;
    }
    @JsonProperty("TH_Region__c")
    public void settH_Region__c(String tH_Region__c) {
        this.tH_Region__c = tH_Region__c;
    }

    public String gettHS_Type__c() {
        return tHS_Type__c;
    }
    @JsonProperty("THS_Type__c")
    public void settHS_Type__c(String tHS_Type__c) {
        this.tHS_Type__c = tHS_Type__c;
    }

    public String getAccountId() {
        return accountId;
    }
    @JsonProperty("AccountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAssetId() {
        return assetId;
    }
    @JsonProperty("AssetId")
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String gettHS_Division__c() {
        return tHS_Division__c;
    }
    @JsonProperty("THS_Division__c")
    public void settHS_Division__c(String tHS_Division__c) {
        this.tHS_Division__c = tHS_Division__c;
    }

    public String gettHS_Sub_Division__c() {
        return tHS_Sub_Division__c;
    }
    @JsonProperty("THS_Sub_Division__c")
    public void settHS_Sub_Division__c(String tHS_Sub_Division__c) {
        this.tHS_Sub_Division__c = tHS_Sub_Division__c;
    }

    public String gettHS_Case_Source__c() {
        return tHS_Case_Source__c;
    }
    @JsonProperty("THS_Case_Source__c")
    public void settHS_Case_Source__c(String tHS_Case_Source__c) {
        this.tHS_Case_Source__c = tHS_Case_Source__c;
    }

    public String gettHC_Country__c() {
        return tHC_Country__c;
    }
    @JsonProperty("THC_Country__c")
    public void settHC_Country__c(String tHC_Country__c) {
        this.tHC_Country__c = tHC_Country__c;
    }

    public String gettHS_Asset_Status__c() {
        return tHS_Asset_Status__c;
    }
    @JsonProperty("THS_Asset_Status__c")
    public void settHS_Asset_Status__c(String tHS_Asset_Status__c) {
        this.tHS_Asset_Status__c = tHS_Asset_Status__c;
    }

    public String getOwnerId() {
        return ownerId;
    }
    @JsonProperty("OwnerId")
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getpO_Number__c() {
        return pO_Number__c;
    }
    @JsonProperty("PO_Number__c")
    public void setpO_Number__c(String pO_Number__c) {
        this.pO_Number__c = pO_Number__c;
    }
}
