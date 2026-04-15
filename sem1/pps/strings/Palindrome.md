### Write a C program without using STRING-HANDLING functions to check whether the given string is a palindrome or not

```bash
#include <stdio.h>

int main() {
    char str[100];
    int i, len = 0, flag = 1;

    printf("Enter a string: ");
    fgets(str, sizeof(str), stdin);

    while (str[len] != '\0' && str[len] != '\n')
        len++;

    for (i = 0; i < len / 2; i++) {
        if (str[i] != str[len - i - 1]) {
            flag = 0;
            break;
        }
    }

    if (flag)
        printf("Palindrome\n");
    else
        printf("Not a palindrome\n");

    return 0;
}

```
