### Define a structure for a cricket player with members for player name, team name, and batting average. Write a program to input data for multiple players and sort them by batting average. (Use the concept of array and structures).

```bash
#include <stdio.h>
#include <string.h>

struct Player {
    char name[50];
    char team[50];
    float avg;
};

int main() {
    int n, i, j;
    printf("Enter number of players: ");
    scanf("%d", &n);

    struct Player p[n], temp;

    for (i = 0; i < n; i++) {
        printf("\nEnter details for player %d\n", i + 1);
        printf("Name: ");
        scanf("%s", p[i].name);
        printf("Team: ");
        scanf("%s", p[i].team);
        printf("Batting Average: ");
        scanf("%f", &p[i].avg);
    }

    for (i = 0; i < n - 1; i++) {
        for (j = i + 1; j < n; j++) {
            if (p[i].avg < p[j].avg) {
                temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }
    }

    printf("\nPlayers sorted by batting average:\n");
    for (i = 0; i < n; i++) {
        printf("%s (%s) - Average: %.2f\n", p[i].name, p[i].team, p[i].avg);
    }
    return 0;
}

```
