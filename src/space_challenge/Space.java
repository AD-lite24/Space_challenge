package space_challenge;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Space {
	public static void main(String args[]) {
		
		Simulation sim = new Simulation();
		int budget_U1 = 0;
		int budget_U2 = 0;
		
		try {
			ArrayList<Item> items_p1 = sim.loadItems("phase1");
			budget_U1 += sim.runSimulation(sim.loadU1(items_p1));
			budget_U2 += sim.runSimulation(sim.loadU2(items_p1));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ArrayList<Item> items_p2 = sim.loadItems("phase2");
			budget_U1 += sim.runSimulation(sim.loadU1(items_p2));
			budget_U2 += sim.runSimulation(sim.loadU2(items_p2));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The budget for U1 is: " + budget_U1);
		System.out.println("The budget for U2 is: " + budget_U2);
		
	}
		
}

