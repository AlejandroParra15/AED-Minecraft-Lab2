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
    	Block oak = new Block("Oak.png", "Oak");blocks.add(oak);
    	Block stone = new Block("Stone.png", "Stone");blocks.add(stone);
    	Block bedrock = new Block("Bedrock.png", "Bedrock");blocks.add(bedrock);
    	Block emerald = new Block("Emerald.png", "Emerald");blocks.add(emerald);
    	Block iron = new Block("Iron.png", "Iron");blocks.add(iron);
    	Block lava = new Block("Lava.png", "Lava");blocks.add(lava);
    	Block obsidian = new Block("Obsidian.png", "Obsidian");blocks.add(obsidian);
    	Block pumpkin = new Block("Pumpkin.png", "Pumpkin");blocks.add(pumpkin);
    	Block sand = new Block("Sand.png", "Sand");blocks.add(sand);
    	Block tnt = new Block("Tnt.png", "Tnt");blocks.add(tnt);
    	Block water = new Block("Water.png", "Water");blocks.add(water);
    	Block wool = new Block("Wool.png", "Wool");blocks.add(wool);
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
