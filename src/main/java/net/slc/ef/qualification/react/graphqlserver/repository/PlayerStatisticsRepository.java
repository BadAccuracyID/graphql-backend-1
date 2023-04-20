package net.slc.ef.qualification.react.graphqlserver.repository;

import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatistics;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayerStatisticsRepository extends CrudRepository<PlayerStatistics, Long> {

    Optional<PlayerStatistics> findPlayerStatisticsByPlayerId(Long playerId);

}
