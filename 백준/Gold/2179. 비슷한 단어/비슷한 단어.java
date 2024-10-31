import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<단어> 단어들 = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            단어들.add(new 단어(br.readLine(), i));
        }
        
        int 가장높은유사도 = -1;
        단어 결과단어1 = null;
        단어 결과단어2 = null;
        
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                단어 첫번째단어 = 단어들.get(i);
                단어 두번째단어 = 단어들.get(j);
                
                int 현재유사도 = get유사도(첫번째단어.value, 두번째단어.value);
                
                if(현재유사도 > 가장높은유사도) {
                    가장높은유사도 = 현재유사도;
                    결과단어1 = 첫번째단어;
                    결과단어2 = 두번째단어;
                }
                else if(현재유사도 == 가장높은유사도) {
                    if(첫번째단어.index < 결과단어1.index || 
                       (첫번째단어.index == 결과단어1.index && 두번째단어.index < 결과단어2.index)) {
                        결과단어1 = 첫번째단어;
                        결과단어2 = 두번째단어;
                    }
                }
            }
        }
        
        System.out.println(결과단어1.value);
        System.out.println(결과단어2.value);
    }
    
    static class 단어 {
        String value;
        int index;
        
        public 단어(String value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    static int get유사도(String str1, String str2) {
        int minLen = Math.min(str1.length(), str2.length());
        int 접두사길이 = 0;
        
        for(int i = 0; i < minLen; i++) {
            if(str1.charAt(i) == str2.charAt(i)) {
                접두사길이++;
            } else {
                break;
            }
        }
        return 접두사길이;
    }
}
