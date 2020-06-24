package com.mudu.golangide;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mudu.golangide.SamplePageHelpers.*;

//import static com.mudu.golangide.SamplePageChartHelper.*;
//import static com.mudu.golangide.SamplePageTableHelper.createTableView;
//import static com.mudu.golangide.SamplePageTableHelper.createTableViewSimple;
//import static com.mudu.golangide.SamplePageTreeHelper.createTreeView;
//import static com.mudu.golangide.SamplePageTreeTableHelper.createTreeTableView;

public class EditPage extends GridPane {
    private int rowIndex = 0;
    private Map<String, Node> content = new HashMap<>();
    private List<Section> sections = new ArrayList<>();

    public EditPage() {
        setVgap(25);
        setHgap(15);
        setPadding(new Insets(15));

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


