package com.thermax.cp.salesforce.dto.opportunity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChosenProducts {

    private List<ChosenProduct> records;

    public List<ChosenProduct> getRecords() {
        return records;
    }

    public void setRecords(List<ChosenProduct> records) {
        this.records = records;
    }

}
