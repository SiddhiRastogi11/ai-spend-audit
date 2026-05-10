package com.siddhi.aispendaudit.controller;

import com.siddhi.aispendaudit.model.AuditFinalReport;
import com.siddhi.aispendaudit.model.AuditRequest;
import com.siddhi.aispendaudit.model.AuditResponse;
import com.siddhi.aispendaudit.service.AIService;
import com.siddhi.aispendaudit.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
@CrossOrigin(origins = "*")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @Autowired
    private AIService aiService;

    @PostMapping("/run")
    public AuditFinalReport runAudit(@RequestBody List<AuditRequest> requests) {
        // 1. Run the math logic
        List<AuditResponse> logicResults = auditService.runAudit(requests);

        // 2. Generate AI summary
        String aiSummary = aiService.generateSummary(logicResults);

        // 3. Calculate totals for the Hero Section
        double monthlySavings = logicResults.stream()
                .mapToDouble(AuditResponse::getPotentialSavings)
                .sum();
        double annualSavings = monthlySavings * 12;

        // 4. Return the complete report
        return new AuditFinalReport(logicResults, aiSummary, monthlySavings, annualSavings);
    }
}