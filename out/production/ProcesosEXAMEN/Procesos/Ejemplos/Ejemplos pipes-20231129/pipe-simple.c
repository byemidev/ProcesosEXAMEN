#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

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

    if (child_pid == 0) { // Código del proceso hijo
        // Cerrar el descriptor de lectura que no se va a usar en el hijo
        close(pipe_fd[0]);

        // Escribir un mensaje en el pipe
        char message[] = "Hola, soy tu hijo!";
        write(pipe_fd[1], message, strlen(message) + 1);

        // Cerrar el descriptor de escritura después de usarlo
        close(pipe_fd[1]);
    } else { // Código del proceso padre
        // Cerrar el descriptor de escritura que no se va a usar en el padre
        close(pipe_fd[1]);

        // Leer el mensaje del pipe
        read(pipe_fd[0], buffer, sizeof(buffer));

        // Imprimir el mensaje recibido
        printf("Mensaje del hijo: %s\n", buffer);

        // Cerrar el descriptor de lectura después de usarlo
        close(pipe_fd[0]);
    }

    return EXIT_SUCCESS;
}
