package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class InventoryController {

	@FXML
	private GridPane gridInventory;
	@FXML
	private Label lbOpenList;

	@FXML
	void openList(MouseEvent event) {
		Stage stage = null;
		Parent myNewScene = null;
		stage = (Stage) lbOpenList.getScene().getWindow();
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("List.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(myNewScene);
		stage.setScene(scene);
		stage.setTitle("My New Scene");
		stage.show();
	}

	public void initialize() {
		try {
			final Font f = Font.loadFont(new FileInputStream(new File("Resources/minecraft_font.ttf")), 14);
			lbOpenList.setFont(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
