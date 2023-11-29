#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>

int main() {
    int pipe_fd[2];
    pid_t child_pid;
    char buffer[100];

    // Crear un pipe
    if (pipe(pipe_fd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    // Crear un proceso hijo
    if ((child_pid = fork()) == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (child_pid == 0) {  // Código del proceso hijo
        // Cerrar el descriptor de lectura que no se va a usar en el hijo
        close(pipe_fd[0]);

        // Escribir tres mensajes en el pipe
        char mensajes[3][100] = {"Hola, soy tu hijo!", "Mensaje número 2", "Último mensaje"};
        for (int i = 0; i < 3; i++) {
            write(pipe_fd[1], mensajes[i], strlen(mensajes[i]) + 1);
            sleep(2); // Dormir por dos segundos
        }

        // Cerrar el descriptor de escritura después de usarlo
        close(pipe_fd[1]);
        sleep(15);
    } else {  // Código del proceso padre
        // Cerrar el descriptor de escritura que no se va a usar en el padre
        close(pipe_fd[1]);

        // Leer los mensajes del pipe
        for (int i = 0; i < 3; i++) {
            read(pipe_fd[0], buffer, sizeof(buffer));
            printf("Mensaje del hijo: %s\n", buffer);
        }

        // Imprimir mensaje final
        wait(NULL);
        printf("Terminó mi hijo\n");

        // Cerrar el descriptor de lectura después de usarlo
        close(pipe_fd[0]);
    }

    return EXIT_SUCCESS;
}
