/**
 * @author Amit Sharabi
 * 323784298
 */

import animations.AnimationRunner;
import gamearkanoid.GameLevel;
import gameobject.Velocity;
import interfaces.LevelInformation;
import levels.FirstLevel;
import levels.SecondLevel;
import levels.ThirdLevel;
import levels.FourthLevel;
import levels.GameFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create a game object, initializes and runs it.
 */
public class Ass6Game {

    /**
     * Main method.
     *
     * @param args is the program arguments
     */
    public static void main(String[] args) {
        boolean flag = false;
        AnimationRunner ar = new AnimationRunner();
        GameFlow gameFlow = new GameFlow(ar, ar.getGui().getKeyboardSensor());
        List<LevelInformation> levelInformationList = new ArrayList<>();
        System.out.println(10 + 20 + "hello");
        System.out.println("hello"+ 10 + 20);
        for (String arg : args) {
            switch (arg) {
                case "1":
                    levelInformationList.add(new FirstLevel());
                    flag = true;
                    break;
                case "2":
                    levelInformationList.add(new SecondLevel());
                    flag = true;
                    break;
                case "3":
                    levelInformationList.add(new ThirdLevel());
                    flag = true;
                    break;
                case "4":
                    levelInformationList.add(new FourthLevel());
                    flag = true;
                    break;
                default:
                    break;
            }
        }
        if (!flag) {
            levelInformationList.add(new FirstLevel());
            levelInformationList.add(new SecondLevel());
            levelInformationList.add(new ThirdLevel());
            levelInformationList.add(new FourthLevel());
        }
        gameFlow.runLevels(levelInformationList);
    }
}
