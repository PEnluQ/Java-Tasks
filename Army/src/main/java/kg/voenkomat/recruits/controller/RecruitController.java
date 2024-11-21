package kg.voenkomat.recruits.controller;

import kg.voenkomat.recruits.dto.RecruitDTO;
import kg.voenkomat.recruits.service.RecruitService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class RecruitController {
    RecruitService recruitService;

    @GetMapping("/")
    public ResponseEntity<?> getAllRecruits() {
        try {
            List<RecruitDTO> recruits = recruitService.getAllRecruits();
            if(recruits.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Список пуст");
            }
            return ResponseEntity.ok(recruits);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Произошла ошибка: " + e.getMessage());
        }
    }
    @GetMapping("/recruit/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id) {
        try {
            Optional<RecruitDTO> recruit = recruitService.getRecruitById(id);
            if (recruit.isPresent()) {
                return ResponseEntity.ok(recruit.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Рекрут с ID " + id + " не найден");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Произошла ошибка: " + e.getMessage());
        }
    }
}