package kg.voenkomat.recruits.service;

import kg.voenkomat.recruits.dto.RecruitDTO;
import kg.voenkomat.recruits.entity.Recruit;
import kg.voenkomat.recruits.repo.RecruitRepo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class RecruitService {
    RecruitRepo recruitRepo;

    public List<RecruitDTO> getAllRecruits() {
        List<Recruit> recruits = recruitRepo.findAll();
        return recruits.stream()
                .map(recruit -> new RecruitDTO(recruit.getId(), recruit.getName(), recruit.getAge(), recruit.isWorkability()))
                .collect(Collectors.toList());
    }
    public Optional<RecruitDTO> getRecruitById(Long Id){
        return recruitRepo.findById(Id).map(recruit -> new RecruitDTO(recruit.getId(), recruit.getName(), recruit.getAge(), recruit.isWorkability()));
    }
    public RecruitDTO createRecruit(RecruitDTO recruitDTO){
        Recruit recruit = Recruit.builder()
                .name(recruitDTO.getName())
                .age(recruitDTO.getAge())
                .workability(recruitDTO.getWorkability())
                .build();
        Recruit savedRecruit = recruitRepo.save(recruit);
        return RecruitDTO.builder()
                .name(savedRecruit.getName())
                .age(savedRecruit.getAge())
                .workability(savedRecruit.isWorkability())
                .build();
    }
    public RecruitDTO updateRecruit(Long id, RecruitDTO recruitDTO){
        Recruit existingRecruit = recruitRepo.findById(id).orElseThrow(() -> new NoSuchElementException("Рекрут с id " + id + " не найден"));
        existingRecruit = Recruit.builder()
                .id(existingRecruit.getId())
                .name(recruitDTO.getName())
                .age(recruitDTO.getAge())
                .workability(recruitDTO.getWorkability())
                .build();
        Recruit updatedRecruit = recruitRepo.save(existingRecruit);
        return RecruitDTO.builder()
                .name(updatedRecruit.getName())
                .age(updatedRecruit.getAge())
                .workability(updatedRecruit.isWorkability())
                .build();
    }
}