## Check if the sum of the cubes of all digits of an inputted number equals the number itself (Armstrong Number)

```bash
#include <stdio.h>

int main() {
    int num, original, sum = 0, remainder;

    printf("Enter a number: ");
    scanf("%d", &num);

    original = num;

    while (num != 0) {
        remainder = num % 10;
        sum += remainder * remainder * remainder;
        num /= 10;
    }

    if (sum == original)
        printf("It is an Armstrong number.\n");
    else
        printf("It is not an Armstrong number.\n");

    return 0;
}
```
