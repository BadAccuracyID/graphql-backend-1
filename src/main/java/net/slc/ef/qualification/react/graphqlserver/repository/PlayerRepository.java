package net.slc.ef.qualification.react.graphqlserver.repository;

import net.slc.ef.qualification.react.graphqlserver.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByName(String name);

}
