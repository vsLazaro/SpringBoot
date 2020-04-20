package maciel.lazaro.ExemploClientsComLombok.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Client {

    @Getter @Setter
    private String name;

    @Getter @Setter
    String dateOfBirth;

}
