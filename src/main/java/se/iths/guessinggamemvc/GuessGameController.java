package se.iths.guessinggamemvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuessGameController {

@Autowired
private GameService gameService;

@GetMapping("/game")
    public String guessForm(Model m){
    m.addAttribute("guesses", "");
    return "guesspage";
}

@PostMapping("/game")
    public String guessNumber(@RequestParam int guessNo, Model m){
    m.addAttribute("guesses", gameService.getAnswer(guessNo));
    m.addAttribute("answers", gameService.getListOfAnswers());
    return "guesspage";
}


}
