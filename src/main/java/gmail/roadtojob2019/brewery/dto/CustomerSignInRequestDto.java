package gmail.roadtojob2019.brewery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerSignInRequestDto {
    private String email;
    private String password;
}
