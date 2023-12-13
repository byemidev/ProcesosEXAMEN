#include <stdlib.h>


int
main(){

    system("find / -perm 777 > peligrosos.txt"); //busca en disco los ficheros con permisos 777 y los guarda en peligrosos.txt
    system("plumba peligrosos.txt &");  // abre en plumba peligrosos.txt
    system("firefox https://www.marca.com &"); // abre marca.com con firefox

    return 0;
}
