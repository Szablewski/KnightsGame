package bartosz.szablewski.middleAges.repository;

import bartosz.szablewski.middleAges.domain.Player;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, String> {

    Player findByEmail(String email);

    List<Player> findByEmailLike(String email);

}
