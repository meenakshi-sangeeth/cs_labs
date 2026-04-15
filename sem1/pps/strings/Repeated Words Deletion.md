### Write a C program without using STRING-HANDLING functions to delete all repeated words in the given string

```bash
#include <stdio.h>

int main() {
    char str[200], words[50][50];
    int i = 0, j = 0, count = 0, k, l, duplicate;

    printf("Enter a sentence: ");
    fgets(str, sizeof(str), stdin);

    // Extract words manually
    while (str[i] != '\0' && str[i] != '\n') {
        if (str[i] != ' ') {
            words[count][j++] = str[i];
        } else {
            words[count][j] = '\0';
            count++;
            j = 0;
        }
        i++;
    }
    words[count][j] = '\0';
    count++;

    // Remove duplicates manually
    for (i = 0; i < count; i++) {
        for (j = i + 1; j < count; j++) {
            duplicate = 1;
            for (k = 0; words[i][k] != '\0' || words[j][k] != '\0'; k++) {
                if (words[i][k] != words[j][k]) {
                    duplicate = 0;
                    break;
                }
            }
            if (duplicate) {
                for (l = j; l < count - 1; l++) {
                    k = 0;
                    while ((words[l][k] = words[l+1][k]) != '\0')
                        k++;
                }
                count--;
                j--;
            }
        }
    }

    printf("Sentence after removing duplicates: ");
    for (i = 0; i < count; i++) {
        printf("%s", words[i]);
        if (i < count - 1) printf(" ");
    }
    printf("\n");

    return 0;
}

```
