/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import ProjectView.Proyecto;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author crisc
 */
public class TimerExample extends JFrame implements ActionListener { 
    private JPanel container;
    private JLabel labelCounter;
    private Timer timer1 = new Timer(100, this);
    int w,x,y,z = 1;
  
    public TimerExample() { //ajustar retraso inicial de 1000 milisegundos timer1.setInitialDelay(1150) 
        timer1.setInitialDelay(100);
        container = new JPanel();
        container.setBackground(Color.WHITE);
        JLabel label=new JLabel("INICIO");
        label.setLocation(100,100);
        label.setFont(new Font("Calibri", Font.BOLD, 20));

        container.add(label);
        add(container);   
        
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(300,200);
        setResizable(false);
        setTitle("Producto saludables, Salsita Caleña");
        JOptionPane.showMessageDialog(null,"Su pedido va en camino");
        timer1.start();
    } 
         
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (w < 60 ){ 
            Graphics g = container.getGraphics();
            g.drawLine(w,x,y,z);
            w = w+1;
            x = x+1;
            y = y+1;
            z = z+1 ;
        }
        else if (w < 150){ 
            Graphics g = container.getGraphics();
            g.drawLine(w,x,y,z);
            w = w+1;
            x = x+0;
            y = y+1;
            z = z+0 ;
        }
         else if (w < 200){ 
            Graphics g = container.getGraphics();
            g.drawLine(w,x,y,z);
            w = w+1;
            x = x+1;
            y = y+1;
            z = z+1 ;
        }
        else{
            timer1.stop();
             JOptionPane.showMessageDialog(null,"Su pedido llegó");
        }

    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TimerExample().setVisible(true);
            }
        });
    }
}