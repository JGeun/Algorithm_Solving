#include<iostream>
#include<queue>
using namespace std;

/*
 * 1~N개의 자료구조가 있고, 각각의 자료구조에는 한 개의 원소가 있다.
 * 즉 이 문제는 스택일 때는 들어온 숫자를 pop하고, queue일 땐 이전 숫자를 pop해야하는 문제이다.
 * 하지만 N = 100,000, M = 100,000이기 때문에 10,000,000,000 이라서 1초 안에 해결이 안된다.
 *
 * 시간복잡도 M으로 해결하는 방법은 Stack일 경우는 FILO이기 때문에 들어온 값이 바로 pop됩니다.
 * Queue는 이전에 저장된 값이 pop되기 때문에 queue에 해당하는 값들만 관리하는 Queue에 넣어서 순차적으로 빼주면 됩니다.
 */
int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    int N, *A, *B, M, *ansList;
    queue<int> queue;

    cin >> N;
    A = new int[N];
    B = new int[N];

    for (int i=0; i<N; i++) {
        cin >> A[i];
    }
    for (int i=0; i<N; i++) {
        cin >> B[i];
    }

    for (int i=N-1; i>=0; i--) {
        if (A[i] == 0) { // Queue인 경우만
            queue.push(B[i]);
        }
    }

    cin >> M;
    ansList = new int[M];
    for (int j=0; j<M; j++) {
        int num;
        cin >> num;

        queue.push(num);
        ansList[j] = queue.front();
        queue.pop();
    }

    for (int i=0; i<M; i++) {
        cout << ansList[i] << ' ';
    }
    cout << "\n";
}
