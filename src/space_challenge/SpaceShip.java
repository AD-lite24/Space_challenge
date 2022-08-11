package space_challenge;

interface SpaceShip {
	boolean launch();
	boolean land();
	boolean canCarry(Item item);
	void carry(Item item);
}
