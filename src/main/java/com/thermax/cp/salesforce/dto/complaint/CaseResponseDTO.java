package com.thermax.cp.salesforce.dto.complaint;

import lombok.Data;

import java.util.List;

@Data
public class CaseResponseDTO {
    private String id;
    private boolean success;
    private List errors ;
    private String message;
    private String errorCode;
    private List<String> fields;
}
