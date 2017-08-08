#include <stdio.h>
#include <stdlib.h>

/*
gcc -o libpycall.so -shared -fPIC pycall.c
*/

int foo(int a, int b)
{
  printf("you input %d and %d\n", a, b);
  return a + b;
}