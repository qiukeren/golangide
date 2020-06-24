package com.mudu.golangide;

import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static com.mudu.golangide.SamplePageChartHelper.*;
import static com.mudu.golangide.SamplePageHelpers.*;
//import static com.mudu.golangide.SamplePageTableHelper.createTableView;
//import static com.mudu.golangide.SamplePageTableHelper.createTableViewSimple;
//import static com.mudu.golangide.SamplePageTreeHelper.createTreeView;
//import static com.mudu.golangide.SamplePageTreeTableHelper.createTreeTableView;

public class SamplePage extends GridPane {
    private int rowIndex = 0;
    private Map<String, Node> content = new HashMap<>();
    private List<Section> sections = new ArrayList<>();

    public SamplePage() {
        setVgap(25);
        setHgap(15);
        setPadding(new Insets(15));
        newSection("Label:",
                new Label("Label"),
                withState(new Label("Disabled"), "disabled"));
        newSection("Button:",
                new Button("Button"),
                withState(new Button("Hover"), "hover"),
                withState(new Button("Armed"), "armed"),
                withState(new Button("Focused"), "focused"),
                withState(new Button("Focused & Hover"), "focused, hover"),
                withState(new Button("Focused & Armed"), "focused, armed"),
                withState(new Button("Disabled"), "disabled"));
        Button defaultButton = new Button("Button");
        defaultButton.setDefaultButton(true);
        newSection("Default Button:",
                defaultButton,
                withState(new Button("Hover"), "default, hover"),
                withState(new Button("Armed"), "default, armed"),
                withState(new Button("Focused"), "default, focused"),
                withState(new Button("Focused & Hover"), "default, focused, hover"),
                withState(new Button("Focused & Armed"), "default, focused, armed"),
                withState(new Button("Disabled"), "default, disabled"));
        Button b1 = new Button("Button");
        b1.setStyle("-fx-base: #f3622d;");
        Button b2 = new Button("Button");
        b2.setStyle("-fx-base: #fba71b;");
        Button b3 = new Button("Button");
        b3.setStyle("-fx-base: #57b757;");
        Button b4 = new Button("Button");
        b4.setStyle("-fx-base: #41a9c9;");
        Button b5 = new Button("Button");
        b5.setStyle("-fx-base: #888;");
        newSection("Nice Colors:", b1, b2, b3, b4, b5);
        newSection("Greys:", 0,
                createGreyButton(0),
                createGreyButton(0.1),
                createGreyButton(0.2),
                createGreyButton(0.3),
                createGreyButton(0.4),
                createGreyButton(0.5),
                createGreyButton(0.6),
                createGreyButton(0.7),
                createGreyButton(0.8),
                createGreyButton(0.9),
                createGreyButton(1));
        ToggleGroup tg1 = new ToggleGroup();
        ToggleGroup tg2 = new ToggleGroup();
        ToggleGroup tg3 = new ToggleGroup();
        ToggleGroup tg4 = new ToggleGroup();

        ToggleButton left1 = new ToggleButton("Left");
        left1.getStyleClass().add("left-pill");
        left1.setToggleGroup(tg1);
        ToggleButton center1 = new ToggleButton("Center");
        center1.getStyleClass().add("center-pill");
        center1.setToggleGroup(tg1);
        ToggleButton right1 = new ToggleButton("Right");
        right1.getStyleClass().add("right-pill");
        right1.setToggleGroup(tg1);

        ToggleButton left2 = new ToggleButton("Left");
        left2.getStyleClass().add("left-pill");
        left2.setToggleGroup(tg2);
        left2.setSelected(true);
        ToggleButton center2 = new ToggleButton("Center");
        center2.getStyleClass().add("center-pill");
        center2.setToggleGroup(tg2);
        ToggleButton right2 = new ToggleButton("Right");
        right2.getStyleClass().add("right-pill");
        right2.setToggleGroup(tg2);

        ToggleButton left3 = new ToggleButton("Left");
        left3.getStyleClass().add("left-pill");
        left3.setToggleGroup(tg3);
        ToggleButton center3 = new ToggleButton("Center");
        center3.getStyleClass().add("center-pill");
        center3.setToggleGroup(tg3);
        center3.setSelected(true);
        ToggleButton right3 = new ToggleButton("Right");
        right3.getStyleClass().add("right-pill");
        right3.setToggleGroup(tg3);

        ToggleButton left4 = new ToggleButton("Left");
        left4.getStyleClass().add("left-pill");
        left4.setToggleGroup(tg4);
        ToggleButton center4 = new ToggleButton("Center");
        center4.getStyleClass().add("center-pill");
        center4.setToggleGroup(tg4);
        ToggleButton right4 = new ToggleButton("Right");
        right4.getStyleClass().add("right-pill");
        right4.setToggleGroup(tg4);
        right4.setSelected(true);

        newSection("Pill Toggle\nButtons:",
                new HBox(left1, center1, right1),
                new HBox(left2, center2, right2),
                new HBox(left3, center3, right3),
                new HBox(left4, center4, right4)
        );

        ToggleGroup tg5 = new ToggleGroup();
        ToggleGroup tg6 = new ToggleGroup();
        ToggleGroup tg7 = new ToggleGroup();
        ToggleGroup tg8 = new ToggleGroup();

        ToggleButton left5 = new ToggleButton("#");
        left5.getStyleClass().add("left-pill");
        left5.setToggleGroup(tg5);
        ToggleButton center5 = new ToggleButton("#");
        center5.getStyleClass().add("center-pill");
        center5.setToggleGroup(tg5);
        ToggleButton right5 = new ToggleButton("#");
        right5.getStyleClass().add("right-pill");
        right5.setToggleGroup(tg5);

        ToggleButton left5_1 = new ToggleButton("L");
        left5_1.getStyleClass().add("left-pill");
        left5_1.setToggleGroup(tg5);
        withState(left5_1, "focused");
        ToggleButton center5_1 = new ToggleButton("C");
        center5_1.getStyleClass().add("center-pill");
        center5_1.setToggleGroup(tg5);
        ToggleButton right5_1 = new ToggleButton("R");
        right5_1.getStyleClass().add("right-pill");
        right5_1.setToggleGroup(tg5);

        ToggleButton left5_2 = new ToggleButton("L");
        left5_2.getStyleClass().add("left-pill");
        left5_2.setToggleGroup(tg5);
        ToggleButton center5_2 = new ToggleButton("C");
        center5_2.getStyleClass().add("center-pill");
        center5_2.setToggleGroup(tg5);
        withState(center5_2, "focused");
        ToggleButton right5_2 = new ToggleButton("R");
        right5_2.getStyleClass().add("right-pill");
        right5_2.setToggleGroup(tg5);

        ToggleButton left5_3 = new ToggleButton("L");
        left5_3.getStyleClass().add("left-pill");
        left5_3.setToggleGroup(tg5);
        ToggleButton center5_3 = new ToggleButton("C");
        center5_3.getStyleClass().add("center-pill");
        center5_3.setToggleGroup(tg5);
        ToggleButton right5_3 = new ToggleButton("R");
        right5_3.getStyleClass().add("right-pill");
        right5_3.setToggleGroup(tg5);
        withState(right5_3, "focused");

        ToggleButton left6 = new ToggleButton("L");
        left6.getStyleClass().add("left-pill");
        left6.setToggleGroup(tg6);
        left6.setSelected(true);
        withState(left6, "focused");
        ToggleButton center6 = new ToggleButton("C");
        center6.getStyleClass().add("center-pill");
        center6.setToggleGroup(tg6);
        ToggleButton right6 = new ToggleButton("R");
        right6.getStyleClass().add("right-pill");
        right6.setToggleGroup(tg6);

        ToggleButton left7 = new ToggleButton("L");
        left7.getStyleClass().add("left-pill");
        left7.setToggleGroup(tg7);
        ToggleButton center7 = new ToggleButton("C");
        center7.getStyleClass().add("center-pill");
        center7.setToggleGroup(tg7);
        center7.setSelected(true);
        withState(center7, "focused");
        ToggleButton right7 = new ToggleButton("R");
        right7.getStyleClass().add("right-pill");
        right7.setToggleGroup(tg7);

        ToggleButton left8 = new ToggleButton("L");
        left8.getStyleClass().add("left-pill");
        left8.setToggleGroup(tg8);
        ToggleButton center8 = new ToggleButton("C");
        center8.getStyleClass().add("center-pill");
        center8.setToggleGroup(tg8);
        ToggleButton right8 = new ToggleButton("R");
        right8.getStyleClass().add("right-pill");
        right8.setToggleGroup(tg8);
        right8.setSelected(true);
        withState(right8, "focused");

        newSection("Pill Toggle\nButtons\nFocused:",
                new HBox(left5, center5, right5),
                new HBox(left5_1, center5_1, right5_1),
                new HBox(left5_2, center5_2, right5_2),
                new HBox(left5_3, center5_3, right5_3),
                new HBox(left6, center6, right6),
                new HBox(left7, center7, right7),
                new HBox(left8, center8, right8)
        );
        newSection("ToggleButton:",
                new ToggleButton("Button"),
                withState(new ToggleButton("Hover"), "hover"),
                withState(new ToggleButton("Armed"), "armed"),
                withState(new ToggleButton("Focused"), "focused"),
                withState(new ToggleButton("Focused & Hover"), "focused, hover"),
                withState(new ToggleButton("Focused & Armed"), "focused, armed"),
                withState(new ToggleButton("Disabled"), "disabled"));
        newSection("ToggleButton Selected:",
                withState(new ToggleButton("Button"), "selected"),
                withState(new ToggleButton("Hover"), "selected, hover"),
                withState(new ToggleButton("Armed"), "selected, armed"),
                withState(new ToggleButton("Focused"), "selected, focused"),
                withState(new ToggleButton("Focused & Hover"), "selected, focused, hover"),
                withState(new ToggleButton("Focused & Armed"), "selected, focused, armed"),
                withState(new ToggleButton("Disabled"), "selected, disabled"));
        newSection("CheckBox:",
                new CheckBox("CheckBox"),
                withState(new CheckBox("Hover"), "hover"),
                withState(new CheckBox("Armed"), "armed"),
                withState(new CheckBox("Focused"), "focused"),
                withState(new CheckBox("Focused & Hover"), "focused, hover"),
                withState(new CheckBox("Focused & Armed"), "focused, armed"),
                withState(new CheckBox("Disabled"), "disabled"));
        newSection("CheckBox Selected:",
                withState(new CheckBox("CheckBox"), "selected"),
                withState(new CheckBox("Hover"), "selected, hover"),
                withState(new CheckBox("Armed"), "selected, armed"),
                withState(new CheckBox("Focused"), "selected, focused"),
                withState(new CheckBox("Focused & Hover"), "selected, focused, hover"),
                withState(new CheckBox("Focused & Armed"), "selected, focused, armed"),
                withState(new CheckBox("Disabled"), "selected, disabled"));

        CheckBox checkB = new CheckBox("CheckBox");
        checkB.setSelected(true);
        checkB.setIndeterminate(true);
        checkB.setAllowIndeterminate(true);
        newSection("CheckBox\nIndeterminate:",
                checkB,
                withState(new CheckBox("Hover"), "indeterminate, selected, hover"),
                withState(new CheckBox("Armed"), "indeterminate, selected, armed"),
                withState(new CheckBox("Focused"), "indeterminate, selected, focused"),
                withState(new CheckBox("Focused & Hover"), "indeterminate, selected, focused, hover"),
                withState(new CheckBox("Focused & Armed"), "indeterminate, selected, focused, armed"),
                withState(new CheckBox("Disabled"), "indeterminate, selected, disabled"));
        newSection("RadioButton:",
                new RadioButton("RadioButton"),
                withState(new RadioButton("Hover"), "hover"),
                withState(new RadioButton("Armed"), "armed"),
                withState(new RadioButton("Focused"), "focused"),
                withState(new RadioButton("Focused & Hover"), "focused, hover"),
                withState(new RadioButton("Focused & Armed"), "focused, armed"),
                withState(new RadioButton("Disabled"), "disabled"));
        newSection("RadioButton\nSelected:",
                withState(new RadioButton("RadioButton"), "selected"),
                withState(new RadioButton("Hover"), "selected, hover"),
                withState(new RadioButton("Armed"), "selected, armed"),
                withState(new RadioButton("Focused"), "selected, focused"),
                withState(new RadioButton("Focused & Hover"), "selected, focused, hover"),
                withState(new RadioButton("Focused & Armed"), "selected, focused, armed"),
                withState(new RadioButton("Disabled"), "selected, disabled"));
        newSection("HyperLink:",
                new Hyperlink("Hyperlink"),
                withState(new Hyperlink("Visited"), "visited"),
                withState(new Hyperlink("Hover"), "hover"),
                withState(new Hyperlink("Armed"), "armed"),
                withState(new Hyperlink("Focused"), "focused"),
                withState(new Hyperlink("F & Visited"), "focused, visited"),
                withState(new Hyperlink("F & Hover"), "focused, hover"),
                withState(new Hyperlink("F & Armed"), "focused, armed"),
                withState(new Hyperlink("Disabled"), "disabled"));
        ObservableList<String> choiceBoxLongList = sampleItems(200);
        choiceBoxLongList.add(100, "Long List");
        ChoiceBox<String> cb1 = new ChoiceBox<String>(sampleItems());
        cb1.setValue("Item A");
        ChoiceBox<String> cb2 = new ChoiceBox<String>(choiceBoxLongList);
        cb2.setValue("Long List");
        ChoiceBox<String> cb3 = new ChoiceBox<String>(sampleItems());
        cb3.setValue("Item B");
        ChoiceBox<String> cb4 = new ChoiceBox<String>(sampleItems());
        cb4.setValue("Item B");
        ChoiceBox<String> cb5 = new ChoiceBox<String>(sampleItems());
        cb5.setValue("Item B");
        ChoiceBox<String> cb6 = new ChoiceBox<String>(sampleItems());
        cb6.setValue("Item C");
        cb6.setDisable(true);
        newSection(
                "ChoiceBox:", cb1, cb2,
                withState(cb3, "hover"),
                withState(cb4, "showing"),
                withState(cb5, "focused"),
                cb6);
        ChoiceBox<String> c1 = new ChoiceBox<String>(sampleItems());
        c1.setValue("Item A");
        ChoiceBox<String> c2 = new ChoiceBox<String>(choiceBoxLongList);
        c2.setValue("Long List");
        ChoiceBox<String> c3 = new ChoiceBox<String>(sampleItems());
        c3.setValue("Item B");
        ChoiceBox<String> c4 = new ChoiceBox<String>(sampleItems());
        c4.setValue("Item B");
        ChoiceBox<String> c5 = new ChoiceBox<String>(sampleItems());
        c5.setValue("Item B");
        ChoiceBox<String> c6 = new ChoiceBox<String>(sampleItems());
        c6.setValue("Item C");
        c6.setDisable(true);
        newSection(
                "ChoiceBox:", c1, c2,
                withState(c3, "hover"),
                withState(c4, "showing"),
                withState(c5, "focused"),
                c6);
    }

    public List<Section> getSections() {
        return sections;
    }

    private void newSection(String name, Node... children) {
        newSection(name, 10, children);
    }

    private void newSection(String name, int spacing, Node... children) {
        Label sectionLabel = new Label(name);
        sectionLabel.getStyleClass().add("section-label");
        sectionLabel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox box = new HBox(spacing);
        box.getStyleClass().add("section-border");
        box.getChildren().addAll(children);
        setConstraints(sectionLabel, 0, rowIndex, 1, 1, HPos.CENTER, VPos.CENTER, Priority.ALWAYS, Priority.ALWAYS);
        setConstraints(box, 1, rowIndex++);
        getChildren().addAll(sectionLabel, box);
        sections.add(new Section(name, sectionLabel, box));
        content.put(name, box);
    }

    public static class Section {
        public final String name;
        public final Label label;
        public final Node box;

        public Section(String name, Label label, Node box) {
            this.name = name;
            this.label = label;
            this.box = box;
        }

        @Override
        public String toString() {
            return name.replaceAll("\n", " ");
        }
    }
}


