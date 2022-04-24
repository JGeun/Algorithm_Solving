package Programmers.level1.kotlin

class Solution {
    private var answer = 0
    fun solution(nums: IntArray): Int {

        makeCase(1, nums, IntArray(nums.size+1), BooleanArray(nums.size));
        return answer
    }

    private fun makeCase(cnt: Int, nums: IntArray, store: IntArray, visit: BooleanArray){
        if(cnt == 4){
            var sum = nums[store[1]] + nums[store[2]] + nums[store[3]]
            if(isPrime(sum)) answer+=1
            return
        }

        for(i in store[cnt-1] until nums.size){
            if(!visit[i]){
                visit[i] = true
                store[cnt] = i
                makeCase(cnt+1, nums, store, visit)
                visit[i] = false
            }
        }
    }

    private fun isPrime(num : Int) : Boolean{
        for(i in 2 .. (Math.sqrt(num.toDouble()).toInt())){
            if(num%i==0) return false
        }

        if(num < 2) return false
        return true
    }
}