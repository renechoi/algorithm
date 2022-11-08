
## 카운트 정렬을 이용한다

import sys
n = int(sys.stdin.readline())

count = [0] * 10001 # 주어지는 수는 10,000보다 작거나 같다 

for _ in range(n):
    number_input = int(sys.stdin.readline())
    count[number_input] += 1
    
for occurance_at_counts in range(10001):
    for _ in range(count[occurance_at_counts]):
        print(occurance_at_counts)
        