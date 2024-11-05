package kg.voenkomat.mobilization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "soldiers")
@Getter
@Setter
public class Soldier {

    @Id
    private Long id;
}