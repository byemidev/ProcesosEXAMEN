#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>


int main()
{
    int fd = open("salida.txt", O_RDWR | O_CREAT, S_IRUSR | S_IWUSR|0x744);

    dup2(fd, 1);   // salida estandar
    dup2(fd, 2);   // salida de error
               
    close(fd);     // cerramos fichero
    execl( "/bin/ls" , "ls" , "-la" , (char *) 0 );

return 0;
}