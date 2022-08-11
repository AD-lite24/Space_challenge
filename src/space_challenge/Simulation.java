package space_challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Simulation{
	
	
	ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {
		ArrayList<Item> items = new ArrayList<Item>();
		File file = new File(fileName);
		try (Scanner fileScanner = new Scanner(file)) {
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				Item data = new Item();
				String delims = "[=]+";
				String[] tokens = line.split(delims);
				
//			System.out.println(line);
//			for (String a : tokens) {
//	            System.out.println(a);}
				
				//System.out.println(tokens[0]);
				//System.out.println(tokens[1]);
				data.name = (String)tokens[0];
				data.weight = Integer.parseInt(tokens[1]);
				//System.out.println("name is: " + data.name + " and weight is: " + data.weight);
				items.add(data);
			}
			fileScanner.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}
	
	ArrayList<Rocket> loadU1(ArrayList<Item> items){
		ArrayList<Rocket> U1rockets = new ArrayList<>();
		ArrayList<Item> temp = new ArrayList<Item>(items);
		boolean allItemsFilled = false;
		while(!allItemsFilled) {
			int i = 0;
			U1 rocket = new U1();
			//System.out.println("test");
			
			if (temp.size() == 0) {
				allItemsFilled = true;
				break;
			}
			while(temp.size() !=0 && rocket.canCarry(temp.get(i))) {
				//System.out.println(temp.size());
				rocket.carry(temp.get(i));
				//System.out.println(rocket.currentWeight);
				//System.out.println(temp.get(i).weight);
				temp.remove(i);
			}
			U1rockets.add(rocket);
		}
		return U1rockets;
	}
	
	ArrayList<Rocket> loadU2(ArrayList<Item> items){
		ArrayList<Rocket> U2rockets = new ArrayList<>();
		ArrayList<Item> temp = new ArrayList<Item>(items);
		boolean allItemsFilled = false;
		while(!allItemsFilled) {
			int i = 0;
			U2 rocket = new U2();
			
			if (temp.size() == 0) {
				allItemsFilled = true;
				break;
			}
			while(temp.size() !=0 && rocket.canCarry(temp.get(i))) {
				rocket.carry(temp.get(i));
				temp.remove(i);
			}
			U2rockets.add(rocket);
		
		}
		return U2rockets;
	}
	
	int runSimulation(ArrayList<Rocket> Rockets) {
		int budget = 0;
		for (int i = 0; i < Rockets.size(); i++) {
			int num = 0;
			do {
				budget += Rockets.get(i).cost;
				//System.out.println(num + 1);
				num++;
			}
			while(!(Rockets.get(i).land() || Rockets.get(i).launch()));
					
		}
		return budget;
	}
}