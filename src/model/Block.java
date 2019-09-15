package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Block {

	private String path;
	private String name;
	private int number;
	private Image image;
	private ImageView imageView;
	private int key;
	
	public Block(String p, String n, int k) {
		path = "Images/"+p;
		name = n;
		image = new Image(path);
		key = k;
		setupImage();
	}
	
	public void setupImage() {
		imageView = new ImageView(image);
		imageView.setFitHeight(62);
		imageView.setFitWidth(56);
	}

	public String getName() {
		return name;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}
	
}
