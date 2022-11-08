import sys

def merge_sort(start, end):
    global swap_cnt, ARR

    if start < end:
        mid = (start + end) // 2
        merge_sort(start, mid)
        merge_sort(mid + 1, end)

        left_idx, right_idx = start, mid + 1
        new_arr = []

        # 비교를 통해 swap을 하는 부분은 다음 비교를 위해 idx를 올려준다 
        while left_idx <= mid and right_idx <= end:
            if ARR[left_idx] <= ARR[right_idx]:
                new_arr.append(ARR[left_idx])
                left_idx += 1
            else:
                new_arr.append(ARR[right_idx])
                right_idx += 1
                swap_cnt += mid - left_idx + 1  # 버블 swap 카운팅 

        if left_idx <= mid:
            new_arr = new_arr + ARR[left_idx : mid + 1]
        if right_idx <= end:
            new_arr = new_arr + ARR[right_idx : end + 1]

        for i in range(len(new_arr)):
            ARR[start + i] = new_arr[i]


if __name__ == "__main__":
    swap_cnt = 0
    N = int(sys.stdin.readline())
    ARR = list(map(int, sys.stdin.readline().split()))
    merge_sort(0, N - 1)
    print(swap_cnt)