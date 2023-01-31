package com.thermax.cp.salesforce.dto.contact;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactRequestDTO {

    private String salutation;
    private String lastName;
    private String accountId;
    private String title;
    private String email;
    private String mobilePhone;
    private String firstName;
    private String middleName;
    private String department;
    private String phone;
    private String tH_IBG_International_Calling_Code__c;
    private String mailingStreet;
    private String mailingCity;
    private String mailingState;
    private String mailingPostalCode;
    private String mailingCountry;
    private boolean isActiveForCP;

    public boolean isActiveForCP() {
        return isActiveForCP;
    }

    @JsonProperty("TMAX_isActiveForCP__c")
    public void setActiveForCP(boolean activeForCP) {
        isActiveForCP = activeForCP;
    }

    public String getSalutation() {
        return salutation;
    }

    @JsonProperty("Salutation")
    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("AccountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    @JsonProperty("MobilePhone")
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("MiddleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDepartment() {
        return department;
    }

    @JsonProperty("Department")
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    @JsonProperty("Phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTH_IBG_International_Calling_Code__c() {
        return tH_IBG_International_Calling_Code__c;
    }

    @JsonProperty("TH_IBG_International_Calling_Code__c")
    public void setTH_IBG_International_Calling_Code__c(String tH_IBG_International_Calling_Code__c) {
        this.tH_IBG_International_Calling_Code__c = tH_IBG_International_Calling_Code__c;
    }

    public String getMailingStreet() {
        return mailingStreet;
    }

    @JsonProperty("MailingStreet")
    public void setMailingStreet(String mailingStreet) {
        this.mailingStreet = mailingStreet;
    }

    public String getMailingCity() {
        return mailingCity;
    }

    @JsonProperty("MailingCity")
    public void setMailingCity(String mailingCity) {
        this.mailingCity = mailingCity;
    }

    public String getMailingState() {
        return mailingState;
    }

    @JsonProperty("MailingState")
    public void setMailingState(String mailingState) {
        this.mailingState = mailingState;
    }

    public String getMailingPostalCode() {
        return mailingPostalCode;
    }

    @JsonProperty("MailingPostalCode")
    public void setMailingPostalCode(String mailingPostalCode) {
        this.mailingPostalCode = mailingPostalCode;
    }

    public String getMailingCountry() {
        return mailingCountry;
    }

    @JsonProperty("MailingCountry")
    public void setMailingCountry(String mailingCountry) {
        this.mailingCountry = mailingCountry;
    }
}
