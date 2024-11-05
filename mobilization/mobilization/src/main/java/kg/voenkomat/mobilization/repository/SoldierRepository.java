package kg.voenkomat.mobilization.repository;

import kg.voenkomat.mobilization.entity.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldierRepository extends JpaRepository<Soldier, Long>{

}