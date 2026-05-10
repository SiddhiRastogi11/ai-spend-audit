package com.siddhi.aispendaudit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class AuditFinalReport {
    private List<AuditResponse> results;
    private String aiSummary;
    private double totalMonthlySavings;
    private double totalAnnualSavings;
}