package kg.voenkomat.recruits.service;

import kg.voenkomat.recruits.dto.RecruitDTO;

import java.util.List;
import java.util.Optional;

public interface RecruitService {
    List<RecruitDTO> getAllRecruits();

    Optional<RecruitDTO> getRecruitById(Long id);

    RecruitDTO createRecruit(RecruitDTO recruitDTO);

    RecruitDTO updateRecruit(Long id, RecruitDTO recruitDTO);

    void deleteRecruit(Long id);
}
