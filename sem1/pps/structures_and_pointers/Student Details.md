### Define a structure to store student details (e.g., name, roll number, marks in three subjects). Write a program to input data for five students, calculate their total and average marks, and display the results.

```bash
#include <stdio.h>

struct Student {
    char name[50];
    int roll;
    float marks[3];
    float total;
    float avg;
};

int main() {
    struct Student s[5];
    int i, j;

    for (i = 0; i < 5; i++) {
        printf("\nEnter details for student %d\n", i + 1);
        printf("Name: ");
        scanf("%s", s[i].name);
        printf("Roll number: ");
        scanf("%d", &s[i].roll);
        s[i].total = 0;
        for (j = 0; j < 3; j++) {
            printf("Marks in subject %d: ", j + 1);
            scanf("%f", &s[i].marks[j]);
            s[i].total += s[i].marks[j];
        }
        s[i].avg = s[i].total / 3.0;
    }

    printf("\nStudent Details:\n");
    for (i = 0; i < 5; i++) {
        printf("%s (Roll %d) - Total: %.2f, Average: %.2f\n",
               s[i].name, s[i].roll, s[i].total, s[i].avg);
    }
    return 0;
}

```
