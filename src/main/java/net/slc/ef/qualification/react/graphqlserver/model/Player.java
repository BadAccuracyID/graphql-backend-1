package net.slc.ef.qualification.react.graphqlserver.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "player")
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "motto", nullable = false)
    private String motto;

    @Column(name = "avatar", nullable = false)
    private String avatar;

    @Column(name = "instagram")
    private String instagram;

    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    private PlayerStats stats;

    public static PlayerBuilder builder() {
        return new PlayerBuilder();
    }

    public static class PlayerBuilder {
        private Long id;
        private String name;
        private String motto;
        private String avatar;
        private String instagram;
        private PlayerStats stats;

        public PlayerBuilder() {
        }

        public PlayerBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PlayerBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder motto(String motto) {
            this.motto = motto;
            return this;
        }

        public PlayerBuilder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public PlayerBuilder instagram(String instagram) {
            this.instagram = instagram;
            return this;
        }

        public PlayerBuilder stats(PlayerStats stats) {
            this.stats = stats;
            return this;
        }

        public Player build() {
            Player player = new Player();
            player.setId(id);
            player.setName(name);
            player.setMotto(motto);
            player.setAvatar(avatar);
            player.setInstagram(instagram);
            player.setStats(stats);
            return player;
        }
    }

}
