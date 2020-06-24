package com.mudu.golangide;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import org.slf4j.LoggerFactory;

public class Main extends Application {
    private BorderPane outerRoot;
    private BorderPane root;
    private static Main instance;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Main.class);


    @Override
    public void start(Stage primaryStage) throws Exception {
        // build Menu Bar
        outerRoot = new BorderPane();
        outerRoot.setTop(buildMenuBar());
        outerRoot.setCenter(root);
        rebuildUI(true, false, 0, null);
        Scene scene = new Scene(outerRoot, 1024, 768);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Modena");
        primaryStage.show(); // see SamplePage.java:110 comment on how test fails without having stage shown
    }

    public static void main(String[] args) {
        launch(args);
    }

    private MenuBar buildMenuBar() {
        MenuBar menuBar = new MenuBar();
        menuBar.setUseSystemMenuBar(true);
        Menu fontSizeMenu = new Menu("Font");
        ToggleGroup tg = new ToggleGroup();
        fontSizeMenu.getItems().addAll(
                buildFontRadioMenuItem("System Default", null, 0, tg),
                buildFontRadioMenuItem("Mac (13px)", "Lucida Grande", 13, tg),
                buildFontRadioMenuItem("Windows 100% (12px)", "Segoe UI", 12, tg),
                buildFontRadioMenuItem("Windows 125% (15px)", "Segoe UI", 15, tg),
                buildFontRadioMenuItem("Windows 150% (18px)", "Segoe UI", 18, tg),
                buildFontRadioMenuItem("Linux (13px)", "Lucida Sans", 13, tg),
                buildFontRadioMenuItem("Embedded Touch (22px)", "Arial", 22, tg),
                buildFontRadioMenuItem("Embedded Small (9px)", "Arial", 9, tg)
        );
        menuBar.getMenus().add(fontSizeMenu);
        return menuBar;
    }

    public RadioMenuItem buildFontRadioMenuItem(String name, final String in_fontName, final int in_fontSize, ToggleGroup tg) {
        RadioMenuItem rmItem = new RadioMenuItem(name);
        rmItem.setStyle("-fx-font: " + in_fontSize + "px \"" + in_fontName + "\";");
        rmItem.setToggleGroup(tg);
        return rmItem;
    }

    private SamplePageNavigation samplePageNavigation;
    private SamplePage samplePage;
    private ToggleButton modenaButton, retinaButton, rtlButton, embeddedPerformanceButton;
    private TabPane contentTabs;

    private void rebuildUI(boolean modena, boolean retina, int selectedTab, final SamplePage.Section scrolledSection) {
        try {
            if (root == null) {
                root = new BorderPane();
                outerRoot.setCenter(root);
            } else {
                // clear out old UI
                root.setTop(null);
                root.setCenter(null);
            }
            // Create sample page and nav
            samplePageNavigation = new SamplePageNavigation();
            samplePage = samplePageNavigation.getSamplePage();
            // Create Content Area
            contentTabs = new TabPane();
            Tab tab1 = new Tab("All Controls");
            tab1.setContent(samplePageNavigation);

            Tab tab2 = new Tab("editPage");
            tab2.setContent(new EditPage());

            contentTabs.getTabs().addAll(tab2, tab1);
            contentTabs.getSelectionModel().select(selectedTab);

            // Create Toolbar
            retinaButton = new ToggleButton("@2x");
            retinaButton.setSelected(retina);
            retinaButton.setOnAction(event -> {
                ToggleButton btn = (ToggleButton) event.getSource();
            });
            ToggleGroup themesToggleGroup = new ToggleGroup();
            modenaButton = new ToggleButton("Modena");
            modenaButton.setToggleGroup(themesToggleGroup);
            modenaButton.setSelected(modena);
            modenaButton.getStyleClass().add("left-pill:");
            ToggleButton caspianButton = new ToggleButton("Caspian");
            caspianButton.setToggleGroup(themesToggleGroup);
            caspianButton.setSelected(!modena);
            caspianButton.getStyleClass().add("right-pill");

            rtlButton = new ToggleButton("RTL");
            rtlButton.setOnAction(event -> root.setNodeOrientation(rtlButton.isSelected() ?
                    NodeOrientation.RIGHT_TO_LEFT : NodeOrientation.LEFT_TO_RIGHT));

            embeddedPerformanceButton = new ToggleButton("EP");
            embeddedPerformanceButton.setTooltip(new Tooltip("Apply Embedded Performance extra stylesheet"));
            embeddedPerformanceButton.setOnAction(event -> {
            });

            Button saveButton = new Button("Save...");

            Button restartButton = new Button("Restart");

            ToolBar toolBar = new ToolBar(new HBox(modenaButton, caspianButton), rtlButton,
                    embeddedPerformanceButton, new Separator(), retinaButton,
                    new Label("Base:"),
                    new Label("Background:"),
                    new Label("Accent:"),
                    new Separator(), saveButton, restartButton
            );
            toolBar.setId("TestAppToolbar");
            // Create content group used for scaleing @2x
            final Pane contentGroup = new Pane() {
                @Override
                protected void layoutChildren() {
                    double scale = contentTabs.getTransforms().isEmpty() ? 1 : ((Scale) contentTabs.getTransforms().get(0)).getX();
                    contentTabs.resizeRelocate(0, 0, getWidth() / scale, getHeight() / scale);
                }
            };
            contentGroup.getChildren().add(contentTabs);
            // populate root
            root.setTop(toolBar);
            root.setCenter(contentGroup);

            samplePage.getStyleClass().add("needs-background");
            // apply retina scale
            if (retina) {
                contentTabs.getTransforms().setAll(new Scale(2, 2));
            }
            root.applyCss();
            // update state
            Platform.runLater(() -> {
                // move focus out of the way
                modenaButton.requestFocus();
                samplePageNavigation.setCurrentSection(scrolledSection);
            });
        } catch (Exception ex) {
            logger.error("{}", ex);
        }

    }


}