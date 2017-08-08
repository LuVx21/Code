#include <iostream>
using namespace std;

/*
g++ -o testmain main.cpp
 */

int test()
{
    int a = 10, b = 5;
    return a + b;
}

int main()
{
    cout<<"---begin---"<<endl;
    int num = test();
    cout<<"num="<<num<<endl;
    cout<<"---end---"<<endl;
}