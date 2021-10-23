package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import sample.Money;
import sample.Tower;
import sample.ActionListener;

public class MarketController implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;

//    @FXML
//    private Label testClickOn;

    @FXML
    private Label accountBalance;

    // testing FXML variable
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button tower1;

    @FXML
    private Button tower2;

    @FXML
    private Button tower3;

    @FXML
    private Button tower4;

    @FXML
    private Button tower5;

    @FXML
    private ImageView towerImg1;

    @FXML
    private ImageView towerImg2;

    @FXML
    private ImageView towerImg3;

    @FXML
    private ImageView towerImg4;

    @FXML
    private ImageView towerImg5;

    private boolean isClicked1;
    private boolean isClicked2;
    private boolean isClicked3;
    private boolean isClicked4;
    private boolean isClicked5;

    private List<Tower> towers = null;
    private ActionListener actionListener;
    private Tower clickedTower = null;
    private Money balance;


    private List<Tower> generateFiveTowers() {
        List<Tower> towers = new ArrayList<>();
        Tower tower;
        for (int i = 1; i <= 5; i++) {
            tower = new Tower();
            tower.setName("Sample" + i);
            tower.setPrice(250 + i);
            String urlImg = "/img/" + i + ".png";
            tower.setImgSrc(urlImg);
            towers.add(tower);
        }
        return towers;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.accountBalance.setText("200");
        try {
            if (this.towers == null) {
                this.towers = generateFiveTowers();
            }
            actionListener = new ActionListener() {
                @Override
                public void onClickListener(Tower tower) {
                    getClickedTower(tower);
                }
            };

            for (int i = 0; i < this.towers.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/tower.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                TowerController towerController = fxmlLoader.getController();
                towerController.setTowerInfo(towers.get(i), actionListener);
                grid.addRow(i, anchorPane);
                // set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);
                // set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);
                GridPane.setMargin(anchorPane, new Insets(5));

                // Changing the image when mouse hovering over it
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alert");
                alert.setContentText("Cannot go into debt");
                tower1.setOnMouseEntered(e -> {
                    if (clickedTower != null) {
                        towerImg1.setImage(new Image(clickedTower.getImgSrc()));
                    }
                });
                tower1.setOnMouseExited(e -> {
                    if (!isClicked1) {
                        towerImg1.setImage(new Image("/img/placeHolder.png"));
                    }
                });
                tower1.setOnMouseClicked(e -> {
                    if (this.balance.isValidTransaction(clickedTower.getPrice())) {
                        alert.showAndWait();
                    } else if (clickedTower != null) {
                        isClicked1 = true;
                        // set the image
                        towerImg1.setImage(new Image(clickedTower.getImgSrc()));
                        // subtract money
                        this.balance.subtractBalance(clickedTower.getPrice());
                        System.out.println(balance.getBalance());
                        this.clickedTower = null;
                        updateBalance();
                    }
                });

                tower2.setOnMouseEntered(e -> {
                    if (clickedTower != null) {
                        towerImg2.setImage(new Image(clickedTower.getImgSrc()));
                    }
                });
                tower2.setOnMouseExited(e -> {
                    if (!isClicked2) {
                        towerImg2.setImage(new Image("/img/placeHolder.png"));
                    }
                });
                tower2.setOnMouseClicked(e -> {
                    if (this.balance.isValidTransaction(clickedTower.getPrice())) {
                        alert.showAndWait();
                    } else if (clickedTower != null) {
                        isClicked2 = true;
                        // set the image
                        towerImg2.setImage(new Image(clickedTower.getImgSrc()));
                        // subtract money
                        this.balance.subtractBalance(clickedTower.getPrice());
                        System.out.println(balance.getBalance());
                        this.clickedTower = null;
                        updateBalance();
                    }
                });

                tower3.setOnMouseEntered(e -> {
                    if (clickedTower != null) {
                        towerImg3.setImage(new Image(clickedTower.getImgSrc()));
                    }
                });
                tower3.setOnMouseExited(e -> {
                    if (!isClicked3) {
                        towerImg3.setImage(new Image("/img/placeHolder.png"));
                    }
                });
                tower3.setOnMouseClicked(e -> {
                    if (this.balance.isValidTransaction(clickedTower.getPrice())) {
                        alert.showAndWait();
                    } else if (clickedTower != null) {
                        isClicked3 = true;
                        // set the image
                        towerImg3.setImage(new Image(clickedTower.getImgSrc()));
                        // subtract money
                        this.balance.subtractBalance(clickedTower.getPrice());
                        System.out.println(balance.getBalance());
                        this.clickedTower = null;
                        updateBalance();
                    }
                });

                tower4.setOnMouseEntered(e -> {
                    if (clickedTower != null) {
                        towerImg4.setImage(new Image(clickedTower.getImgSrc()));
                    }
                });
                tower4.setOnMouseExited(e -> {
                    if (!isClicked4) {
                        towerImg4.setImage(new Image("/img/placeHolder.png"));
                    }
                });
                tower4.setOnMouseClicked(e -> {
                    if (this.balance.isValidTransaction(clickedTower.getPrice())) {
                        alert.showAndWait();
                    } else if (clickedTower != null) {
                        isClicked4 = true;
                        // set the image
                        towerImg4.setImage(new Image(clickedTower.getImgSrc()));
                        // subtract money
                        this.balance.subtractBalance(clickedTower.getPrice());
                        System.out.println(balance.getBalance());
                        this.clickedTower = null;
                        updateBalance();
                    }
                });

                tower5.setOnMouseEntered(e -> {
                    if (clickedTower != null) {
                        towerImg5.setImage(new Image(clickedTower.getImgSrc()));
                    }
                });
                tower5.setOnMouseExited(e -> {
                    if (!isClicked5) {
                        towerImg5.setImage(new Image("/img/placeHolder.png"));
                    }
                });
                tower5.setOnMouseClicked(e -> {
                    if (this.balance.isValidTransaction(clickedTower.getPrice())) {
                        alert.showAndWait();
                    } else if (clickedTower != null) {
                        isClicked5 = true;
                        // set the image
                        towerImg5.setImage(new Image(clickedTower.getImgSrc()));
                        // subtract money
                        this.balance.subtractBalance(clickedTower.getPrice());
                        System.out.println(balance.getBalance());
                        this.clickedTower = null;
                        updateBalance();
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getClickedTower(Tower tower) {
        // only change the label name for now
//        testClickOn.setText(tower.getName());
        clickedTower = tower;
    }
    public void setValues(Money balance) {
        this.balance = balance;
        System.out.println(this.balance.getBalance());
        updateBalance();
    }
    public void setClickedOn1(boolean isClicked1){
        this.isClicked1 = true;

    }
    public void setClickedOn2(boolean isClicked2){
        this.isClicked2 = true;

    }
    public void setClickedOn3(boolean isClicked3){
        this.isClicked3 = true;

    }
    public void setClickedOn4(boolean isClicked4){
        this.isClicked4 = true;

    }
    public void setClickedOn5(boolean isClicked5){
        this.isClicked5 = true;

    }
    private void updateBalance() {
        String amount = String.valueOf((int) this.balance.getBalance());
        accountBalance.setText(amount);
    }
}
