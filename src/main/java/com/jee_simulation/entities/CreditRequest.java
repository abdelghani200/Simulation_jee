package com.jee_simulation.entities;

import java.time.LocalDate;

import com.jee_simulation.enums.CreditReuquestStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "credit_Requests")
public class CreditRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int duration;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate requestDate;

    @Column(nullable = false)
    private double requestedAmount;

    @Column(nullable = false)
    private double mounthlyAmount;

    @Column(length = 255)
    private String remark;

    @Column(columnDefinition = "DATE DEFAULT NULL", nullable = true)
    private LocalDate reviewDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditReuquestStatus status;

    @ManyToOne
    @JoinColumn(name = "agency_id", nullable = false)
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
