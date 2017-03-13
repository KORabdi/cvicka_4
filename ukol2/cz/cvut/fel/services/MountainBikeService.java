package cz.cvut.fel.services;

import cz.cvut.fel.objects.MountainBike;

public class MountainBikeService extends BasicService {
	public void accept(MountainBike bike){
		System.out.print("fixing "+bike);
	}
}
