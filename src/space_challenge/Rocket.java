package space_challenge;

class Rocket implements SpaceShip{
	
	int cost;
	int currentWeight;
	int cargoLimit;
	
	@Override
	public boolean launch() {
		return true;
	}
	@Override
	public boolean land() {
		return true;
	}
	public boolean canCarry(Item item) {
		if (item.weight + this.currentWeight <= this.cargoLimit) {
			return true;
		}
		else {
			return false;
		}
	}
	public void carry(Item item) {
		this.currentWeight = this.currentWeight + item.weight;
		//System.out.println(this.currentWeight);
	}
}