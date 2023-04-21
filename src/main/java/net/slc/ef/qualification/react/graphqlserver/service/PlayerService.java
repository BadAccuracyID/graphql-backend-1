package net.slc.ef.qualification.react.graphqlserver.service;

import jakarta.transaction.Transactional;
import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.model.PlayerStatistics;
import net.slc.ef.qualification.react.graphqlserver.repository.PlayerRepository;
import net.slc.ef.qualification.react.graphqlserver.repository.PlayerStatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerStatisticsRepository statisticsRepository;

    public PlayerService(PlayerRepository playerRepository, PlayerStatisticsRepository statisticsRepository) {
        this.playerRepository = playerRepository;
        this.statisticsRepository = statisticsRepository;
    }

    @Transactional
    public Iterable<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Transactional
    public Optional<Player> getPlayerById(Long id) {
        // retrieve player from database
        Player player = playerRepository.findById(id).orElse(null);
        if (player == null) {
            return Optional.empty();
        }

        // retrieve player statistics from database
        PlayerStatistics playerStatistics = statisticsRepository.findPlayerStatisticsByPlayerId(player.getId())
                .orElseGet(() -> {
                    PlayerStatistics statistics = new PlayerStatistics();
                    statistics.setPlayer(player);
                    return statisticsRepository.save(statistics);
                });
        player.setPlayerStatistics(playerStatistics); // add player statistics to player

        return Optional.of(player);
    }


    @Transactional
    public Player getPlayerByName(String name) {
        return playerRepository.findPlayerByName(name);
    }

    @Transactional
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Transactional
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Transactional
    public Long deletePlayer(Long id) {
        playerRepository.deleteById(id);
        return id;
    }

    @Transactional
    public String deletePlayerByName(String name) {
        playerRepository.deletePlayerByName(name);
        return name;
    }
}
