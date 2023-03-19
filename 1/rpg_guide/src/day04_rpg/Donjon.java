package day04_rpg;

import java.util.Random;
import java.util.Scanner;

public class Donjon {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);

	private mob mob;
	
	// 파티원들 전부 출력
	public void print() {
		Player.guild.printParty();
	}

	// 던전 몹들
	public void printMob() {
		System.out.printf("야생의 %s가 출현했다\n", mob.mobList.get(0).name);
	}
	private void battle() {
		
		
	}
	//셋팅
	private void set() {
		mob = new mob();
	}
	private int donjonSelect() {
		System.out.println("[1. 고블린 숲][2. 버섯의 숲]");
		System.out.print("던전을 고르세요 : ");
		int select = scan.nextInt();
		
		return select;
	}
	
	public void run() {
		int donjonSelect = donjonSelect();
		set();
		if(donjonSelect==1) {
			while(true) {				
				printMob();
			}
		}
	}
	
	// 경험치 배분
	
	
	// 보상
}
