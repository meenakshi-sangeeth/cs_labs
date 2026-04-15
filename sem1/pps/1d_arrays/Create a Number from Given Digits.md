## Write a C program to enter number of digits and create a number using this digit. 

### [Hint: Enter number of digits: 3, Enter units’ place digit: 1, Enter tens place digit: 2, Enter hundreds place digit: 5; The number is 521] 

```bash
#include <stdio.h>
#include <math.h>

int main() {
    int digits, i, num = 0, place;
    printf("Enter number of digits: ");
    scanf("%d", &digits);

    for (i = digits - 1; i >= 0; i--) {
        printf("Enter digit for %d's place: ", (int)pow(10, i));
        scanf("%d", &place);
        num = num * 10 + place;
    }

    printf("The number is: %d\n", num);
    return 0;
}
```
