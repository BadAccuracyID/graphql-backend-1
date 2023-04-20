package net.slc.ef.qualification.react.graphqlserver.service;

import jakarta.transaction.Transactional;
import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public Iterable<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Transactional
    public Optional<Player> getPlayer(Long id) {
        return playerRepository.findById(id);
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
