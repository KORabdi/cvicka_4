package cz.cvut.fel.services;

import cz.cvut.fel.objects.RoadBike;

public class RoadBikeService extends BasicService {
	public void accept(RoadBike bike){
		System.out.print("fixing"+bike);
	}
}
