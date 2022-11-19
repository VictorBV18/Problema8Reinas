
package problema8reinas;

public class Problema9Reinas {

    //esto solo es para que se vea mas descente el tablero (vistas)
    static String ANSI_PURPLE_BACKGROUND = "\u001b[45m";
    static String ANSI_RESET = "\u001b[0m";

    static void visualizacion(int[] tablero) {

        //los for son de 0-7 porque un tablero tiene de 1-8 espacios
        for (int i = 0; i < 9; i++) { //i representa las celdas horizontales (FILAS)
            for (int j = 0; j < 9; j++) {//j representa las celdas verticales   (COLUMNAS)
                if (tablero[i] == j) {

                    //si coinicide la fila con la columna significa que esta parada en una REINA
                    if ((i + j) % 2 == 0) {
                        System.out.print(ANSI_PURPLE_BACKGROUND + "|R" + ANSI_RESET);
                        //esto pone el color al tablero :)
                    } else {
                        System.out.print("|R");
                        //aqui se pone solo un print para que no de el salto de linea 
                    }

                } else {
                    if ((i + j) % 2 == 0) {
                        System.out.print(ANSI_PURPLE_BACKGROUND + "|_" + ANSI_RESET);
                    } else {
                        System.out.print("|-");
                    }
                }
            }
            System.out.println();

        }
        System.out.println();
    }

    static boolean movimiento(int[] tablero) {
  
        boolean result = false;
        
        //MOVIMIENTO EN COLUMNAS Y FILAS
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
    //aqui estoy mostrando el echo de que si hay 2 reinas que coincidan en una misma columna o fila se estan atacando entre si y
    //el return hace que regrese el tablero de nuevo para que no haya 2 reinas en la misma fila ni en la misma columna 
                if (tablero[i] == tablero[j])return true;
            }
        }
        
        //MOVIMIENTO EN DIAGONALES 
                for (int i = 0; i < 8; i++) {
                    for (int j = i + 1; j < 9; j++) {
    //aqui estoy mostrando el echo de que si hay 2 reinas que coincidan en una misma diagonal  se estan atacando entre si y
    //el return hace que regrese el tablero de nuevo para que no haya 2 reinas en la misma diagonal 
                    
                if (tablero[i]+i == tablero[j]+j)return true;//aqui hacemos que las 2 reinas no choquen en una de las diagonales positivamente 
                if (tablero[i]-i == tablero[j]-j)return true;//aqui es lo mismo pero negativamente osea del lado izquierdo :) 
            }
        }
        return result;
    }

    //aqui vamos a forzar el echo de buscar todas las convinaciones posibles 
    static void soluciones() {
        int contador =0;
        for (int a = 0; a < 9; a++)
            for (int b = 0; b < 9; b++)
                for (int c = 0; c < 9; c++)
                    for (int d = 0; d < 9; d++)//AQUI ESTOY FORZANDO CON 8 LETRAS PARA QUE VAYA RECORRIENDO UNA CASILLA POR CASILLA :)
                        for (int e = 0; e < 9; e++)
                            for (int f = 0; f < 9; f++)
                                for (int g = 0; g < 9; g++)
                                    for (int h = 0; h < 9; h++)
                                        for (int i = 0; i < 9; i++){
                                        int[] tablero = {a, b, c, d, e, f, g, h,i};
                                        if (!movimiento (tablero )){
                                        visualizacion(tablero);
                                        contador ++;
                                        }
                                    }
        System.out.println("Las soluciones encontradas son "+contador );
                            }
    
    public static void main(String[] args) {
        
        System.out.println("LA PRIMERA SOLUCION LA ESTOY METIENDO YO MANUALMENTE DE COMO LAS ENCONTRE :)");
        //esta visualizacion la meti yo al intentar acomodar las reinas en mi cuaderno :) 
        //visualizacion(new int[]{2, 5, 7, 1, 3, 0, 4, 6});

        System.out.println("AQUI COMIENZA LAS SOLUCIONES ENCONTRADAS PROGRAMANDO ");
        soluciones();

    }

}
