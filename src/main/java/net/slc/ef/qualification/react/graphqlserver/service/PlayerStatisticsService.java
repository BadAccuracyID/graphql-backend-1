package net.slc.ef.qualification.react.graphqlserver.service;

import jakarta.transaction.Transactional;
import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatistics;
import net.slc.ef.qualification.react.graphqlserver.repository.PlayerRepository;
import net.slc.ef.qualification.react.graphqlserver.repository.PlayerStatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerStatisticsService {

    private final PlayerRepository playerRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;

    public PlayerStatisticsService(PlayerRepository playerRepository, PlayerStatisticsRepository playerStatisticsRepository) {
        this.playerRepository = playerRepository;
        this.playerStatisticsRepository = playerStatisticsRepository;
    }

    @Transactional
    public Iterable<PlayerStatistics> getAllPlayerStatistics() {
        return playerStatisticsRepository.findAll();
    }

    @Transactional
    public Iterable<Player> getTopPlayersByWins(Integer limit) {
        return playerStatisticsRepository.findTopPlayersByWins(limit);
    }

    @Transactional
    public Optional<PlayerStatistics> getPlayerStatistics(Long id) {
        return playerStatisticsRepository.findById(id);
    }

    @Transactional
    public Optional<PlayerStatistics> getPlayerStatisticsByPlayerId(Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isEmpty()) {
            return Optional.empty();
        }

        PlayerStatistics newStats = playerStatisticsRepository.findPlayerStatisticsByPlayerId(player.get().getId())
                .orElseGet(() -> {
                    PlayerStatistics playerStatistics = new PlayerStatistics();
                    playerStatistics.setPlayer(player.get());
                    return playerStatisticsRepository.save(playerStatistics);
                });

        return Optional.of(newStats);
    }

    @Transactional
    public Optional<PlayerStatistics> getPlayerStatisticsByPlayerName(String playerName) {
        return playerStatisticsRepository.findPlayerStatisticsByPlayerName(playerName);
    }


    @Transactional
    public PlayerStatistics updatePlayerStatistics(PlayerStatistics playerStatistics) {
        return playerStatisticsRepository.save(playerStatistics);
    }

}
