class Solution {
    public long solution(int n, int[] times) {
			long left = 1;
			long right = getMaxTime(n, times);
			long answer = right; // 일단 최대로 초기화

			while (left <=right){
				long mid = (left + right) / 2;
				long count = 0;
				for (int t : times) {
					count += mid / t;
					if(count >= n) {
						break;
					}
				}

				if (count >= n) {
					answer = mid;
					right = mid - 1;    // 더 줄여보기
				} else {
					// 처리 불가능 → 시간을 늘려야 함
					left = mid + 1;
				}

			}

			return answer;
		}

	private static long getMaxTime(long n, int[] times) {
		long maxTime = 0;
		for (int t : times) {
			if (t > maxTime) {
				maxTime = t;
			}
		}
		// 최대 시간 (가장 느린 심사관이 n명을 처리)
		return maxTime * n;
	}
}