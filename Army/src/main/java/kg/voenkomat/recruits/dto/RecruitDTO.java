package kg.voenkomat.recruits.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecruitDTO {
    Long id;
    String name;
    Integer age;
    boolean workability;
}