package com.thermax.cp.salesforce.dto.shutdown;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class ShutdownResponseDTO {
    private String id;
    private boolean success;
    private List errors ;
    private String message;
    private String errorCode;
    private List<String> fields;
}
