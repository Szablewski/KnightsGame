package bartosz.szablewski.middleAges;

import bartosz.szablewski.middleAges.domain.Player;
import bartosz.szablewski.middleAges.service.KnightService;
import bartosz.szablewski.middleAges.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutumnOfTheMiddleAgesApplication implements CommandLineRunner {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private KnightService knightService;

    public static void main(String[] args) {
        SpringApplication.run(AutumnOfTheMiddleAgesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Player player = new Player("szablewski@mail.com", "123456", "Bartek", "Szablewski");
        playerService.createPlayer(player);

        Player admin = new Player("admin@mail.pl", "123456", "admin", "admin");
        playerService.createAdmin(admin);

    }
}
