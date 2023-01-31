package com.thermax.cp.salesforce.dto.opportunity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.origin.PropertySourceOrigin;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
public class OpportunityRequestDTO {
    public List<OpportunityExtRecord> getRecords() {
        return records;
    }

    public void setRecords(List<OpportunityExtRecord> records) {
        this.records = records;
    }

    private List<OpportunityExtRecord> records;
}
class OpportunityExtRecord
{
    private Attributes attributes;
    private String tH_Type__c;
    private String domastic_International__c;
    private String last_Checked_On__c;
    private String tH_CP_Opportunity__c;
    private String currencyISOCode;
    private String OwnerId;

    public String getOwnerId() {
        return OwnerId;
    }
    @JsonProperty("OwnerId")
    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }
    private String tMAX_Contact__c;
    private Opportunities opportunities__r;

    public String getCurrencyISOCode() {
        return currencyISOCode;
    }
    @JsonProperty("CurrencyISOCode")
    public void setCurrencyISOCode(String currencyISOCode) {
        currencyISOCode = currencyISOCode;
    }



    public String getTMAX_Contact__c() {
        return tMAX_Contact__c;
    }
    @JsonProperty("TMAX_Contact__c")
    public void setTMAX_Contact__c(String TMAX_Contact__c) {
        this.tMAX_Contact__c = TMAX_Contact__c;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String gettH_Type__c() {
        return tH_Type__c;
    }
    @JsonProperty("TH_Type__c")
    public void settH_Type__c(String tH_Type__c) {
        this.tH_Type__c = tH_Type__c;
    }

    public String getDomastic_International__c() {
        return domastic_International__c;
    }
    @JsonProperty("Domastic_International__c")
    public void setDomastic_International__c(String domastic_International__c) {
        this.domastic_International__c = domastic_International__c;
    }

    public String getLast_Checked_On__c() {
        return last_Checked_On__c;
    }
    @JsonProperty("Last_Checked_On__c")
    public void setLast_Checked_On__c(String last_Checked_On__c) {
        this.last_Checked_On__c = last_Checked_On__c;
    }

    public String gettH_CP_Opportunity__c() {
        return tH_CP_Opportunity__c;
    }
    @JsonProperty("TH_CP_Opportunity__c")
    public void settH_CP_Opportunity__c(String tH_CP_Opportunity__c) {
        this.tH_CP_Opportunity__c = tH_CP_Opportunity__c;
    }

    public Opportunities getOpportunityRecord() {
        return opportunities__r;
    }
    @JsonProperty("Opportunities__r")
    public void setOpportunityRecord(Opportunities opportunityRecord) {
        this.opportunities__r = opportunityRecord;
    }


}
class Attributes
{
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    private String referenceId;
}
class OpportunityAssets
{
    private List<OpportunityAsset> records;

    public List<OpportunityAsset> getRecords() {
        return records;
    }

    public void setRecords(List<OpportunityAsset> records) {
        this.records = records;
    }
}
class OpportunityAsset
{
    private Attributes attributes;
    private String account__c;
    private String ownerId;
    private String currencyISOCode;
    private String asset__c;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getAccount__c() {
        return account__c;
    }
    @JsonProperty("Account__c")
    public void setAccount__c(String account__c) {
        this.account__c = account__c;
    }

    public String getOwnerId() {
        return ownerId;
    }
    @JsonProperty("OwnerId")
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCurrencyISOCode() {
        return currencyISOCode;
    }
    @JsonProperty("CurrencyISOCode")
    public void setCurrencyISOCode(String currencyISOCode) {
        this.currencyISOCode = currencyISOCode;
    }

    public String getAsset__c() {
        return asset__c;
    }
    @JsonProperty("Asset__c")
    public void setAsset__c(String asset__c) {
        this.asset__c = asset__c;
    }
}
class Opportunities
{
    public List<OpportunityRecord> getRecords() {
        return records;
    }

    public void setRecords(List<OpportunityRecord> records) {
        this.records = records;
    }

    private List<OpportunityRecord> records;
}
class OpportunityRecord
{
    private Attributes attributes;

    private String name;

    private String pricebook2Id;

    private String tH_Division__c;

    private String accountId;

    private String closeDate;

    private String tH_Opportunity_Type__c;

    private double amount ;

    private String description;

    private String reason_for_Spares_Sale__c;

    private String stageName;
    private String tHSC_Opportunity_Asset_Id__c;
    private String tH_Region__c;
    private String tHCH_Zone__c;
    private String tHCH_Territory__c;
    private String currencyISOCode;
    private String recordTypeId;
    private String tHSC_Executor__c;
    //private OpportunityLineItems opportunityLineItems;
    private OpportunityAssets opportuntiyAsset__r;
    //private Proposal proposals__r;
    private OpportunityContactRoles opportunityContactRoles;
    private String leadSource;
    private String tH_Domestic_International__c ;
    public ChosenProducts getChosen_Products__r() {
        return chosen_Products__r;
    }

    @JsonProperty("Chosen_Products__r")
    public void setChosen_Products__r(ChosenProducts chosen_Products__r) {
        this.chosen_Products__r = chosen_Products__r;
    }

    private ChosenProducts chosen_Products__r;
    public String gettH_Domestic_International__c() {
        return tH_Domestic_International__c;
    }
    @JsonProperty("TH_Domestic_International__c")
    public void settH_Domestic_International__c(String tH_Domestic_International__c) {
        this.tH_Domestic_International__c = tH_Domestic_International__c;
    }
    private String OwnerId;

    public String getOwnerId() {
        return OwnerId;
    }
    @JsonProperty("OwnerId")
    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public String gettHSC_Executor__c() {
        return tHSC_Executor__c;
    }
    @JsonProperty("THSC_Executor__c")
    public void settHSC_Executor__c(String tHSC_Executor__c) {
        this.tHSC_Executor__c = tHSC_Executor__c;
    }

    public String getLeadSource() {
        return leadSource;
    }
    @JsonProperty("LeadSource")
    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }
    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getPricebook2Id() {
        return pricebook2Id;
    }

    public void setPricebook2Id(String pricebook2Id) {
        this.pricebook2Id = pricebook2Id;
    }

    public String gettH_Division__c() {
        return tH_Division__c;
    }
    @JsonProperty("TH_Division__c")
    public void settH_Division__c(String tH_Division__c) {
        this.tH_Division__c = tH_Division__c;
    }

    public String getAccountId() {
        return accountId;
    }
    @JsonProperty("AccountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCloseDate() {
        return closeDate;
    }
    @JsonProperty("CloseDate")
    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String gettH_Opportunity_Type__c() {
        return tH_Opportunity_Type__c;
    }
    @JsonProperty("TH_Opportunity_Type__c")
    public void settH_Opportunity_Type__c(String tH_Opportunity_Type__c) {
        this.tH_Opportunity_Type__c = tH_Opportunity_Type__c;
    }

    public double getAmount() {
        return amount;
    }
    @JsonProperty("Amount")
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }
    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getReason_for_Spares_Sale__c() {
        return reason_for_Spares_Sale__c;
    }
    @JsonProperty("Reason_for_Spares_Sale__c")
    public void setReason_for_Spares_Sale__c(String reason_for_Spares_Sale__c) {
        this.reason_for_Spares_Sale__c = reason_for_Spares_Sale__c;
    }

    public String getStageName() {
        return stageName;
    }
    @JsonProperty("StageName")
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String gettHSC_Opportunity_Asset_Id__c() {
        return tHSC_Opportunity_Asset_Id__c;
    }
    @JsonProperty("THSC_Opportunity_Asset_Id__c")
    public void settHSC_Opportunity_Asset_Id__c(String tHSC_Opportunity_Asset_Id__c) {
        this.tHSC_Opportunity_Asset_Id__c = tHSC_Opportunity_Asset_Id__c;
    }

    public String gettH_Region__c() {
        return tH_Region__c;
    }
    @JsonProperty("TH_Region__c")
    public void settH_Region__c(String tH_Region__c) {
        this.tH_Region__c = tH_Region__c;
    }

    public String gettHCH_Zone__c() {
        return tHCH_Zone__c;
    }
    @JsonProperty("THCH_Zone__c")
    public void settHCH_Zone__c(String tHCH_Zone__c) {
        this.tHCH_Zone__c = tHCH_Zone__c;
    }

    public String gettHCH_Territory__c() {
        return tHCH_Territory__c;
    }
    @JsonProperty("THCH_Territory__c")
    public void settHCH_Territory__c(String tHCH_Territory__c) {
        this.tHCH_Territory__c = tHCH_Territory__c;
    }

    public String getCurrencyISOCode() {
        return currencyISOCode;
    }
    @JsonProperty("CurrencyISOCode")
    public void setCurrencyISOCode(String currencyISOCode) {
        this.currencyISOCode = currencyISOCode;
    }

    public String getRecordTypeId() {
        return recordTypeId;
    }
    @JsonProperty("RecordTypeId")
    public void setRecordTypeId(String recordTypeId) {
        this.recordTypeId = recordTypeId;
    }

    /*public OpportunityLineItems getOpportunityLineItems() {
        return opportunityLineItems;
    }
    @JsonProperty("OpportunityLineItems")
    public void setOpportunityLineItems(OpportunityLineItems opportunityLineItems) {
        this.opportunityLineItems = opportunityLineItems;
    }*/


    public OpportunityAssets getOpportunityAssets() {
        return opportuntiyAsset__r;
    }
    @JsonProperty("OpportuntiyAsset__r")
    public void setOpportunityAssets(OpportunityAssets opportunityAssets) {
        this.opportuntiyAsset__r = opportunityAssets;
    }
    /*public Proposal getProposals__r() {
        return proposals__r;
    }
    @JsonProperty("Proposals__r")
    public void setProposals__r(Proposal proposals__r) {
        this.proposals__r = proposals__r;
    }*/

    public OpportunityContactRoles getOpportunityContactRoles() {
        return opportunityContactRoles;
    }
    @JsonProperty("OpportunityContactRoles")
    public void setOpportunityContactRoles(OpportunityContactRoles opportunityContactRoles) {
        this.opportunityContactRoles = opportunityContactRoles;
    }

}

class Proposal
{
    private List<OpportunityProposal> records;

    public List<OpportunityProposal> getRecords() {
        return records;
    }

    public void setRecords(List<OpportunityProposal> records) {
        this.records = records;
    }
}
class OpportunityProposal
{
    private Attributes attributes;
    private String account__c;
    private String Additional_Input_By_Requester__c;
    private String asset__c;
    private String committed_Date__c;
    private String department__c;
    private Boolean isLatestVersion__c;
    private String proposal_Number__c;
    private String proposer_User__c;
    private String reason__c;
    private String currencyISOCode;
    private String status__c;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getAccount__c() {
        return account__c;
    }
    @JsonProperty("Account__c")
    public void setAccount__c(String account__c) {
        this.account__c = account__c;
    }

    public String getAdditional_Input_By_Requester__c() {
        return Additional_Input_By_Requester__c;
    }
    @JsonProperty("Additional_Input_By_Requester__c")
    public void setAdditional_Input_By_Requester__c(String additional_Input_By_Requester__c) {
        Additional_Input_By_Requester__c = additional_Input_By_Requester__c;
    }

    public String getAsset__c() {
        return asset__c;
    }
    @JsonProperty("Asset__c")
    public void setAsset__c(String asset__c) {
        this.asset__c = asset__c;
    }

    public String getCommitted_Date__c() {
        return committed_Date__c;
    }
    @JsonProperty("Committed_Date__c")
    public void setCommitted_Date__c(String committed_Date__c) {
        this.committed_Date__c = committed_Date__c;
    }

    public String getDepartment__c() {
        return department__c;
    }
    @JsonProperty("Department__c")
    public void setDepartment__c(String department__c) {
        this.department__c = department__c;
    }

    public Boolean getLatestVersion__c() {
        return isLatestVersion__c;
    }
    @JsonProperty("IsLatestVersion__c")
    public void setLatestVersion__c(Boolean latestVersion__c) {
        isLatestVersion__c = latestVersion__c;
    }

    public String getProposal_Number__c() {
        return proposal_Number__c;
    }
    @JsonProperty("Proposal_Number__c")
    public void setProposal_Number__c(String proposal_Number__c) {
        this.proposal_Number__c = proposal_Number__c;
    }

    public String getProposer_User__c() {
        return proposer_User__c;
    }
    @JsonProperty("Proposer_User__c")
    public void setProposer_User__c(String proposer_User__c) {
        this.proposer_User__c = proposer_User__c;
    }

    public String getReason__c() {
        return reason__c;
    }
    @JsonProperty("Reason__c")
    public void setReason__c(String reason__c) {
        this.reason__c = reason__c;
    }

    public String getCurrencyISOCode() {
        return currencyISOCode;
    }
    @JsonProperty("CurrencyISOCode")
    public void setCurrencyISOCode(String currencyISOCode) {
        this.currencyISOCode = currencyISOCode;
    }

    public String getStatus__c() {
        return status__c;
    }
    @JsonProperty("Status__c")
    public void setStatus__c(String status__c) {
        this.status__c = status__c;
    }
}
class OpportunityContactRoles
{
    private List<OpportunityContactRole> records;

    public List<OpportunityContactRole> getRecords() {
        return records;
    }

    public void setRecords(List<OpportunityContactRole> records) {
        this.records = records;
    }
}
class OpportunityContactRole
{
    private Attributes attributes;
    private String contactId;
    private String currencyISOCode;
    private String role;
    private Boolean isPrimary;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getContactId() {
        return contactId;
    }
    @JsonProperty("ContactId")
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getCurrencyISOCode() {
        return currencyISOCode;
    }
    @JsonProperty("CurrencyISOCode")
    public void setCurrencyISOCode(String currencyISOCode) {
        this.currencyISOCode = currencyISOCode;
    }

    public String getRole() {
        return role;
    }
    @JsonProperty("Role")
    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }
    @JsonProperty("isPrimary")
    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }


}
class OpportunityLineItems {
    private List<OpportunityLineItem> records;

    public List<OpportunityLineItem> getRecords() {
        return records;
    }

    public void setRecords(List<OpportunityLineItem> records) {
        this.records = records;
    }
}
class OpportunityLineItem
{
    private Attributes attributes;
    private String tH_Asset__c;
    private String product2Id;
    private double unitPrice;
    private double quantity;
    private String currencyISOCode;
    private double discount__c;
    private String pricebookEntryId;
    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }



    public String gettH_Asset__c() {
        return tH_Asset__c;
    }
    @JsonProperty("TH_Asset__c")
    public void settH_Asset__c(String tH_Asset__c) {
        this.tH_Asset__c = tH_Asset__c;
    }

    public String getProduct2Id() {
        return product2Id;
    }
    @JsonProperty("Product2Id")
    public void setProduct2Id(String product2Id) {
        this.product2Id = product2Id;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    @JsonProperty("UnitPrice")
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }
    @JsonProperty("Quantity")
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getCurrencyISOCode() {
        return currencyISOCode;
    }
    @JsonProperty("CurrencyISOCode")
    public void setCurrencyISOCode(String currencyISOCode) {
        this.currencyISOCode = currencyISOCode;
    }

    public double getDiscount__c() {
        return discount__c;
    }
    @JsonProperty("Discount__c")
    public void setDiscount__c(double discount__c) {
        this.discount__c = discount__c;
    }

    public String getPricebookEntryId() {
        return pricebookEntryId;
    }
    @JsonProperty("PricebookEntryId")
    public void setPricebookEntryId(String pricebookEntryId) {
        this.pricebookEntryId = pricebookEntryId;
    }



}


