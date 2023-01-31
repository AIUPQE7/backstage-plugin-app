package com.thermax.cp.salesforce.query;

public interface QueryConstants {

    String ACCOUNT_INFO_QUERY = "SELECT+name,ID,TH_GST_Number__c,TH_CIN_Number__c,Rating,TH_Status__c+from+Account+limit+10";

    String ASSET_DETAIL_QUERY = "SELECT+Id,Name,TH_Asset__c,TH_Spare__c,TH_Asset_Name__c,TH_Change_Type__c,TH_Description_for__c+from+TH_Asset_History__c+ where+TH_Asset__c+=";

    String ASSET_TAGGED_TO_ACCOUNT_QUERY = "SELECT+Id,Name,TH_IBG_Division__c,THCH_Region__c ,Asset_Make__c,AccountId,THCH_Asset_Status__c,THCH_Sales_Order_Number__c+from Asset+where+accountId+=";

    String FILE_VIA_CONTENT_VERSION_QUERY = "SELECT+ContentDocumentId+from+ContentVersion+ where + Id+ =";

    String ASSETS_FOR_ACCOUNT_QUERY = "SELECT+Id,Name,TH_IBG_Division__c,THCH_Region__c ,Asset_Make__c,AccountId,THCH_Asset_Status__c,THCH_Sales_Order_Number__c+from Asset+where+accountId+=";

    String FETCH_CONTENT_DOCUMENT_QUERY = "SELECT+ContentDocumentId+from+ContentVersion+ where + Id+ = +";
}