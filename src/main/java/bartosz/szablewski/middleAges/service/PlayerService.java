package bartosz.szablewski.middleAges.service;

import bartosz.szablewski.middleAges.domain.Role;
import bartosz.szablewski.middleAges.domain.Player;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import bartosz.szablewski.middleAges.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Player findByEmail(String email) {
        return playerRepository.findByEmail(email);
    }

    public void createPlayer(Player player) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        player.setPassword(encoder.encode(player.getPassword()));
        Role playerRole = new Role("USER");
        List<Role> roles = new ArrayList();
        roles.add(playerRole);
        player.setRoles(roles);
        playerRepository.save(player);
    }

    public void createAdmin(Player player) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        player.setPassword(encoder.encode(player.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList();
        roles.add(userRole);
        player.setRoles(roles);
        playerRepository.save(player);

    }

    public boolean isPlayerPresent(String email) {
        Player player = playerRepository.findByEmail(email);
        if (player != null) {
            return true;
        }
        return false;
    }
    
    public List<Player> findByEmailLike(String email) {
        return playerRepository.findByEmailLike("%" + email + "%");
    }
}
