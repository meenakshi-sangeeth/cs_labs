### Write a program to multiply two numbers using a recursive function

```bash
#include <stdio.h>

int multiply(int a, int b) {
    if (b == 0)
        return 0;
    if (b > 0)
        return a + multiply(a, b - 1);
    return -multiply(a, -b); // handle negative multiplier
}

int main() {
    int num1, num2;
    printf("Enter two numbers: ");
    scanf("%d %d", &num1, &num2);
    printf("Product of %d and %d is %d\n", num1, num2, multiply(num1, num2));
    return 0;
}
