// 구현 문제
/**
 * 1. 1초마다 각각의 points를 이동시켜야 함. (route에 가깝게)
 * 2. map에 표시를 끝낸 다음 중첩되는 위치가 있는지 확인해서 개수를 더해 줌. (중첩되는 위치를 어떻게 판단할 것인가? - HashMap으로 판단 (맵을 전체 순회하는 것은 비효율적.))
 * 3. 매번 이동한 위치를 저장해줘야 함.
 */

data class Robot(
    // 목표 지점 리스트
    val targetList: List<Int>,
    // 현재 목표 위치
    val targetIndex: Int,
    // 현재 지도 위치 r
    val x: Int,
    // 현재 지도 위치 c
    val y: Int
) {
    fun hasValidateWork() = targetIndex < targetList.size
}

class Solution {
    
    fun solution(points: Array<IntArray>, routes: Array<IntArray>): Int {
        var answer: Int = 0
        
        val robotList: Array<Robot> = initRobotList(points, routes)
        val finished = BooleanArray(robotList.size) { false }
    
        // 초기 위치 충돌 계산
        answer += calcConflict(robotList)
        
        var isAllFinish = false
        val workingRobots = mutableListOf<Robot>()
        
        while (isAllFinish.not()) {
            isAllFinish = true
            workingRobots.clear()
            
            // 이동하면서 points 새롭게 저장
            for (i in robotList.indices) {
                val robot = robotList[i]
                
                if (robot.hasValidateWork().not()) continue
                isAllFinish = false
                
                val newRobot = moveToNext(robotList[i], points[robot.targetList[robot.targetIndex] - 1])
                robotList[i] = newRobot
                workingRobots.add(newRobot)
            }
            
            // 이번에 동작한 로봇의 충돌 확인
            answer += calcConflict(workingRobots.toTypedArray())
        }
        
        return answer
    }
    
    fun calcConflict(robotList: Array<Robot>): Int {
        var res = 0
        val pointMap = HashMap<Pair<Int, Int>, Int>()
        
        for (robot in robotList) {
            val key = Pair(robot.x, robot.y)
            pointMap[key] = pointMap.getOrDefault(key, 0) + 1
        }
        
        for ((_, value) in pointMap) {
            if (value >= 2) {
                res += 1
            }
        }
        
        return res
    }
    
    fun initRobotList(points: Array<IntArray>, routes: Array<IntArray>): Array<Robot> {
        val robotList = mutableListOf<Robot>()
        
        for (i in routes.indices) {
            val start = routes[i][0] - 1
            
            val robot = Robot(
                targetList = routes[i].toList(),
                targetIndex = 1,
                x = points[start][0],
                y = points[start][1]
            )
            
            robotList.add(robot)
        }
        
        return robotList.toTypedArray()
    }
    
    fun moveToNext(robot: Robot, dest: IntArray): Robot {
        
        val (nx, ny) = when {
            dest[0] > robot.x -> robot.x + 1 to robot.y
            dest[0] < robot.x -> robot.x - 1 to robot.y
            dest[1] > robot.y -> robot.x to robot.y + 1
            else -> robot.x to robot.y - 1
        }
        
        val newTargetIndex = if (nx == dest[0] && ny == dest[1]) {
            robot.targetIndex + 1
        } else {
            robot.targetIndex
        }
        
        return robot.copy(
            targetIndex = newTargetIndex,
            x = nx,
            y = ny
        )
    }
}