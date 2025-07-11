//
//  main.swift
//  CodingTest
//
//  Created by 박정근 on 7/12/25.
//

import Foundation

let A = readLine()!
let B = readLine()!
let aNum = Int(A)!
let bNum = Int(B)!
let aArr = A.map { Int(String($0))! }
let bArr = B.map { Int(String($0))! }

for bIdx in stride(from: aArr.count - 1, through: 0, by: -1) {
    print(bArr[bIdx] * aNum)
}

print(aNum * bNum)
