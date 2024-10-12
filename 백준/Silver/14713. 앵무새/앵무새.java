
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int 앵무새개수 = Integer.parseInt(br.readLine());

		ArrayList<String> 앵무새가말한문장들 = new ArrayList<>();
		while (앵무새개수-->0){
			앵무새가말한문장들.add(br.readLine());
		}

		String 검증해야하는문장 = br.readLine();

		System.out.println(가능여부판단하기(앵무새가말한문장들, 검증해야하는문장));

	}

	private static String 가능여부판단하기(ArrayList<String> 앵무새가말한문장들, String 검증해야하는문장) {

		 ArrayDeque<String>[] 앵무새별큐 = new ArrayDeque[앵무새가말한문장들.size()];
		 for(int i = 0; i<앵무새별큐.length; i++){
			 앵무새별큐[i]=new ArrayDeque<>();
		 }

		for (int i = 0; i < 앵무새가말한문장들.size(); i++ ){
			StringTokenizer stringTokenizer = new StringTokenizer(앵무새가말한문장들.get(i));

			while(stringTokenizer.hasMoreTokens()){
				앵무새별큐[i].add(stringTokenizer.nextToken());
			}
		}

		StringTokenizer stringTokenizer = new StringTokenizer(검증해야하는문장);

		while (stringTokenizer.hasMoreTokens()) {
			String 단어 = stringTokenizer.nextToken();

			boolean 단어match = false;
			for (int i = 0; i < 앵무새별큐.length; i++) {
				if (단어.equals(앵무새별큐[i].peek())) {
					앵무새별큐[i].pop();
					단어match = true;
					break;
				}
			}

			if (!단어match) {
				return "Impossible";
			}
		}

		// 모든 앵무새의 큐가 비었는지 확인
		for (ArrayDeque<String> 큐 : 앵무새별큐) {
			if (!큐.isEmpty()) {
				return "Impossible";
			}
		}


		return "Possible";
	}


}
