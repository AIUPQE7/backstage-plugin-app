package com.thermax.cp.salesforce.mapper;

import com.thermax.cp.salesforce.dto.upload.*;
import com.thermax.cp.salesforce.entity.ContentLinkEntity;
import com.thermax.cp.salesforce.entity.FileEntity;
import org.springframework.stereotype.Service;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CompositeFileUploadMapper {

    public AllRequestsForFileDTO fileUploadCompositeRequesttoAllRequestsForFileDTO(CompositeFileRequestDTO compositeFileRequestDTO)
    {
        List<PostContentVersionDTO> postContentVersionList = new ArrayList<PostContentVersionDTO>();
        List<GetRefContentVersionDTO> getRefContentVersionList = new ArrayList<GetRefContentVersionDTO>();
        List<PostContentDocumentLinkDTO> postContentDocumentLinkList = new ArrayList<PostContentDocumentLinkDTO>();
        AllRequestsForFileDTO allRequestsForFileDTO = new AllRequestsForFileDTO();
        int iterator = 1;
        for(FileUploadCompositeRequestDTO dto : compositeFileRequestDTO.getFileUploadCompositeRequest())
        {
            PostContentVersionDTO postContentVersion = new PostContentVersionDTO();
            postContentVersion.setMethod("POST");
            postContentVersion.setUrl("/services/data/v52.0/sobjects/ContentVersion");
            postContentVersion.setReferenceId("refContent"+iterator);
            postContentVersion.setBody(new FileEntity("CompositeFile"+iterator,dto.getPathOnClient(),"S",dto.getVersionData()));
            postContentVersionList.add(postContentVersion);
            GetRefContentVersionDTO getRefContentVersionDTO = new GetRefContentVersionDTO();
            getRefContentVersionDTO.setMethod("GET");
            getRefContentVersionDTO.setReferenceId("refContentVersion"+iterator);
            getRefContentVersionDTO.setUrl("/services/data/v52.0/sobjects/ContentVersion/@{"+postContentVersion.getReferenceId()+".id}");
            getRefContentVersionList.add(getRefContentVersionDTO);
            PostContentDocumentLinkDTO postContentDocumentLinkDTO = new PostContentDocumentLinkDTO();
            postContentDocumentLinkDTO.setMethod("POST");
            postContentDocumentLinkDTO.setUrl("/services/data/v52.0/sobjects/ContentDocumentLink");
            postContentDocumentLinkDTO.setReferenceId("refContentLink"+iterator);
            postContentDocumentLinkDTO.setBody(new ContentLinkEntity("@{"+getRefContentVersionDTO.getReferenceId()
                 +".ContentDocumentId}",dto.getLinkedEntityId(),"AllUsers"));
            postContentDocumentLinkList.add(postContentDocumentLinkDTO);
            iterator++;
        }
        allRequestsForFileDTO.setPostContentVersionList(postContentVersionList);
        allRequestsForFileDTO.setGetRefContentVersionDTOList(getRefContentVersionList);
        allRequestsForFileDTO.setPostContentDocumentLinkDTOList(postContentDocumentLinkList);
        return allRequestsForFileDTO;
    }

    public CompositeFileUploadDTO allRequestsForFileDTOtoCompositeFileUploadDTO(AllRequestsForFileDTO dto)
    {
        //List<AllRequestsForFileDTO> outerList = new ArrayList<AllRequestsForFileDTO>();
       // outerList.add(dto);
        List<Object> list = new ArrayList<>();
        dto.getPostContentVersionList().forEach(e->list.add((Object)e));
        dto.getGetRefContentVersionDTOList().forEach(e->list.add((Object)e));
        dto.getPostContentDocumentLinkDTOList().forEach(e->list.add((Object)e));


        CompositeFileUploadDTO compositeFileUploadDTO = new CompositeFileUploadDTO();
        compositeFileUploadDTO.setAllOrNone(Boolean.TRUE);

        compositeFileUploadDTO.setCompositeRequest(list);

        return compositeFileUploadDTO;
    }
}
