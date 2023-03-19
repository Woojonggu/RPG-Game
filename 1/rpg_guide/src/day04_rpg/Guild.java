package day04_rpg;

import java.util.ArrayList;
import java.util.Scanner;

public class Guild {
	int PARTY_SIZE = 4;
	ArrayList<Unit> guildList = new ArrayList<>();
	Unit[] partyList;
	

	public void setGuild() {
		Unit temp = new Unit("?��?��?��", 1, 100, 10, 5, 0);
		guildList.add(temp);
		temp = new Unit("강아�?", 1, 80, 7, 3, 0);
		guildList.add(temp);
		temp = new Unit("?��?��", 1, 50, 3, 1, 0);
		guildList.add(temp);
		temp = new Unit("?��?���?", 1, 70, 5, 2, 0);
		guildList.add(temp);
		temp = new Unit("?���?", 1, 200, 4, 8, 0);
		guildList.add(temp);
		temp = new Unit("?��?��", 1, 120, 11, 7, 0);
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
		System.out.println("[골드 : " + Player.money + "]");
		System.out.println("============= [길드?��] =================");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "�?]");
			System.out.print(" [?���? : " + guildList.get(i).name + "]");
			System.out.print(" [?���? : " + guildList.get(i).level + "]");
			System.out.print(" [체력 : " + guildList.get(i).hp);
			System.out.println(" / " + guildList.get(i).maxHp + "]");
			System.out.print("[공격?�� : " + guildList.get(i).att + "]");
			System.out.print(" [방어?�� : " + guildList.get(i).def + "]");
			System.out.println(" [?��?���? : " + guildList.get(i).party + "]");
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
		String[] n1 = { "�?", "?��", "�?", "�?", "?��", "�?", "?��" };
		String[] n2 = { "�?", "�?", "�?", "�?", "?��", "?��", "�?" };
		String[] n3 = { "?��", "?��", "�?", "?��", "?��", "�?", "�?" };

		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("=====================================");
		System.out.print("[?���? : " + name + "]");
		System.out.print(" [?���? : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격?�� : " + att + "]");
		System.out.println(" [방어?�� : " + def + "]");
		System.out.println("길드?��?�� 추�??��?��?��.");
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
		System.out.println("?��?��?�� 번호�? ?��?��?��?��?�� ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).party) {
			System.out.println("?��?��중인 멤버?�� ?��?��?��?�� ?��?��?��?��.");
		} else {
			System.out.println("=================================");
			System.out.print("[?���? : " + guildList.get(sel - 1).name + "]");
			System.out.println("길드?��?�� ?��?��?��?��?��.");
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
		System.out.println("================ [?��?��?��] ===============");
		for (int i = 0; i < PARTY_SIZE; i++) {
			System.out.print("[" + (i + 1) + "�?]");
			System.out.print(" [?���? : " + partyList[i].name + "]");
			System.out.print(" [?���? : " + partyList[i].level + "]");
			System.out.print(" [체력 : " + partyList[i].hp);
			System.out.println(" / " + partyList[i].maxHp + "]");
			System.out.print("[공격?�� : " + partyList[i].att + "]");
			System.out.print(" [방어?�� : " + partyList[i].def + "]");
			System.out.println(" [?��?���? : " + guildList.get(i).party + "]");
			System.out.println("");
		}
		System.out.println("=====================================");
	}

	public void partyChange() {

		printAllUnitStaus();
		
		System.out.println("[1.?��?��?��?��]  [2.?��?��참�?]");
		
		int sel = MainGame.scan.nextInt();
		if(sel==1) {
			if(this.PARTY_SIZE>0) {
				
					System.out.println("?��?��?�� 번호�? ?��?��?��?��?�� ");
					int guildNum = MainGame.scan.nextInt();
					if(guildList.get(guildNum - 1).party = true) {
						guildList.get(guildNum - 1).party = false;	
						
						System.out.println("====================================");
						System.out.print("[?���? : " + guildList.get(guildNum - 1).name + "]");
						System.out.println("?��?�� ?��?��?��?�� ?��?��?��???��?��?��.");
						System.out.println("====================================");
						
						this.PARTY_SIZE--;
					}
					else {
						System.out.println("?���? ?��?��?�� ?��?��?��?��?��");
					}
			}
			else {
				System.out.println("?��?���? 존재?���? ?��?��?��?��.");
			}
		}		
		else {
			if(this.PARTY_SIZE<4) {
				System.out.println("참�??�� 번호�? ?��?��?��?��?�� ");
				int guildNum = MainGame.scan.nextInt();
				if(guildList.get(guildNum - 1).party == false) {
					
					guildList.get(guildNum - 1).party = true;
					
					System.out.println("====================================");
					System.out.print("[?���? : " + guildList.get(guildNum - 1).name + "]");
					System.out.println("?��?�� ?��?��?�� 참�??��???��?��?��.");
					System.out.println("====================================");
					
					this.PARTY_SIZE++;
				}
				else {
					System.out.println("?���? ?��?��?�� �??�� ?��?�� ?��?��?��?��.");
				}
			}
			else {
				System.out.println("?��?���? 꽉찼?��?��?��.");
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
			System.out.println("=============== [길드�?�?] ================");
			System.out.println("[1.길드목록] [2.길드?��추�?] [3.길드?��?��?��]\n" + "[4.?��?��?��교체] [5.?��?��]  [0.?��로�?�?]");
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