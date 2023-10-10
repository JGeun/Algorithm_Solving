#include <iostream>
#include <deque>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    int N, cmd, X;
    deque<int> deque;
    cin >> N;

    while(N-->0) {
        cin >> cmd;

        if (cmd == 1) {
            cin >> X;
            deque.push_front(X);
        } else if (cmd == 2) {
            cin >> X;
            deque.push_back(X);
        } else if (cmd == 3) {
            if(!deque.empty()) {
                cout << deque.front() << "\n";
                deque.pop_front();
            } else {
                cout << -1 << "\n";
            }
        } else if (cmd == 4) {
            if(!deque.empty()) {
                cout << deque.back() << "\n";
                deque.pop_back();
            } else {
                cout << -1 << "\n";
            }
        } else if (cmd == 5) {
            cout << deque.size() << "\n";
        } else if (cmd == 6) {
            if (deque.empty()) {
                cout << 1 << "\n";
            } else {
                cout << 0 << "\n";
            }
        } else if (cmd == 7) {
            if (!deque.empty()) {
                cout << deque.front() << "\n";
            } else {
                cout << -1 << "\n";
            }
        } else if (cmd == 8) {
            if (!deque.empty()) {
                cout << deque.back() << "\n";
            } else {
                cout << -1 << "\n";
            }
        }
    }

    return 0;
}
