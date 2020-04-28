package maciel.lazaro.exemplosql2.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

@Entity
@Table(name = "cliente")
public class ClientEntety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "renda")
    private double income;
}
