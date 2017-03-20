package cz.cvut.fel.pjv;

import cz.cvut.fel.objects.*;
import cz.cvut.fel.services.*;

public class TestBikes3 {

	public static void main(String[] args) {
		Bicycle bike01, bike02, bike03;
		 
		bike01 = new Bicycle(20, 10, 1);
		bike02 = new MountainBike(20, 10, 5, "Dual");
		bike03 = new RoadBike(40, 20, 8, 23);
		
		BasicService service01 = new BasicService();
		MountainBikeService service02 = new MountainBikeService();
		RoadBikeService service03 = new RoadBikeService();
		
		bike01.visit(BasicService);
		// TODO: vytvorit metodu visit. Dodelat double dispatch. 
	}

}
