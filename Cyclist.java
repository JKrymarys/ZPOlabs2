package lab2;

public class Cyclist {
	private double lastTime;
	private  String name;
	
	Cyclist(String _name) {
		this.name = _name;
		this.lastTime = 0;
	}
	
	public void setTime(double newTime)
	{
		this.lastTime = newTime;
	}
}
