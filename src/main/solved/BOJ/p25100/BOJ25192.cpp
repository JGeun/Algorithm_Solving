#include <iostream>
#include <set>
#include <string>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    int N, res = 0;
    string person;
    set<string> personSet;

    cin >> N;
    while(N-->0) {
        cin >> person;
        if (person == "ENTER") {
            res += personSet.size();
            personSet.clear();
            continue;
        }

        personSet.insert(person);
    }

    res += personSet.size();
    cout << res << "\n";

    return 0;
}
