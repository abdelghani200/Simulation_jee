package com.jee_simulation.entities;

import java.io.Serializable;
import java.time.LocalDate;

import com.jee_simulation.enums.CreditRequestStatus;

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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Entity
@Table(name = "credit_Requests")
public class CreditRequest implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int duration;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate requestDate;

    @Column(nullable = false)
    private double borrowedAmount;

    @Column(nullable = false)
    private double monthlyAmount;

    @Column(length = 255, nullable = true)
    private String remark;

    @Column(columnDefinition = "DATE DEFAULT NULL", nullable = true)
    private LocalDate reviewDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditRequestStatus status;

    @ManyToOne
    @JoinColumn(name = "agency_id", nullable = false)
    private Agency agency;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
