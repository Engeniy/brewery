package gmail.roadtojob2019.brewery.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Long id;
    private String fullName;
    private String email;
    private String phone;
    private String password;
}
