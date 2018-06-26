package bartosz.szablewski.middleAges.repository;

import bartosz.szablewski.middleAges.domain.Knight;
import bartosz.szablewski.middleAges.domain.Player;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnightRepository extends JpaRepository<Knight, Long> {

    List<Knight> findByPlayer(Player player);

}
