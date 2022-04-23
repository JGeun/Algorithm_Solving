function solution(left, right) {
    var answer = 0;
    for(let i=left; i<=right; i++){
        if(getDivisorCnt(i)%2==0) answer+=i;
        else answer-=i;
    }
    return answer;
}

function getDivisorCnt(num){
    let cnt = 0;
    for(let i=1; i<=num; i++){
        if(num%i == 0) cnt+=1
    }
    return cnt;
}