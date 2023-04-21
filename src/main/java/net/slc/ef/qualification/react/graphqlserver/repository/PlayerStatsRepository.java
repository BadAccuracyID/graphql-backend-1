package net.slc.ef.qualification.react.graphqlserver.repository;

import net.slc.ef.qualification.react.graphqlserver.model.PlayerStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {

    Optional<PlayerStats> findByPlayerId(Long playerId);

    @Query("SELECT p FROM PlayerStats p ORDER BY p.wins DESC")
    Page<PlayerStats> findTopByOrderByWinsDesc(Pageable pageable);

    @Query("SELECT p FROM PlayerStats p ORDER BY p.losses DESC")
    Page<PlayerStats> findTopByOrderByLossesDesc(Pageable pageable);

    @Query("SELECT p FROM PlayerStats p ORDER BY p.kills DESC")
    Page<PlayerStats> findTopByOrderByKillsDesc(Pageable pageable);

    @Query("SELECT p FROM PlayerStats p ORDER BY p.deaths DESC")
    Page<PlayerStats> findTopByOrderByDeathsDesc(Pageable pageable);

    @Query("SELECT p FROM PlayerStats p ORDER BY p.assists DESC")
    Page<PlayerStats> findTopByOrderByAssistsDesc(Pageable pageable);

    @Query("SELECT p FROM PlayerStats p ORDER BY p.money DESC")
    Page<PlayerStats> findTopByOrderByMoneyDesc(Pageable pageable);

}
