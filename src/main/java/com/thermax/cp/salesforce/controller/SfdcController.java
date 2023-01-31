package com.thermax.cp.salesforce.controller;

import com.google.gson.Gson;
import com.thermax.cp.salesforce.config.SfdcClientConfiguration;
import com.thermax.cp.salesforce.config.SfdcOAuthConnectorRequest;
import com.thermax.cp.salesforce.dto.OAuthResponseDTO;
import com.thermax.cp.salesforce.dto.account.AccountListDTO;
import com.thermax.cp.salesforce.dto.account.AccountRequestDTO;
import com.thermax.cp.salesforce.dto.asset.AssetRecordListDTO;
import com.thermax.cp.salesforce.dto.asset.history.AssetHistoryRecordListDTO;
import com.thermax.cp.salesforce.dto.complaint.CaseRequestDTO;
import com.thermax.cp.salesforce.dto.complaint.CaseResponseDTO;
import com.thermax.cp.salesforce.dto.contact.ContactCreationResponseDTO;
import com.thermax.cp.salesforce.dto.contact.ContactRequestDTO;
import com.thermax.cp.salesforce.dto.contact.DeletedContactListDTO;
import com.thermax.cp.salesforce.dto.opportunity.OpportunityRequestDTO;
import com.thermax.cp.salesforce.dto.opportunity.OpportunityResponseDTO;
import com.thermax.cp.salesforce.dto.shutdown.ShutdownRequestDTO;
import com.thermax.cp.salesforce.dto.shutdown.ShutdownResponseDTO;
import com.thermax.cp.salesforce.dto.upload.CompositeFileRequestDTO;
import com.thermax.cp.salesforce.dto.upload.ContentDocumentListDTO;
import com.thermax.cp.salesforce.dto.upload.FileUploadResponseDTO;
import com.thermax.cp.salesforce.dto.upload.LinkedContentDocumentToEntityDTO;
import com.thermax.cp.salesforce.entity.ContentLinkEntity;
import com.thermax.cp.salesforce.entity.FileEntity;
import com.thermax.cp.salesforce.exception.*;
import com.thermax.cp.salesforce.feign.request.*;
import com.thermax.cp.salesforce.mapper.CompositeFileUploadMapper;
import com.thermax.cp.salesforce.query.QueryConstants;
import com.thermax.cp.salesforce.utils.SfdcServiceUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/sfdc")
public class SfdcController {

    @Autowired
    private SfdcServiceUtils sfdcServiceUtils;

    @Autowired
    private SfdcClientConfiguration sfdcClientConfiguration;

    @Autowired
    private SfdcOAuthConnectorRequest sfdcOAuthConnectorRequest;

    @Autowired
    private SfdcAccountInfoRequest sfdcAccountInfoRequest;

    @Autowired
    private SfdcAssetDetailRequest sfdcAssetDetailRequest;

    @Autowired
    private SfdcFileUploadRequest sfdcFileUploadRequest;

    @Autowired
    private SfdcAssetsForAccountRequest sfdcAssetsForAccountRequest;

    @Autowired
    private SfdcContentDocumentRequest sfdcContentDocumentRequest;

    @Autowired
    private SfdcContentDocumentLinkRequest sfdcContentDocumentLinkRequest;

    @Autowired
    private SfdcUpdateAccountRequest sfdcUpdateAccountRequest;

    @Autowired
    private OpportunityCreationRequest opportunityCreationRequest;

    @Autowired
    private CaseCreationRequest caseCreationRequest;

    @Autowired
    private CompositeUploadRequest compositeUploadRequest;

    @Autowired
    private SfdcRegisterShutdownRequest sfdcRegisterShutdownRequest;

    @Autowired
    private CompositeFileUploadMapper compositeFileUploadMapper;

    @Autowired
    private ContactCreationRequest contactCreationRequest;

    @Autowired
    private ContactUpdateRequest contactUpdateRequest;

    @Autowired
    private DeletedContactsQueryRequest deletedContactsQueryRequest;

    @PostMapping(value = "/bearerToken")
    public ResponseEntity<OAuthResponseDTO> getBearerToken() {
        OAuthResponseDTO oAuthResponseDTO = sfdcOAuthConnectorRequest.getAuthentication(sfdcClientConfiguration.getGrantType(), sfdcClientConfiguration.getClientId(),
                sfdcClientConfiguration.getClientSecret(), sfdcClientConfiguration.getUsername(), sfdcClientConfiguration.getPassword());

        if (oAuthResponseDTO != null) {
            return new ResponseEntity<>(oAuthResponseDTO, HttpStatus.OK);
        } else {
            log.error("Unable to get bearer token from Sfdc..");
            throw new OAuthResponseException("Unable to get bearer token from Sfdc..");
        }
    }

    @PatchMapping(path = "/updateAccount", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateAccount(@RequestParam("account_id") String accountId, @RequestBody AccountRequestDTO account) {
        log.info("Received request to update account into SFDC where accountId :: " + accountId);
        ResponseEntity updateAccountResponseEntity = sfdcUpdateAccountRequest.updateAccount(account, accountId);
        if (updateAccountResponseEntity != null) {
            return updateAccountResponseEntity;
        } else {
            throw new AccountUpdateException("There was a problem while update account with id :: " + accountId);
        }
    }

    @GetMapping("/get/account-info")
    public ResponseEntity<AccountListDTO> getAccountInfoFromSfdc() throws UnsupportedEncodingException {
        log.info("Getting AccountInfo from SFDC.. ");
        String accountInfoQuery = sfdcServiceUtils.decodeRequestQuery(QueryConstants.ACCOUNT_INFO_QUERY);
        ResponseEntity<AccountListDTO> accountListDTO = sfdcAccountInfoRequest.getAccountInfo(accountInfoQuery);
        if (accountListDTO != null) {
            return accountListDTO;
        } else {
            log.error("Unable to fetch AccountInfo details from SFDC, please try again after sometime.");
            throw new AccountInfoNotFoundException("Unable to fetch AccountInformation from SFDC, please try again after sometime.");
        }
    }

    @GetMapping("/get/asset-details/{assetId}")
    public ResponseEntity<AssetHistoryRecordListDTO> getAssetDetailsFromSfdc(@PathVariable String assetId) throws UnsupportedEncodingException {
        log.info("Getting AssetDetails where assetId is {} ", assetId);
        String assetDetailsQuery = sfdcServiceUtils.decodeRequestQuery(QueryConstants.ASSET_DETAIL_QUERY) + "'" + assetId + "'";
        ResponseEntity<AssetHistoryRecordListDTO> assetHistoryRecordList = sfdcAssetDetailRequest.getAssetDetails(assetDetailsQuery);
        if (assetHistoryRecordList != null) {
            return assetHistoryRecordList;
        } else {
            throw new AssetDetailsNotFoundException("Unable to find Asset Details from SFDC for the specified Id : " + assetId);
        }
    }

    @GetMapping("/get/assets-for-account/{accountId}")
    public ResponseEntity<AssetRecordListDTO> getAssetsForAccountFromSfdc(@PathVariable String accountId) throws UnsupportedEncodingException {
        log.info("Getting Asset Records where accountId is {} ", accountId);
        String assetsForAccountQuery = sfdcServiceUtils.decodeRequestQuery(QueryConstants.ASSETS_FOR_ACCOUNT_QUERY) + "'" + accountId + "'";
        ResponseEntity<AssetRecordListDTO> assetRecordListDTO = sfdcAssetsForAccountRequest.getAssetsForAccount(assetsForAccountQuery);
        if (assetRecordListDTO != null) {
            return assetRecordListDTO;
        } else {
            throw new AssetsNotFoundForAccountException("Unable to find Asset Details from SFDC for the specified account : " + accountId);
        }
    }

    @PostMapping("/upload-file/{entityId}")
    public ResponseEntity<FileUploadResponseDTO> uploadFileIntoSfdc(@RequestBody FileEntity fileEntity, @PathVariable String entityId) throws UnsupportedEncodingException {
        log.info("Being Uploading file into SFDC for Entity : " + entityId);
        ResponseEntity<FileUploadResponseDTO> fileUploadResponseDTO = sfdcFileUploadRequest.uploadFileToSfdc(fileEntity);
        List<Object> errorMessages = new ArrayList<>();
        if (fileUploadResponseDTO != null) {
            String contentVersionId = fileUploadResponseDTO.getBody().getId();
            log.info("Step 1 : File uploaded into SFDC :: [ContentVersionId] -> " + contentVersionId);
            // Now, Fetching content document against this contentVersionId from SFDC..
            ResponseEntity<ContentDocumentListDTO> contentDocumentResponse = sfdcServiceUtils.getContentDocumentForContentVersionId(sfdcContentDocumentRequest, contentVersionId);
            if (contentDocumentResponse != null && contentDocumentResponse.getBody().getRecords() != null) {
                // Link this document with the specified entity Id in SFDC.
                // Build ContentLinkEntity & post to SFDC..
                String contentDocumentId = contentDocumentResponse.getBody().getRecords().get(0).getContentDocumentId();
                log.info("Step 2 : Successfully retrieved documentId from SFDC :: [ContentDocumentId] -> " + contentVersionId);
                ResponseEntity<LinkedContentDocumentToEntityDTO> entityLinkResponse = sfdcContentDocumentLinkRequest.linkContentDocumentWithEntity(new ContentLinkEntity(contentDocumentId, entityId, "AllUsers"));
                if (entityLinkResponse != null && entityLinkResponse.getBody() != null) {
                    // Once the ContentDocument got linked with the entity successfully, in upload response.
                    // Replace the contentVersionId with the linked record Id.
                    String documentRecordId = entityLinkResponse.getBody().getId();
                    log.info("Step 3 : Successfully Linked [ContentDocumentId] with entity into SFDC :: [DocumentRecordId] -> " + documentRecordId);
                    fileUploadResponseDTO.getBody().setId(entityLinkResponse.getBody().getId());
                } else {
                    errorMessages.add("Unable to link contentDocumentId[" + contentDocumentId + "] with entityId[" + entityId + "]");
                }
            } else {
                String errorMessage = "Unable to fetch content document against the content version id : " + contentVersionId;
                errorMessages.add(errorMessage);
                log.error(errorMessage);
                fileUploadResponseDTO.getBody().setErrors(errorMessages);
            }
            return fileUploadResponseDTO;
        } else {
            throw new FileEntityUploadException("Unable to upload file into SFDC, [status code] " + fileUploadResponseDTO.getStatusCode());
        }
    }

    @PostMapping(path = "/registerShutdown")
    public ResponseEntity<ShutdownResponseDTO> registerShutdown(@RequestBody ShutdownRequestDTO registerShutdownDTO) {
        log.info("Registering Asset Shutdown with SFDC.. ");
        ResponseEntity<ShutdownResponseDTO> shutdownResponseDTO = null;
        try {
            shutdownResponseDTO = sfdcRegisterShutdownRequest.registerShutdown(registerShutdownDTO);

        } catch (ResponseStatusException resEx) {
            log.error(resEx);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return shutdownResponseDTO;
    }

    @PostMapping(path = "/createOpportunity", consumes = "application/json")

    public ResponseEntity<OpportunityResponseDTO> createOpportunity(@RequestBody OpportunityRequestDTO opportunityRequestDTO) {
        log.info("Creation of opportunity with SFDC.. ");
        ResponseEntity<OpportunityResponseDTO> opportunityResponseDTO = null;
        try {
            Gson gson = new Gson();
            String requestDTOJson = gson.toJson(opportunityRequestDTO);
            log.info("opportunity creation done for request :: " + requestDTOJson);
            opportunityResponseDTO = opportunityCreationRequest.postEnquirytoSFDC(requestDTOJson);

        } catch (ResponseStatusException resEx) {
            log.error(resEx);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return opportunityResponseDTO;
    }

    @PostMapping(path = "/createCase")
    public ResponseEntity<CaseResponseDTO> createCase(@RequestBody CaseRequestDTO caseRequestDTO) {
        log.info("Creation of case with SFDC.. ");
        ResponseEntity<CaseResponseDTO> caseResponseDTO = null;
        try {
            caseResponseDTO = caseCreationRequest.postCasetoSFDC(caseRequestDTO);

        } catch (ResponseStatusException resEx) {
            log.error(resEx);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return caseResponseDTO;
    }

    @PostMapping(path = "/compositeRequest")
    public ResponseEntity<Object> uploadFilesToSFDC(@RequestBody CompositeFileRequestDTO compositeFileRequestDTO) {
        log.info("Upload of files with SFDC in single request");
        ResponseEntity<Object> compositeFileResponseDTO = null;
        try {
            compositeFileResponseDTO = compositeUploadRequest.uploadFilestoSFDC(
                    compositeFileUploadMapper.allRequestsForFileDTOtoCompositeFileUploadDTO(
                            compositeFileUploadMapper.fileUploadCompositeRequesttoAllRequestsForFileDTO(compositeFileRequestDTO)));
            log.info("response from SFDC upload files : " + compositeFileResponseDTO.getBody());
        } catch (ResponseStatusException resEx) {
            log.error(resEx);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return compositeFileResponseDTO;
    }

    @PostMapping(path = "/createContact")
    public ResponseEntity<ContactCreationResponseDTO> createContactInSfdc(@RequestBody ContactRequestDTO contactRequestDTO) {
        log.info("Creating a contact in SFDC..");
        ResponseEntity<ContactCreationResponseDTO> contactCreationResponseDTO = null;

        log.info("User to be registered into SFDC" + new Gson().toJson(contactRequestDTO));
        try {
            contactCreationResponseDTO = contactCreationRequest.createContactIntoSFDC(contactRequestDTO);
            if (contactCreationResponseDTO.hasBody()) {
                log.info("User registered into SFDC Successfully !! with id {}  ", contactCreationResponseDTO.getBody().getId());
            }
        } catch (ResponseStatusException resEx) {
            log.error(resEx);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return contactCreationResponseDTO;
    }

    @PatchMapping(path = "/updateContact/{contactId}")
    public ResponseEntity updateContactInSfdc(@RequestBody ContactRequestDTO contactRequestDTO,
                                              @PathVariable String contactId) {

        log.info("Updating a contact in SFDC with id {}", contactId);
        log.info("User contact to be updated into SFDC" + new Gson().toJson(contactRequestDTO) + "with contact ID as ::" +contactId);
        ResponseEntity contactUpdateResponseEntity = null;
        try {
            contactUpdateResponseEntity = contactUpdateRequest.updateContactDetailsIntoSFDC(contactRequestDTO, contactId);
            log.info("contact updated into SFDC Successfully !!");
        } catch (ResponseStatusException resEx) {
            log.error(resEx);
            return new ResponseEntity<>(contactUpdateResponseEntity, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(contactUpdateResponseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(contactUpdateResponseEntity, HttpStatus.OK);
    }

    @GetMapping("/getDeletedSFDCContacts/{interval}")
    public ResponseEntity<DeletedContactListDTO> getDeletedSFDCContacts(@PathVariable Integer interval) throws UnsupportedEncodingException {
        log.info("Getting deleted contacts from salesforce for last {} ", interval + " minutes." );
        try {
            String query = "select+id,accountId ,Email,TH_IsActive__c,TMAX_isActiveForCP__c,isDeleted+from+Contact+where+isDeleted=true+AND+TMAX_Minutes_since_modified__c+<="+interval;
            query = URLDecoder.decode(query, "UTF-8");
            ResponseEntity<DeletedContactListDTO> deletedContactListDTO = deletedContactsQueryRequest.getDeletedSFDCContacts(query);
            if (deletedContactListDTO.getBody()!=null && !deletedContactListDTO.getBody().getRecords().isEmpty()) {
                return  deletedContactListDTO;
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        }
        catch (Exception e) {
            log.debug("Something wrong in getting deleted users !! ");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
