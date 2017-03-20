package cz.cvut.fel.objects;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fel.holders.BicycleHolder;
import cz.cvut.fel.holders.MountainBikeHolder;
import cz.cvut.fel.holders.RoadBikeHolder;
import cz.cvut.fel.interfaces.BicycleVisitor;

public class Car implements BicycleVisitor {
	List<BicycleHolder> carHolders = new ArrayList<BicycleHolder>(4);
	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	public void accept(Bicycle bike){
		BicycleHolder bh = new BicycleHolder(bike);
		this.carHolders.add(bh);
	}
	public void accept(MountainBike bike){
		MountainBikeHolder bh = new MountainBikeHolder(bike);
		this.carHolders.add(bh);
	}
	public void accept(RoadBike bike){
		RoadBikeHolder bh = new RoadBikeHolder(bike);
		this.carHolders.add(bh);
	}

}
