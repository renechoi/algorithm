T = int(input())
a_numbers = []
b_numbers = []

for _ in range(T):
	a,b = map(int,input().split())
	a_remainder = a%10

	if a_remainder == 0:                 # 0인 경우는 10이므로 10 그대로 출력 
		print(10)
  
	elif a_remainder in [1,5,6]:         # 자기 자신을 그대로 출력하는 숫자들 그대로 출력 
		print(a_remainder)
  
	elif a_remainder in [4,9]:           # b도 10으로 나눈 나머지, 0이면 a 아니면 일의 자리
		b_remainder = b % 2
  
		if b_remainder == 0:
			print(a_remainder * a_remainder % 10)
   
		else:
			print(a_remainder)
   
	else:                                # 나머지가 0이면 a 출력, 아니면 a를 b**b의 나머지
		b_remainder = b % 4  
  
		if b_remainder ==0:
			print(a_remainder ** 4 % 10)
   
		else:
			print(a_remainder ** b_remainder % 10)
