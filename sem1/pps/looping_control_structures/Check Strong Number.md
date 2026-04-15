## Check whether the given number is strong or not. (Positive number whose sum of the factorial of its digits is equal to the number itself.)

```bash
#include <stdio.h>

int factorial(int n) {
    int fact = 1, i;
    for (i = 1; i <= n; i++)
        fact *= i;
    return fact;
}

int main() {
    int num, original, sum = 0, remainder;

    printf("Enter a number: ");
    scanf("%d", &num);

    original = num;

    while (num != 0) {
        remainder = num % 10;
        sum += factorial(remainder);
        num /= 10;
    }

    if (sum == original)
        printf("It is a Strong number.\n");
    else
        printf("It is not a Strong number.\n");

    return 0;
}
```
