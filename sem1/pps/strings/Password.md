### Write a C program without using STRING-HANDLING functions to read a string representing a password character by character and mask every character in the input with '*'.

```bash
#include <stdio.h>
#include <conio.h> // for getch()

int main() {
    char pass[50];
    int i = 0;
    char ch;

    printf("Enter password: ");
    while (1) {
        ch = getch();
        if (ch == '\r') break;
        pass[i++] = ch;
        printf("*");
    }
    pass[i] = '\0';

    printf("\nPassword entered: %s\n", pass);
    return 0;
}
```
