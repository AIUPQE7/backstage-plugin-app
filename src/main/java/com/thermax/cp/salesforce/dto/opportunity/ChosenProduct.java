package com.thermax.cp.salesforce.dto.opportunity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChosenProduct {
    private Attributes attributes;

    private String product_Code__c;

    private String description__c;


    private String additional_Information__c;


    private Integer quantity__c;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public String getProduct_Code__c() {
        return product_Code__c;
    }
    @JsonProperty("Product_Code__c")
    public void setProduct_Code__c(String product_Code__c) {
        this.product_Code__c = product_Code__c;
    }

    public String getDescription__c() {
        return description__c;
    }
    @JsonProperty("Description__c")
    public void setDescription__c(String description__c) {
        this.description__c = description__c;
    }

    public String getAdditional_Information__c() {
        return additional_Information__c;
    }
    @JsonProperty("Additional_Information__c")
    public void setAdditional_Information__c(String additional_Information__c) {
        this.additional_Information__c = additional_Information__c;
    }

    public Integer getQuantity__c() {
        return quantity__c;
    }
    @JsonProperty("Quantity__c")
    public void setQuantity__c(Integer quantity__c) {
        this.quantity__c = quantity__c;
    }




}
