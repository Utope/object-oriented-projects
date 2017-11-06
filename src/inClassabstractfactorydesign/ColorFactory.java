package inClassabstractfactorydesign;

public class ColorFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shape) {
		return null;
	}

	@Override
	public Color getColor(String color) {
		switch(color) {
		case "BLUE":
			return new Blue();
		case "RED":
			return new Red();
		case "GREEN":
			return new Green();
		}
		return null;
	}

}
