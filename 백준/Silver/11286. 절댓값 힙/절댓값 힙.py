import sys
import heapq

N = int(input())
heap = []

for i in range(N):
    x = int(sys.stdin.readline())
    
    if x == 0:
        if not heap:
            print(0)
        else:
            print(heapq.heappop(heap)[1])   # Pop the smallest item off the heap, maintaining the heap invariant.
        
    else:
        heapq.heappush(heap,(abs(x),x)) #Push item onto heap, maintaining the heap invariant.