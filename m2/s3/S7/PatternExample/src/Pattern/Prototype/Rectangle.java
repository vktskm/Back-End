package Pattern.Prototype;

public class Rectangle extends Shape {
	
	public int width;
	public int heigth;

	public Rectangle() {}
	
	public Rectangle(Rectangle target) {
		super(target);
		if(target != null) {
			this.width = target.width;
			this.heigth = target.heigth;
		}
	}

	@Override
	public Shape clone() {
		return new Rectangle(this);
	}

}
