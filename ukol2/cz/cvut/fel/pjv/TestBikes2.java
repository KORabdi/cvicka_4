package cz.cvut.fel.pjv;

import cz.cvut.fel.objects.*;
import cz.cvut.fel.services.*;

public class TestBikes2 {

	public static void main(String[] args) {
		Bicycle bike01, bike02, bike03;
		 
		bike01 = new Bicycle(20, 10, 1);
		bike02 = new MountainBike(20, 10, 5, "Dual");
		bike03 = new RoadBike(40, 20, 8, 23);
		
		BasicService service01 = new BasicService();
		service01.accept(bike01);
		MountainBikeService service02 = new MountainBikeService();
		service02.accept(bike02);
		RoadBikeService service03 = new RoadBikeService();
		service03.accept(bike03);
		 
//		bike01.printDescription();
//		bike02.printDescription();
//		bike03.printDescription();
	}

}
