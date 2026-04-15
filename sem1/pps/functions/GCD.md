### Write a recursive function to find the GCD of two numbers. Write a main program which reads 2 numbers and finds the GCD of the numbers using the specified function. 

```bash
#include <stdio.h>

int GCD(int a, int b) {
    if (b == 0)
        return a;
    return GCD(b, a % b);
}

int main() {
    int num1, num2;
    printf("Enter two numbers: ");
    scanf("%d %d", &num1, &num2);
    printf("GCD of %d and %d is %d\n", num1, num2, GCD(num1, num2));
    return 0;
}
```
