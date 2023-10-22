package com.jee_simulation.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "clients")
public final class Client extends Person {
    
    @Column(length = 255, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)    
    private Employee employee;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditRequest> creditRequests;

}
