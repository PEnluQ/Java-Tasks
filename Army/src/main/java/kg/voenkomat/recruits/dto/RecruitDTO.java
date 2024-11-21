package kg.voenkomat.recruits.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecruitDTO {
    private Long id;
    private String name;
    private Integer age;
    private Boolean workability;
}