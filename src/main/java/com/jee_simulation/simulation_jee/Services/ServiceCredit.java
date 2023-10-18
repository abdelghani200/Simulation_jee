package com.jee_simulation.simulation_jee.Services;

import com.jee_simulation.simulation_jee.Dto.Credit;
import com.jee_simulation.simulation_jee.Enums.EtatCredit;
import com.jee_simulation.simulation_jee.Interfaces.ICredit;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ServiceCredit {

    private ICredit creditService;

    public ServiceCredit(ICredit creditService) {
        this.creditService = creditService;
    }

    public Credit createCredit(Credit credit) throws Exception {
        Optional<Credit> savedCredit = creditService.create(credit);
        if (savedCredit.isPresent()){
            return savedCredit.get();
        } else {
            throw new Exception("Erreur lors de la création du crédit.");
        }
    }

    public boolean changeEtat(int numero, EtatCredit newEtat)
    {
        if (newEtat == EtatCredit.Active || newEtat == EtatCredit.Inactive) {
            return creditService.update(numero, newEtat);
        } else {
            return false;
        }
    }


    public List<Credit> getAll(){
        return creditService.read();
    }

    public List<Credit> findByEtat(EtatCredit etatCredit){
        return creditService.getByEtat(etatCredit);
    }

    public List<Credit> findByDate(LocalDate date){
        return creditService.getByDate(date);
    }


}
