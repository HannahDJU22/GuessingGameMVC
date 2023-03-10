package se.iths.guessinggamemvc;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@SessionScope
public class GameService {

    int secretNumber;
    List<String> listOfAnswers;

    public GameService() {
        newgame();
    }

    public void newgame(){
        Random randNo = new Random();
        secretNumber = randNo.nextInt(1, 101);
        listOfAnswers=new ArrayList<>();
    }

    public List<String> getListOfAnswers() {
        return listOfAnswers;
    }

    public String getAnswer(int guessNo) {
        if (guessNo < secretNumber) {
            listOfAnswers.add(guessNo + " is too low.");
            return " Try again";
        } else if (guessNo > secretNumber) {
            listOfAnswers.add(guessNo + " is too high.");
            return "Try again";
        } else {
            listOfAnswers.clear();
            newgame();
            return "YOU WIN! " + guessNo + " was CORRECT. Please play the game again.";
        }

    }
}
