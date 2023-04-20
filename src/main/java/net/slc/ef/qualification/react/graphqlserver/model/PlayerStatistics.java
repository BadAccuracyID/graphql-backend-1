package net.slc.ef.qualification.react.graphqlserver.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PlayerStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Player.class, fetch = FetchType.LAZY)
    private Player player;

    private int wins;
    private int losses;
    private int kills;
    private int deaths;
    private int assists;
    private int money;

}
