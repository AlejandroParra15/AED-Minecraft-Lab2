package ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Structures.AccessQueue;
import Structures.GenericQueue;
import Structures.Hash;
import Structures.Node;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Block;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class InventoryController {

	@FXML
	private GridPane gridInventory;
	@FXML
    private GridPane gridQuickAcces;
	@FXML
	private Label lbOpenList;
	@FXML
    private TextField tfIndex;
	
	int selectedQueue = 0;
	ArrayList<Block> bs;
	ListController lc;
	Hash<Block> hash = new Hash<>();
	AccessQueue<Block>[] queue = new AccessQueue[12];
	

	@FXML
	void openList(MouseEvent event) {
		Stage stage = new Stage();
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
		for (int i = 0; i < queue.length; i++) {
			queue[i] = new AccessQueue<>();
		}
		try {	
			final Font f = Font.loadFont(new FileInputStream(new File("Resources/minecraft_font.ttf")), 14);
			lbOpenList.setFont(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void addToInventary(Block block) {
		hash.add(block.getKey(), block);
		refresh();
	}
	
	@FXML
    void navigation(MouseEvent event) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				AccessQueue<Block> q = new AccessQueue<>();
				gridQuickAcces.getChildren().clear();
				for (int k = 0; k < queue[selectedQueue].size(); k++) {
					if(!queue[selectedQueue].isEmpty()) {
						Label lb = new Label(String.valueOf(queue[selectedQueue].peek().getNumber()));
						lb.setTextFill(Color.WHITE);
						try {
							final Font f = Font.loadFont(
									new FileInputStream(new File("Resources/minecraft_font.ttf")), 18);
							lb.setFont(f);
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						lb.setPadding(new Insets(35, 0, 0, 30));
						lb.setStyle("-fx-cursor: hand");
						lb.setId(String.valueOf(queue[selectedQueue].peek().getKey()));
						q.add(queue[selectedQueue].peek());
						ImageView image = new ImageView(queue[selectedQueue].poll().getPath());
						image.setFitHeight(62);
						image.setFitWidth(56);
						gridQuickAcces.add(image, k, 0);
						gridQuickAcces.add(lb, k, 0);
					}
				}
				queue[selectedQueue] = q;
				tfIndex.setText(String.valueOf(selectedQueue));
				if(selectedQueue<11) {
					selectedQueue++;
				}else {
					selectedQueue=0;
				}
			}
		});
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
								lb.setStyle("-fx-cursor: hand");
								lb.setId(String.valueOf(bs.get(cont).getKey()));
								gridInventory.add(bs.get(cont).getImageView(), i, j);
								gridInventory.add(lb, i, j);
								lb.setOnMouseClicked(new EventHandler<Event>() {

									@Override
									public void handle(Event event) {
										gridQuickAcces.getChildren().clear();
										int key = Integer.parseInt(lb.getId());
										AccessQueue<Block> q = new AccessQueue<>();
										Block b = hash.getObject(hash.position(key)).getObj();
										queue[key].add(b);
										q.add(b);
										Node<Block> temp = hash.getObject(hash.position(key));
										boolean exit = false;
										while (!exit) {
											if (temp.getNext() == null) {
												exit = true;
											} else {
												temp = temp.getNext();
												queue[key].add(temp.getObj());
												q.add(temp.getObj());
											}

										}
										for (int k = 0; k < queue[key].size(); k++) {
											if(!queue[key].isEmpty()) {
												Label lb = new Label(String.valueOf(queue[key].peek().getNumber()));
												lb.setTextFill(Color.WHITE);
												try {
													final Font f = Font.loadFont(
															new FileInputStream(new File("Resources/minecraft_font.ttf")), 18);
													lb.setFont(f);
												} catch (FileNotFoundException e) {
													e.printStackTrace();
												}
												lb.setPadding(new Insets(35, 0, 0, 30));
												lb.setStyle("-fx-cursor: hand");
												lb.setId(String.valueOf(queue[key].peek().getKey()));
												ImageView image = new ImageView(queue[key].poll().getPath());
												image.setFitHeight(62);
												image.setFitWidth(56);
												gridQuickAcces.add(image, k, 0);
												gridQuickAcces.add(lb, k, 0);
											}
											
										}
										queue[key] = q;
										Node<Block> tempo = hash.getObject(hash.position(key));
										boolean exitt = false;
										while (!exitt) {
											if (tempo.getNext() == null) {
												exitt = true;
											} else {
												tempo = tempo.getNext();
												hash.remove(tempo.getObj().getKey());
											}

										}
										hash.remove(key);
										refresh();
									}

								});
								cont++;
							}
						}
					}
				}
			}
		});
	}

}
