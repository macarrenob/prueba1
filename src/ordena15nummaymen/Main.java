/*
 * Programa que ordena 15 numeros introducidos por el usuario
 * y los ordena de menor a mayor y a la inversa.
 * 
 */
package ordena15nummaymen;
import javax.swing.*;

public class Main extends JFrame{    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //COMENTO ACÁ PARA INDICAR UN CAMBIO
        OrdenamientoNumeros ordena = new OrdenamientoNumeros();
        ordena.setVisible(true);
        ordena.setLocationRelativeTo(null);
        ordena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
      
    }
}
