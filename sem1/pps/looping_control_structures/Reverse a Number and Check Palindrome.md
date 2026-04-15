##  Reverse a given number and check if it is a palindrome or not

```bash
// Program 1: Reverse a Number and Check Palindrome (Using while loop)
#include <stdio.h>

int main() {
    int num, original, reverse = 0, remainder;
    printf("Enter a number: ");
    scanf("%d", &num);

    original = num;

    while (num != 0) {
        remainder = num % 10;
        reverse = reverse * 10 + remainder;
        num /= 10;
    }

    printf("Reversed Number: %d\n", reverse);

    if (original == reverse)
        printf("The number is a palindrome.\n");
    else
        printf("The number is not a palindrome.\n");

    return 0;
}

```
