package kg.voenkomat.recruits.service.impl;

import kg.voenkomat.recruits.dto.RecruitDTO;
import kg.voenkomat.recruits.entity.Recruit;
import kg.voenkomat.recruits.exception.CustomException;
import kg.voenkomat.recruits.mapper.RecruitMapper;
import kg.voenkomat.recruits.repo.RecruitRepo;
import kg.voenkomat.recruits.service.RecruitService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class RecruitServiceImpl implements RecruitService {
    final RecruitMapper recruitMapper;
    RecruitRepo recruitRepo;

    @Override
    public List<RecruitDTO> getAllRecruits() {
        List<Recruit> recruits = recruitRepo.findAll();

        return recruits.stream()
                .map(recruitMapper::toDTO)
                .toList();
    }

    @Override
    public RecruitDTO getRecruitById(Long id) {
        return recruitMapper.toDTO(getById(id));
    }

    @Override
    public RecruitDTO createRecruit(RecruitDTO recruitDTO) {
        Recruit recruit = recruitMapper.toEntity(recruitDTO);
        recruitRepo.save(recruit);

        return recruitMapper.toDTO(recruit);
    }

    @Override
    public RecruitDTO updateRecruit(Long id, RecruitDTO recruitDTO) {
        Recruit existingRecruit = getById(id);
        recruitMapper.updateEntityFromDTO(recruitDTO, existingRecruit);
        Recruit updatedRecruit = recruitRepo.save(existingRecruit);

        return recruitMapper.toDTO(updatedRecruit);
    }

    @Override
    public void deleteRecruit(Long id) {
        Recruit recruit = getById(id);
        recruitRepo.delete(recruit);
    }

    private Recruit getById(Long id) {
        return recruitRepo.findById(id).orElseThrow(() -> new CustomException(
                "Not found id %s".formatted(id),
                404
        ));
    }
}