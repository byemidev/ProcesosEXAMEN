//
// Created by goeth on 05/11/2023.
//

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define MAX_NUM 13

void write_tables(int num) {
    for (int i = 1; i <= num; i++) {
        char filename[20];
        sprintf(filename, "tabla%d.txt", i);
        FILE *file = fopen(filename, "w");
        for (int j = 1; j <= 10; j++) {
            fprintf(file, "%d x %d = %d\n", i, j, i*j);
        }
        fclose(file);
    }
}

void read_tables(int num) {
    for (int i = 1; i <= num; i++) {
        char filename[20];
        sprintf(filename, "tabla%d.txt", i);
        FILE *file = fopen(filename, "r");
        char line[50];
        while (fgets(line, sizeof(line), file)) {
            printf("%s", line);
        }
        fclose(file);
        printf("\n");
    }
}

int main() {
    pid_t pid = fork();
    if (pid == 0) {
        write_tables(MAX_NUM);
    } else {
        wait(NULL);
        read_tables(MAX_NUM);
    }
    return 0;
}