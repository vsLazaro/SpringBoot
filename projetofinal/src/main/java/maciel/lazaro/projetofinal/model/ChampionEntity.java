package maciel.lazaro.projetofinal.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @author Lázaro
 * @since 01/05/2020 13:44
 * @version 1.0
 */

@Component
@Entity
@Table(name = "champion")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class ChampionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_champion")
    private long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "cidade_natal")
    private String hometown;
    @Column(name = "funcao")
    private String function;
    @Column(name = "dificuldade")
    private String difficulty;
}
