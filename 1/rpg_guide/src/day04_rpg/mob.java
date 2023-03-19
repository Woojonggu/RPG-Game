package day04_rpg;

import java.util.ArrayList;
import java.util.Random;

public class mob {
	Random random = new Random();
	ArrayList<mob> mobList = new ArrayList<mob>();
	
	public int power;
	public int hp;
	public String name;
	public int level;
	public int money;
	public int exp;
	
	public mob(int power, int hp, String name, int level, int money , int exp) {
		this.power = power;
		this.hp = hp;
		this.name = name;
		this.level = level;
		this.money = money;
		this.exp = exp;
	}
	
	public mob() {
	
		int power = random.nextInt(10)+1;
		int hp = random.nextInt(50)+20;
		int level = 8;
		int money = 60;
		int exp =10;
		String name = "고블린";
		
		
		mobList.add(new mob(power, hp, name, level, money, exp));
		
		power = random.nextInt(14)+1;
		hp = random.nextInt(70)+20;
		level = 10;
		money = 100;
		exp =10;
		name = "주황버섯";
		
		mobList.add(new mob(power, hp, name, level, money, exp));
		
		power = random.nextInt(50)+1;
		hp = random.nextInt(500)+20;
		level = 20;
		money = 250;
		exp =20;
		name = "스톤골램";
		
		mobList.add(new mob(power, hp, name, level, money, exp));
		
		
		power = random.nextInt(80)+1;
		hp = random.nextInt(2000)+20;
		level = 50;
		money = 1000;
		exp =50;
		name = "크림슨발록";
		
		mobList.add(new mob(power, hp, name, level, money, exp));
		
		power = random.nextInt(60)+1;
		hp = random.nextInt(800)+20;
		level = 30;
		money = 500;
		exp =30;
		name = "구미호";
		
		mobList.add(new mob(power, hp, name, level, money, exp));
		
		power = random.nextInt(70)+1;
		hp = random.nextInt(1000)+20;
		level = 40;
		money = 600;
		exp =40;
		name = "주니어발록";
		
		mobList.add(new mob(power, hp, name, level, money, exp));
	}
	public void printMob () {
		for(int i = 0 ; i<mobList.size() ; i++) {
			System.out.printf("%d: [ %s ] [레벨 : %d ]\n",i+1, mobList.get(i).name, mobList.get(i).level);

		}
	}
	

	
	
}
