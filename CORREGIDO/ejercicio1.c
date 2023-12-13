/*
Debes hacer un programa en C que haga lo siguiente.

El proceso padre va crear un hijo se va a crear un pipe entre el padre y el hijo (2 puntos.).

El hijo va a crear otro hijo(hijo2 o nieto como queráis), ese hijo va tener una variable que guarde 
un numero aleatorio entre 1 y 20. 
Debe mostrar ciclo1 me duermo, ciclo 2 me duermo.... cada ciclo se debe dormir un segundo (1punto)

El hijo debe esperar por su (hijo2 nieto) y cuando acabe mandar 30 mensajes de la forma mensaje-hijo 1, mensaje-hijo 2, 
mensaje-hijo 3. cuando termine de mandar los mensajes deberá dormir de forma aleatoria entre 1 y 10 segundos....

El padre cada mensaje recibido debe mostrar "recibido: mensaje-hijo 1" cada vez que llegue. 
Cuando acabe de esperar por que acabe el hijo y mostrar el "hijo ha finalizado". (2 puntos)
*/


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>
#define BUFFER_SIZE 1024

int main()
{
    int pipe_fd[2];
    pid_t hijo1;
    char buffer[BUFFER_SIZE];
    // Crear un pipe
    if (pipe(pipe_fd) == -1) {
        perror("pipe");
        exit(EXIT_FAILURE);
    }

    // Crear un proceso hijo
    if ((hijo1 = fork()) == -1) {
        perror("fork");
        exit(EXIT_FAILURE);
    }
    if (hijo1 == 0) { // Código del proceso hijo
        pid_t hijo2;
        if ((hijo2 = fork()) == -1) {
            perror("fork");
            exit(EXIT_FAILURE);
        }
        if (hijo2 == 0) { //Hijo2
            int num = rand() % 20 + 1;
            for(int i=1;i<=num;i++)
            {
                printf("ciclo %d me duermo\n",i);
                sleep(1);
            }
        }
        else{// hijo1
            // Espera a que cada hijo2 termine
            wait(NULL);
            //cierro el pipe de lectura
            close(pipe_fd[0]); 
            for(int i=0;i<30;i++)
            {
                
                // Escribir un mensaje en el pipe
                char mensaje[BUFFER_SIZE];
                snprintf(mensaje, BUFFER_SIZE, "mensaje-hijo %d", i+1);
                write(pipe_fd[1], mensaje, strlen(mensaje) + 1);
                sleep(1);   
            }
            close(pipe_fd[1]);
            int num = rand() % 10 + 1;
            sleep(num);


        }


    }
    else{ //Padre
        //cierro el pipe de lectura
        close(pipe_fd[1]);
        for(int i=0;i<30;i++)
        {
            //leemos el mensaje
            read(pipe_fd[0], buffer, BUFFER_SIZE); 
            printf("Recibido: %s\n", buffer);
            fflush(stdout);
            
        }
            
        close(pipe_fd[0]);
        //Espera por el hijo
        wait(NULL);
        printf("hijo ha finalizado\n");


    }

}