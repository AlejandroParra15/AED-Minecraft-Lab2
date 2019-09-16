package ui;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Block;

public class ListController {

	@FXML
	private TextField tfNumberBlocks;
	@FXML
	private GridPane gridList;
	@FXML
	private ImageView imgSelected;
	ImageIcon icono = new ImageIcon("Resources/icono.png");

	ArrayList<Block> blocks = new ArrayList<Block>();

	InventoryController ic;

	int selected = -1;

	public void initialize() {
		setupBlocks();
		int cont = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				ImageView img = blocks.get(cont).getImageView();
				img.setStyle("-fx-cursor: hand");
				gridList.add(img, i, j);
				img.setOnMouseClicked(new EventHandler<Event>() {

					@Override
					public void handle(Event event) {
						imgSelected.setImage(img.getImage());
					}

				});
				cont++;
			}
		}

	}

	public void setupBlocks() {
		int k = 0;
		Block oak = new Block("Oak.png", "Oak", k);
		blocks.add(oak);
		k++;
		Block stone = new Block("Stone.png", "Stone", k);
		blocks.add(stone);
		k++;
		Block bedrock = new Block("Bedrock.png", "Bedrock", k);
		blocks.add(bedrock);
		k++;
		Block emerald = new Block("Emerald.png", "Emerald", k);
		blocks.add(emerald);
		k++;
		Block iron = new Block("Iron.png", "Iron", k);
		blocks.add(iron);
		k++;
		Block lava = new Block("Lava.png", "Lava", k);
		blocks.add(lava);
		k++;
		Block obsidian = new Block("Obsidian.png", "Obsidian", k);
		blocks.add(obsidian);
		k++;
		Block pumpkin = new Block("Pumpkin.png", "Pumpkin", k);
		blocks.add(pumpkin);
		k++;
		Block sand = new Block("Sand.png", "Sand", k);
		blocks.add(sand);
		k++;
		Block tnt = new Block("Tnt.png", "Tnt", k);
		blocks.add(tnt);
		k++;
		Block water = new Block("Water.png", "Water", k);
		blocks.add(water);
		k++;
		Block wool = new Block("Wool.png", "Wool", k);
		blocks.add(wool);
		k++;
	}

	@FXML
	void AddToInventory(ActionEvent event) {
		try {
			int nblocks = Integer.parseInt(tfNumberBlocks.getText());
			if (nblocks <= 64 && nblocks > 0) {
				for (int i = 0; i < blocks.size(); i++) {
					if (blocks.get(i).getImage() == imgSelected.getImage()) {
						Block b = blocks.get(i);
						Block bl = new Block(b.getName() + ".png", b.getName(), b.getKey());
						bl.setNumber(nblocks);
						ic.addToInventary(bl);
						JOptionPane.showMessageDialog(null, " Block added :)", "Congratulations!",
								JOptionPane.PLAIN_MESSAGE, icono);
					}

				}
			} else {
				JOptionPane.showMessageDialog(null,
						"the number entered must be greater than 0 and less than or equal to 64.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Enter a number in the field.", "Error", JOptionPane.ERROR_MESSAGE);
			tfNumberBlocks.setText("");
			tfNumberBlocks.requestFocus();
		}
		Stage stage = null;
		stage = (Stage) tfNumberBlocks.getScene().getWindow();
		stage.close();
	}

	@FXML
	void back(ActionEvent event) {
		Stage stage = null;
		stage = (Stage) tfNumberBlocks.getScene().getWindow();
		stage.close();
	}

	public void setupInventaryController(InventoryController inventaryC) {
		ic = inventaryC;
	}
}
