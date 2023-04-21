package net.slc.ef.qualification.react.graphqlserver.service;

import jakarta.transaction.Transactional;
import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStats;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatsPage;
import net.slc.ef.qualification.react.graphqlserver.repository.PlayerRepository;
import net.slc.ef.qualification.react.graphqlserver.repository.PlayerStatsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerStatsService {

    private final PlayerRepository playerRepository;
    private final PlayerStatsRepository playerStatsRepository;

    public PlayerStatsService(PlayerRepository playerRepository, PlayerStatsRepository playerStatsRepository) {
        this.playerRepository = playerRepository;
        this.playerStatsRepository = playerStatsRepository;
    }

    public List<PlayerStats> getPlayerStats() {
        return playerStatsRepository.findAll();
    }

    public Optional<PlayerStats> getPlayerStatsById(Long id) {
        return playerStatsRepository.findById(id);
    }

    public Optional<PlayerStats> getPlayerStatsByPlayerId(Long playerId) {
        return playerStatsRepository.findByPlayerId(playerId);
    }

    public Optional<PlayerStats> getPlayerStatsByPlayerName(String playerName) {
        return playerRepository.findByName(playerName).map(Player::getStats);
    }

    @Transactional
    public PlayerStats updatePlayerStats(Long playerId, Integer wins, Integer losses, Integer kills, Integer deaths, Integer assists, Integer money) {
        PlayerStats stats = getOrCreatePlayerStats(playerId);

        if (wins != null) stats.setWins(wins);
        if (losses != null) stats.setLosses(losses);
        if (kills != null) stats.setKills(kills);
        if (deaths != null) stats.setDeaths(deaths);
        if (assists != null) stats.setAssists(assists);
        if (money != null) stats.setMoney(money);

        return playerStatsRepository.save(stats);
    }

    @Transactional
    public PlayerStats resetPlayerStats(Long playerId) {
        PlayerStats stats = getOrCreatePlayerStats(playerId);

        stats.setWins(0);
        stats.setLosses(0);
        stats.setKills(0);
        stats.setDeaths(0);
        stats.setAssists(0);
        stats.setMoney(0);

        return playerStatsRepository.save(stats);
    }

    public PlayerStatsPage getTopPlayersByWins(Integer pageNumber, Integer limit) {
        Page<PlayerStats> page = playerStatsRepository.findTopByOrderByWinsDesc(PageRequest.of(pageNumber, limit));
        return new PlayerStatsPage(page.getContent(), page.getTotalElements());
    }

    public PlayerStatsPage getTopPlayersByLosses(Integer pageNumber, Integer limit) {
        Page<PlayerStats> page = playerStatsRepository.findTopByOrderByLossesDesc(PageRequest.of(pageNumber, limit));
        return new PlayerStatsPage(page.getContent(), page.getTotalElements());
    }

    public PlayerStatsPage getTopPlayersByKills(Integer pageNumber, Integer limit) {
        Page<PlayerStats> page = playerStatsRepository.findTopByOrderByKillsDesc(PageRequest.of(pageNumber, limit));
        return new PlayerStatsPage(page.getContent(), page.getTotalElements());
    }

    public PlayerStatsPage getTopPlayersByDeaths(Integer pageNumber, Integer limit) {
        Page<PlayerStats> page = playerStatsRepository.findTopByOrderByDeathsDesc(PageRequest.of(pageNumber, limit));
        return new PlayerStatsPage(page.getContent(), page.getTotalElements());
    }

    public PlayerStatsPage getTopPlayersByAssists(Integer pageNumber, Integer limit) {
        Page<PlayerStats> page = playerStatsRepository.findTopByOrderByAssistsDesc(PageRequest.of(pageNumber, limit));
        return new PlayerStatsPage(page.getContent(), page.getTotalElements());
    }

    public PlayerStatsPage getTopPlayersByMoney(Integer pageNumber, Integer limit) {
        Page<PlayerStats> page = playerStatsRepository.findTopByOrderByMoneyDesc(PageRequest.of(pageNumber, limit));
        return new PlayerStatsPage(page.getContent(), page.getTotalElements());
    }

    private PlayerStats getOrCreatePlayerStats(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with id: " + playerId));

        PlayerStats stats = player.getStats();
        if (stats == null) {
            stats = new PlayerStats();
            stats.setPlayer(player);
            player.setStats(stats);
        }

        return stats;
    }
}
