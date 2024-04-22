import java.util.*;

class Patient implements Comparable<Patient> {
    int emergency;
    int index;

    Patient(int emergency, int index) {
        this.emergency = emergency;
        this.index = index;
    }

    // 내림차순 정렬을 위한 compareTo 구현
    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.emergency, this.emergency);
    }
}

class Solution {
    public int[] solution(int[] emergency) {
        List<Patient> patients = new ArrayList<>();

        // 환자 객체 초기화
        for (int i = 0; i < emergency.length; i++) {
            patients.add(new Patient(emergency[i], i));
        }

        // 환자 리스트 정렬
        Collections.sort(patients);

        // 결과 배열 초기화
        int[] result = new int[emergency.length];
        for (int i = 0; i < patients.size(); i++) {
            result[patients.get(i).index] = i + 1; // 순위 할당
        }

        return result;
    }
}
