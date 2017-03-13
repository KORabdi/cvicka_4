package cz.cvut.fel.services;

import cz.cvut.fel.objects.Bicycle;
import cz.cvut.fel.objects.RoadBike;

public class RoadBikeService extends BasicService {
	public void accept(Bicycle bike){
		System.out.println("fixing Bicycle");
	}
	public void accept(RoadBike bike){
		System.out.println("fixing RoadBike");
	}
}
