package kg.voenkomat.recruits.controller;

import kg.voenkomat.recruits.dto.RecruitDTO;
import kg.voenkomat.recruits.service.RecruitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RecruitController {
    RecruitService recruitService;

    @GetMapping("/")
    public List<RecruitDTO> getAllRecruits() {
        return recruitService.getAllRecruits();
    }


    @GetMapping("/recruit/{id}")
    public RecruitDTO getRecruitById(@PathVariable Long id) {
        return recruitService.getRecruitById(id);
    }


    @PostMapping
    public RecruitDTO createRecruit(@RequestBody RecruitDTO recruitDTO) {
        return recruitService.createRecruit(recruitDTO);
    }


    @PutMapping("/edit/{id}")
    public RecruitDTO updateRecruit(@PathVariable Long id, @RequestBody RecruitDTO recruitDTO) {
        return recruitService.updateRecruit(id, recruitDTO);
    }


    @DeleteMapping("/remove/{id}")
    public void deleteRecruit(@PathVariable Long id) {
        recruitService.deleteRecruit(id);
    }
}