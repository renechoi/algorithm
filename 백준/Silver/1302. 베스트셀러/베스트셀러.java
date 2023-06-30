
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		int bookCounts = Integer.parseInt(bufferedReader.readLine());

		String[] books = new String[bookCounts];
		while(bookCounts-->0){
			String bookTitle = bufferedReader.readLine();
			books[bookCounts] = bookTitle;
		}

		Arrays.sort(books, Comparator.naturalOrder());

		String topBook =books[0];
		int count = 1;
		int max = 1;
		for (int i =0; i<books.length; i++){
			if (i==0){
				continue;
			}
			if (books[i].equals(books[i-1])){
				count++;
				if (max < count) {
					max = count;
					topBook = books[i];
				}
			} else{
				count = 1;
			}
		}
		System.out.println(topBook);
	}
}

