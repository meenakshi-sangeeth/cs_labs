### Write a C program without using STRING-HANDLING functions to search for a given substring in the main string

```bash
#include <stdio.h>

int main() {
    char str[200], sub[50];
    int i, j, found;

    printf("Enter the main string: ");
    fgets(str, sizeof(str), stdin);

    printf("Enter the substring to search: ");
    fgets(sub, sizeof(sub), stdin);

    for (i = 0; sub[i] != '\0'; i++)
        if (sub[i] == '\n') sub[i] = '\0';

    for (i = 0; str[i] != '\0'; i++) {
        found = 1;
        for (j = 0; sub[j] != '\0'; j++) {
            if (str[i + j] != sub[j]) {
                found = 0;
                break;
            }
        }
        if (found) {
            printf("Substring found at position %d\n", i + 1);
            return 0;
        }
    }

    printf("Substring not found\n");
    return 0;
}

```
