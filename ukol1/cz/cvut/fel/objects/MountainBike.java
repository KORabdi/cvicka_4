package cz.cvut.fel.objects;

public class MountainBike extends Bicycle {
	private String suspension;

	public MountainBike(int i, int j, int k, String string) {
		super(i, j, k);
		this.suspension = string;
	}

	public String getSuspension() {
		return suspension;
	}

	public void setSuspension(String suspension) {
		this.suspension = suspension;
	}
	
	//Informace o odpružení (u druhého kola) a o šířce pneumatik (u třetího kola) chybí. Návrhy jak to vyřešit?
	// prepsali jsme cadence,gear a speed z private na protected
	@Override
	public void printDescription(){
		System.out.print("Bike is in gear "+this.gear+" with a cadence of "+this.cadence+" and travelling at a speed of "+this.speed+" and suspension is "+this.suspension+".\n");
	}
	
	//ukol 2
	@Override
	public String toString(){
		return ("Bike is in gear "+this.gear+" with a cadence of "+this.cadence+" and travelling at a speed of "+this.speed+" and suspension is "+this.suspension+".\n");
	}
}
