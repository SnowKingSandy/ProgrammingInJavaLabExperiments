import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RestaurantManagementApp extends Application {
    private TableView<Restaurant> restaurantTable;
    private TableView<MenuItem> menuItemTable;
    
    private ObservableList<Restaurant> restaurantData = FXCollections.observableArrayList();
    private ObservableList<MenuItem> menuItemData = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Restaurant Management System");
        
        BorderPane root = new BorderPane();
        
        // Top section - Title
        Label titleLabel = new Label("Restaurant & Menu Item Management System (JDBC + JavaFX)");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold; -fx-padding: 10;");
        root.setTop(titleLabel);
        
        // Center section - Tab Pane for Restaurants and Menu Items
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        
        Tab restaurantTab = createRestaurantTab();
        Tab menuItemTab = createMenuItemTab();
        
        tabPane.getTabs().addAll(restaurantTab, menuItemTab);
        root.setCenter(tabPane);
        
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        loadData();
    }
    
    private Tab createRestaurantTab() {
        Tab tab = new Tab("Restaurants", new Label(""));
        tab.setClosable(false);
        
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        
        // Restaurant Table
        restaurantTable = new TableView<>();
        restaurantTable.setItems(restaurantData);
        restaurantTable.setPrefHeight(300);
        
        TableColumn<Restaurant, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getId()));
        
        TableColumn<Restaurant, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        nameCol.setPrefWidth(150);
        
        TableColumn<Restaurant, String> locationCol = new TableColumn<>("Location");
        locationCol.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getLocation()));
        locationCol.setPrefWidth(150);
        
        TableColumn<Restaurant, String> cuisineCol = new TableColumn<>("Cuisine");
        cuisineCol.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCuisine()));
        cuisineCol.setPrefWidth(150);
        
        restaurantTable.getColumns().addAll(idCol, nameCol, locationCol, cuisineCol);
        
        // Button Panel
        HBox buttonPanel = new HBox(10);
        buttonPanel.setPadding(new Insets(5));
        
        Button addBtn = new Button("Add Restaurant");
        addBtn.setStyle("-fx-font-size: 12; -fx-padding: 8;");
        addBtn.setOnAction(e -> showAddRestaurantDialog());
        
        Button updateBtn = new Button("Update Selected");
        updateBtn.setStyle("-fx-font-size: 12; -fx-padding: 8;");
        updateBtn.setOnAction(e -> showUpdateRestaurantDialog());
        
        Button deleteBtn = new Button("Delete Selected");
        deleteBtn.setStyle("-fx-font-size: 12; -fx-padding: 8; -fx-text-fill: white; -fx-base: #dc3545;");
        deleteBtn.setOnAction(e -> deleteSelectedRestaurant());
        
        Button refreshBtn = new Button("Refresh");
        refreshBtn.setStyle("-fx-font-size: 12; -fx-padding: 8;");
        refreshBtn.setOnAction(e -> loadRestaurants());
        
        buttonPanel.getChildren().addAll(addBtn, updateBtn, deleteBtn, refreshBtn);
        
        vbox.getChildren().addAll(
            new Label("--- Restaurant List ---"),
            restaurantTable,
            buttonPanel
        );
        
        tab.setContent(vbox);
        return tab;
    }
    
    private Tab createMenuItemTab() {
        Tab tab = new Tab("Menu Items", new Label(""));
        tab.setClosable(false);
        
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        
        // Menu Item Table
        menuItemTable = new TableView<>();
        menuItemTable.setItems(menuItemData);
        menuItemTable.setPrefHeight(300);
        
        TableColumn<MenuItem, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getId()));
        
        TableColumn<MenuItem, String> nameCol = new TableColumn<>("Item Name");
        nameCol.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        nameCol.setPrefWidth(150);
        
        TableColumn<MenuItem, Integer> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue().getPrice()));
        
        TableColumn<MenuItem, String> restaurantCol = new TableColumn<>("Restaurant");
        restaurantCol.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getRestaurantName()));
        restaurantCol.setPrefWidth(150);
        
        menuItemTable.getColumns().addAll(idCol, nameCol, priceCol, restaurantCol);
        
        // Button Panel
        HBox buttonPanel = new HBox(10);
        buttonPanel.setPadding(new Insets(5));
        
        Button addBtn = new Button("Add Menu Item");
        addBtn.setStyle("-fx-font-size: 12; -fx-padding: 8;");
        addBtn.setOnAction(e -> showAddMenuItemDialog());
        
        Button updateBtn = new Button("Update Selected");
        updateBtn.setStyle("-fx-font-size: 12; -fx-padding: 8;");
        updateBtn.setOnAction(e -> showUpdateMenuItemDialog());
        
        Button deleteBtn = new Button("Delete Selected");
        deleteBtn.setStyle("-fx-font-size: 12; -fx-padding: 8; -fx-text-fill: white; -fx-base: #dc3545;");
        deleteBtn.setOnAction(e -> deleteSelectedMenuItem());
        
        Button refreshBtn = new Button("Refresh");
        refreshBtn.setStyle("-fx-font-size: 12; -fx-padding: 8;");
        refreshBtn.setOnAction(e -> loadMenuItems());
        
        buttonPanel.getChildren().addAll(addBtn, updateBtn, deleteBtn, refreshBtn);
        
        vbox.getChildren().addAll(
            new Label("--- Menu Item List ---"),
            menuItemTable,
            buttonPanel
        );
        
        tab.setContent(vbox);
        return tab;
    }
    
    private void loadData() {
        loadRestaurants();
        loadMenuItems();
    }
    
    private void loadRestaurants() {
        restaurantData.clear();
        restaurantData.addAll(DatabaseManager.getAllRestaurants());
    }
    
    private void loadMenuItems() {
        menuItemData.clear();
        menuItemData.addAll(DatabaseManager.getAllMenuItems());
    }
    
    private void showAddRestaurantDialog() {
        Dialog<Restaurant> dialog = new Dialog<>();
        dialog.setTitle("Add Restaurant");
        dialog.setHeaderText("Enter Restaurant Details");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        TextField nameField = new TextField();
        nameField.setPromptText("Restaurant Name");
        TextField locationField = new TextField();
        locationField.setPromptText("Location");
        TextField cuisineField = new TextField();
        cuisineField.setPromptText("Cuisine Type");
        
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Location:"), 0, 1);
        grid.add(locationField, 1, 1);
        grid.add(new Label("Cuisine:"), 0, 2);
        grid.add(cuisineField, 1, 2);
        
        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                if (!nameField.getText().isEmpty() && !locationField.getText().isEmpty()) {
                    DatabaseManager.insertRestaurant(nameField.getText(), locationField.getText(), cuisineField.getText());
                    loadRestaurants();
                    showAlert("Success", "Restaurant added successfully!");
                    return new Restaurant(0, nameField.getText(), locationField.getText(), cuisineField.getText());
                } else {
                    showAlert("Error", "Please fill all fields!");
                }
            }
            return null;
        });
        
        dialog.showAndWait();
    }
    
    private void showUpdateRestaurantDialog() {
        Restaurant selected = restaurantTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Error", "Please select a restaurant to update!");
            return;
        }
        
        Dialog<Restaurant> dialog = new Dialog<>();
        dialog.setTitle("Update Restaurant");
        dialog.setHeaderText("Update Restaurant Details");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        TextField nameField = new TextField(selected.getName());
        TextField locationField = new TextField(selected.getLocation());
        TextField cuisineField = new TextField(selected.getCuisine());
        
        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Location:"), 0, 1);
        grid.add(locationField, 1, 1);
        grid.add(new Label("Cuisine:"), 0, 2);
        grid.add(cuisineField, 1, 2);
        
        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                DatabaseManager.updateRestaurant(selected.getId(), nameField.getText(), locationField.getText(), cuisineField.getText());
                loadRestaurants();
                showAlert("Success", "Restaurant updated successfully!");
            }
            return null;
        });
        
        dialog.showAndWait();
    }
    
    private void deleteSelectedRestaurant() {
        Restaurant selected = restaurantTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Error", "Please select a restaurant to delete!");
            return;
        }
        
        Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialog.setTitle("Confirm Delete");
        confirmDialog.setHeaderText("Delete Restaurant?");
        confirmDialog.setContentText("Are you sure you want to delete: " + selected.getName() + "?");
        
        if (confirmDialog.showAndWait().get() == ButtonType.OK) {
            DatabaseManager.deleteRestaurant(selected.getId());
            loadRestaurants();
            showAlert("Success", "Restaurant deleted successfully!");
        }
    }
    
    private void showAddMenuItemDialog() {
        Dialog<MenuItem> dialog = new Dialog<>();
        dialog.setTitle("Add Menu Item");
        dialog.setHeaderText("Enter Menu Item Details");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        TextField nameField = new TextField();
        nameField.setPromptText("Item Name");
        TextField priceField = new TextField();
        priceField.setPromptText("Price");
        
        ObservableList<String> restaurants = FXCollections.observableArrayList();
        for (Restaurant r : restaurantData) {
            restaurants.add(r.getId() + " - " + r.getName());
        }
        ComboBox<String> restaurantCombo = new ComboBox<>(restaurants);
        restaurantCombo.setPromptText("Select Restaurant");
        
        grid.add(new Label("Item Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Price:"), 0, 1);
        grid.add(priceField, 1, 1);
        grid.add(new Label("Restaurant:"), 0, 2);
        grid.add(restaurantCombo, 1, 2);
        
        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                if (!nameField.getText().isEmpty() && !priceField.getText().isEmpty() && restaurantCombo.getValue() != null) {
                    try {
                        int price = Integer.parseInt(priceField.getText());
                        String selected = restaurantCombo.getValue();
                        int restaurantId = Integer.parseInt(selected.split(" - ")[0]);
                        DatabaseManager.insertMenuItem(nameField.getText(), price, restaurantId);
                        loadMenuItems();
                        showAlert("Success", "Menu item added successfully!");
                    } catch (NumberFormatException e) {
                        showAlert("Error", "Please enter valid price!");
                    }
                } else {
                    showAlert("Error", "Please fill all fields!");
                }
            }
            return null;
        });
        
        dialog.showAndWait();
    }
    
    private void showUpdateMenuItemDialog() {
        MenuItem selected = menuItemTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Error", "Please select a menu item to update!");
            return;
        }
        
        Dialog<MenuItem> dialog = new Dialog<>();
        dialog.setTitle("Update Menu Item");
        dialog.setHeaderText("Update Menu Item Details");
        
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        
        TextField nameField = new TextField(selected.getName());
        TextField priceField = new TextField(String.valueOf(selected.getPrice()));
        
        grid.add(new Label("Item Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Price:"), 0, 1);
        grid.add(priceField, 1, 1);
        
        dialog.getDialogPane().setContent(grid);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == ButtonType.OK) {
                try {
                    int price = Integer.parseInt(priceField.getText());
                    DatabaseManager.updateMenuItem(selected.getId(), nameField.getText(), price);
                    loadMenuItems();
                    showAlert("Success", "Menu item updated successfully!");
                } catch (NumberFormatException e) {
                    showAlert("Error", "Please enter valid price!");
                }
            }
            return null;
        });
        
        dialog.showAndWait();
    }
    
    private void deleteSelectedMenuItem() {
        MenuItem selected = menuItemTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Error", "Please select a menu item to delete!");
            return;
        }
        
        Alert confirmDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmDialog.setTitle("Confirm Delete");
        confirmDialog.setHeaderText("Delete Menu Item?");
        confirmDialog.setContentText("Are you sure you want to delete: " + selected.getName() + "?");
        
        if (confirmDialog.showAndWait().get() == ButtonType.OK) {
            DatabaseManager.deleteMenuItem(selected.getId());
            loadMenuItems();
            showAlert("Success", "Menu item deleted successfully!");
        }
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
