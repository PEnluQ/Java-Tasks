package kg.voenkomat.mobilization.controller;

import kg.voenkomat.mobilization.dto.SoldierDTO;
import kg.voenkomat.mobilization.service.SoldierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/soldier")
public class SoldierController {
    private final SoldierService soldierService;

//    @PostMapping
//    @DeleteMapping
//    @PutMapping
//    @PatchMapping
//    @GetMapping("/list")
//    public String qwe(@RequestBody SoldierDTO soldierDTO) {
//        return "";
//    }

    @GetMapping("/list/{id}")
    public String qwe(@PathVariable Long id) {
        soldierService.addSoldier();
        return "";
    }

}