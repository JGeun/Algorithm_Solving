import Foundation

let input = readLine()!.split(separator: " ").map { Int($0)! }
let A = input[0]
let B = input[1]
let C = Int(readLine()!)!

var hour = A
var min = B + C
if (min >= 60) {
    hour = (A + min / 60) % 24
    min = min - min / 60 * 60
}

print("\(hour) \(min)")