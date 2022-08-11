package space_challenge;

class U1 extends Rocket{
	
	
	U1() {
		this.cost = 100;
		this.currentWeight = 10000;
		this.cargoLimit = 18000;
	}
	public boolean launch() {
		double random = Math.random();
		System.out.println("random num = " + random + " and prob = " + 0.05*this.currentWeight/this.cargoLimit);
		if (random > (0.05*this.currentWeight/this.cargoLimit)) {	
			System.out.print(true);
			return true;
		}
		else {
			System.out.print(false);
			return false;
		}
	}
	public boolean land() {
		if (Math.random() > (0.01*this.currentWeight/this.cargoLimit)) {
			return true;
		}
		else {
			return false;
		}
	}
}
