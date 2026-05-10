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
            // Basic logic for Cursor
            if (req.getToolName().equalsIgnoreCase("Cursor") && req.getPlan().equalsIgnoreCase("Business") && req.getSeats() < 3) {
                responses.add(new AuditResponse("Cursor", "Downgrade to Pro", req.getCurrentSpend() - 20, "Business plan is not cost-effective for teams under 3."));
            } else {
                responses.add(new AuditResponse(req.getToolName(), "Optimal", 0, "You are on the right plan."));
            }
        }
        return responses;
    }
}