package com.thermax.cp.salesforce.dto.upload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class CompositeFileRequestDTO {
    private List<FileUploadCompositeRequestDTO> fileUploadCompositeRequest;
}
