package cz.cvut.fel.objects;

public class Bicycle {
	protected int cadence;
	protected int gear;
	protected int speed;
	
	public Bicycle(int cadence, int speed, int gear){
		this.cadence = cadence;
		this.gear = gear;
		this.speed = speed;
	}

	public void printDescription(){
		System.out.print("Bike is in gear "+this.gear+" with a cadence of "+this.cadence+" and travelling at a speed of "+this.speed+".\n");
	}
	public int getGear() {
		return gear;
	}
	public void setGear(int gear) {
		this.gear = gear;
	}
	public int getCadence() {
		return cadence;
	}
	public void setCadence(int cadence) {
		this.cadence = cadence;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
}
