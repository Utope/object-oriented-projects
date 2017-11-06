package inClassabstractfactorydesign;

public class ShapeFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shape) {
		switch(shape) {
		case "SQUARE":
			return new Square();
		case "CIRCLE":
			return new Circle();
		case "RECTANGLE":
			return new Rectangle();
		}
		return null;
	}

	@Override
	public Color getColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

}
