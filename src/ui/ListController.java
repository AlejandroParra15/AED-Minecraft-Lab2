package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    
    ArrayList<Block> blocks = new ArrayList<Block>();
    
    public void initialize() {
    	setupBlocks();
    	int cont = 0;
    	for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				ImageView img = blocks.get(cont).getImageView();
				gridList.add(img,i,j);
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
    	Block oak = new Block("Oak.png", "Oak", k);blocks.add(oak);k++;
    	Block stone = new Block("Stone.png", "Stone", k);blocks.add(stone);k++;
    	Block bedrock = new Block("Bedrock.png", "Bedrock", k);blocks.add(bedrock);k++;
    	Block emerald = new Block("Emerald.png", "Emerald", k);blocks.add(emerald);k++;
    	Block iron = new Block("Iron.png", "Iron", k);blocks.add(iron);k++;
    	Block lava = new Block("Lava.png", "Lava", k);blocks.add(lava);k++;
    	Block obsidian = new Block("Obsidian.png", "Obsidian", k);blocks.add(obsidian);k++;
    	Block pumpkin = new Block("Pumpkin.png", "Pumpkin", k);blocks.add(pumpkin);k++;
    	Block sand = new Block("Sand.png", "Sand", k);blocks.add(sand);k++;
    	Block tnt = new Block("Tnt.png", "Tnt", k);blocks.add(tnt);k++;
    	Block water = new Block("Water.png", "Water", k);blocks.add(water);k++;
    	Block wool = new Block("Wool.png", "Wool", k);blocks.add(wool);k++;
    }
    
    @FXML
    void lowerBlock(MouseEvent e) {
    	
    }
    
    @FXML
    void AddToInventory(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) {
    	Stage stage = null;
		Parent myNewScene = null;
		stage = (Stage) tfNumberBlocks.getScene().getWindow();
		try {
			myNewScene = FXMLLoader.load(getClass().getResource("Inventory.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(myNewScene);
		stage.setScene(scene);
		stage.setTitle("My New Scene");
		stage.show();
    }
}
