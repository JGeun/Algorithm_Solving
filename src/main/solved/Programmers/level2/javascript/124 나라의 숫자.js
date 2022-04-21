function solution(n) {
    var answer = '';
    let store = ['4', '1', '2'];

    while(n != 0){
        answer = store[n%3] + answer;
        if(n%3==0) n-=3;
        n = parseInt(n/3);
    }
    return answer;
}