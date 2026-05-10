package com.siddhi.aispendaudit;

import lombok.Data;

@Data
public class AuditRequest {
    private String toolName;
    private String plan;
    private int seats;
    private double currentSpend;
}
