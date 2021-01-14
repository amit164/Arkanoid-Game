package levels;

import animations.AnimationRunner;
import animations.EndScreen;
import animations.KeyPressStoppableAnimation;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import gamearkanoid.GameLevel;
import interfaces.LevelInformation;

import java.util.List;

/**
 * This class represent the game flow. This class is in charge of displaying the levels one after another.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;

    /**
     * Constructor function.
     *
     * @param ar is the animation runner
     * @param ks is the keyboard sensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
    }

    /**
     * @param levels is the levels to run
     */
    public void runLevels(List<LevelInformation> levels) {
        int score = 0;
        for (LevelInformation levelInfo : levels) {
            Sleeper sleeper = new Sleeper();
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, score);

            level.initialize();

            while (level.getBlocks().getValue() > 0 && level.getBalls().getValue() > 0) {
                level.run();
            }
            if (level.getBalls().getValue() == 0) {
                score = level.getScore().getValue();
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                        new EndScreen(this.keyboardSensor, false, score, this.animationRunner)));
                break;
            }
            score = level.getScore().getValue();
            sleeper.sleepFor(1000);
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                new EndScreen(this.keyboardSensor, true, score, this.animationRunner)));
    }
}
