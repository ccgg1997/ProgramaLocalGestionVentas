/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chat;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cliente1 extends JFrame implements ActionListener{

    private JTextField campoIntroducir; // introduce la información del usuario
    private JTextArea areaPantalla; // muestra la información al usuario
    private ObjectOutputStream salida; // flujo de salida hacia el servidor
    private ObjectInputStream entrada; // flujo de entrada del servidor
    private String mensaje = ""; // mensaje del servidor
    private String servidorChat; // aloja al servidor para esta aplicación
    private Socket cliente;
    
    // inicializa el objeto servidorChat y establece la GUI
    public Cliente1( String host )
    {
        super( "Cliente" );
        servidorChat = host; // establece el servidor al que se conecta este cliente
        campoIntroducir = new JTextField(); // crea objeto campoIntroducir
        campoIntroducir.setEditable( false );
        campoIntroducir.addActionListener(this);
        add( campoIntroducir, BorderLayout.NORTH );
        areaPantalla = new JTextArea(); // crea objeto areaPantalla
        add( new JScrollPane( areaPantalla ), BorderLayout.CENTER );

        setSize( 300, 150 ); // establece el tamaño de la ventana
        setVisible( true ); // muestra la ventana
    } // fin del constructor de Cliente
    
    // se conecta al servidor, obtiene flujos, procesa la conexión
    public void ejecutarCliente()
    {
        try 
        {   conectarAlServidor(); // crea un objeto Socket para hacer la conexión
            obtenerFlujos(); // obtiene los flujos de entrada y salida
            procesarConexion(); // procesa la conexión
        }catch ( EOFException excepcionEOF ){
            mostrarMensaje( "\nCliente termino la conexion" );
        } // fin de catch
        catch ( IOException excepcionES ){
            excepcionES.printStackTrace();
        } // fin de catch
        finally {
            cerrarConexion(); // cierra la conexión
        } // fin de finally
    } // fin del método ejecutarCliente
            
           
    // se conecta al servidor
    private void conectarAlServidor() throws IOException {
        mostrarMensaje( "Intentando realizar conexion\n" );
        
        // crea objeto Socket para hacer conexión con el servidor
        cliente = new Socket( InetAddress.getByName( servidorChat ), 12345 );
        // muestra la información de la conexión
        mostrarMensaje( "Conectado a: " + cliente.getInetAddress().getHostName() );
    } // fin del método conectarAlServidor
       
    
    // obtiene flujos para enviar y recibir datos
    private void obtenerFlujos() throws IOException {
        // establece flujo de salida para los objetos 
        salida = new ObjectOutputStream( cliente.getOutputStream() );
        salida.flush(); // vacía el búfer de salida para enviar información de encabezado
        // establece flujo de entrada para los objetos 
        entrada = new ObjectInputStream( cliente.getInputStream() );
        mostrarMensaje( "\nSe obtuvieron los flujos de E/S\n" );
    } // fin del método obtenerFlujos
    
    // procesa la conexión con el servidor
    private void procesarConexion() throws IOException  {
        // habilita campoIntroducir para que el usuario cliente pueda enviar mensajes
        campoIntroducir.setEditable(true );
        do // procesa los mensajes que se envían desde el servidor
        {
            try // lee el mensaje y lo muestra
            {
                mensaje = ( String ) entrada.readObject(); // lee nuevo mensaje
                mostrarMensaje( "\n" + mensaje ); // muestra el mensaje
            } catch ( ClassNotFoundException excepcionClaseNoEncontrada ){
                mostrarMensaje( "nSe recibio un tipo de objeto desconocido" );
            }
        } while ( !mensaje.equals( "SERVIDOR>>> TERMINAR" ) );
    } // fin del método procesarConexion 
                
   // cierra flujos y socket
    private void cerrarConexion() {
        mostrarMensaje( "\nCerrando conexion" );
        campoIntroducir.setEditable( false ); // deshabilita campoIntroducir
        try {
            salida.close(); // cierra el flujo de salida
            entrada.close(); // cierra el flujo de entrada 1
            cliente.close(); // cierra el socket
        } catch ( IOException excepcionES ){
            excepcionES.printStackTrace();
        } // fin de catch
    } // fin del método cerrarConexion             
         
    private void enviarDatos( String mensaje ) {
        try // envía un objeto al servidor
        {
            salida.writeObject( "CLIENTE>>> " + mensaje );
            salida.flush(); // envía todos los datos a la salida
            mostrarMensaje( "\nCLIENTE>>> " + mensaje );
        } catch ( IOException excepcionES ) {
            areaPantalla.append( "\nError al escribir objeto" );
        } // fin de catch
    } // fin del método enviarDatos
    
     private void mostrarMensaje( final String mensajeAMostrar ) {
         areaPantalla.append( mensajeAMostrar ); // adjunta el mensaje
     } // fin del método mostrarMensaje
 

    @Override
    public void actionPerformed(ActionEvent ae) {
        String m= campoIntroducir.getText();
        //enviarDatos( ae.getActionCommand()); 
         enviarDatos(m );       
        campoIntroducir.setText( "" );
        
    }
    
   
}
