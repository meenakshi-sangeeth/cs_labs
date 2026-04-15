## Arrange elements in ascending/descending order using bubble sort

```bash
#include <stdio.h>

void bubbleSort(int arr[], int n, char order) {
    int i, j, temp;
    for (i = 0; i < n-1; i++) {
        for (j = 0; j < n-i-1; j++) {
            if ((order == 'a' && arr[j] > arr[j+1]) ||
                (order == 'd' && arr[j] < arr[j+1])) {
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

int main() {
    int n, i;
    char choice;
    printf("Enter number of elements: ");
    scanf("%d", &n);
    int arr[n];
    printf("Enter elements:\n");
    for (i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("Enter 'a' for ascending or 'd' for descending: ");
    scanf(" %c", &choice);

    bubbleSort(arr, n, choice);

    printf("Sorted array: ");
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);
    return 0;
}

```
 
