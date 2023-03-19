package day04_rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class Guild {
	int PARTY_SIZE = 4;
	ArrayList<Unit> guildList = new ArrayList<>();
	Unit[] partyList;
	

	public void setGuild() {
		Unit temp = new Unit("?˜¸?‘?´", 1, 100, 10, 5, 0);
		guildList.add(temp);
		temp = new Unit("ê°•ì•„ì§?", 1, 80, 7, 3, 0);
		guildList.add(temp);
		temp = new Unit("?‚¬?Š´", 1, 50, 3, 1, 0);
		guildList.add(temp);
		temp = new Unit("?‘?”ì§?", 1, 70, 5, 2, 0);
		guildList.add(temp);
		temp = new Unit("?¼ì§?", 1, 200, 4, 8, 0);
		guildList.add(temp);
		temp = new Unit("?‚¬?", 1, 120, 11, 7, 0);
		guildList.add(temp);
		for (int i = 0; i < 4; i++) {
			guildList.get(i).party = true;
		}
		partyList = new Unit[PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).party == true) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
	}	
	
	
	public Unit getGuildUnit(int num) {
		return guildList.get(num);
	}
	
	public void setGuildUnitExp(int num, int exp) {
		guildList.get(num).exp = exp;
	}

	public void printAllUnitStaus() {
		System.out.println("======================================");
		System.out.println("[ê³¨ë“œ : " + Player.money + "]");
		System.out.println("============= [ê¸¸ë“œ?›] =================");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "ë²?]");
			System.out.print(" [?´ë¦? : " + guildList.get(i).name + "]");
			System.out.print(" [? ˆë²? : " + guildList.get(i).level + "]");
			System.out.print(" [ì²´ë ¥ : " + guildList.get(i).hp);
			System.out.println(" / " + guildList.get(i).maxHp + "]");
			System.out.print("[ê³µê²©? ¥ : " + guildList.get(i).att + "]");
			System.out.print(" [ë°©ì–´? ¥ : " + guildList.get(i).def + "]");
			System.out.println(" [?ŒŒ?‹°ì¤? : " + guildList.get(i).party + "]");
			System.out.println("");
		}
		System.out.println("=================================");
	}

	public void printUnitStaus(int num) {
		guildList.get(num).printStatus();
	}

	public void printUnitItem(int num) {
		guildList.get(num).printEquitedItem();
	}

	public void buyUnit() {
		if (Player.money < 5000)
			return;
		String[] n1 = { "ë°?", "?´", "ê¹?", "ìµ?", "?œ ", "ì§?", "?˜¤" };
		String[] n2 = { "ëª?", "ê¸?", "ì¢?", "ë¯?", "?¬", "?„", "ê´?" };
		String[] n3 = { "?ˆ˜", "?", "ë¯?", "?ˆ˜", "?„", "ë¯?", "ì²?" };

		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("=====================================");
		System.out.print("[?´ë¦? : " + name + "]");
		System.out.print(" [? ˆë²? : " + 1 + "]");
		System.out.print(" [ì²´ë ¥ : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[ê³µê²©? ¥ : " + att + "]");
		System.out.println(" [ë°©ì–´? ¥ : " + def + "]");
		System.out.println("ê¸¸ë“œ?›?„ ì¶”ê??•©?‹ˆ?‹¤.");
		System.out.println("=====================================");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		guildList.add(temp);
		Player.money -= 5000;
	}

	public void removeUnit() {
		printAllUnitStaus();
		System.out.println("?‚­? œ?•  ë²ˆí˜¸ë¥? ?…? ¥?•˜?„¸?š” ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).party) {
			System.out.println("?ŒŒ?‹°ì¤‘ì¸ ë©¤ë²„?Š” ?‚­? œ?• ?ˆ˜ ?—†?Šµ?‹ˆ?‹¤.");
		} else {
			System.out.println("=================================");
			System.out.print("[?´ë¦? : " + guildList.get(sel - 1).name + "]");
			System.out.println("ê¸¸ë“œ?›?„ ?‚­? œ?•©?‹ˆ?‹¤.");
			System.out.println("=================================");
			guildList.remove(sel - 1);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printParty() {
		System.out.println("================ [?ŒŒ?‹°?›] ===============");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "ë²?]");
			System.out.print(" [?´ë¦? : " + partyList[i].name + "]");
			System.out.print(" [? ˆë²? : " + partyList[i].level + "]");
			System.out.print(" [ì²´ë ¥ : " + partyList[i].hp);
			System.out.println(" / " + partyList[i].maxHp + "]");
			System.out.print("[ê³µê²©? ¥ : " + partyList[i].att + "]");
			System.out.print(" [ë°©ì–´? ¥ : " + partyList[i].def + "]");
			System.out.println(" [?ŒŒ?‹°ì¤? : " + guildList.get(i).party + "]");
			System.out.println("");
		}
		System.out.println("=====================================");
	}

	public void partyChange() {

		printAllUnitStaus();
		
		System.out.println("[1.?ŒŒ?‹°?ƒˆ?‡´]  [2.?ŒŒ?‹°ì°¸ê?]");
		
		int sel = MainGame.scan.nextInt();
		if(sel==1) {
			if(this.PARTY_SIZE>0) {
				
					System.out.println("?ƒˆ?‡´?•  ë²ˆí˜¸ë¥? ?…? ¥?•˜?„¸?š” ");
					int guildNum = MainGame.scan.nextInt();
					if(guildList.get(guildNum - 1).party = true) {
						guildList.get(guildNum - 1).party = false;	
						
						System.out.println("====================================");
						System.out.print("[?´ë¦? : " + guildList.get(guildNum - 1).name + "]");
						System.out.println("?‹˜?´ ?ŒŒ?‹°?—?„œ ?ƒˆ?‡´?•˜???Šµ?‹ˆ?‹¤.");
						System.out.println("====================================");
						
						this.PARTY_SIZE--;
					}
					else {
						System.out.println("?´ë¯? ?ƒˆ?‡´?•œ ?ƒ?ƒœ?…?‹ˆ?‹¤");
					}
			}
			else {
				System.out.println("?ŒŒ?‹°ê°? ì¡´ì¬?•˜ì§? ?•Š?Šµ?‹ˆ?‹¤.");
			}
		}		
		else {
			if(this.PARTY_SIZE<4) {
				System.out.println("ì°¸ê??•  ë²ˆí˜¸ë¥? ?…? ¥?•˜?„¸?š” ");
				int guildNum = MainGame.scan.nextInt();
				if(guildList.get(guildNum - 1).party == false) {
					
					guildList.get(guildNum - 1).party = true;
					
					System.out.println("====================================");
					System.out.print("[?´ë¦? : " + guildList.get(guildNum - 1).name + "]");
					System.out.println("?‹˜?´ ?ŒŒ?‹°?— ì°¸ê??•˜???Šµ?‹ˆ?‹¤.");
					System.out.println("====================================");
					
					this.PARTY_SIZE++;
				}
				else {
					System.out.println("?´ë¯? ?ŒŒ?‹°?— ê°??… ?˜?–´ ?ˆ?Šµ?‹ˆ?‹¤.");
				}
			}
			else {
				System.out.println("?ŒŒ?‹°ê°? ê½‰ì°¼?Šµ?‹ˆ?‹¤.");
			}
		}
		

		
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).party) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void guildMenu() {
		while (true) {
			System.out.println("=============== [ê¸¸ë“œê´?ë¦?] ================");
			System.out.println("[1.ê¸¸ë“œëª©ë¡] [2.ê¸¸ë“œ?›ì¶”ê?] [3.ê¸¸ë“œ?›?‚­? œ]\n" + "[4.?ŒŒ?‹°?›êµì²´] [5.? •? ¬]  [0.?’¤ë¡œê?ê¸?]");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStaus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} else if (sel == 4) {
				partyChange();
			} else if (sel == 0) {
				break;
			}
		}
	}

}