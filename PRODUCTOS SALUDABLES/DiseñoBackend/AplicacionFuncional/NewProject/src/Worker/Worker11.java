/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Worker;

import Chat.Cliente1;
import Chat.Servidor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 * Ejemplo de SwingWoker.<br>
 * El tipo de resultado a devolver es un Double. No hay elemento de progreso.
 * 
 * @author admin
 */
public class Worker11 extends SwingWorker<Double, Void> {
  
    /**
     * Tarea que tarda mucho y que queremos que se ejecute en un hilo separado.
     * @throws java.lang.Exception
     */
    @Override
    protected Double doInBackground() throws Exception {
        System.out.println("doInBackground() esta en el hilo "
                + Thread.currentThread().getName());

        Cliente1 aplicacion; // declara la aplicación cliente
        
        aplicacion = new Cliente1( "127.0.0.1" ); // se conecta a localhost
        //aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacion.ejecutarCliente();
        return 0.1;
    }

    @Override
    protected void done() {
    
    }
}
