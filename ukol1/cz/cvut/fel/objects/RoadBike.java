package cz.cvut.fel.objects;

public class RoadBike extends Bicycle {
	private int tireWidth;

	public RoadBike(int i, int j, int k, int l) {
		super(i,j,k);
		this.setTireWidth(l);
	}

	public int getTireWidth() {
		return tireWidth;
	}

	public void setTireWidth(int tireWidth) {
		this.tireWidth = tireWidth;
	}
	//Informace o odpružení (u druhého kola) a o šířce pneumatik (u třetího kola) chybí. Návrhy jak to vyřešit?
	// prepsali jsme cadence,gear a speed z private na protected
	@Override
	public void printDescription(){
		System.out.print("Bike is in gear "+this.gear+" with a cadence of "+this.cadence+" and travelling at a speed of "+this.speed+" and tire width is size of "+this.tireWidth+".\n");
	}
	
	//ukol 2
	@Override
	public String toString(){
		return ("Bike is in gear "+this.gear+" with a cadence of "+this.cadence+" and travelling at a speed of "+this.speed+" and tire width is size of "+this.tireWidth+".\n");
	}
}
