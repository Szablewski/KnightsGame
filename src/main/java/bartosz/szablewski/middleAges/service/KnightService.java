package bartosz.szablewski.middleAges.service;

import bartosz.szablewski.middleAges.domain.Knight;
import bartosz.szablewski.middleAges.domain.Player;
import bartosz.szablewski.middleAges.repository.KnightRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnightService {

    @Autowired
    private KnightRepository knightRepository;

    public List<Knight> findPlayerKnight(Player player) {
        return knightRepository.findByPlayer(player);
    }

    public void saveKnight(Knight knight, Player player) {
        knightRepository.findByPlayer(player);
        knight.setPlayer(player);
        knightRepository.save(knight);
    }
    
    public void deleteKnight(Long id){
        knightRepository.delete(id);
    }
}
