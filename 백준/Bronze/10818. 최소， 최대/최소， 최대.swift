import Foundation

let N = Int(readLine()!)!
let arr = readLine()!.split(separator: " ").map { Int($0)! }

var max = Int.min
var min = Int.max
for i in 0 ... N-1 {
    if arr[i] > max {
        max = arr[i]
    }
    
    if arr[i] < min {
        min = arr[i]
    }
}

print("\(min) \(max)")