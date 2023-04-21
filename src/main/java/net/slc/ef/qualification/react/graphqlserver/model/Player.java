package net.slc.ef.qualification.react.graphqlserver.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PlayerStatistics playerStatistics;


}
