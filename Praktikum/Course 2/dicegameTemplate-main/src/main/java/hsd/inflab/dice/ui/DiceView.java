package hsd.inflab.dice.ui;

import hsd.inflab.dice.types.Dice;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Random;

/*
 *
 * DIESE KLASSE NICHT VERÄNDERN!
 *
 */

public class DiceView extends VBox {
    private static final Random RANDOM = new Random();

    private final Dice dice;
    private final Label valueLabel;
    private Label nameLabel;

    public DiceView(Dice dice) {
        this.dice = dice;

        nameLabel = new Label(dice.getName() + " ( " + dice.getSides() + " )");
        valueLabel = new Label("-");
        valueLabel.setStyle("-fx-font-size: 32px;");

        setAlignment(Pos.CENTER);
        setSpacing(5);
        setStyle("-fx-border-color: gray; -fx-padding: 10;");
        getChildren().addAll(nameLabel, valueLabel);
    }

    public Dice getDice() {
        return dice;
    }

    public void setValue(int value) {
        valueLabel.setText(String.valueOf(value));
    }

    public void playRollAnimation(int nextValue) {
        updateNameLabel();
        Timeline timeline = new Timeline();
        for (int i = 1; i <= 5; i++) {
            int flickerValue = RANDOM.nextInt(dice.getSides()) + 1;
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(i * 60), e -> valueLabel.setText(String.valueOf(flickerValue))));
        }
        timeline.setOnFinished(e -> setValue(nextValue));
        timeline.play();
    }

    private void updateNameLabel() {
        nameLabel.setText(dice.getName() + " ( " + dice.getSides() + " )");
    }
}
