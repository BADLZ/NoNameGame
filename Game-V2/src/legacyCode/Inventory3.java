package legacyCode;

import java.util.ArrayList;

import accessory.Accessory;

public class Inventory3 {

	public static final int MAX_ITENS_INV = 30;

	private ArrayList<Accessory> inventory;
	//													wtf is this
	private Accessory weapon, armour, boots, hat, belt, cuises, gloves;

	public Inventory3() {
		inventory = new ArrayList<>();
	}



	//-------------------------------------------------
	//-------------------------------------------------
	public ArrayList<Accessory> getInv(){
		return inventory;
	}
	public Accessory getWeapon() {
		return weapon;
	}
	public Accessory getArmour() {
		return armour;
	}
	public Accessory getBoots() {
		return boots;
	}
	public Accessory getHat() {
		return hat;
	}
	public Accessory getBelt() {
		return belt;
	}
	public Accessory getCuises() {
		return cuises;
	}
	public Accessory getGolves() {
		return gloves;
	}
	//-------------------------------------------------
	public void equipItem(Accessory item) {
		String type = item.getType().toLowerCase();
		switch(type) {
		case "weapon":
			inventory.remove(item);
			if(weapon != null) {
				inventory.add(weapon);
			}
			weapon = item;
			break;
		case "armour":
			inventory.remove(item);
			if(armour != null) {
				inventory.add(armour);
			}
			armour = item;
			break;
		case "boots":
			inventory.remove(item);
			if(boots != null) {
				inventory.add(boots);
			}
			boots = item;
			break;
		case "hat":
			inventory.remove(item);
			if(hat != null) {
				inventory.add(hat);
			}
			hat = item;
			break;
		case "belt":
			inventory.remove(item);
			if(belt != null) {
				inventory.add(belt);
			}
			belt = item;
			break;
		case "cuises":
			inventory.remove(item);
			if(cuises != null) {
				inventory.add(cuises);
			}
			cuises = item;
			break;
		case "gloves":
			inventory.remove(item);
			if(gloves != null) {
				inventory.add(gloves);
			}
			gloves = item;
			break;
		default: break;
		}
	}
	//------------------------------------------------------------------
}
