package vehicleshop.graphics;

import vehicleshop.jdbchandlers.Queries;
import vehicleshop.jdbchandlers.ScriptExecutor;
import vehicleshop.jdbchandlers.Updates;
import vehicleshop.model.Categories;
import vehicleshop.model.Collections;
import vehicleshop.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppController {

    @FXML
    private TableView<Product> table;

    @FXML
    private TableColumn<Product, Long> productIdColumn;

    @FXML
    private TableColumn<Product, String> categoryNameColumn;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Double> costColumn;

    @FXML
    private TableColumn<Product, String> maintainerColumn;

    @FXML
    private TableColumn<Product, String> characteristicsColumn;

    @FXML
    private TableColumn<Product, String> warehouseAddressColumn;

    @FXML
    private Button clearButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button removeButton;

    @FXML
    private CheckBox categoryNameSearchBtn;

    @FXML
    private TextField categorySearchPredicateField;

    @FXML
    private CheckBox costSearchBtn;

    @FXML
    private TextField costSearchPredicateField;

    @FXML
    private CheckBox gyroboardCategory;

    @FXML
    private CheckBox bikeCategory;

    @FXML
    private CheckBox motorbikeCategory;

    @FXML
    private CheckBox pickupCategory;

    @FXML
    private CheckBox sedanCategory;

    @FXML
    private CheckBox roverCategory;

    @FXML
    private CheckBox rollersCategory;

    @FXML
    private CheckBox hatchbackCategory;

    @FXML
    private CheckBox selectAllBtn;

    @FXML
    private Button getListButton;

    @FXML
    private Button loadDefaultDataButton;

    @FXML
    private Button searchButton;

    public static boolean confirm = false;

    private boolean categoryNameSearch = false;
    private boolean costSearch = false;

    @FXML
    void initialize() {

        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        categoryNameColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));
        maintainerColumn.setCellValueFactory(new PropertyValueFactory<>("maintainer"));
        characteristicsColumn.setCellValueFactory(new PropertyValueFactory<>("characteristics"));
        warehouseAddressColumn.setCellValueFactory(new PropertyValueFactory<>("addresses"));
        table.setItems(Collections.productsObservableList);

        table.setEditable(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        categoryNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        categoryNameColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setCategoryName(e.getNewValue());
                String newValue = e.getNewValue();
                Updates.updateCategoryName(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        productNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        productNameColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setProductName(e.getNewValue());
                String newValue = e.getNewValue();
                Updates.updateProductName(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        costColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        costColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setCost(e.getNewValue());
                Double newValue = e.getNewValue();
                Updates.updateCost(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        maintainerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        maintainerColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setMaintainer(e.getNewValue());
                String newValue = e.getNewValue();
                Updates.updateMaintainer(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        characteristicsColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        characteristicsColumn.setOnEditCommit(e -> {
            createConfirmWindow();
            if (confirm) {
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setCharacteristics(e.getNewValue());
                String newValue = e.getNewValue();
                Updates.updateCharacteristics(e.getTableView().getItems().get(e.getTablePosition().getRow()).getId(), newValue);
            } else {
                table.refresh();
            }
        });

        getListButton.setOnAction(actionEvent -> {
            List<String> categories = new ArrayList<>();

            if (roverCategory.isSelected()) {
                categories.add(Categories.ROVER_CATEGORY);
            }
            if (sedanCategory.isSelected()) {
                categories.add(Categories.SEDAN_CATEGORY);
            }
            if (pickupCategory.isSelected()) {
                categories.add(Categories.PICKUP_CATEGORY);
            }
            if (hatchbackCategory.isSelected()) {
                categories.add(Categories.HATCHBACK_CATEGORY);
            }
            if (bikeCategory.isSelected()) {
                categories.add(Categories.BIKE_CATEGORY);
            }
            if (motorbikeCategory.isSelected()) {
                categories.add(Categories.MOTORBIKE_CATEGORY);
            }
            if (gyroboardCategory.isSelected()) {
                categories.add(Categories.GYROBOARD_CATEGORY);
            }
            if (rollersCategory.isSelected()) {
                categories.add(Categories.ROLLERS_CATEGORY);
            }

            Collections.clearAll();
            Collections.addAll(Queries.getListByCriteria(categories));
        });

        selectAllBtn.setOnAction(actionEvent -> {
            if (!selectAllBtn.isSelected()) {
                roverCategory.setSelected(false);
                rollersCategory.setSelected(false);
                gyroboardCategory.setSelected(false);
                motorbikeCategory.setSelected(false);
                bikeCategory.setSelected(false);
                pickupCategory.setSelected(false);
                sedanCategory.setSelected(false);
                hatchbackCategory.setSelected(false);
            } else {
                roverCategory.setSelected(true);
                rollersCategory.setSelected(true);
                gyroboardCategory.setSelected(true);
                motorbikeCategory.setSelected(true);
                bikeCategory.setSelected(true);
                pickupCategory.setSelected(true);
                sedanCategory.setSelected(true);
                hatchbackCategory.setSelected(true);
            }
        });

        loadDefaultDataButton.setOnAction(actionEvent -> {
            try {
                ScriptExecutor.execute("/init.sql");
            } catch (Exception ignored) {

            }
        });

        clearButton.setOnAction(actionEvent -> {
            try {
                ScriptExecutor.execute("/truncate.sql");
            } catch (Exception ignored) {

            }
            createConfirmWindow();
            if (confirm) {
                Collections.clearAll();
            }
        });

        removeButton.setOnAction(actionEvent -> {
            ObservableList<Product> accountsSelected = table.getSelectionModel().getSelectedItems();
            if (accountsSelected.size() != 0) {
                ArrayList<Product> items = new ArrayList<>(table.getSelectionModel().getSelectedItems());
                List<Long> ids = new ArrayList<>();
                for (Product product : items) {
                    ids.add(product.getId());
                }
                createConfirmWindow();
                if (confirm) {
                    Updates.removeProducts(ids);
                    Collections.productsObservableList.removeAll(accountsSelected);
                    table.getSelectionModel().clearSelection();
                    Collections.productsList.removeAll(items);
                }
            }
        });

        resetButton.setOnAction(actionEvent -> {
            Collections.productsObservableList.clear();
            Collections.productsObservableList.addAll(Collections.productsList);
            categorySearchPredicateField.clear();
            categorySearchPredicateField.setDisable(true);
            costSearchPredicateField.clear();
            costSearchPredicateField.setDisable(true);
            categoryNameSearchBtn.setSelected(false);
            costSearchBtn.setSelected(false);
        });

        categoryNameSearchBtn.setOnAction(actionEvent -> {
            if (categoryNameSearchBtn.isSelected()) {
                categorySearchPredicateField.setDisable(false);
                categoryNameSearch = true;
            } else {
                categorySearchPredicateField.clear();
                categorySearchPredicateField.setDisable(true);
                categoryNameSearch = false;
            }

        });

        costSearchBtn.setOnAction(actionEvent -> {
            if (costSearchBtn.isSelected()) {
                costSearchPredicateField.setDisable(false);
                costSearch = true;
            } else {
                costSearchPredicateField.clear();
                costSearchPredicateField.setDisable(true);
                costSearch = false;
            }
        });

        searchButton.setOnAction(actionEvent -> {

            if (!categoryNameSearch && !costSearch) {
                Warning.showWarnWithHeaderText("No criteria selected");
            } else {
                ObservableList<Product> tempProductsObservableList = FXCollections.observableArrayList();
                ObservableList<Product> tempProductsObservableList1 = FXCollections.observableArrayList();
                ObservableList<Product> tempProductsObservableList2 = FXCollections.observableArrayList();

                tempProductsObservableList.addAll(Collections.productsObservableList);
                Collections.productsObservableList.clear();

                if (categoryNameSearch) {
                    tempProductsObservableList1.addAll(tempProductsObservableList.stream()
                            .filter(e -> e.getCategoryName().equalsIgnoreCase(categorySearchPredicateField.getText()))
                            .collect(Collectors.toList()));
                    tempProductsObservableList.clear();

                    if (costSearch) {
                        costSearchFilter(tempProductsObservableList1, tempProductsObservableList2);

                        tempProductsObservableList1.clear();
                        Collections.productsObservableList.addAll(tempProductsObservableList2);
                    } else {
                        Collections.productsObservableList.addAll(tempProductsObservableList1);
                    }

                } else if (costSearch) {
                    costSearchFilter(tempProductsObservableList, tempProductsObservableList1);
                    tempProductsObservableList.clear();
                    Collections.productsObservableList.addAll(tempProductsObservableList1);
                    System.out.println(Collections.productsObservableList);
                }
            }

        });


    }

    private void costSearchFilter(ObservableList<Product> tempProductsObservableList, ObservableList<Product> tempProductsObservableList1) {
        String[] arr = costSearchPredicateField.getText().split("-");
        Double start = Double.parseDouble(arr[0]);
        Double end = Double.parseDouble(arr[1]);
        tempProductsObservableList1.addAll(tempProductsObservableList.stream()
                .filter(e -> e.getCost() >= start && e.getCost() <= end)
                .collect(Collectors.toList()));
    }

    public static void createConfirmWindow() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AppController.class.getResource("/confirm.fxml"));
        loadFXML(loader);
    }

    static void loadFXML(FXMLLoader loader) {
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
    }


}