#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

// este programa es igual pero sin esperar por un pid concreto
int main() {
    pid_t pid1, pid2;

    // Crear el primer hijo
    if ((pid1 = fork()) == 0) {
        // Código del primer hijo
        printf("Hijo 1: PID = %d\n", getpid());
        sleep(20);  // Simula trabajo del hijo
        exit(10);  // El hijo termina con estado 10
    } else if (pid1 > 0) {
        // Crear el segundo hijo
        if ((pid2 = fork()) == 0) {
            // Código del segundo hijo
            printf("Hijo 2: PID = %d\n", getpid());
            sleep(4);  // Simula trabajo del hijo
            exit(20);  // El hijo termina con estado 20
        } else if (pid2 > 0) {
            // Código del padre
            int status;
            pid_t waited_pid;

            // El primero que acabe
            waited_pid = waitpid(-1, &status, 0);
            printf("Padre: Hijo %d terminado con estado %d\n", waited_pid, WEXITSTATUS(status));

            // El segundo que acabe
            waited_pid = waitpid(-1, &status, 0);
            printf("Padre: Hijo %d terminado con estado %d\n", waited_pid, WEXITSTATUS(status));
        } else {
            perror("fork");
            exit(EXIT_FAILURE);
        }
    } else {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    return 0;
}

