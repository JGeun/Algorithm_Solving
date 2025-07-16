import Foundation

let N = Int(readLine()!)!

for i in 1...N {
    for _ in stride(from: N-i, to: 0, by: -1) {
        print(" ", terminator: "")
    }
    for _ in 1...i {
        print("*", terminator: "")
    }
    print()
}