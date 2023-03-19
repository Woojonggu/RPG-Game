package day04_rpg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hunting {

	Scanner scan = new Scanner(System.in);

	private int power;
	private int hp;
	private int exp;
	private int level;
	private int maxHp;
	private int money;
	private String name;

	private mob mob;

	// 몹 셋팅
	public int set() {
		// 모두 경험치 0

		int selectCharacter = characterSelect();

		this.power = Player.guild.getGuildUnit(selectCharacter - 1).att;
		this.hp = Player.guild.getGuildUnit(selectCharacter - 1).hp;
		this.maxHp = Player.guild.getGuildUnit(selectCharacter - 1).maxHp;
		this.name = Player.guild.getGuildUnit(selectCharacter - 1).name;
		this.exp = Player.guild.getGuildUnit(selectCharacter - 1).exp;
		this.level = Player.guild.getGuildUnit(selectCharacter - 1).level;
		return selectCharacter;
	}

	// 몹 선택
	public int selectMob() {
		mob = new mob();
		mob.printMob();
		System.out.print("사냥할 몬스터를 선택하세요 : ");
		int selectMob = scan.nextInt();

		return selectMob;
	}

	// 캐릭터 고르기
	public int characterSelect() {
		Player.guild.printAllUnitStaus();

		System.out.print("캐릭터를 선택하세요 : ");
		int selectCharacter = MainGame.scan.nextInt();

		return selectCharacter;
	}

	public void run() {
		int selectCharacter = set();
		mobAppearance(selectCharacter);
	}

	// 몹 출현
	public void mobAppearance(int selectCharacter) {
		int selectMob = selectMob();
		System.out.printf("야생의 %s가 출현했다\n", mob.mobList.get(selectMob - 1).name);
		print(selectMob, selectCharacter);
	}

	private void print(int selectMob, int selectCharacter) {
		boolean isRun = true;
		while (isRun) {
			System.out.printf("[ %s ] [공격력 : %d] [체력 : %d]\n", mob.mobList.get(selectMob - 1).name,
					mob.mobList.get(selectMob - 1).power, mob.mobList.get(selectMob - 1).hp);
			System.out.printf("[ %s ] [공격력 : %d] [체력 : %d/%d]\n", this.name, this.power, this.hp, this.maxHp);
			System.out.printf("[exp :    %d/%d]\n", this.exp, LevelUp.levelUp.get(this.level-1).level);
			System.out.println("1. 싸운다 2. 도망간다");
			int sel = scan.nextInt();
			isRun = battle(sel, selectMob, selectCharacter);
		}

	}

	private boolean battle(int sel, int selectMob, int selectCharacter) {

		boolean isRun = true;
		if (sel == 1) {
			System.out.printf("매직클로!\n 데미지 : %d\n", power);
			mob.mobList.get(selectMob - 1).hp -= this.power;
			

			System.out.printf("상대 몸통박치기!\n 데미지 : %d\n", mob.mobList.get(selectMob - 1).power);
			this.hp -= mob.mobList.get(selectMob - 1).power;

			if (mob.mobList.get(selectMob - 1).hp <= 0) {
				System.out.println("상대가 쓰려졌다!");
				System.out.printf("%sgold++  %sexp++\n", mob.mobList.get(selectMob - 1).money,
						mob.mobList.get(selectMob - 1).exp);
				Player.guild.guildList.get(selectCharacter - 1).exp += mob.mobList.get(selectMob - 1).exp;
				Player.money += mob.mobList.get(selectCharacter - 1).money;
				isRun = false;
				if(Player.guild.guildList.get(selectCharacter - 1).exp>=LevelUp.levelUp.get(this.level-1).level) {
					Player.guild.guildList.get(selectCharacter-1).level++;
					System.out.println("레벨업");
					Player.guild.guildList.get(selectCharacter-1).exp=0;
				}
			}
			if (hp <= 0) {
				System.out.println("사망하였습니다.");
				System.out.printf("-%dexp\n", mob.mobList.get(selectMob).exp / 2);
				Player.guild.guildList.get(selectCharacter - 1).exp -= 10;
				isRun = false;
			}
		} else if (sel == 2) {
			isRun = false;
		} else {
			System.out.println("잘못눌렀습니다.");
		}

		return isRun;
	}

}
