package com.thermax.cp.salesforce.dto.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactCreationResponseDTO {

    private String id;
    private boolean success;
    private List errors;
}
