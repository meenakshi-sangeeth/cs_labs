###  Write a C program without using STRING-HANDLING functions to count the number of words in a sentence.

```bash
#include <stdio.h>

int main() {
    char str[200];
    int i, count = 0;

    printf("Enter a sentence: ");
    fgets(str, sizeof(str), stdin);

    for (i = 0; str[i] != '\0'; i++) {
        if ((str[i] != ' ' && str[i] != '\n') && 
           (str[i+1] == ' ' || str[i+1] == '\n' || str[i+1] == '\0')) {
            count++;
        }
    }

    printf("Number of words: %d\n", count);
    return 0;
}
```
