package Estructura_Final;
import java.util.Scanner;

public class AlgoritmosOrdenamiento {

    
    public static void main(String[] args) {
      try (Scanner scan = new Scanner(System.in)) {
        int opcion=0;
          
          int[] numerosAleatorios = {
              587, 254, 503, 818, 237, 215, 122, 653, 774, 202, 890, 657, 109, 859, 305, 789, 141, 788, 147, 598, 
              227, 133, 423, 947, 969, 27, 792, 572, 908, 339, 746, 243, 181, 279, 428, 96, 647, 545, 872, 174, 
              479, 934, 25, 931, 922, 678, 110, 292, 617, 104, 741, 726, 823, 503, 736, 581, 63, 852, 470, 121, 
              419, 866, 283, 328, 336, 454, 196, 461, 473, 77, 764, 612, 468, 855, 962, 798, 287, 25, 394, 204, 
              989, 293, 305, 361, 307, 154, 319, 803, 108, 538, 396, 227, 262, 949, 69, 123, 18, 255, 979, 493, 
              657, 581, 71
          };
 while(opcion != 6){
          System.out.println("Elige el método de ordenamiento: \n 1. Imprimir arreglo original. \n 2. Bubble Sort. \n 3. Merge Sort. \n 4. Quick Sort. \n 5. AVL Tree Sort. \n 6.Salir");
        opcion = scan.nextInt();

switch(opcion){
  case 1:{
          // Imprimir los números aleatorios para verificar
          System.out.println("Números aleatorios:");
          for (int i = 0; i < numerosAleatorios.length; i++) {
              System.out.println(numerosAleatorios[i]);
          }
          break;
  }
case 2:{
          long startTime= System.currentTimeMillis();
          BubbleSort(numerosAleatorios);
          long endTime = System.currentTimeMillis();
          long Tiempo = endTime - startTime;
          System.out.println("\n El método tardo: " + Tiempo + " milisegundos.");
          
          System.out.println("\n");
          break;
}

case 3:{
          long startTime2=System.currentTimeMillis();
          MergeSort(numerosAleatorios);
          long endTime2 = System.currentTimeMillis();
          long Tiempo2 = endTime2 - startTime2;
          System.out.println("\n El método tardo: " + Tiempo2 + " milisegundos.");
          System.out.println("\n");
break;
}
case 4:{
          long startTime3=System.currentTimeMillis();
          QuickSort1(numerosAleatorios);
          long endTime3 = System.currentTimeMillis();
          long Tiempo3 = endTime3 - startTime3;
          System.out.println("\n El método tardo: " + Tiempo3 + " milisegundos.");
          System.out.println("\n");
          break;
}
case 5:{
 ArbolAVL arbol = new ArbolAVL();
 arbol.insertarDesdeArreglo(numerosAleatorios);
 long startTimer4=System.currentTimeMillis();
 arbol.recorridoEnOrden(arbol.raiz);
 long endTime4=System.currentTimeMillis();
 long Tiempo4 = endTime4 - startTimer4;
 System.out.println("\n El método tardo: " + Tiempo4 + " milisegundos.");
 System.out.println("\n");
break;
}
}
 }
      }
}

//Metodos del programa

    public static void BubbleSort(int numerosAleatorios[]){
for(int i=0; i< numerosAleatorios.length -1;i++){
    for(int j=0;j<numerosAleatorios.length -1;j++){
        if(numerosAleatorios[j]>numerosAleatorios[j+1]){
        int temp = numerosAleatorios[j+1];
        numerosAleatorios[j+1]=numerosAleatorios[j];
        numerosAleatorios[j]=temp;
        }
    }
}
 mostrarN(numerosAleatorios);
    }
   

public static void mostrarN(int numerosAleatorios[]){
    for(int i=0;i<numerosAleatorios.length;i++){
        System.out.println("[ "+ numerosAleatorios[i]+ " ]");
    }
}

public static void MergeSort(int numerosAleatorios[]){
int n=numerosAleatorios.length;
sort(numerosAleatorios,0,n-1);
printArray(numerosAleatorios);
}

public static void sort(int arr[], int left, int right){
    if(left < right){
      //Encuentra el punto medio del vector.
      int middle = (left + right) / 2;
      
      //Divide la primera y segunda mitad (llamada recursiva).
      sort(arr, left, middle);
      sort(arr, middle+1, right);

      //Une las mitades.
      merge(arr, left, middle, right);
    }
}

public static void merge(int arr[], int left, int middle, int right) {
    //Encuentra el tamaño de los sub-vectores para unirlos.
    int n1 = middle - left + 1;
    int n2 = right - middle;
  
    //Vectores temporales.
    int leftArray[] = new int [n1];
    int rightArray[] = new int [n2];
  
    //Copia los datos a los arrays temporales.
    for (int i=0; i < n1; i++) {
      leftArray[i] = arr[left+i];
    }
    for (int j=0; j < n2; j++) {
      rightArray[j] = arr[middle + j + 1];
    }
    /* Une los vectorestemporales. */
  
    //Índices inicial del primer y segundo sub-vector.
    int i = 0, j = 0;
  
    //Índice inicial del sub-vector arr[].
    int k = left;
  
    //Ordenamiento.
    while (i < n1 && j < n2) {
      if (leftArray[i] <= rightArray[j]) {
        arr[k] = leftArray[i];
        i++;
      } else {
          arr[k] = rightArray[j];
          j++;
      }
      k++;
    }//Fin del while.
  
    /* Si quedan elementos por ordenar */
    //Copiar los elementos restantes de leftArray[].
    while (i < n1) {
      arr[k] = leftArray[i];
      i++;
      k++;
    }
    //Copiar los elementos restantes de rightArray[].
    while (j < n2) {
      arr[k] = rightArray[j];
      j++;
      k++;
    }
  }

  public static void printArray(int arr[]) {
    int n = arr.length;
    for (int i=0; i<n; ++i) {
        System.out.println(arr[i] + " ");
    }
    System.out.println();
}

public static void Quicksort(int numeros[], int izq, int der)
{
        /*Este metodo recibe un arreglo de numero, y dos enteros que referencian el primer valor
        Y el ultimo*/
    
        //Se toma como pivote el primer valor
        int pivote = numeros[izq];
        
        //Se definen los dos lados y un auxiliar
        int i = izq; 
        int j = der; 
        int aux;
       
        while(i<j)
        {
           while (numeros[i] <= pivote && i < j) 
              i++;

           while (numeros[j] > pivote) 
              j--;   

           if (i<j) 
           {                                     
               aux = numeros[i];                  
               numeros[i]= numeros[j];
               numeros[j]=aux;
           }
        }

         numeros[izq] = numeros[j]; 
         numeros[j] = pivote;

         if (izq < j-1)
            Quicksort(numeros,izq,j-1);

         if (j+1 < der)
            Quicksort(numeros,j+1,der);
  }

  public static void ImprimirVector(int arreglo[])
  {
      for(int i = 0; i < arreglo.length; i++)
      {
          System.out.println(arreglo[i]);
      }
  }

  public static void QuickSort1(int numerosAleatorios[]){
Quicksort(numerosAleatorios,0,numerosAleatorios.length-1);
ImprimirVector(numerosAleatorios);
  }

}
