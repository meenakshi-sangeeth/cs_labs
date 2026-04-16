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
