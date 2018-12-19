/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab05_metodosdeordenamiento;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Dell
 */
public class LAB05_MetodosDeOrdenamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    }

    public void ordenamientoBurbuja(int vector[], int n) {
        int aux;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (vector[i] > vector[j]) {
                    aux = vector[i];
                    vector[i] = vector[j];
                    vector[j] = aux;

                }
            }

        }
    }

    public void quickSort(int[] v, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }
        int pivote = v[inicio];
        int izq = inicio + 1;
        int der = fin;
        while (izq <= der) {
            while (izq <= fin && v[izq] < pivote) {
                izq++;

            }
            while (der > inicio && v[der] >= pivote) {
                der--;
            }
            if (izq < der) {
            }
            if (izq < der) {
                int tmp = v[izq];
                v[izq] = v[der];
                v[der] = tmp;

            }
        }
        if (der > inicio) {
            int tmp = v[inicio];
            v[inicio] = v[der];
            v[der] = tmp;
        }
        quickSort(v, inicio, der - 1);
        quickSort(v, der + 1, fin);
    }

    //algoritmo de ordenacion ShellSort

    public void ordenacionShell(int[] v, int N) {
        int incremento = N;
        do {
            incremento = incremento / 2;
            for (int k = 0; k < incremento; k++) {
                for (int i = incremento + k; i < N; i += incremento) {
                    int j = i;
                    while (j - incremento >= 0 && v[j] < v[j - incremento]) {
                        int tmp = v[j];
                        v[j] = v[j - incremento];
                        v[j - incremento] = tmp;
                        j -= incremento;

                    }
                }
            }
        } while (incremento > 1);
    }

    public void ordenaciontoRadix(int[] v) {
        int max = 1;  //cantidad de repeticiones
        int nbytes = 4; //numeros de bytes a desplazar
        int nColas = (int) Math.pow(2, nbytes);
        //creacion he inicializacion del arreglo de colas
        Queue<Integer>[] cola = new LinkedList[nColas];
        for (int i = 0; i < nColas; i++) {
            cola[i] = new LinkedList<Integer>();

        }
        int div = 0; //posicion a comparar  
        for (int i = 0; i < max; i++) {
            for (int numero : v) {
                if (i == 0) {
                    if (numero > max) {
                        max = numero;

                    }
                }
                //colocar cada cola que debe ir en cada numero
                int numCola = (numero >> div) & 0xf;
                cola[numCola].add(numero);

            }
            //rrecorrer las colas en orden para cada elemnto en el vector
            div = div + nbytes;
            int j = 0;
            for (Queue<Integer> c : cola) {
                while (!c.isEmpty()) {
                    v[j++] = c.remove();

                }
            }
            //la primera se actualiza el numero de veces que se debe ejecutar el proceso
            if (i == 0) {
                max = (int) (Math.log(max) / Math.log(nColas)) + 1;

            }
        }
    }
    
    
    public void intercalacion(int vector[], int n){
        int i = 0, k, aux = 0;
        boolean band = false;
        for (k = 1; k <n; k++){
            aux = vector [k];
            i = k - 1;
            band = false;
            while (i >= 0 &&! band){
                if (aux < vector[i]){
                    vector[i + 1] = vector[i];
                    i--;
                    
                }else{
                    band = true;
                   
                }
            }
        }
         vector[i + 1] = aux;
    }
    

    public void mezclaNatural(int arr[]){
        if (arr.length <= 1){
            return;
            
        }
        int tam1 = arr.length / 2;
        int tam2 = arr.length - tam1;
        
        int primeraMitad[] = new int [tam1];
        int segundaMitad[] = new int [tam2];
        
        System.arraycopy(arr, 0, primeraMitad, 0, tam1);
        System.arraycopy(arr, tam1, segundaMitad, 0, tam2);
        
        mezclaNatural(primeraMitad);
        mezclaNatural(segundaMitad);
        merge(primeraMitad, segundaMitad, arr);
    }
    
    private static void merge(int[] fuente1, int[] fuente2, int[] dest){
        //indices de los tres array
        int srcIndex1 = 0;
        int srcIndex2 = 0;
        int desIndex = 0;
        // merge asta que uno de los array fuentes este vacio
        
       while (srcIndex1 < fuente1.length && srcIndex2 < fuente2.length){
           if (fuente1[srcIndex1] < fuente2[srcIndex2]){
               dest[desIndex] = fuente1[srcIndex1];
               srcIndex1++;
           }else{
               //dest[destIndex] = fuente2[srcIndex2];
               srcIndex1++;
           }
           
       }
    }
}
