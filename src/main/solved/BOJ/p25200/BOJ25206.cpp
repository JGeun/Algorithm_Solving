#include<iostream>
#include<map>
using namespace std;

void initGradeMap(map<string, float>& gradeMap) {
    gradeMap["A+"] = 4.5;
    gradeMap["A0"] = 4.0;
    gradeMap["B+"] = 3.5;
    gradeMap["B0"] = 3.0;
    gradeMap["C+"] = 2.5;
    gradeMap["C0"] = 2.0;
    gradeMap["D+"] = 1.5;
    gradeMap["D0"] = 1.0;
    gradeMap["F"] = 0.0;
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);

    map<string, float> gradeMap;
    initGradeMap(gradeMap);

    float majorSum = 0.0f;
    float creditSum = 0.0f;
    for (int i=0; i<20; i++) {
        string subject;
        float credit;
        string grade;

        cin >> subject >> credit >> grade;

        if (grade == "P") continue;

        majorSum += gradeMap[grade] * credit;
        creditSum += credit;
    }

    if (creditSum == 0) {
        cout << 0.000000 << "\n";
    } else {
        cout << majorSum/creditSum << "\n";
    }
}