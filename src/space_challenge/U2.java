package space_challenge;

class U2 extends Rocket{
	
	U2(){
		cost = 120;
		currentWeight = 18000;
		cargoLimit = 29000;
	}
	public boolean launch() {
		if (Math.random() > (0.04*this.currentWeight/this.cargoLimit)) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean land() {
		if (Math.random() > (0.08*this.currentWeight/this.cargoLimit)) {
			return true;
		}
		else {
			return false;
		}
	}
}

