package bartosz.szablewski.middleAges.controller;

import bartosz.szablewski.middleAges.domain.Knight;
import bartosz.szablewski.middleAges.domain.Player;
import bartosz.szablewski.middleAges.service.KnightService;
import bartosz.szablewski.middleAges.service.PlayerService;
import java.security.Principal;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KnightController {

    @Autowired
    public KnightService knightService;

    @Autowired
    public PlayerService playerService;

    @GetMapping("/findAll")
    public String getAllKnights(Model model, Principal principal) {
        String email = principal.getName();
        Player player = playerService.findByEmail(email);
        model.addAttribute("knights", knightService.findPlayerKnight(player));
        return "views/listKnight";
    }

    @GetMapping("/saveKnight")
    public String createKnight(Player player, Model model) {
        model.addAttribute("knight", new Knight());
        return "views/knightForm";
    }

    @PostMapping("/saveKnight")
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult, HttpSession session, Principal principal) {

        String emial = principal.getName();
        playerService.findByEmail(emial);

        if (bindingResult.hasErrors()) {
            System.out.println("There were errors");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            });
            return "views/knightForm";
        } else {
            Player player = playerService.findByEmail(emial);
            String email = (String) session.getAttribute("email");
            knightService.saveKnight(knight, player);
            return "redirect:/findAll";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteKnight(@PathVariable("id") Long id) {
        knightService.deleteKnight(id);
        return "redirect:/findAll";
    }

}
