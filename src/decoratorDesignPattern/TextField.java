package decoratorDesignPattern;

public class TextField implements Widget {
	private int width;
	private int height;
	
	public TextField(int width, int height) {
		this.width = width;
		this.height = height;
		
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.print("TextField [" + this.width + "," + this.height + "]");
		
	}
}
