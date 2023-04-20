package net.slc.ef.qualification.react.graphqlserver.queries;

import net.slc.ef.qualification.react.graphqlserver.objects.Player;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerQuery {

    @QueryMapping
    public Iterable<Player> players() {
        return List.of(
                new Player(1L, "John"),
                new Player(2L, "Jane"),
                new Player(3L, "Jack")
        );
    }

    @QueryMapping
    public Player player(@Argument Long id) {
        return new Player(id, "John");
    }
}
