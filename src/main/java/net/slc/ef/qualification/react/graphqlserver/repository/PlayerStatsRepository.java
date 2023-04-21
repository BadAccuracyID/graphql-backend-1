package net.slc.ef.qualification.react.graphqlserver.repository;

import net.slc.ef.qualification.react.graphqlserver.model.PlayerStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {

    Optional<PlayerStats> findByPlayerId(Long playerId);

    Page<PlayerStats> findTopByOrderByWinsDesc(Pageable pageable);

    Page<PlayerStats> findTopByOrderByLossesDesc(Pageable pageable);

    Page<PlayerStats> findTopByOrderByKillsDesc(Pageable pageable);

    Page<PlayerStats> findTopByOrderByDeathsDesc(Pageable pageable);

    Page<PlayerStats> findTopByOrderByAssistsDesc(Pageable pageable);

    Page<PlayerStats> findTopByOrderByMoneyDesc(Pageable pageable);

}
