/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VentanaConPestana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crisc
 */

public class VentanaConPestana extends JFrame  implements ActionListener{
    private JPanel panel;
    private JPanel panelBotones;
    private JPanel panelInventario;
    private JPanel panelcombo;
    private JPanel panelcrud;
    private JPanel subgrupodatos_botones;
    private JPanel controles;
    private JPanel subgrupoinfo;
    private JPanel ventas;
    
    private JLabel lblCantidadVentas;
    private JLabel lblid;
    private JLabel lblNombre;
    private JLabel lblcostoproduccion;
    private JLabel lblprecioventa;
    private JLabel lbltelefono;
    private JLabel lbljornada;
    private JLabel lbldireccion;
    
    //DEFINIR TODOS LOS TEXTFIELDS
    private JTextField txtid;
    private JTextField txtNombre;
    private JTextField txtcostoproduccion;
    private JTextField txtprecioventa;
    private JTextField txtanio;
    private JTextField txttelefono;
    private JTextField txtjornada;
    private JTextField txtdireccion;
    
    //DEFINIR LOS 4 BOTONES
    private JComboBox<String> combocrud;
    private JButton btnSalir;
    private JButton btnAgregar;
    private JButton btnBorrar;
    private JButton btnModificar;
    private JButton btnNuevo;
    
    
    private JComboBox<String> combo1;
    private JTable tablainventario;
    private JTable tablacrud; 
    private Container container;
    private JTabbedPane pestañas = new JTabbedPane();
    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel dtmcrud = new DefaultTableModel(); 
    
    private JTextArea pantalla;
    private JScrollPane desliza;
    private String seleccioninventario;
    private String seleccioncrud;
    
    public VentanaConPestana(){
        panelBotones=new JPanel();
        panelcrud=new JPanel();
        ventas=new JPanel();
        seleccioninventario="";
        seleccioncrud="";
        
        tablainventario= new JTable();
        tablainventario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        String [] titulos = {"ID","NOMBRE ", "CANTIDAD "};
        dtm.setRowCount(0);
        dtm.setColumnIdentifiers(titulos);
        tablainventario.setModel(dtm);
        
        tablacrud= new JTable();
        tablacrud.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        String [] tituloscrud = {"ID","NOMBRE ", "CANTIDAD "};
        dtmcrud.setRowCount(0);
        dtmcrud.setColumnIdentifiers(tituloscrud);
        tablacrud.setModel(dtmcrud);
        
        panelBotones.add(tablainventario);
        
        
        panel= new JPanel(new BorderLayout());
        //definir nombre ventana y exitclose
        setTitle("Producto Saludable");
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        //panel Inventario y sus elementos 
        
        panelInventario= new JPanel(new BorderLayout());
        panelInventario.setLayout(new GridLayout(5, 1));
        panelcombo=new JPanel(new BorderLayout());
        panelcombo.setLayout(new GridLayout(3, 1));
        
        combo1=new JComboBox<String>();
        combo1.setBounds(20,20,80,20);
        combo1.addItem("Producto");
        combo1.addItem("Materia Prima");
        lblCantidadVentas = new JLabel ("Cantidad de ventas: ");
        panelcombo.add(lblCantidadVentas);
        panelcombo.add(combo1);
         
        
        
        //panelInventario.add(lblCantidadVentas);
        panelInventario.add(panelcombo);
        panelInventario.setBorder(BorderFactory.createTitledBorder
        (BorderFactory.createLineBorder(Color.BLACK,1),"Inventario"));
        panelInventario.add(panelBotones);
       
        //panel ventas y sus elementos 
        
        
        pestañas.addTab("Inventario".toUpperCase(), panelInventario);
        pestañas.addTab("CRUD".toUpperCase(), panelcrud);
        pestañas.addTab("Ventas".toUpperCase(), ventas);
        //pestañas.addTab("CRUD".toUpperCase(), graphics2d);
        
        
        panelBotones = new JPanel(new FlowLayout());
        container = getContentPane();
        container.setLayout(new BorderLayout());
        
      
        /*
        container.add(panelBotones);
        container.add(pestañas);        
        */
        
        panel.add(pestañas);   
        container.add(panel);
        pestañaCrud();
        
        
        combocrud.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                //codigoDepartamento();
                //JOptionPane.showMessageDialog(null,seleccioninventario);
                seleccioncrud=combocrud.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,seleccioncrud);
                selectorcrud();
                
			}
		}); 
        
        
        combo1.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
                //codigoDepartamento();
                //JOptionPane.showMessageDialog(null,seleccioninventario);
                seleccioninventario=combo1.getSelectedItem().toString();
                conexion();
                JOptionPane.showMessageDialog(null,seleccioninventario);
			}
		});  
        
        
        
    }
    
    private void selectorcrud(){
        
        if(null != seleccioncrud)
        switch (seleccioncrud) {
            case "Producto":
                txttelefono.setEnabled(false);
                txtid.setEnabled(true);
                txtNombre.setEnabled(true);
                txtcostoproduccion.setEnabled(true);
                txtprecioventa.setEnabled(true);
                txtjornada.setEnabled(false);
                txtdireccion.setEnabled(false);
                break;
            case "Proveedor":
            case "Cliente":
                txttelefono.setEnabled(true);
                txtid.setEnabled(true);
                txtNombre.setEnabled(true);
                txtcostoproduccion.setEnabled(false);
                txtprecioventa.setEnabled(false);
                txtjornada.setEnabled(false);
                txtdireccion.setEnabled(true);
                break;
            case "Vendedor":
                txttelefono.setEnabled(true);
                txtid.setEnabled(true);
                txtNombre.setEnabled(true);
                txtcostoproduccion.setEnabled(false);
                txtprecioventa.setEnabled(false);
                txtjornada.setEnabled(true);
                txtdireccion.setEnabled(true);
                break;
            default:
                break;
        }
        
    }
    
    
    
    private void pestañaCrud(){
        
        panelcrud.setLayout(new GridLayout(3, 1));
        panelcrud.setBorder(BorderFactory.createTitledBorder
        (BorderFactory.createLineBorder(Color.BLACK,1),"CRUD"));
        
        subgrupoinfo=new JPanel();
        subgrupodatos_botones= new JPanel();
        controles= new JPanel();
        
        //setear los subgrupos jpanel
        subgrupodatos_botones.setLayout(new GridLayout(1, 2));
        subgrupoinfo.setLayout(new GridLayout(7, 2));
        controles.setLayout(new GridLayout(4, 1));
   
        //definir combo 
        combocrud=new JComboBox<String>();
        combocrud.setBounds(20,20,80,20);
        combocrud.addItem("Producto");
        combocrud.addItem("Proveedor");
        combocrud.addItem("Cliente");
        combocrud.addItem("Trabajador");
        
        //definirlabels
        txtid= new JTextField(10);
        txtNombre= new JTextField(10);
        txtcostoproduccion= new JTextField(10);
        txtprecioventa= new JTextField(10);
        txttelefono= new JTextField(10);
        txtjornada= new JTextField(10);
        txtdireccion= new JTextField(10);
        
        //labels del txt
        lbltelefono = new JLabel ("telefono: ");
        lbljornada = new JLabel ("jornada: ");
        lbldireccion = new JLabel ("direccion: ");
        lblid = new JLabel ("ID: ");
        lblNombre = new JLabel ("Nombre: ");
        lblcostoproduccion= new JLabel ("CostoProduccion: ");
        lblprecioventa= new JLabel ("PrecioVenta: ");

        //SE CREAN LOS BOTONES Y SE LES PONE TEXTO.
        btnAgregar = new JButton("Agregar");
        btnBorrar = new JButton("Borrar");
        btnModificar = new JButton("Modificar");
        btnNuevo = new JButton("Nuevo");
        
        subgrupoinfo.setBorder(BorderFactory.createTitledBorder
        (BorderFactory.createLineBorder(Color.BLACK,1),"Informacion"));
        controles.setBorder(BorderFactory.createTitledBorder
        (BorderFactory.createLineBorder(Color.BLACK,1),"Controles"));
       //pnlTabla.setBorder(BorderFactory.createTitledBorder
        //(BorderFactory.createLineBorder(Color.BLACK,1),"HISTORICO DE VENTAS"));
        subgrupoinfo.add(lblid);
        subgrupoinfo.add(txtid);
        subgrupoinfo.add(lblNombre);
        subgrupoinfo.add(txtNombre);
        subgrupoinfo.add(lblcostoproduccion);
        subgrupoinfo.add(txtcostoproduccion);
        subgrupoinfo.add(lblprecioventa);
        subgrupoinfo.add(txtprecioventa);
        subgrupoinfo.add(lbltelefono);
        subgrupoinfo.add(txttelefono);
        subgrupoinfo.add(lbljornada);
        subgrupoinfo.add(txtjornada);
        subgrupoinfo.add(lbldireccion);
        subgrupoinfo.add(txtdireccion);
        
        controles.add(combocrud);
        controles.add(btnBorrar);
        controles.add(btnModificar);
        controles.add(btnNuevo);
        
        
        subgrupodatos_botones.add(subgrupoinfo);
        subgrupodatos_botones.add(controles);       
        panelcrud.add(subgrupodatos_botones);
       
       
    }
    
 
    
    private void limpiartabla(){
        for (int i = 0; i < tablainventario.getRowCount(); i++) {
                dtm.removeRow(i);
                i-=1;
            }
        
    }
    
    private void conexion(){
        
        String dbUrl = "jdbc:postgresql://ec2-54-87-179-4.compute-1.amazonaws.com:5432/d7dn5f0eokivoh?sslmode=require&user=ddfthtnrlykawt&password=4748283b48b041eb54bd706bacc656243be496cf0ca3753784409fe0e6a71ebf";
        String user = "ddfthtnrlykawt";
        String driver = "org.postgresql.Driver";
        String pass = "4748283b48b041eb54bd706bacc656243be496cf0ca3753784409fe0e6a71ebf";
        Statement stmt = null;
   
        Connection con = null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }// Fin de try

        try {

            // 1. Establecer el canal de comunción
            con = DriverManager.getConnection(dbUrl, user, pass);

            // 2. Crea un objeto Statement
            stmt = con.createStatement();
            String sql ="";
            
            // 3. Definir la operación a realizar - SQL Statement
            if("Producto".equals(seleccioninventario)){
                sql = "select codigo,nombre_producto,cantidad_producto from public.\"InventarioProducto\" " ;
            }
            else{
                sql = "select codigo,nombre_producto,cantidad_producto from public.\"InventarioMateriaPrima\" " ;
            
            }
            
            
            

            // 4. Ejecutar el query
            ResultSet resultado = stmt.executeQuery(sql);
            // INSERT, UPDATE , DELETE -> stmt.executeUpdate(sql) -> int
            // 5. Gestionar el resultado
            String listado = "";
            limpiartabla();
         
            while(resultado.next()){
               
                String [] titulos = {"id ","nombre","cantidad "};
                dtm.addRow(new Object[]{resultado.getString("codigo"),resultado.getString("nombre_producto"),resultado.getString("cantidad_producto")});
                
            }
        
            panelInventario.add(tablainventario.getTableHeader(),BorderLayout.PAGE_START);
            panelInventario.add(tablainventario);
                      
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                    + "\n " + ex.getMessage());
        }

        
        finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                        + "\n " + ex.getMessage());
            }// nothing we can do
            try{
                if(con!=null)
                    con.close();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Código :" + ex.getErrorCode()
                        + "\n " + ex.getMessage());
            }//fin finally try
        }// Fin de try
        combo1.addActionListener(this);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == btnSalir){
              dispose();
          }
         }

    
}
