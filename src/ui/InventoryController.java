package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Structures.Hash;
import Structures.Node;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Block;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class InventoryController {

	@FXML
	private GridPane gridInventory;
	@FXML
	private Label lbOpenList;
	ListController lc;

	Hash<Block> hash = new Hash<>();

	@FXML
	void openList(MouseEvent event) {
		Stage stage = new Stage();
		// stage = (Stage) lbOpenList.getScene().getWindow();
		FXMLLoader fxmlL = new FXMLLoader(getClass().getResource("List.fxml"));
		Parent root;
		try {
			root = fxmlL.load();
			lc = fxmlL.getController();
			lc.setupInventaryController(this);
			Scene scene = new Scene(root);
			stage.setTitle("List");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialize() {
		refresh();
		try {
			final Font f = Font.loadFont(new FileInputStream(new File("Resources/minecraft_font.ttf")), 14);
			lbOpenList.setFont(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	ArrayList<Block> bs;

	public void addToInventary(Block block) {
		hash.add(block.getKey(), block);
		refresh();
	}

	public void refresh() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				bs = new ArrayList<>();
				for (int i = 0; i < hash.size(); i++) {
					if (hash.getObject(i) != null) {
						Block b = hash.getObject(i).getObj();
						bs.add(b);
						Node<Block> temp = hash.getObject(i);
						boolean exit = false;
						while (!exit) {
							if (temp.getNext() == null) {
								exit = true;
							} else {
								temp = temp.getNext();
								bs.add(temp.getObj());
							}

						}
					}
				}
				gridInventory.getChildren().clear();
				if (!bs.isEmpty()) {
					int cont = 0;
					for (int j = 0; j < 3; j++) {
						for (int i = 0; i < 6; i++) {
							if (cont < bs.size()) {
								Label lb = new Label(String.valueOf(bs.get(cont).getNumber()));
								lb.setTextFill(Color.WHITE);
								try {
									final Font f = Font.loadFont(
											new FileInputStream(new File("Resources/minecraft_font.ttf")), 18);
									lb.setFont(f);
								} catch (FileNotFoundException e) {
									e.printStackTrace();
								}
								lb.setPadding(new Insets(35, 0, 0, 30));
								gridInventory.add(bs.get(cont).getImageView(), i, j);
								gridInventory.add(lb, i, j);
								cont++;
							}
						}
					}
				}
			}
		});
	}

}
