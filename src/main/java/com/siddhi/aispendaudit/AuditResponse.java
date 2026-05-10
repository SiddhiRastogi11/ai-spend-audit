package com.siddhi.aispendaudit;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuditResponse {
    private String toolName;
    private String recommendation;
    private double potentialSavings;
    private String reasoning;
}