package kg.voenkomat.mobilization.api.controller;

import kg.voenkomat.mobilization.entity.Soldier;
import kg.voenkomat.mobilization.repository.SoldierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SoldierController {
    @Autowired
    private SoldierRepository soldierRepository;

    @GetMapping("/soldiers")
    public List<Soldier> getSoldiers(){
        return soldierRepository.findAll();
    }
    @PostMapping("/save")
    public String saveUser(@RequestBody Soldier soldier){
        soldierRepository.save(soldier);
        return "Saved...";
    }
    @PutMapping("update/{id}")
    public String updateSoldier(@PathVariable Long id, @RequestBody Soldier soldier){
        Soldier updatedSoldier = soldierRepository.findById(id).get();
        updatedSoldier.setFirstName(soldier.getFirstName());
        updatedSoldier.setLastName(soldier.getLastName());
        updatedSoldier.setAge(soldier.getAge());
        updatedSoldier.setWorkability(soldier.getWorkability());
        soldierRepository.save(updatedSoldier);
        return "Updated...";
    }
}