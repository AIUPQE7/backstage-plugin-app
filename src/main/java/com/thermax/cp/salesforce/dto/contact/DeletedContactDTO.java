package com.thermax.cp.salesforce.dto.contact;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thermax.cp.salesforce.dto.account.AccountAttributeDTO;
import lombok.Data;

@Data
public class DeletedContactDTO {

     private AccountAttributeDTO attributes;

     private String id;

     private String accountId;

     private String email;

     private String tH_IsActive__c;

     private String tMAX_isActiveForCP__c;

     private String isDeleted;

     public AccountAttributeDTO getAttributes() {
      return attributes;
     }

     public void setAttributes(AccountAttributeDTO attributes) {
      this.attributes = attributes;
     }

     public String getId() {
      return id;
     }

     @JsonProperty("Id")
     public void setId(String id) {
      this.id = id;
     }

     public String getAccountId() {
      return accountId;
     }

     @JsonProperty("AccountId")
     public void setAccountId(String accountId) {
      this.accountId = accountId;
     }

     public String getEmail() {
      return email;
     }

     @JsonProperty("Email")
     public void setEmail(String email) {
      this.email = email;
     }

     public String gettH_IsActive__c() {
      return tH_IsActive__c;
     }

     @JsonProperty("TH_IsActive__c")
     public void settH_IsActive__c(String tH_IsActive__c) {
      this.tH_IsActive__c = tH_IsActive__c;
     }

     public String gettMAX_isActiveForCP__c() {
      return tMAX_isActiveForCP__c;
     }

     @JsonProperty("TMAX_isActiveForCP__c")
     public void settMAX_isActiveForCP__c(String tMAX_isActiveForCP__c) {
      this.tMAX_isActiveForCP__c = tMAX_isActiveForCP__c;
     }

     public String getIsDeleted() {
      return isDeleted;
     }

     @JsonProperty("IsDeleted")
     public void setIsDeleted(String isDeleted) {
      this.isDeleted = isDeleted;
     }


}
