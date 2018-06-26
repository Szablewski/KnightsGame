package bartosz.szablewski.middleAges.controller;

import bartosz.szablewski.middleAges.domain.Player;
import bartosz.szablewski.middleAges.service.PlayerService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("player", new Player());
        return "views/registerForm";
    }

    @PostMapping("/register")
    public String register(@Valid Player player, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if (playerService.isPlayerPresent(player.getEmail())) {
            model.addAttribute("exist", true);
            return "views/registerForm";
        }
        playerService.createPlayer(player);
        return "views/success";
    }
}
