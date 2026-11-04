package hsd.inflab.dice.ui;

import hsd.inflab.dice.framework.DiceFactory;
import hsd.inflab.dice.framework.DiceResult;
import hsd.inflab.dice.framework.Shaker;
import hsd.inflab.dice.types.Dice;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.util.List;

/*
*
* DIESE KLASSE NICHT VERÄNDERN!
*
 */

public class DiceGameApp extends Application {
    private static Shaker shaker;
    private ComboBox<Class<? extends Dice>> diceTypeBox = new ComboBox<>();
    private VBox diceTypeGroup = new VBox(5, new Label("Würfeltyp"), diceTypeBox);
    private Spinner<Integer> sidesSpinner = new Spinner<>(4, 20, 6);
    private VBox sidesGroup = new VBox(5, new Label("Seitenzahl"), sidesSpinner);

    private Spinner<Integer> countSpinner = new Spinner<>(1, 20, 1);
    private VBox countGroup = new VBox(5, new Label("Anzahl"), countSpinner);

    private Button addButton = new Button("Hinzufügen");
    private Button resetButton = new Button("Zurücksetzen");

    private HBox controlBar = new HBox(10, diceTypeGroup, sidesGroup, countGroup, addButton, resetButton);

    private FlowPane diceArea = new FlowPane(10, 10);
    private ScrollPane diceScrollPane = new ScrollPane(diceArea);

    private Button rollButton = new Button("Würfeln");
    private CheckBox autoCheckBox = new CheckBox("Auto");
    private Timeline timeline;
    private Spinner<Integer> autoCycleTimeSpinner = new Spinner<>(1, 10, 2);
    private boolean autoRollRunning = false;

    private HBox footer = new HBox(10, rollButton, autoCheckBox, autoCycleTimeSpinner);

    public static void setShaker(Shaker shaker) {
        DiceGameApp.shaker = shaker;
    }

    @Override
    public void start(Stage stage) {
        diceTypeBox.getItems().addAll(DiceFactory.discoverDiceTypes());
        addButton.setDisable(diceTypeBox.getItems().isEmpty());
        diceTypeBox.setConverter(new StringConverter<Class<? extends Dice>>() {
            @Override
            public String toString(Class<? extends Dice> type) {
                if (type == null) {
                    return "";
                }
                return type.getSimpleName();
            }

            @Override
            public Class<? extends Dice> fromString(String string) {
                throw new UnsupportedOperationException();
            }
        });
        diceTypeBox.getSelectionModel().selectFirst();
        diceTypeBox.valueProperty().addListener((obs, oldValue, newValue) -> updateSidesSpinnerState());

        controlBar.setPadding(new Insets(10));
        controlBar.setAlignment(Pos.BOTTOM_CENTER);

        diceArea.setPadding(new Insets(10));
        diceArea.setAlignment(Pos.CENTER);

        footer.setPadding(new Insets(10));
        footer.setAlignment(Pos.CENTER);

        updateRollControlState();
        updateSidesSpinnerState();

        addButton.setOnAction(e -> {
            Class<? extends Dice> type = diceTypeBox.getValue();
            if (type == null) {
                return;
            }
            int sides = sidesSpinner.getValue();
            int count = countSpinner.getValue();
            for (int i = 0; i < count; i++) {
                Dice dice;
                if (DiceFactory.supportsSides(type)) {
                    dice = DiceFactory.create(type, sides);
                } else {
                    dice = DiceFactory.create(type);
                }
                shaker.addDice(dice);
            }
            refreshDiceArea(diceArea);
            updateRollControlState();
        });

        resetButton.setOnAction(e -> {
            shaker.clear();
            refreshDiceArea(diceArea);
            updateRollControlState();
            if (autoRollRunning)
                toggleAutoRollMode();
        });

        rollButton.setOnAction(e -> {
            if(autoCheckBox.isSelected()) {
                toggleAutoRollMode();
            }
            else {
                performRoll();
            }
        });

        //if checkbox is unselected during autorunning, stop autorunning.
        autoCheckBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
                    if (!isNowSelected && autoRollRunning) {
                        toggleAutoRollMode();
                    }
                });

        diceScrollPane.setFitToWidth(true);

        BorderPane root = new BorderPane();
        root.setTop(controlBar);
        root.setCenter(diceScrollPane);
        root.setBottom(footer);

        Scene scene = new Scene(root, 800, 400);
        stage.setScene(scene);
        stage.setTitle("Würfelspiel");
        stage.show();
    }

    private void refreshDiceArea(FlowPane diceArea) {
        diceArea.getChildren().setAll(shaker.getDices().stream().map(DiceView::new).toList());
    }

    private void updateRollControlState() {
        rollButton.setDisable(shaker.isEmpty());
        autoCheckBox.setDisable(shaker.isEmpty());
        autoCycleTimeSpinner.setDisable(shaker.isEmpty());
    }

    private void updateSidesSpinnerState() {
        Class<? extends Dice> type = diceTypeBox.getValue();
        boolean sidesRelevant = type != null && DiceFactory.supportsSides(type);
        sidesSpinner.setDisable(!sidesRelevant);
    }

    private void toggleAutoRollMode() {
        if (!autoRollRunning) {
            performRoll();          //only runs once so the user immediately gets a UI response
            int intervalSeconds = autoCycleTimeSpinner.getValue();
            timeline = new Timeline( new KeyFrame(Duration.seconds(intervalSeconds), f -> performRoll()));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            autoRollRunning = true;
        }
        else {
            timeline.stop();
            autoRollRunning = false;
        }
    }

    private void performRoll() {
        List<DiceResult> results = shaker.throwDice();
        for (DiceResult r : results) {
            for (Node n : diceArea.getChildren()) {
                DiceView d = (DiceView) n;
                if (d.getDice() == r.dice()) {
                    d.playRollAnimation(r.result());
                }
            }
        }
    }
}
