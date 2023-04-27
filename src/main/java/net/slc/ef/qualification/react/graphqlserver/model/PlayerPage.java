package net.slc.ef.qualification.react.graphqlserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PlayerPage {
    private List<Player> items;
    private Long totalCount;
}
