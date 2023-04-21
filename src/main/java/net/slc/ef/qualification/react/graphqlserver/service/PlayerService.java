package net.slc.ef.qualification.react.graphqlserver.service;

import jakarta.transaction.Transactional;
import net.slc.ef.qualification.react.graphqlserver.model.Player;
import net.slc.ef.qualification.react.graphqlserver.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Optional<Player> getPlayerByName(String name) {
        return playerRepository.findByName(name);
    }

    @Transactional
    public Player addPlayer(String name) {
        Player player = new Player();
        player.setName(name);
        return playerRepository.save(player);
    }

    @Transactional
    public Player updatePlayer(Long id, String name) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with id: " + id));
        player.setName(name);
        return playerRepository.save(player);
    }

    @Transactional
    public Long removePlayer(Long id) {
        playerRepository.deleteById(id);
        return id;
    }

    @Transactional
    public Long removePlayerByName(String name) {
        Player player = playerRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Player not found with name: " + name));
        playerRepository.deleteById(player.getId());
        return player.getId();
    }
}
