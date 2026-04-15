### Write a C program without using STRING-HANDLING functions to delete a word from the given sentence

```bash
#include <stdio.h>

int main() {
    char str[200], word[50], result[200];
    int i = 0, j = 0, k = 0, match, m;

    printf("Enter a sentence: ");
    fgets(str, sizeof(str), stdin);

    printf("Enter the word to delete: ");
    fgets(word, sizeof(word), stdin);

    // Remove newline from word
    for (m = 0; word[m] != '\0'; m++) {
        if (word[m] == '\n') word[m] = '\0';
    }

    while (str[i] != '\0') {
        match = 1;
        for (m = 0; word[m] != '\0'; m++) {
            if (str[i + m] != word[m]) {
                match = 0;
                break;
            }
        }
        if (match && (str[i + m] == ' ' || str[i + m] == '\0' || str[i + m] == '\n')) {
            i += m;
            if (str[i] == ' ') i++;
        } else {
            result[k++] = str[i++];
        }
    }
    result[k] = '\0';

    printf("Sentence after deletion: %s\n", result);
    return 0;
}

```
