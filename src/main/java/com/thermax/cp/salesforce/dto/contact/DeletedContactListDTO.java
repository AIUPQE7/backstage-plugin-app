package com.thermax.cp.salesforce.dto.contact;

import com.thermax.cp.salesforce.dto.account.AccountInfoDTO;
import lombok.Data;

import java.util.List;
@Data
public class DeletedContactListDTO {

        private String totalSize;
        private String done;
        private List<DeletedContactDTO> records;

}
