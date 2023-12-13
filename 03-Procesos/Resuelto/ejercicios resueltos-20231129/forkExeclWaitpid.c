/*
El programa padre debe crear un primer hijo. Este debe con execl debe listar todos los ficheros ejecutables de la carpeta home y guardarlos en un fichero ejecutables.txt.
Cuando el primer hijo acabe debe crear dos hijos mas.
EL primero debe abrir en un bloc de notas (pluma, gedit) el fichero anterior.
El segundo debe abrir un navegador con url dada.
El padre cuando se cierre el bloc de notas debe escribir finalizado bloc de notas y cuando el firefox ha terminado firefox.
*/

 
        


#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/wait.h>
#include <unistd.h>
#include <fcntl.h>
int main() {
    
    pid_t child_pid;
     if ((child_pid = fork()) == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }

    if (child_pid == 0) {  // Código del proceso hijo
    int fd = open("ejecutables.txt", O_RDWR | O_CREAT, S_IRUSR | S_IWUSR|0x744);

        dup2(fd, 1);   // salida estandar
        dup2(fd, 2);   // salida de error

        close(fd);     // cerramos fichero
        execl("/usr/bin/find", "find", "/home", "-type", "f", "-executable", (char *) NULL);
    } else {  // Código del proceso padre
        wait(NULL); // Espera a que el hijo termine
        pid_t hijo2;
        //hijo2
        if ((hijo2 = fork()) == -1) {
            perror("fork");
            exit(EXIT_FAILURE);
        }
        if (hijo2 == 0) {
            execl( "/usr/bin/mousepad","mousepad" , "ejecutables.txt"  , (char *) 0 );
        }
        else //padre
        {
            pid_t hijo3;
            if ((hijo3 = fork()) == -1) {
                perror("fork");
                exit(EXIT_FAILURE);
            }
            if (hijo3 == 0) {
                execl( "/usr/bin/firefox", "firefox" , "https://www.google.es"  , (char *) 0 );
            }
            else
            {
                wait(NULL);
                printf("Terminado firefox\n");
            }
            wait(NULL);
            printf("Terminado bloc de notas\n");

        }



    }
    return 0;
}