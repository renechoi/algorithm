arr=list(map(int,input().strip().split()))
arr.sort()
print("2" if arr[0]==arr[1] and arr[1]==arr[2] 
      else "1" if arr[2]**2==(arr[0]**2+arr[1]**2) 
      else "0")