package kg.voenkomat.recruits.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "recruits")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Recruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(length = 20)//todo add all required params
    String name;

    @Column
    Integer age;

    @Column
    boolean workability;
}