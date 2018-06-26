package bartosz.szablewski.middleAges.controller;

import bartosz.szablewski.middleAges.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {

    @Autowired
    public PlayerService playerService;

    @GetMapping("/playerList")
    public String findAllPlayers(Model model, @RequestParam(defaultValue = "") String email) {
        model.addAttribute("players", playerService.findByEmailLike(email));
        return "views/playerList";
    }
}
