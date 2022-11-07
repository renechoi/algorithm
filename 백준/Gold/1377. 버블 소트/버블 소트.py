import sys

n = int(sys.stdin.readline())
arr = []

for i in range(n):
    arr.append( (int(sys.stdin.readline()), i) )

new_arr = sorted(arr)
answer = []

for i in range(n):
    answer.append(new_arr[i][1] - arr[i][1] +1)
    
print(max(answer))