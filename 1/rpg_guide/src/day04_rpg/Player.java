package day04_rpg;

import java.util.ArrayList;

public class Player {
	static int money;
	static Guild guild = new Guild();
	static Inventory inven = new Inventory();
	private Hunting hunting;
	private Donjon Donjon;
	
	
	
	Player() {
		money = 1000;
		guild.setGuild();
	}
	
	public void guildMenu() {
		guild.guildMenu();
	}
	public int getMoney() {

		return Player.money;
	}
	public void setMoney(int money) {
		Player.money = money;
	}
	

	public void inventoryMenu() {
		inven.inventoryMenu();
	}

	static public ArrayList<Unit> getGuildList() {
		return guild.guildList;
	}

	static public ArrayList<Item> getItemList() {
		return inven.itemList;
	}

	static public Unit getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	static public int getGuildSize() {
		return guild.guildList.size();
	}

	static public int getItemSize() {
		return inven.itemList.size();
	}
	public void hunting () {
		hunting = new Hunting();
		hunting.run();
	}
	public void characterInformation() {
		for(int i = 0 ; i<guild.guildList.size(); i++) {
			guild.getGuildUnit(i).printStatus();
		}
	}
	public void Donjon () {
		Donjon = new Donjon();
		Donjon.print();
	}
}