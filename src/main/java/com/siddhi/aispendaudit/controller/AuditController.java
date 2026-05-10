package com.siddhi.aispendaudit.controller;

import com.siddhi.aispendaudit.model.AuditRequest;
import com.siddhi.aispendaudit.model.AuditResponse;
import com.siddhi.aispendaudit.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/audit")
@CrossOrigin(origins = "*") // Allows your frontend to talk to this backend
public class AuditController {

    @Autowired
    private AuditService auditService;

    @PostMapping("/run")
    public List<AuditResponse> runAudit(@RequestBody List<AuditRequest> requests) {
        return auditService.runAudit(requests);
    }
}