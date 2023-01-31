package com.thermax.cp.salesforce.dto.upload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class CompositeFileResponseDTO {
    private List<FileUploadResponse>  compositeResponse;
}

@AllArgsConstructor
class FileUploadResponse {
    private FileUploadResponseDTO body;
    private HttpHeaders httpHeaders;
    private Integer httpStatusCode;

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public FileUploadResponseDTO getBody() {
        return body;
    }

    public void setBody(FileUploadResponseDTO body) {
        this.body = body;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }



    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    private String referenceId;
}
class HttpHeaders
{

    private String location;

    public String getLocation() {
        return location;
    }
    @JsonProperty("Location")
    public void setLocation(String location) {
        this.location = location;
    }
}
