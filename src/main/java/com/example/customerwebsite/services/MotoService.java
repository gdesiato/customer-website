package com.example.customerwebsite.services;

import com.example.customerwebsite.model.RentalMoto;
import com.example.customerwebsite.repositories.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotoService {

    @Autowired
    MotoRepository motoRepository;

    public List<RentalMoto> getMoto() {
        return motoRepository.findAll();
    }

    public List<RentalMoto> getAvailableCars() {
        return getMoto().stream().filter(c -> c.getCustomer() == null)
                .collect(Collectors.toList());
    }

    public RentalMoto getMoto(Long id) {
        return motoRepository.findById(id)
                .orElse(null);
    }

    @Transactional
    public RentalMoto saveMoto(RentalMoto moto) throws IllegalArgumentException {
        return motoRepository.save(moto);
    }

    public void removeAssignment(Long customerId) {
        RentalMoto moto = motoRepository.findByCustomerId(customerId);
        if (moto != null) {
            moto.setCustomer(null);
            saveMoto(moto);
        }
    }
}