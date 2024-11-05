package kg.voenkomat.mobilization.service;

import kg.voenkomat.mobilization.repository.SoldierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SoldierService {
    private final SoldierRepository soldierRepository;

    public void addSoldier() {
        soldierRepository.findAll();
    }
}