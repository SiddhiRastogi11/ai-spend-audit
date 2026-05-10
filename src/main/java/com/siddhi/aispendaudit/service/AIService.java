package com.siddhi.aispendaudit.service;

import com.siddhi.aispendaudit.model.AuditResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AIService {

    @Autowired
    private RestTemplate restTemplate;

    // Replace with your real API key later
    private final String API_URL = "https://api.anthropic.com/v1/messages";
    private final String API_KEY = "YOUR_ANTHROPIC_KEY";

    public String generateSummary(List<AuditResponse> results) {
        try {
            // In a real scenario, you'd build a JSON request for Anthropic here.
            // For the MVP, we are setting up the structure.

            String auditSummary = results.stream()
                    .map(r -> r.getToolName() + ": " + r.getRecommendation())
                    .collect(Collectors.joining(", "));

            // logic to call API would go here
            // return restTemplate.postForObject(API_URL, request, String.class);

            // Simulating a successful AI response for now
            return "Based on your stack, you have a significant opportunity to optimize. " +
                    "By switching specific tiers in " + auditSummary + ", you could save over " +
                    "the estimated annual amount while maintaining full developer productivity.";

        } catch (Exception e) {
            // FALLBACK LOGIC: If API fails, return this professional template
            return "Audit Complete: Your AI stack shows several optimization opportunities. " +
                    "Review the detailed breakdown below to see where plan downgrades or " +
                    "alternative tools can reduce your monthly burn without impacting workflow.";
        }
    }
}