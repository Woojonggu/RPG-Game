package day04_rpg;

import java.util.Random;
import java.util.Scanner;

public class RandomPull {
	Scanner scan= new Scanner(System.in);
	Random random = new Random();
	
	private Shop item = new Shop();
	
	public void pull() {
		while(true) {
			System.out.println("뽑기를 하시겠습니까? [1000gold]  [0. 뒤로가기]");
			int select = scan.nextInt();
			int number = 0;
			if(Player.money<1000) {
				System.out.println("잔액이 부족합니다.");
			}else {
				if(select!=0) {
					for(int i = 0 ; i<40; i++) {
						int num = random.nextInt(item.itemList.size());
						System.out.println(item.itemList.get(num).name);
						if(i<10) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						else if(i<20) {
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						else if(i<40) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(i==39) {
							number= num;
						}
					}
					System.out.printf("==============================================\n");
					System.out.printf("==============================================\n");
					System.out.printf("==============================================\n");
					System.out.printf("아이템을 획득하였습니다!!  [%s]\n", item.itemList.get(number).name);
					Player.inven.addItem(item.itemList.get(number));
				}
				else if(select==0){
					break;
				}
			}
			
		}
	}
	

}
