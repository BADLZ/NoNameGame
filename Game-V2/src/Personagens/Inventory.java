package Personagens;

import java.util.ArrayList;

import accessory.Accessory;

public class Inventory {

	public static final int MAX_ITENS_INV = 30;

	private ArrayList<Accessory> inventory, equippedItems;
	
	public Inventory() {
		inventory = new ArrayList<>();
		equippedItems = new ArrayList<>();
	}
	//---------------------------------------------------
	public void addItem(Accessory item) {
		if(inventory.size() < MAX_ITENS_INV)
			inventory.add(item);
	}
	public void equipItem(Accessory item) {
		inventory.remove(item);
		Accessory sameType = null;
		for(Accessory equipped: equippedItems) {
			if(equipped.getType().equalsIgnoreCase(item.getType())) {
				inventory.add(equipped);
				sameType = equipped;
			}
		}
		if(sameType != null)
			equippedItems.remove(sameType);
		equippedItems.add(item);
	}
	public void removeItem(Accessory item) {
		inventory.remove(item);
	}
	public void unequipItem(Accessory item) {
		if(inventory.size() < MAX_ITENS_INV)
			if(equippedItems.remove(item))
				inventory.add(item);
	}
	//--------------------------------------------------
	public boolean isEquipped(Accessory item) {
		return equippedItems.contains(item);
	}
	public boolean contains(Accessory item) {
		return inventory.contains(item) || isEquipped(item);
	}
	public boolean hasSpace() {
		return inventory.size() < MAX_ITENS_INV;
	}
	//---------------------------------------------------
	//getters
	public ArrayList<Accessory> getInv(){
		ArrayList<Accessory> result = new ArrayList<>();
		for(Accessory item: inventory)
			result.add(item);
		return result;
	}
	public ArrayList<Accessory> getEquipped(){
		ArrayList<Accessory> result = new ArrayList<>();
		for(Accessory item: equippedItems)
			result.add(item);
		return result;
	}
	//---------------------------------------------------
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Equipped items:\n");
		for(Accessory item: equippedItems)
			result.append("\t" + item.toString());
		result.append("\n");
		result.append("Inventory items:\n");
		for(Accessory item: inventory)
			result.append("\t" + item.toString());
		result.append("\n");
		return result.toString();
	}
	
}
