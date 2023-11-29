//
// Created by goeth on 05/11/2023.
//

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid_hijo1, pid_hijo2, pid_hijo3;

    pid_hijo1 = fork();

    if (pid_hijo1 == 0) {
        // Primer hijo
        execl("/bin/ls", "ls", "-l", "/home", ">", "ejecutables.txt", NULL);
    } else {
        // Padre
        wait(NULL); // Espera a que el primer hijo termine

        pid_hijo2 = fork();
        if (pid_hijo2 == 0) {
            // Segundo hijo
            execl("/usr/bin/gedit", "gedit", "ejecutables.txt", NULL);
        } else {
            // Padre
            wait(NULL); // Espera a que el segundo hijo termine
            printf("Finalizado bloc de notas\n");

            pid_hijo3 = fork();
            if (pid_hijo3 == 0) {
                // Tercer hijo
                execl("/usr/bin/firefox", "firefox", "http://www.goole.com", NULL);
            } else {
                // Padre
                wait(NULL); // Espera a que el tercer hijo termine
                printf("Firefox ha terminado\n");
            }
        }
    }

    return 0;
}
