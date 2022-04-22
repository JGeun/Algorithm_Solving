function solution(lottos, win_nums) {
    var rate = [6, 6, 5, 4, 3, 2, 1];
    var result = lottos.filter(n => win_nums.includes(n)).length
    var zeroCnt = lottos.filter(l => l === 0).length
    return [rate[result+zeroCnt],rate[result]];
}