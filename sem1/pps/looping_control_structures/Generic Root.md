## Find out the generic root of any number. [Hint: Generic root is the sum of digits of a number until a single digit is obtained.]

```bash
#include <stdio.h>

int main() {
    int num;
    printf("Enter a number: ");
    scanf("%d", &num);

    while (num >= 10) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        num = sum;
    }

    printf("Generic root: %d\n", num);
    return 0;
}
```
