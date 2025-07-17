/**
 * 각 수와 index를 묶고 가장 큰 수의 Index를 찾으면 되는 문제
 * 예제에서 85번은 7번째이지만 8이 출력된 것을 보면 index가 1부터 시작임.
 */

import Foundation

var max = 0
var index = 0

for i in 1 ... 9 {
    let num = Int(readLine()!)!
    
    if num > max {
        max = num
        index = i
    }
}

print(max)
print(index)