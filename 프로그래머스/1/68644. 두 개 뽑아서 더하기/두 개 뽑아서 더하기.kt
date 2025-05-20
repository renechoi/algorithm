import java.util.TreeSet

class Solution {

    companion object {
        // 입력 배열 (전역)
        lateinit var NUMBERS: IntArray

        // 중복 제거 + 오름차순 정렬용 TreeSet
        val SUMS: MutableSet<Int> = TreeSet()
    }

    private fun dfs(start: Int, depth: Int, currentSum: Int) {
        if (depth == 2) {          // 두 수를 골랐다면
            SUMS.add(currentSum)   // 합 저장
            return
        }
        for (i in start until NUMBERS.size) {
            dfs(i + 1, depth + 1, currentSum + NUMBERS[i])
        }
    }

    fun solution(numbers: IntArray): IntArray {
        NUMBERS = numbers
        
        dfs(0, 0, 0)

        return SUMS.toIntArray()
    }
}
