package kg.voenkomat.recruits.service.impl;

import kg.voenkomat.recruits.dto.RecruitDTO;
import kg.voenkomat.recruits.entity.Recruit;
import kg.voenkomat.recruits.repo.RecruitRepo;
import kg.voenkomat.recruits.service.RecruitService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Service
public class RecruitServiceImpl implements RecruitService {//todo add interface
    RecruitRepo recruitRepo;

    @Override
    public List<RecruitDTO> getAllRecruits() {
        return recruitRepo.findAll().stream()
                .map(recruit -> new RecruitDTO(recruit.getId(), recruit.getName(), recruit.getAge(), recruit.isWorkability()))
                .toList();
    }

    @Override
    public Optional<RecruitDTO> getRecruitById(Long Id) {//todo read java convension
        return recruitRepo.findById(Id).map(recruit -> new RecruitDTO(recruit.getId(), recruit.getName(), recruit.getAge(), recruit.isWorkability()));
    }

    @Override
    public RecruitDTO createRecruit(RecruitDTO recruitDTO) {
        Recruit recruit = Recruit.builder()
                .name(recruitDTO.getName())
                .age(recruitDTO.getAge())
                .workability(recruitDTO.getWorkability())
                .build();
        recruitRepo.save(recruit);

        return RecruitDTO.builder()
                .id(recruit.getId())
                .name(recruit.getName())
                .age(recruit.getAge())
                .workability(recruit.isWorkability())
                .build();
    }

    @Override
    public RecruitDTO updateRecruit(Long id, RecruitDTO recruitDTO) {
        Recruit existingRecruit = recruitRepo.findById(id).
                orElseThrow(() -> new NoSuchElementException("Рекрут с id %s не найден".formatted(id)));
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

    @Override
    public void deleteRecruit(Long id) {
        Recruit recruit = recruitRepo.findById(id).
                orElseThrow(() -> new NoSuchElementException("Рекрут с id " + id + " не найден"));//todo with formatter
        recruitRepo.delete(recruit);
    }
}