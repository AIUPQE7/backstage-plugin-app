package com.thermax.cp.salesforce.dto.upload;

import lombok.Data;

import java.util.List;
@Data
public class AllRequestsForFileDTO {
    List<PostContentVersionDTO> postContentVersionList;
    List<GetRefContentVersionDTO> getRefContentVersionDTOList;
    List<PostContentDocumentLinkDTO> postContentDocumentLinkDTOList;
}

