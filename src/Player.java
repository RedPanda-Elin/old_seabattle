package l1_test4_seabattle.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by igor on 18.10.15.
 */
public class Player {
    private String name = "Player1";
    private int points = 100;
    public int shotCount = 0;

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = getInput("Ведите ваше имя:");
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getInput(String prompt) {
        String userInput = null;
        System.out.println(prompt);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        while (userInput == null) {
            try {
                userInput = bfr.readLine();
                if (userInput.length() == 0) userInput = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return userInput;
    }
}
