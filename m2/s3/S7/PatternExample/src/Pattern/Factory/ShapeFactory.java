package Pattern.Factory;

public class ShapeFactory {
	
	public static Forma createShape(String f) {
		if(f == null) {
			return null;
		} else if(f.equalsIgnoreCase("CIRCLE")) {
			return new Cerchio();
		} else if(f.equalsIgnoreCase("RECTANGLE")) {
			return new Rettangolo();
		}
		return null;
	}

}
