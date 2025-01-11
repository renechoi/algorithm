
import java.util.ArrayList;


public class Solution {
	public int solution(int[] bandage, int health, int[][] attacks) {

		int 마지막시간초 = get마지막공격시간(attacks);
		캐릭터 캐릭터 = new 캐릭터(health, new 붕대기술(bandage));
		공격리스트 공격리스트 = new 공격리스트(attacks);
		for (int i = 0; i <= 마지막시간초; i++) {
			boolean 생존 = 캐릭터.붕대기술시전(공격리스트.공격하기(i));
			if (!생존) {
				return -1;
			}
		}
		return 캐릭터.health;
	}

	public static class 공격리스트 {
		private ArrayList<공격> 공격리스트;

		public 공격리스트(int[][] attacks) {
			공격리스트 = new ArrayList<>();
			for (int i = 0; i < attacks.length; i++) {
				공격리스트.add(new 공격(attacks[i]));
			}
		}

		public int 공격하기(int 시간초) {
			return 공격리스트.stream()
				.filter(공격 -> 공격.공격가능(시간초))
				.findFirst()
				.map(공격::공격하기)
				.orElse(0);
		}
	}

	public static class 공격 {
		private int 공격시간;
		private int 피해량;

		public 공격(int[] attack) {
			this.공격시간 = attack[0];
			this.피해량 = attack[1];
		}

		public boolean 공격가능(int 시간초) {
			return 공격시간 == 시간초;
		}

		public int 공격하기() {
			return 피해량;
		}
	}

	private int get마지막공격시간(int[][] attacks) {
		return attacks[attacks.length - 1][0];
	}

	public static class 캐릭터 {
		int health;
		int maxHealth; 
		붕대기술 붕대기술;

		public 캐릭터(int health, 붕대기술 붕대기술) {
			this.health = health;
			this.붕대기술 = 붕대기술;
			this.maxHealth = health;
		}

		public boolean 붕대기술시전( int 공격) {
			if (공격 != 0) {
				health -= 공격;
				붕대기술.회복콤보초기화();
				if (health <= 0) {
					return false;
				}
			} else {
				health += 붕대기술.붕대기술시전();
				health = Math.min(health, maxHealth); // 최대 체력 초과 방지
			}

			return true;
		}

	}

	public static class 붕대기술 {
		int 시전시간; // 추가 회복을 하기 위해 콤보가 되어야 하는 시간
		int 초당회복량;
		int 추가회복량;
		int 회복콤보;

		public 붕대기술(int[] bandage) {
			this.시전시간 = bandage[0];
			this.초당회복량 = bandage[1];
			this.추가회복량 = bandage[2];
		}

		public void 회복콤보초기화() {
			회복콤보 = 0;
		}

		public int 붕대기술시전() {
			회복콤보++;
			if (회복콤보 == 시전시간) {
				회복콤보 = 0;
				return 초당회복량 + 추가회복량;
			}
			return 초당회복량;
		}
	}

}
