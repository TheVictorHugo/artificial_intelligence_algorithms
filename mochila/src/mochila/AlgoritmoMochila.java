package mochila;



public class AlgoritmoMochila 
{ 
    static int maximo(int num1, int num2) { 
        return (num1 > num2) ? num1 : num2;
     } 

    static int mochila(int qtdPeso, int peso[], int val[], int total) { 
     
     int matriz[][] = new int[total+1][qtdPeso+1]; 

     for (int i = 0; i <= total; i++) { 
         for (int j = 0; j <= qtdPeso; j++) { // percorre toda matriz
             if (i==0 || j==0) {
                matriz[i][j] = 0; 
             }   
             else if (peso[i-1] <= j) {
                matriz[i][j] = maximo(val[i-1] + matriz[i-1][j-peso[i-1]],  matriz[i-1][j]); 
             }   
             else {
                matriz[i][j] = matriz[i-1][j]; 
             }        
         } 
      } 
      return matriz[total][qtdPeso]; 
    } 
  
    public static void main(String args[]) 
    { 
        int val[] = new int[]{160, 100, 120}; // valor
        int peso[] = new int[]{15, 10, 30}; // peso
        int qtdPeso = 55; //quanto de peso aguenta a mochila
        int total = val.length; // quantidade de valor
        
        //PRINT A SOMA DO VALOR DOS PESOS
        System.out.println(mochila(qtdPeso, peso, val, total)); 
    } 
} 


