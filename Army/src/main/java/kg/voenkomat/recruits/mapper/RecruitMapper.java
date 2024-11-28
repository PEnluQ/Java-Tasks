package kg.voenkomat.recruits.mapper;

import kg.voenkomat.recruits.dto.RecruitDTO;
import kg.voenkomat.recruits.entity.Recruit;
import org.springframework.stereotype.Component;

@Component
public class RecruitMapper {
    public Recruit toEntity(RecruitDTO dto){
        if(dto == null){
            return null;
        }
        Recruit recruit = new Recruit();
        recruit.setId(dto.getId());
        recruit.setName(dto.getName());
        recruit.setAge(dto.getAge());
        recruit.setWorkability(dto.isWorkability());
        return recruit;
    }
    public RecruitDTO toDTO(Recruit recruit){
        if(recruit == null){
            return null;
        }
        RecruitDTO dto = new RecruitDTO();
        dto.setId(recruit.getId());
        dto.setName(recruit.getName());
        dto.setAge(recruit.getAge());
        dto.setWorkability(recruit.isWorkability());
        return dto;
    }
    public void updateEntityFromDTO(RecruitDTO dto, Recruit entity) {
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getAge() != null) {
            entity.setAge(dto.getAge());
        }
        entity.setWorkability(dto.isWorkability());
    }
}