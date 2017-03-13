package cz.cvut.fel.services;

import cz.cvut.fel.objects.Bicycle;
import cz.cvut.fel.objects.MountainBike;

public class MountainBikeService extends BasicService {
	public void accept(Bicycle bike){
		System.out.println("fixing Bicycle");
	}
	public void accept(MountainBike bike){
		System.out.println("fixing MountainBike");
	}
}
