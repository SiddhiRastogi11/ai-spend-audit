package com.siddhi.aispendaudit.service;

import com.siddhi.aispendaudit.model.AuditRequest;
import com.siddhi.aispendaudit.model.AuditResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditService {
    public List<AuditResponse> runAudit(List<AuditRequest> requests) {
        List<AuditResponse> responses = new ArrayList<>();
        for (AuditRequest req : requests) {
            // Rule 1: The Cursor Business Rule
            if (req.getToolName().equalsIgnoreCase("Cursor") && req.getPlan().equalsIgnoreCase("Business") && req.getSeats() < 3) {
                responses.add(new AuditResponse("Cursor", "Downgrade to Pro", 20.0, "Business plan features aren't needed for solo users."));
            }
            // Rule 2: Generic "High Spend" Rule (Catch-all)
            else if (req.getCurrentSpend() > 30) {
                responses.add(new AuditResponse(req.getToolName(), "Review Plan Tiers", 10.0, "Your spend is above average for this tool. Check for annual billing discounts."));
            }
            // Default
            else {
                responses.add(new AuditResponse(req.getToolName(), "Optimal", 0, "You are using this tool efficiently."));
            }
        }
        return responses;
    }
}