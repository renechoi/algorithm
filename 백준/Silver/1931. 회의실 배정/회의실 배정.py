N = int(input())
meetings = [list(map(int, input().split())) for _ in range(N)]

# 정렬 기준을 사용하여 정렬하는 방법 
## 끝나는 시간(x[1])을 먼저 정렬 -> 같다면 -> 시작되는 시간(x[0])
meetings.sort(key=lambda x: (x[1], x[0]))

answer = 0
end_time = 0

for i in range(len(meetings)):
    if end_time <= meetings[i][0]:
        end_time = meetings[i][1]
        answer += 1

print(answer)