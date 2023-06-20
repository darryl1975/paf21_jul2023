package sg.edu.nus.iss.paf21_jul2023.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Integer id;

    private String roomType;

    private Integer price;
    
}
