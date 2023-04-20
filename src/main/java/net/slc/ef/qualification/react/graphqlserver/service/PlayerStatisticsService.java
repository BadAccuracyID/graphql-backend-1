package net.slc.ef.qualification.react.graphqlserver.service;

import jakarta.transaction.Transactional;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatistics;
import net.slc.ef.qualification.react.graphqlserver.repository.PlayerStatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerStatisticsService {

    private final PlayerStatisticsRepository playerStatisticsRepository;

    public PlayerStatisticsService(PlayerStatisticsRepository playerStatisticsRepository) {
        this.playerStatisticsRepository = playerStatisticsRepository;
    }

    @Transactional
    public Iterable<PlayerStatistics> getAllPlayerStatistics() {
        return playerStatisticsRepository.findAll();
    }

    @Transactional
    public Optional<PlayerStatistics> getPlayerStatistics(Long id) {
        return playerStatisticsRepository.findById(id);
    }

    @Transactional
    public Optional<PlayerStatistics> getPlayerStatisticsByPlayerId(Long playerId) {
        return playerStatisticsRepository.findPlayerStatisticsByPlayerId(playerId);
    }

    @Transactional
    public PlayerStatistics createPlayerStatistics(PlayerStatistics playerStatistics) {
        return playerStatisticsRepository.save(playerStatistics);
    }

    @Transactional
    public PlayerStatistics updatePlayerStatistics(PlayerStatistics playerStatistics) {
        return playerStatisticsRepository.save(playerStatistics);
    }

    @Transactional
    public void deletePlayerStatistics(Long id) {
        playerStatisticsRepository.deleteById(id);
    }
}
