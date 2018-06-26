package bartosz.szablewski.middleAges.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Role {

    @Id
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<Player> players;

    public Role(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public Role(String name) {
        this.name = name;
    }
}
