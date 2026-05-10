package com.siddhi.aispendaudit.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "leads")
@Data
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    private String companyName;
    private double potentialSavings;
    private String primaryUseCase;
}