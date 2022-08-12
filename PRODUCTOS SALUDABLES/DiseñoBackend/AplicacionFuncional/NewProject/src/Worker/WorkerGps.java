/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Worker;

import Modelo.TimerExample;
import javax.swing.SwingWorker;

/**
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
public class WorkerGps extends SwingWorker<Double, Void> {
  
    /**
     * Tarea que tarda mucho y que queremos que se ejecute en un hilo separado.
     * @throws java.lang.Exception
     */
    @Override
    protected Double doInBackground() throws Exception {
        System.out.println("doInBackground() esta en el hilo "
                + Thread.currentThread().getName());

        TimerExample display = new TimerExample();  // crea el servidor
   
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
