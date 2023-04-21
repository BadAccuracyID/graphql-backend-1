package net.slc.ef.qualification.react.graphqlserver.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "player_stats")
public class PlayerStats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "wins", nullable = false)
    private int wins;

    @Column(name = "losses", nullable = false)
    private int losses;

    @Column(name = "kills", nullable = false)
    private int kills;

    @Column(name = "deaths", nullable = false)
    private int deaths;

    @Column(name = "assists", nullable = false)
    private int assists;

    @Column(name = "money", nullable = false)
    private int money;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

}
