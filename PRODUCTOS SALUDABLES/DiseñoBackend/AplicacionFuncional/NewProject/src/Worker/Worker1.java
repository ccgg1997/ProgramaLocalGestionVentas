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
public class Worker1 extends SwingWorker<Double, Void> {
  
    /**
     * Tarea que tarda mucho y que queremos que se ejecute en un hilo separado.
     * @throws java.lang.Exception
     */
    @Override
    protected Double doInBackground() throws Exception {
        System.out.println("doInBackground() esta en el hilo "
                + Thread.currentThread().getName());

        Servidor aplicacion = new Servidor(); // crea el servidor
        //aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacion.ejecutarServidor(); // eje
        
        /*
        Cliente1 aplicacion1; // declara la aplicación cliente
        aplicacion1 = new Cliente1( "127.0.0.1" ); // se conecta a localhost
        aplicacion1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        aplicacion1.ejecutarCliente(); // ejecuta la aplicación cliente
            */
        
        return 0.1;
    }

    /**
     * Cuando termine la tarea, SwingWorker llamar� a este metodo en el hilo de
     * despacho de eventos. Aqui es donde debemos actualizar el JLabel.
     */
    @Override
    protected void done() {
       
       
    }
}
