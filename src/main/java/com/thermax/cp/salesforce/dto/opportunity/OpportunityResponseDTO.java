package com.thermax.cp.salesforce.dto.opportunity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class OpportunityResponseDTO {
    private String hasErrors;
    private List<References> results;

}
@AllArgsConstructor
class References
{
    private String referenceId;
    private String id;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}