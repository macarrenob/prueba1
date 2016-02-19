/* Clase Principal: Main.java
 * 
 * Programa:    Ordenamiento de Números
 * Autor:       Miguel Angel Pérez España
 *              angelshaoran.wordpress.com
 * Escrito:     10 de Diciembre de 2012
 * Compilador:  JDK 1.7.0
 * Plataforma:  Windows 7 x64
 * Descripción del Programa:
 *       Este es un programa que recibe permite introducir 15 números
 *       Y los ordena de menor a mayor y a la inversa.
 */
package ordena15nummaymen;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OrdenamientoNumeros extends JFrame{
    private JPanel pnlVentana;
    private SpringLayout colocador;
    private JTextArea txaCabecera;
    private JTextArea txaInstruccion;
    private Font fontInt=new Font ("Arial",0,12);
    private Font fontCreditos = new Font("Times New Roman",1,10);
    private JLabel etiqueta;
    private String[] textoEtiquetas={"30","30","30","30","30","30","30","30","30","30","30","30","30","30","30"};
    private JLabel[] compEtiquetas = new JLabel[textoEtiquetas.length];
    private JTextField txtCampos;
    private JTextField[] compCampos = new JTextField[textoEtiquetas.length];
    private JButton boton;
    private String[]textoBoton={"Ordenar de Menor a Mayor","Ordenar de Mayor a Menor","Limpiar Campos"};
    private JButton[] compBotones = new JButton[textoEtiquetas.length];
    private Dimension dimBoton = new Dimension(190,25);
    private JTextField[] ordenMenor = new JTextField[textoEtiquetas.length];
            
    public OrdenamientoNumeros(){
        super("Ordena 15 Numeros - angel.shaoran");
        this.setSize(400, 300);
        colocador = new SpringLayout();
        pnlVentana = new JPanel(colocador);
        pnlVentana.setSize(400, 300);
        this.add(pnlVentana);
        //creamos el encabezado
        txaCabecera = new JTextArea("Programa que ordena 15 números introducidos\n"
                + "por el usuario de menor a mayor y a la inversa.\n\nPrimero introduce los números y despúes\n"
                + "presiona el botón correspondiente.");
        txaCabecera.setEditable(false);
        txaCabecera.setFont(fontInt);
        txaCabecera.setOpaque(false);
        txaInstruccion = new JTextArea("angel.shaoran | angelshaoran.wordpress.com");
        txaInstruccion.setFont(fontCreditos);
        txaInstruccion.setOpaque(false);
        pnlVentana.add(txaInstruccion);
        pnlVentana.add(txaCabecera);//agregamos el encabezado al panel
        colocador.putConstraint(SpringLayout.WEST, txaCabecera, 5, SpringLayout.WEST, pnlVentana);
        colocador.putConstraint(SpringLayout.NORTH, txaCabecera, 5, SpringLayout.NORTH, pnlVentana);
        //creamos las etiquetas
        for(int i=0; i<textoEtiquetas.length;i++){
            etiqueta = new JLabel("# ", JLabel.RIGHT);
            etiqueta.setFont(fontInt);
            pnlVentana.add(etiqueta);
            compEtiquetas[i] = etiqueta;           
        }        
        //creamos los jtexfields
        for(int i=0; i<textoEtiquetas.length;i++){
            txtCampos = new JTextField(2);
            txtCampos.setFont(fontInt);
            pnlVentana.add(txtCampos);
            compCampos[i]=txtCampos;
        }
        //creamos los botones
        for(int i=0; i<textoBoton.length;i++){
            boton = new JButton(textoBoton[i]);
            boton.setPreferredSize(dimBoton);
            boton.addActionListener(new ManejadorBotones());
            pnlVentana.add(boton);
            compBotones[i]= boton;
        }
        //ordenamos las etiquetas de la primer columna
        colocador.putConstraint(SpringLayout.WEST, compEtiquetas[0], 5, SpringLayout.WEST, pnlVentana);
        colocador.putConstraint(SpringLayout.NORTH, compEtiquetas[0], 15, SpringLayout.SOUTH, txaCabecera);
        for(int i=1; i<(textoEtiquetas.length-10);i++){
            colocador.putConstraint(SpringLayout.WEST, compEtiquetas[i], 5, SpringLayout.WEST, pnlVentana);
            colocador.putConstraint(SpringLayout.NORTH, compEtiquetas[i], 10, SpringLayout.SOUTH, compEtiquetas[i-1]);
        }
        //ordenamos la etiquetas de la segunda columna
        colocador.putConstraint(SpringLayout.WEST, compEtiquetas[5], 50, SpringLayout.EAST, compEtiquetas[0]);
        colocador.putConstraint(SpringLayout.NORTH, compEtiquetas[5], 15, SpringLayout.SOUTH, txaCabecera);
        for(int i=6; i<(textoEtiquetas.length-5);i++){
            colocador.putConstraint(SpringLayout.WEST, compEtiquetas[i], 50, SpringLayout.EAST, compEtiquetas[0]);
            colocador.putConstraint(SpringLayout.NORTH, compEtiquetas[i], 10, SpringLayout.SOUTH, compEtiquetas[i-6]);        
        }
        //ordenamos la tercer columna de etiquetas
        colocador.putConstraint(SpringLayout.WEST, compEtiquetas[10], 50, SpringLayout.EAST, compEtiquetas[5]);
        colocador.putConstraint(SpringLayout.NORTH, compEtiquetas[10], 15, SpringLayout.SOUTH, txaCabecera);
        for(int i=11; i<textoEtiquetas.length;i++){
            colocador.putConstraint(SpringLayout.WEST, compEtiquetas[i], 50, SpringLayout.EAST, compEtiquetas[5]);
            colocador.putConstraint(SpringLayout.NORTH, compEtiquetas[i], 10, SpringLayout.SOUTH, compEtiquetas[i-11]);        
        }
        //ahora colocamos la primer columna de jtextfields
        colocador.putConstraint(SpringLayout.WEST, compCampos[0], 5, SpringLayout.EAST, compEtiquetas[0]);
        colocador.putConstraint(SpringLayout.NORTH, compCampos[0], 15, SpringLayout.SOUTH, txaCabecera);
        for(int i=1; i<(textoEtiquetas.length-10);i++){
            colocador.putConstraint(SpringLayout.WEST, compCampos[i], 5, SpringLayout.EAST, compEtiquetas[0]);
            colocador.putConstraint(SpringLayout.NORTH, compCampos[i], 5, SpringLayout.SOUTH, compCampos[i-1]);
        }
        //ahora colocamos la segunda columna de jtextfields
        colocador.putConstraint(SpringLayout.WEST, compCampos[5], 5, SpringLayout.EAST, compEtiquetas[5]);
        colocador.putConstraint(SpringLayout.NORTH, compCampos[5], 15, SpringLayout.SOUTH, txaCabecera);
        for(int i=6; i<(textoEtiquetas.length-5);i++){
            colocador.putConstraint(SpringLayout.WEST, compCampos[i], 5, SpringLayout.EAST, compEtiquetas[5]);
            colocador.putConstraint(SpringLayout.NORTH, compCampos[i], 5, SpringLayout.SOUTH, compCampos[i-6]);        
        }
        //colocamos la ultima columna de jtextfields
        colocador.putConstraint(SpringLayout.WEST, compCampos[10], 5, SpringLayout.EAST, compEtiquetas[10]);
        colocador.putConstraint(SpringLayout.NORTH, compCampos[10], 15, SpringLayout.SOUTH, txaCabecera);
        for(int i=11; i<textoEtiquetas.length;i++){
            colocador.putConstraint(SpringLayout.WEST, compCampos[i], 5, SpringLayout.EAST, compEtiquetas[10]);
            colocador.putConstraint(SpringLayout.NORTH, compCampos[i], 5, SpringLayout.SOUTH, compCampos[i-11]);        
        }
        //ahora nos colocamos los botones
        colocador.putConstraint(SpringLayout.WEST, compBotones[0], 15, SpringLayout.EAST, compCampos[10]);
        colocador.putConstraint(SpringLayout.NORTH, compBotones[0], 20, SpringLayout.SOUTH, txaCabecera);
        for(int i=1; i<textoBoton.length;i++){
            colocador.putConstraint(SpringLayout.WEST, compBotones[i], 15, SpringLayout.EAST, compCampos[10]);
            colocador.putConstraint(SpringLayout.NORTH, compBotones[i], 10, SpringLayout.SOUTH, compBotones[i-1]);
        }
        //colocamos los créditos
        colocador.putConstraint(SpringLayout.WEST, txaInstruccion, 5, SpringLayout.WEST, pnlVentana);
        colocador.putConstraint(SpringLayout.NORTH, txaInstruccion, 15, SpringLayout.SOUTH, compEtiquetas[4]);
    }
    //metodo para ordenar de menor a mayor
    private void ordenaMenorMayor(){        
        int auxiliar=0, auxiliar2=0;         
        for(int k=0; k<textoEtiquetas.length;k++){         
        for(int i=1; i<textoEtiquetas.length;i++){
            if (Integer.parseInt(compCampos[i-1].getText()) > Integer.parseInt(compCampos[i].getText())){//comparamos el primero con el segundo
                auxiliar = Integer.parseInt(compCampos[i-1].getText());//guardamos el valor del primero
                auxiliar2 = Integer.parseInt(compCampos[i].getText());// y tambien del segundo en una nueva variable
                //ordenMenor[i] = compCampos[i];
                compCampos[i-1].setText(Integer.toString(auxiliar2));//cambiamos el primer valor (menor) de posicion
                //compCampos[i-1]=compCampos[i];
                compCampos[i].setText(Integer.toString(auxiliar));//ahora el segundo valor (mayor) de posicion
            }
        }
        }
        //JOptionPane.showMessageDialog(null, "El numero menor es:\n"+compCampos[0].getText());       
    }
    //metodo para ordenar de mayor a menor angelshaoran.wordpress.com
    private void ordenaMayorMenor(){
        int auxiliar=0, auxiliar2=0;         
        for(int k=0; k<textoEtiquetas.length;k++){         
        for(int i=1; i<textoEtiquetas.length;i++){
            if (Integer.parseInt(compCampos[i-1].getText()) < Integer.parseInt(compCampos[i].getText())){//comparamos el primero con el segundo
                auxiliar = Integer.parseInt(compCampos[i-1].getText());//guardamos el valor del primero
                auxiliar2 = Integer.parseInt(compCampos[i].getText());// y tambien del segundo en una nueva variable
                //ordenMenor[i] = compCampos[i];
                compCampos[i-1].setText(Integer.toString(auxiliar2));//cambiamos el primer valor (mayor) de posicion
                //compCampos[i-1]=compCampos[i];
                compCampos[i].setText(Integer.toString(auxiliar));//ahora el segundo valor (menor) de posicion
            }
        }
        }
        //JOptionPane.showMessageDialog(null, "El numero menor es:\n"+compCampos[0].getText());   
    }
    //metodo para limpiar los jtextfields angelshaoran.wordpress.com
    private void limpiar(){
        //CAMBIÉ EL STRING QUE APARECE EN LAS CASILLAS EN BLANCO POR UNA EQUIS
        for(int i=0; i<textoEtiquetas.length;i++){
            compCampos[i].setText("X");
        }
        //OTRA LINEA EXTRA
    }    
    // manejador de ventos de los botones angelshaoran.wordpress.com
    private class ManejadorBotones implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==compBotones[0]){//evento boton menor a mayor
                ordenaMenorMayor();
                //JOptionPane.showMessageDialog(null, "Hola todo bien");
            }
            if(e.getSource()==compBotones[1]){//evento boton mayor a menor
                //JOptionPane.showMessageDialog(null, "Hola todo bien");
                ordenaMayorMenor();
            }
            if(e.getSource()==compBotones[2]){//evento limpiar campos
                limpiar();
            }
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
}//fin de la clase angelshaoran.wordpress.com
