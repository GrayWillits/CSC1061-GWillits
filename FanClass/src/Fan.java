
public class Fan {
	
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;

	private int speed;
	private boolean on;
	private double radius;
	private String color;

	private int id;
	private static int idCount = 1;
	
	public Fan() {
		this.speed = SLOW;
		this.on = false;
		this.radius = 5;
		this.color = "blue";
		
		this.id = idCount;
		idCount++;
	}
	
	@Override
	public String toString() { 
		return id + ", " + ((on) ? speed + ", " : "") + color + ", " + radius + ((!on) ? ", fan is off" : "");
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
