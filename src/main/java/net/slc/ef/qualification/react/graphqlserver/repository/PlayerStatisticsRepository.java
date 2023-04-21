package net.slc.ef.qualification.react.graphqlserver.repository;

import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlayerStatisticsRepository extends CrudRepository<PlayerStatistics, Long> {

    Optional<PlayerStatistics> findPlayerStatisticsByPlayerId(Long player);

    @Query("SELECT ps.player FROM PlayerStatistics ps ORDER BY ps.wins DESC LIMIT :countLimit")
    Iterable<Player> findTopPlayersByWins(@Param("countLimit") Integer countLimit);

    @Query("SELECT ps.player FROM PlayerStatistics ps ORDER BY ps.losses DESC LIMIT :countLimit")
    Iterable<Player> findTopPlayersByLosses(@Param("countLimit") Integer countLimit);

    @Query("SELECT ps FROM PlayerStatistics ps WHERE ps.player.name = :playerName")
    Optional<PlayerStatistics> findPlayerStatisticsByPlayerName(@Param("playerName") String playerName);

}
