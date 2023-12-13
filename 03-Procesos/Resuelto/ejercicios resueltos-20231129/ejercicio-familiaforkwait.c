/*
El programa debe crear un hijo debe mostrar el pid del hijo.
El hijo debe crear dos nietos: Imprimir los pid de los nietos. Los nietos debe dormirse forma aleatorio un tiempo entre 1 y 40 segundos, usar el codigo de numero aleatorio, los nietos deben devolver en el exit() el numero de segundos que se han dormido. Por ejemplo sleep(2) exit(2).
EL hijo debe espera de forma ordenada primero por el primer hijo, y luego por el segundo.
El padre debe esperar a que acabe el hijo y mostrar un mensaje.  
*/

#include <stdio.h>
#include <unistd.h>
#include <time.h>
#include <sys/wait.h>
#include <math.h>



int main() {
     // Inicializar la semilla del generador de números aleatorios
    //srand();

    // // Generar un número aleatorio entre 1 y 40
   
    pid_t pid = fork(); // Crea un nuevo proceso
    
    if (pid < 0) { // Error al crear el proceso
        perror("fork");
        return 1;
    } else if (pid == 0) { // Proceso hijo
        printf("Soy el proceso hijo!\n");
        pid_t pidNieto1 = fork();
        if (pidNieto1 < 0) { // Error al crear el proceso nieto1
            perror("fork nieto1");
            return 1;
        } else if (pidNieto1 == 0) { // Proceso nieto1
            
            srand(getpid());
            int num = rand() % 40 + 1;
            printf("Soy nieto1 me duermo %ds\n",num);
            sleep(num);
        }
        else { //hijo ahora padre de nieto1
            printf("Soy el proceso hijo, y el PID del nieto1 es %d\n", pidNieto1);
            wait(NULL);
            printf("Ha terminado nieto1\n");
            pid_t pidNieto2 = fork();
            if (pidNieto2 < 0) { // Error al crear el proceso nieto2
                perror("fork nieto2");
                return 1;
            } else if (pidNieto2 == 0) { // Proceso nieto2
                srand(getpid());
                int num = rand() % 40 + 1;
                printf("Soy nieto2 me duermo %ds\n",num);
                sleep(num);

            } else { //Proceso hijo
                printf("Soy el proceso hijo, y el PID del nieto2 es %d\n", pidNieto2);
                wait(NULL);
                printf("Ha terminado nieto2\n"); 
            }
        }

    } else { // Proceso padre
        printf("Soy el proceso padre, y el PID de mi hijo es %d\n", pid);
        wait(NULL);
        printf("Han terminado todos...");
    }
    
    return 0;
}