package cz.cvut.fel.interfaces;

import cz.cvut.fel.objects.*;

public interface BicycleVisitor {
	public void accept(Bicycle b);
	public void accept(MountainBike b);
	public void accept(RoadBike b);
}
