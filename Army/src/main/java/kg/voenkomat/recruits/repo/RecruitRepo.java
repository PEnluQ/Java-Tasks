package kg.voenkomat.recruits.repo;

import kg.voenkomat.recruits.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitRepo extends JpaRepository<Recruit, Long> {
    
}