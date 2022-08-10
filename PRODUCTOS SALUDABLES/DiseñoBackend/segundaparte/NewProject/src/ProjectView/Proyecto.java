/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ProjectView;

import Modelo.Cliente;
import Modelo.ClienteDao;
import Modelo.Producto;
import Modelo.ProductoDao;
import Modelo.Proveedor;
import Modelo.ProveedorDao;
import Modelo.Detalle;
import Modelo.Eventos;
import Modelo.Insumo;
import Modelo.InsumoDao;
import Modelo.Vendedor;
import Modelo.VendedorDao;
import Modelo.Venta;
import Modelo.VentaDao;
import Reportes.Excel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import static com.itextpdf.text.pdf.PdfObject.NULL;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

/**
 *
 * @author Valeria
 */
public class Proyecto extends javax.swing.JFrame {
    
    Cliente cl = new Cliente();
    Insumo in= new Insumo();
    InsumoDao inDao= new InsumoDao();
    Vendedor vr= new Vendedor();
    VendedorDao vrdao= new VendedorDao();
    ClienteDao client = new ClienteDao();
    DefaultTableModel modelo=new DefaultTableModel();
    DefaultTableModel tmp =new DefaultTableModel();
    Eventos event = new Eventos();
    Venta v = new Venta();
    VentaDao vdao = new VentaDao();
    Producto p = new Producto();
    ProductoDao pdao = new ProductoDao();
    Proveedor pr=new Proveedor();
    ProveedorDao prdao= new ProveedorDao();
    Detalle Dv = new Detalle();
    int item;
    int totalPagar = 0;


    /**
     * Creates new form Proyecto
     */
    public Proyecto() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtIdNuevaVentaProducto.setVisible(false);
        txtTelefonoClienteVenta.setVisible(false);
        txtDireccionClienteVenta.setVisible(false);
        txtRazonClienteVenta.setVisible(false);
        txtIdCliente.setVisible(false);
        txtIdProveedor.setVisible(false);
        txtIdProducto.setVisible(false);
        txtIdVenta.setVisible(false);
        cdxProveedorProducto.setVisible(false);
        AutoCompleteDecorator.decorate(cdxProveedorProducto);
        //pdao.ConsultarProveedor(cdxProveedorProducto);
        this.setLocationRelativeTo(null);
    }
    
    //ZONA DE LISTAR
    //las siguientes funciones listan los datos
    //en las tablas de: CLIENTE, PROVEEVOR Y PRODUCTO
    public void listarClientes()
    {
        List<Cliente> listarC1= client.listarCliente();
        modelo= (DefaultTableModel)tableCliente.getModel();
        Object[] ob= new Object[6];
        for (int i=0; i<listarC1.size();i++)
        {
            ob[0]=listarC1.get(i).getId();
            ob[2]=listarC1.get(i).getCedula();
            ob[1]=listarC1.get(i).getNombre();
            ob[3]=listarC1.get(i).getTelefono();
            ob[4]=listarC1.get(i).getDireccion();
            modelo.addRow(ob);
        }
        tableCliente.setModel(modelo);
    
    }
    
     public void listarInsumos()
    {
        List<Insumo> listarIn= inDao.listarInsumo();
        modelo= (DefaultTableModel)tableInsumos.getModel();
        Object[] ob= new Object[5];
        for (int i=0; i<listarIn.size();i++)
        {
            ob[0]=listarIn.get(i).getCodigo();
            ob[1]=listarIn.get(i).getNit_proveedor();
            ob[2]=listarIn.get(i).getNombre_insumo();
            ob[3]=listarIn.get(i).getCantidad_insumo();
            ob[4]=listarIn.get(i).getPrecio();
            modelo.addRow(ob);
            
        }
        tableInsumos.setModel(modelo);
    
    }
    
     public void listarVendedor()
    {
        List<Vendedor> listarvr= vrdao.listarVendedor();
        modelo= (DefaultTableModel)tableVendedor.getModel();
        Object[] ob= new Object[5];
        for (int i=0; i<listarvr.size();i++)
        {
            ob[2]=listarvr.get(i).getJornada();
            ob[1]=listarvr.get(i).getCedula();
            ob[0]=listarvr.get(i).getNombre();
            ob[3]=listarvr.get(i).getTelefono();
            ob[4]=listarvr.get(i).getDireccion();
            modelo.addRow(ob);
        }
        tableVendedor.setModel(modelo);
    
    }
    
    
    public void ListarProveedor()
    {
        List<Proveedor> listarpr= prdao.listarProveedor();
        modelo= (DefaultTableModel)tableProveedor.getModel();
        Object[] ob= new Object[5];
        //String aux="";
  
        for (int i=0; i<listarpr.size();i++)
        {
            
            ob[0]=listarpr.get(i).getNit();
            ob[1]=listarpr.get(i).getNombre();
            ob[2]=listarpr.get(i).getTelefono();
            ob[3]=listarpr.get(i).getDireccion();
            ob[4]=listarpr.get(i).getMateriaPrima();
            //aux=listarpr.get(i).getNombre();
            modelo.addRow(ob);
        }
        tableProveedor.setModel(modelo);
        
    
    }
    
     public void listarProductos()
    {
        List<Producto> ListarPro= pdao.listarProductos();
        modelo= (DefaultTableModel)tableProducto.getModel();
        Object[] ob= new Object[6];
        for (int i=0; i<ListarPro.size();i++)
        {
            ob[0]=ListarPro.get(i).getId();
            ob[1]=ListarPro.get(i).getNombre();
            ob[2]=ListarPro.get(i).getCantidad();
            ob[3]=ListarPro.get(i).getPrecio();
            modelo.addRow(ob);
        }
        tableProducto.setModel(modelo);
    
    }
     
     
     public void listarVentas()
    {
        List<Venta> ListarVentas= vdao.listarVentas();
        modelo= (DefaultTableModel)tableVentas.getModel();
        Object[] ob= new Object[4];
        for (int i=0; i<ListarVentas.size();i++)
        {
            ob[0]=ListarVentas.get(i).getNumero_factura();
            ob[1]=ListarVentas.get(i).getNombre_vendedor();
            ob[2]=ListarVentas.get(i).getNombre_cliente();
            ob[3]=ListarVentas.get(i).getPrecio_total();
            modelo.addRow(ob);
        }
        tableVentas.setModel(modelo);
    
    }
    
    //FUNCION PARA  LIMPIAR TABLA 
    public void LimpiarTable() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNuevaVentana = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnVendedor = new javax.swing.JButton();
        btnInsumo = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnEliminarVenta = new javax.swing.JButton();
        txtCodigoVenta = new javax.swing.JTextField();
        txtDescripcionVenta = new javax.swing.JTextField();
        txtCantidadVenta = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        txtStockDisponible = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNuevaVenta = new javax.swing.JTable();
        lblCedulaClienteVenta = new javax.swing.JLabel();
        lblNombreClienteVenta = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtCedulaClienteVenta = new javax.swing.JTextField();
        txtNombreClienteVenta = new javax.swing.JTextField();
        txtTelefonoClienteVenta = new javax.swing.JLabel();
        txtDireccionClienteVenta = new javax.swing.JTextField();
        txtRazonClienteVenta = new javax.swing.JTextField();
        btnFacturar = new javax.swing.JButton();
        txtIdNuevaVentaProducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNombreVendedor = new javax.swing.JTextField();
        txtIdVendedor = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblTotalPagar = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lblCedulaCliente = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCedulaCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        txtRazonSocialCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();
        btnGuardarCliente = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        txtIdCliente = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtNitProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        txtDireccionProveedor = new javax.swing.JTextField();
        txtRazonSocialProveedor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProveedor = new javax.swing.JTable();
        btnGuardarProveedor = new javax.swing.JButton();
        btnActualizarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        cdxProveedorProducto = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableProducto = new javax.swing.JTable();
        btnGuardarProducto = new javax.swing.JButton();
        btnActualizarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtDescripcionProducto = new javax.swing.JTextField();
        txtCantidadProducto = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        btnPdfVentas = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblCedulaVendedor = new javax.swing.JLabel();
        txtCedulaVendedor = new javax.swing.JTextField();
        txtnombreVendedor = new javax.swing.JTextField();
        lblNombreVendedor = new javax.swing.JLabel();
        txtTelefonoVendedor = new javax.swing.JTextField();
        lblTelefonoVendedor = new javax.swing.JLabel();
        txtJornadaVendedor = new javax.swing.JTextField();
        lblJornadaVendedor = new javax.swing.JLabel();
        txtDireccionVendedor = new javax.swing.JTextField();
        lblDireccionVendedor = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableVendedor = new javax.swing.JTable();
        btnAgregarVendedor = new javax.swing.JButton();
        btnEliminarVendedor = new javax.swing.JButton();
        btnModificarVendedor = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigoInsumos = new javax.swing.JTextField();
        txtNombreInsumos = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtPrecioInsumo = new javax.swing.JTextField();
        lbl = new javax.swing.JLabel();
        lnbl2 = new javax.swing.JLabel();
        txtCantidadInsumo = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtid_proveedor = new javax.swing.JTextField();
        btnmodificarinsumo = new javax.swing.JButton();
        btningresarinsumo = new javax.swing.JButton();
        btneliminarinsumo = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableInsumos = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablePrediccion = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(240, 139, 72));

        btnNuevaVentana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nventa.png"))); // NOI18N
        btnNuevaVentana.setText("Nueva Venta");
        btnNuevaVentana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentanaActionPerformed(evt);
            }
        });

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/proveedor.png"))); // NOI18N
        jButton3.setText("Proveedor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        btnProductos.setText("Producción");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/compras.png"))); // NOI18N
        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config.png"))); // NOI18N
        jButton6.setText("Config");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/facebook.png"))); // NOI18N
        btnVendedor.setText("Vendedor");
        btnVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVendedorActionPerformed(evt);
            }
        });

        btnInsumo.setText("Insumos");
        btnInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNuevaVentana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
            .addComponent(btnProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnInsumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnNuevaVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVendedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 190, 440));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Codigo");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Descripcion");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Precio");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Stock disponible");

        btnEliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarVenta.setText("Borrar");
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });

        txtCodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVentaActionPerformed(evt);
            }
        });
        txtCodigoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoVentaKeyTyped(evt);
            }
        });

        txtCantidadVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadVentaActionPerformed(evt);
            }
        });
        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyTyped(evt);
            }
        });

        txtPrecioVenta.setEditable(false);

        tableNuevaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Decripcion", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane1.setViewportView(tableNuevaVenta);
        if (tableNuevaVenta.getColumnModel().getColumnCount() > 0) {
            tableNuevaVenta.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableNuevaVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableNuevaVenta.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableNuevaVenta.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableNuevaVenta.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        lblCedulaClienteVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCedulaClienteVenta.setText("Cedula");

        lblNombreClienteVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombreClienteVenta.setText("Nombre");

        lblTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N
        lblTotal.setText("Total a pagar");

        txtCedulaClienteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaClienteVentaActionPerformed(evt);
            }
        });
        txtCedulaClienteVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaClienteVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaClienteVentaKeyTyped(evt);
            }
        });

        txtNombreClienteVenta.setEditable(false);

        txtTelefonoClienteVenta.setText("Telefono");

        txtDireccionClienteVenta.setText("jTextField1");
        txtDireccionClienteVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionClienteVentaActionPerformed(evt);
            }
        });

        txtRazonClienteVenta.setText("jTextField1");

        btnFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print.png"))); // NOI18N
        btnFacturar.setText("Facturar");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Nombre");

        txtNombreVendedor.setEditable(false);

        txtIdVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdVendedorKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdVendedorKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Id Vendedor");

        lblTotalPagar.setText("-------");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2)
                                .addGap(110, 110, 110)
                                .addComponent(jLabel4))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(35, 35, 35)))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(txtStockDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdNuevaVentaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(btnEliminarVenta))
                            .addComponent(jLabel7)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCedulaClienteVenta)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(txtCedulaClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtTelefonoClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(txtIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDireccionClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRazonClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFacturar)
                        .addGap(47, 47, 47)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lblTotalPagar)
                        .addGap(40, 40, 40))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(lblNombreClienteVenta)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(11, 11, 11))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDescripcionVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStockDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarVenta)
                        .addComponent(txtIdNuevaVentaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedulaClienteVenta)
                            .addComponent(lblNombreClienteVenta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCedulaClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefonoClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccionClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRazonClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTotal)
                        .addComponent(btnFacturar)
                        .addComponent(lblTotalPagar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jTabbedPane2.addTab("tab1", jPanel8);

        jPanel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCedulaCliente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCedulaCliente.setText("Cedula:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Nombre");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Telefono");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Direccion");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Nit");

        txtCedulaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaClienteActionPerformed(evt);
            }
        });
        txtCedulaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaClienteKeyTyped(evt);
            }
        });

        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });

        txtTelefonoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoClienteActionPerformed(evt);
            }
        });
        txtTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoClienteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoClienteKeyTyped(evt);
            }
        });

        txtRazonSocialCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonSocialClienteActionPerformed(evt);
            }
        });
        txtRazonSocialCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialClienteKeyTyped(evt);
            }
        });

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Cedula", "Telefono", "Direccion"
            }
        ));
        tableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCliente);
        if (tableCliente.getColumnModel().getColumnCount() > 0) {
            tableCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableCliente.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableCliente.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableCliente.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        btnGuardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarCliente.setText("Guardar");
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnActualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarCliente.setText("Actualizar");
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel37.setText("CLIENTE");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnEliminarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(btnGuardarCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                                        .addComponent(btnActualizarCliente)
                                        .addGap(33, 33, 33))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(lblCedulaCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtRazonSocialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34)))))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37)))
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCedulaCliente)
                            .addComponent(txtCedulaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtRazonSocialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarCliente)
                            .addComponent(btnActualizarCliente))
                        .addGap(44, 44, 44)
                        .addComponent(btnEliminarCliente)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab2", jPanel9);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Nit");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Nombre");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Telefono");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Direccion");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("MateriaPrima");

        txtNitProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNitProveedorActionPerformed(evt);
            }
        });
        txtNitProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNitProveedorKeyTyped(evt);
            }
        });

        txtNombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyTyped(evt);
            }
        });

        txtTelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyTyped(evt);
            }
        });

        tableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nit", "Nombre", "Telefono", "Direccion", "MateriaPrima"
            }
        ));
        tableProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableProveedor);
        if (tableProveedor.getColumnModel().getColumnCount() > 0) {
            tableProveedor.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableProveedor.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableProveedor.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableProveedor.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        btnGuardarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarProveedor.setText("Guardar");
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });

        btnActualizarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarProveedor.setText("Actualizar");
        btnActualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        txtIdProveedor.setText("jTextField1");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel36.setText("PROVEEDOR");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(69, 69, 69)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNitProveedor)
                                    .addComponent(txtNombreProveedor)
                                    .addComponent(txtTelefonoProveedor)
                                    .addComponent(txtDireccionProveedor)
                                    .addComponent(txtRazonSocialProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                            .addComponent(jLabel36)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarProveedor)
                            .addComponent(btnEliminarProveedor))
                        .addGap(27, 27, 27)
                        .addComponent(btnActualizarProveedor)))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtNitProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtRazonSocialProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardarProveedor)
                            .addComponent(btnActualizarProveedor))
                        .addGap(24, 24, 24)
                        .addComponent(btnEliminarProveedor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab3", jPanel10);

        tableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Cantidad", "Precio"
            }
        ));
        tableProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProductoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableProducto);
        if (tableProducto.getColumnModel().getColumnCount() > 0) {
            tableProducto.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableProducto.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableProducto.getColumnModel().getColumn(2).setPreferredWidth(40);
            tableProducto.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        btnGuardarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarProducto.setText("Guardar");
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });

        btnActualizarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnActualizarProducto.setText("Actualizar");
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel38.setText("PRODUCCIÓN");

        txtDescripcionProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionProductoKeyTyped(evt);
            }
        });

        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Precio");

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Codigo");

        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Descripcion");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Cantidad");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(39, 39, 39)
                        .addComponent(txtCodigoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(45, 45, 45))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/excel.png"))); // NOI18N
        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel38)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cdxProveedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardarProducto)
                                    .addComponent(btnEliminarProducto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnActualizarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel38)))
                .addGap(39, 39, 39)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cdxProveedorProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizarProducto)
                            .addComponent(btnGuardarProducto))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarProducto)
                            .addComponent(jButton1))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane2.addTab("tab4", jPanel11);

        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Vendedor", "Total"
            }
        ));
        tableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableVentas);
        if (tableVentas.getColumnModel().getColumnCount() > 0) {
            tableVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableVentas.getColumnModel().getColumn(1).setPreferredWidth(60);
            tableVentas.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableVentas.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        btnPdfVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnPdfVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfVentasActionPerformed(evt);
            }
        });

        txtIdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btnPdfVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPdfVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab5", jPanel12);

        jLabel24.setText("Nit");

        jLabel25.setText("Nombre");

        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField18KeyTyped(evt);
            }
        });

        jLabel27.setText("Direccion");

        jLabel26.setText("Telefono");

        jLabel28.setText("Razon Social");

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        jButton21.setText("Actualizar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jButton21))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGap(15, 15, 15)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton21)
                .addGap(27, 27, 27))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/empresa.png"))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel39.setText("DATOS DE LA EMPRESA");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel39)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addGap(43, 43, 43)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab6", jPanel13);

        lblCedulaVendedor.setText("Cedula");

        txtCedulaVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaVendedorKeyTyped(evt);
            }
        });

        txtnombreVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreVendedorActionPerformed(evt);
            }
        });
        txtnombreVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreVendedorKeyTyped(evt);
            }
        });

        lblNombreVendedor.setText("Nombre");

        txtTelefonoVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoVendedorKeyTyped(evt);
            }
        });

        lblTelefonoVendedor.setText("Telefono");

        txtJornadaVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJornadaVendedorActionPerformed(evt);
            }
        });
        txtJornadaVendedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJornadaVendedorKeyTyped(evt);
            }
        });

        lblJornadaVendedor.setText("Jornada");

        lblDireccionVendedor.setText("Direccion");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel35.setText("VENDEDORES");

        tableVendedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cedula", "Jornada", "Telefono", "Direccion"
            }
        ));
        tableVendedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVendedorMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableVendedor);

        btnAgregarVendedor.setText("Agregar");
        btnAgregarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarVendedorActionPerformed(evt);
            }
        });

        btnEliminarVendedor.setText("Eliminar");
        btnEliminarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVendedorActionPerformed(evt);
            }
        });

        btnModificarVendedor.setText("Modificar");
        btnModificarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreVendedor)
                            .addComponent(lblCedulaVendedor))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCedulaVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(txtnombreVendedor))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblJornadaVendedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtJornadaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblDireccionVendedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccionVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblTelefonoVendedor)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefonoVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(btnAgregarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnModificarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(122, 122, 122))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblJornadaVendedor)
                                    .addComponent(txtJornadaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblDireccionVendedor)
                                    .addComponent(txtDireccionVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCedulaVendedor)
                                    .addComponent(txtCedulaVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNombreVendedor)
                                    .addComponent(txtnombreVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblTelefonoVendedor)
                                    .addComponent(txtTelefonoVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregarVendedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarVendedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarVendedor)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab7", jPanel4);

        jLabel1.setText("Codigo:");

        txtCodigoInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoInsumosActionPerformed(evt);
            }
        });
        txtCodigoInsumos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoInsumosKeyTyped(evt);
            }
        });

        txtNombreInsumos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreInsumosKeyTyped(evt);
            }
        });

        jLabel23.setText("Nombre");

        lbl.setText("Precio");

        lnbl2.setText("Cantidad");

        txtCantidadInsumo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadInsumoKeyTyped(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("SIMULAR INSUMOS PARA LA SIGUIENTE CANTIDAD:");

        jTextField5.setText("jTextField5");

        jLabel33.setText("Ingrese cantidad");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setText("PEDIR INSUMOS");

        jLabel40.setText("Id_prove");

        txtid_proveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtid_proveedorKeyTyped(evt);
            }
        });

        btnmodificarinsumo.setText("Modificar");
        btnmodificarinsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarinsumoActionPerformed(evt);
            }
        });

        btningresarinsumo.setText("Ingresar");
        btningresarinsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarinsumoActionPerformed(evt);
            }
        });

        btneliminarinsumo.setText("Eliminar");
        btneliminarinsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarinsumoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtCodigoInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtNombreInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtid_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13)))
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(lnbl2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCantidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(lbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtPrecioInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(btningresarinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(btnmodificarinsumo)
                                        .addGap(34, 34, 34)
                                        .addComponent(btneliminarinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCodigoInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(37, 37, 37))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(txtNombreInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtid_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lnbl2)
                            .addComponent(txtCantidadInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl)
                            .addComponent(txtPrecioInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btningresarinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificarinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminarinsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(135, 135, 135)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jScrollPane7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane7MouseClicked(evt);
            }
        });
        jScrollPane7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jScrollPane7KeyPressed(evt);
            }
        });

        tableInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Proveedor", "Nombre", "Cantidad", "Precio"
            }
        ));
        tableInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableInsumosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tableInsumos);

        tablePrediccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tablePrediccion);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab8", jPanel6);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 880, 590));
        jTabbedPane2.getAccessibleContext().setAccessibleName("Factura");

        jPanel2.setBackground(new java.awt.Color(253, 190, 116));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addContainerGap(883, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        listarProductos();
        jTabbedPane2.setSelectedIndex(3);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnNuevaVentanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentanaActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        listarProductos();
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevaVentanaActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        LimpiarTable();
        listarClientes();
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(4);
        LimpiarTable();
        listarVentas();
    }//GEN-LAST:event_btnVentasActionPerformed

    private void txtCodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoVentaActionPerformed

    private void txtDireccionClienteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionClienteVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionClienteVentaActionPerformed

    private void txtRazonSocialClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonSocialClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonSocialClienteActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        // TODO add your handling code here:
        if("".equals(txtRazonSocialCliente.getText())){
            JOptionPane.showMessageDialog(null,"seleccione fila");
        }else{
            cl.setCedula(Integer.parseInt(txtCedulaCliente.getText()));
            cl.setId(Integer.parseInt(txtRazonSocialCliente.getText()));
            cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
            cl.setNombre((txtNombreCliente.getText()));
            cl.setDireccion((txtDireccionCliente.getText()));
             if (!"".equals(txtCedulaCliente.getText()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText()) || !"".equals(txtDireccionCliente.getText())) {
                client.ModificarCliente(cl);
                LimpiarTable();
                limpiarcliente();
                listarClientes();
                     
                 }
             else{
                 JOptionPane.showMessageDialog(null,"Campos Vacios");
             }
            
        }
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        if (!"".equals(txtCedulaCliente.getText()) || !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText()) || !"".equals(txtDireccionCliente.getText())) {
                    cl.setCedula(Integer.parseInt(txtCedulaCliente.getText()));
                    cl.setNombre(txtNombreCliente.getText());
                    cl.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
                    cl.setDireccion(txtDireccionCliente.getText());
                    cl.setId(Integer.parseInt(txtRazonSocialCliente.getText()));
                    client.RegistrarCliente(cl);
                    LimpiarTable();
                    limpiarcliente();
                    listarClientes();
                    

        } else {
                    JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }      // TODO add your handling code here:
      
            
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void txtCedulaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaClienteActionPerformed

    private void txtTelefonoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoClienteActionPerformed

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtRazonSocialProveedor.getText()) || !"".equals(txtNitProveedor.getText()) || !"".equals(txtNombreProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText()) || !"".equals(txtDireccionProveedor.getText())) 
        {
            pr.setNit(Integer.parseInt(txtNitProveedor.getText()));
            pr.setTelefono(Integer.parseInt(txtTelefonoProveedor.getText()));
            pr.setMateriaPrima((txtRazonSocialProveedor.getText()));
            pr.setNombre(txtNombreProveedor.getText());
            pr.setDireccion(txtDireccionProveedor.getText());
            prdao.registrarProvedor(pr);
            LimpiarTable();
            ListarProveedor();
        }
        else{
            JOptionPane.showMessageDialog(null, "los datos estan vacios");
        }          
        
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void tableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClienteMouseClicked
        // TODO add your handling code here:
        int fila = tableCliente.rowAtPoint(evt.getPoint());
        txtRazonSocialCliente.setText(tableCliente.getValueAt(fila,0).toString());
        txtCedulaCliente.setText(tableCliente.getValueAt(fila,2).toString());
        txtNombreCliente.setText(tableCliente.getValueAt(fila,1).toString());
        txtTelefonoCliente.setText(tableCliente.getValueAt(fila,3).toString());
        txtDireccionCliente.setText(tableCliente.getValueAt(fila,4).toString());
      

    }//GEN-LAST:event_tableClienteMouseClicked

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        if(!"".equals(txtRazonSocialCliente.getText()))
        {
            int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro que quiere eliminar");
            if(pregunta==0){
                int id= Integer.parseInt(txtRazonSocialCliente.getText());
                client.eliminarCliente(id);
                LimpiarTable();
                limpiarcliente();
                listarClientes();
            }
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void txtCantidadVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyPressed
        // TODO add your handling code here:
             if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCantidadVenta.getText())) {
                int id = Integer.parseInt(txtCodigoVenta.getText());
                String descripcion = txtDescripcionVenta.getText();
                int cantidad = Integer.parseInt(txtCantidadVenta.getText());
                int precio = Integer.parseInt(txtPrecioVenta.getText());
                int total = cantidad * precio;
                int stock = Integer.parseInt(txtStockDisponible.getText());
                if (stock >= cantidad) {
                    item = item + 1;
                    DefaultTableModel tmp = (DefaultTableModel) tableNuevaVenta.getModel();
                    for (int i = 0; i < tableNuevaVenta.getRowCount(); i++) {
                        if (tableNuevaVenta.getValueAt(i, 1).equals(txtDescripcionVenta.getText())) {
                            JOptionPane.showMessageDialog(null, "Producto ya ha sido registrado");
                            return;
                        }
                    }
                    ArrayList lista = new ArrayList();
                    lista.add(item);
                    lista.add(id);
                    lista.add(descripcion);
                    lista.add(cantidad);
                    lista.add(precio);
                    lista.add(total);
                    Object[] O = new Object[5];
                    O[0] = lista.get(1);
                    O[1] = lista.get(2);
                    O[2] = lista.get(3);
                    O[3] = lista.get(4);
                    O[4] = lista.get(5);

                    tmp.addRow(O);
                    tableNuevaVenta.setModel(tmp);
                    TotalPagar();
                    limpiarVenta();
                    txtCodigoVenta.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Stock no disponible");
                    txtCantidadVenta.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese cantidad");
            }
        }
    }//GEN-LAST:event_txtCantidadVentaKeyPressed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        // TODO add your handling code here:
        if (tableNuevaVenta.getRowCount() > 0) {
            if (!"".equals(txtNombreClienteVenta.getText()) && !"".equals(txtNombreVendedor.getText())) {
                RegistrarVenta();
                RegistrarDetalle();
                ActualizarStock();
                JOptionPane.showMessageDialog(null, "Factura registrada correctamente");
                limpiarTableNvVenta();
                txtCodigoVenta.requestFocus();
                txtCedulaClienteVenta.setText("");
                txtNombreClienteVenta.setText("");
                txtIdVendedor.setText("");
                txtNombreVendedor.setText("");
                lblTotalPagar.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Favor buscar cliente y vendedor");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos registrados");
        }

    }//GEN-LAST:event_btnFacturarActionPerformed

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
        // TODO add your handling code here:
        {
            if (!"".equals(txtCodigoProducto.getText()) || !"".equals(txtDescripcionProducto.getText())
                || !"".equals(txtCantidadProducto.getText()) || !"".equals(txtPrecio.getText())
                || !"".equals(cdxProveedorProducto.getSelectedItem())) {
                p.setId(Integer.parseInt(txtCodigoProducto.getText()));
                p.setNombre(txtDescripcionProducto.getText());
                p.setCantidad(Integer.parseInt(txtCantidadProducto.getText()));
                p.setPrecio(Integer.parseInt(txtPrecio.getText()));
                pdao.RegistrarProductos(p);
                LimpiarTable();
                limpiarProductos();
                listarProductos();
                JOptionPane.showMessageDialog(null, "Producto registrado correctamente");

            } else {
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }             
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void txtCodigoVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyPressed
        // TODO add your handling code here:
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCodigoVenta.getText())) {
                int id = Integer.parseInt(txtCodigoVenta.getText());
                p = pdao.BuscarProducto(id);
                if (p.getNombre() != null) {
                    txtDescripcionVenta.setText("" + p.getNombre());
                    txtPrecioVenta.setText("" + p.getPrecio());
                    txtStockDisponible.setText("" + p.getCantidad());
                    txtCantidadVenta.requestFocus();

                } else {
                    txtDescripcionVenta.setText("");
                    txtPrecioVenta.setText("");
                    txtStockDisponible.setText("");
                    txtCodigoVenta.requestFocus();
                    JOptionPane.showMessageDialog(null, "Codigo de producto no registrado en inventario");
                    txtCodigoVenta.setText("");
                    txtCodigoVenta.requestFocus();
                }
            } else{
//            JOptionPane.showMessageDialog(null,"Codigo de producto no registrado en inventario");
//            txtCodigoVenta.setText("");
//            txtCodigoVenta.requestFocus();
            }
        } else {
            //JOptionPane.showMessageDialog(null, "Ingrese el codigo del producto");
            txtCodigoVenta.requestFocus();
        }
    }//GEN-LAST:event_txtCodigoVentaKeyPressed

    private void txtCantidadVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadVentaActionPerformed

    private void txtNitProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNitProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNitProveedorActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        ListarProveedor();
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProveedorMouseClicked
        // TODO add your handling code here:
        
        int fila = tableProveedor.rowAtPoint(evt.getPoint());
        txtNitProveedor.setText(tableProveedor.getValueAt(fila,0).toString());
        txtNombreProveedor.setText(tableProveedor.getValueAt(fila,1).toString());
        txtTelefonoProveedor.setText(tableProveedor.getValueAt(fila,2).toString());
        txtDireccionProveedor.setText(tableProveedor.getValueAt(fila,3).toString());
        txtRazonSocialProveedor.setText(tableProveedor.getValueAt(fila,4).toString());
    }//GEN-LAST:event_tableProveedorMouseClicked

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        // TODO add your handling code here:
       if(!"".equals(txtNitProveedor.getText()))
        {
            int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro que quiere eliminar");
            if(pregunta==0){
                int id= Integer.parseInt(txtNitProveedor.getText());
                JOptionPane.showMessageDialog(null,"Proveedor eliminado");
                prdao.eliminarProveedor(id);
                LimpiarTable();
                //limpiarcliente();
                limpiarproveedor();
                ListarProveedor();
            }
            
        }else{
                JOptionPane.showMessageDialog(null,"Seleccione un proveedor de la tabla");
            }
   
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnActualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProveedorActionPerformed
       
        if("".equals(txtNitProveedor.getText())){
            JOptionPane.showMessageDialog(null,"seleccione fila");
        }else{
            pr.setNit(Integer.parseInt(txtNitProveedor.getText()));
            pr.setTelefono(Integer.parseInt(txtTelefonoProveedor.getText()));
            pr.setMateriaPrima((txtRazonSocialProveedor.getText()));
            pr.setNombre((txtNombreProveedor.getText()));
            pr.setDireccion((txtDireccionProveedor.getText()));
             if (!"".equals(txtDireccionProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText()) || !"".equals(txtRazonSocialProveedor.getText()) || !"".equals(txtNombreProveedor.getText())) {
                prdao.ModificarProveedor(pr);
                 LimpiarTable();
                //limpiarcliente();
                limpiarproveedor();
                ListarProveedor();
                     
                 }
             else{
                 JOptionPane.showMessageDialog(null,"Campos Vacios");
             }
            
        }
    }//GEN-LAST:event_btnActualizarProveedorActionPerformed

    private void tableProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProductoMouseClicked
        // TODO add your handling code here:
        int fila = tableProducto.rowAtPoint(evt.getPoint());
        txtCodigoProducto.setText(tableProducto.getValueAt(fila,0).toString());
        txtDescripcionProducto.setText(tableProducto.getValueAt(fila,1).toString());
        txtCantidadProducto.setText(tableProducto.getValueAt(fila,2).toString());
        txtPrecio.setText(tableProducto.getValueAt(fila,3).toString());
        
    }//GEN-LAST:event_tableProductoMouseClicked

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        // TODO add your handling code here:
                if(!"".equals(txtCodigoProducto.getText()))
        {
            int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro que quiere eliminar");
            if(pregunta==0){
                int id= Integer.parseInt(txtCodigoProducto.getText());
                pdao.eliminarProducto(id);
                LimpiarTable();
                limpiarProductos();
                listarProductos();
            }
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
        // TODO add your handling code here:
        if("".equals(txtCodigoProducto.getText())){
            JOptionPane.showMessageDialog(null,"seleccione fila");
        }else{
            p.setId(Integer.parseInt(txtCodigoProducto.getText()));
            p.setNombre(txtDescripcionProducto.getText());
            p.setCantidad(Integer.parseInt(txtCantidadProducto.getText()));
            p.setPrecio(Integer.parseInt(txtPrecio.getText()));
             if (!"".equals(txtDescripcionProducto.getText()) 
                     || !"".equals(txtCantidadProducto.getText()) || !"".equals(txtPrecio.getText()) 
                     || !"".equals(cdxProveedorProducto.getSelectedItem().toString())) {
                pdao.ModificarProducto(p);
                JOptionPane.showMessageDialog(null,"Producto modificado"); 
                LimpiarTable();
                limpiarProductos();
                listarProductos();
                    
                 }
             else{
                 JOptionPane.showMessageDialog(null,"Campos Vacios");
             }
            
        }
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        // TODO add your handling code here:
        modelo = (DefaultTableModel) tableNuevaVenta.getModel();
        modelo.removeRow(tableNuevaVenta.getSelectedRow());
        TotalPagar();
        txtCodigoVenta.requestFocus();
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void txtCedulaClienteVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaClienteVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaClienteVentaActionPerformed

    private void btnAgregarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarVendedorActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtCedulaVendedor.getText()) || !"".equals(txtNombreVendedor.getText()) || !"".equals(txtTelefonoVendedor.getText()) || !"".equals(txtDireccionVendedor.getText()) || !"".equals(txtJornadaVendedor.getText())){
                    vr.setCedula(Integer.parseInt(txtCedulaVendedor.getText()));
                    vr.setNombre(txtnombreVendedor.getText());
                    vr.setTelefono(Integer.parseInt(txtTelefonoVendedor.getText()));
                    vr.setDireccion(txtDireccionVendedor.getText());
                    vr.setJornada(txtJornadaVendedor.getText());
                    vrdao.registrarVendedor(vr);
                    LimpiarTable();
                    limpiarVendedor();
                    listarVendedor();
                    

        } else {
                    JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }      // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarVendedorActionPerformed

    private void btnEliminarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVendedorActionPerformed
          // TODO add your handling code here:
                if(!"".equals(txtCedulaVendedor.getText()))
        {
            int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro que quiere eliminar");
            if(pregunta==0){
                int id= Integer.parseInt(txtCedulaVendedor.getText());
                vrdao.eliminarVendedor(id);
                JOptionPane.showMessageDialog(null,"Vendedor eliminado");
                LimpiarTable();
                limpiarVendedor();
                listarVendedor();
            }
        }
    }//GEN-LAST:event_btnEliminarVendedorActionPerformed

    private void btnModificarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarVendedorActionPerformed
        // TODO add your handling code here:
         if("".equals(txtCedulaVendedor.getText())){
            JOptionPane.showMessageDialog(null,"seleccione fila");
        }else{
            vr.setCedula(Integer.parseInt(txtCedulaVendedor.getText()));
            vr.setJornada((txtJornadaVendedor.getText()));
            vr.setTelefono(Integer.parseInt(txtTelefonoVendedor.getText()));
            vr.setNombre((txtnombreVendedor.getText()));
            vr.setDireccion((txtDireccionVendedor.getText()));
             if (!"".equals(txtJornadaVendedor.getText()) || !"".equals(txtNombreVendedor.getText()) || !"".equals(txtTelefonoVendedor.getText()) || !"".equals(txtDireccionVendedor.getText())) {
                vrdao.ModificarVendedor(vr);
                LimpiarTable();
                limpiarVendedor();
                listarVendedor();
                     
                 }
             else{
                 JOptionPane.showMessageDialog(null,"Campos Vacios");
             }
            
        }
        
    }//GEN-LAST:event_btnModificarVendedorActionPerformed

    private void btnVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVendedorActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        listarVendedor();
        jTabbedPane2.setSelectedIndex(6);
    }//GEN-LAST:event_btnVendedorActionPerformed

    private void txtnombreVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreVendedorActionPerformed

    private void txtJornadaVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJornadaVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJornadaVendedorActionPerformed

    private void tableVendedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVendedorMouseClicked
        // TODO add your handling code here:
        int fila = tableVendedor.rowAtPoint(evt.getPoint());
        txtnombreVendedor.setText(tableVendedor.getValueAt(fila,0).toString());
        txtCedulaVendedor.setText(tableVendedor.getValueAt(fila,1).toString());
        txtJornadaVendedor.setText(tableVendedor.getValueAt(fila,2).toString());
        txtTelefonoVendedor.setText(tableVendedor.getValueAt(fila,3).toString());
        txtDireccionVendedor.setText(tableVendedor.getValueAt(fila,4).toString());
        
    }//GEN-LAST:event_tableVendedorMouseClicked

    private void txtCedulaClienteVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaClienteVentaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtCedulaClienteVenta.getText())) {
                int idCliente = Integer.parseInt(txtCedulaClienteVenta.getText());
                cl = client.BuscarCliente(idCliente);
                if (cl.getNombre() != null) {
                    txtNombreClienteVenta.setText("" + cl.getNombre());
                    txtTelefonoClienteVenta.setText("" + cl.getTelefono());
                    txtDireccionClienteVenta.setText("" + cl.getDireccion());
                    txtRazonClienteVenta.setText("" + cl.getId());
                } else {
                    txtCedulaClienteVenta.setText("");
                    JOptionPane.showMessageDialog(null, "Cliente no esta registrado");
                }
            }
        }
    }//GEN-LAST:event_txtCedulaClienteVentaKeyPressed

    private void txtIdVendedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdVendedorKeyPressed
        // TODO add your handling code here:
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtIdVendedor.getText())) {
                int idVendedor = Integer.parseInt(txtIdVendedor.getText());
               vr = vrdao.BuscarVendedor(idVendedor);
               if (cl.getNombre() != null){
               txtNombreVendedor.setText(""+vr.getNombre());
//               txtTelefonoClienteVenta.setText(""+cl.getTelefono());
//               txtDireccionClienteVenta.setText(""+cl.getDireccion());
//               txtRazonClienteVenta.setText(""+cl.getId());
               } else {
                   txtIdVendedor.setText("");
                   JOptionPane.showMessageDialog(null,"Vendedor no esta registrado");
               }
        }
        }
    }//GEN-LAST:event_txtIdVendedorKeyPressed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btningresarinsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarinsumoActionPerformed
        // TODO add your handling code here:
        if (!"".equals(txtCodigoInsumos.getText()) || !"".equals(txtid_proveedor.getText()) || !"".equals(txtNombreInsumos.getText()) || !"".equals(txtCantidadInsumo.getText()) || !"".equals(txtPrecioInsumo.getText())) 
        {
            in.setCodigo(Integer.parseInt(txtCodigoInsumos.getText()));
            in.setNit_proveedor(Integer.parseInt(txtid_proveedor.getText()));
            in.setNombre_insumo(txtNombreInsumos.getText());
            in.setCantidad_insumo(Integer.parseInt(txtCantidadInsumo.getText()));
            in.setPrecio(Integer.parseInt(txtPrecioInsumo.getText()));
            inDao.RegistrarInsumo(in);
            LimpiarTable();
            listarInsumos();
        }
        else{
            JOptionPane.showMessageDialog(null, "los datos estan vacios");
        } 
    }//GEN-LAST:event_btningresarinsumoActionPerformed

    private void btnInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsumoActionPerformed
        // TODO add your handling code here:
        LimpiarTable();
        listarInsumos();
        jTabbedPane2.setSelectedIndex(7);
        
    }//GEN-LAST:event_btnInsumoActionPerformed

    private void txtCodigoInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoInsumosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoInsumosActionPerformed

    private void jScrollPane7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jScrollPane7KeyPressed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_jScrollPane7KeyPressed

    private void jScrollPane7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane7MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jScrollPane7MouseClicked

    private void tableInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInsumosMouseClicked
        // TODO add your handling code here:
        int fila = tableInsumos.rowAtPoint(evt.getPoint());
        txtCodigoInsumos.setText(tableInsumos.getValueAt(fila,0).toString());
        txtNombreInsumos.setText(tableInsumos.getValueAt(fila,2).toString());
        txtid_proveedor.setText(tableInsumos.getValueAt(fila,1).toString());
        txtCantidadInsumo.setText(tableInsumos.getValueAt(fila,3).toString());
        txtPrecioInsumo.setText(tableInsumos.getValueAt(fila,4).toString());
    }//GEN-LAST:event_tableInsumosMouseClicked

    private void btnmodificarinsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarinsumoActionPerformed
        // TODO add your handling code here:
        if("".equals(txtCodigoInsumos.getText())){
            JOptionPane.showMessageDialog(null,"seleccione fila");
        }else{
            in.setCodigo(Integer.parseInt(txtCodigoInsumos.getText()));
            in.setNit_proveedor(Integer.parseInt(txtid_proveedor.getText()));
            in.setNombre_insumo(txtNombreInsumos.getText());
            in.setCantidad_insumo(Integer.parseInt(txtCantidadInsumo.getText()));
            in.setPrecio(Integer.parseInt(txtPrecioInsumo.getText()));
            System.out.println(txtCodigoInsumos.getText()+" prueba de codigo");
            System.out.println(txtid_proveedor.getText()+" prueba de proveedor");
            System.out.println(txtNombreInsumos.getText()+" prueba de nombre");
            System.out.println(txtCantidadInsumo.getText()+" prueba de cantidad");
            System.out.println(txtPrecioInsumo.getText()+" prueba de precio");
             if (!"".equals(txtid_proveedor.getText()) || !"".equals(txtNombreInsumos.getText()) || !"".equals(txtCantidadInsumo.getText()) || !"".equals(txtPrecioInsumo.getText())) {
               inDao.ModificarInsumo(in);
                 LimpiarTable();
                //limpiarcliente();
                listarInsumos();
                limpiarInsumos();
                 }
             else{
                 JOptionPane.showMessageDialog(null,"Campos Vacios");
             }
            
        }
          
    }//GEN-LAST:event_btnmodificarinsumoActionPerformed

    private void btneliminarinsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarinsumoActionPerformed
        // TODO add your handling code here:
        if(!"".equals(txtCodigoInsumos.getText()))
        {
            int pregunta=JOptionPane.showConfirmDialog(null,"Esta seguro que quiere eliminar");
            if(pregunta==0){
                int codigo= Integer.parseInt(txtCodigoInsumos.getText());
                inDao.eliminarInsumo(codigo);
                JOptionPane.showMessageDialog(null,"Insumo eliminado");
                LimpiarTable();
                limpiarInsumos();
                listarInsumos();
            }
            
        }else{
                JOptionPane.showMessageDialog(null,"Seleccione un proveedor de la tabla");
            }
    }//GEN-LAST:event_btneliminarinsumoActionPerformed

    private void txtCodigoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoVentaKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtCodigoVentaKeyTyped

    private void txtCedulaClienteVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaClienteVentaKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtCedulaClienteVentaKeyTyped

    private void txtIdVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdVendedorKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtIdVendedorKeyTyped

    private void txtCantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtCantidadVentaKeyTyped

    private void txtCedulaClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaClienteKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtCedulaClienteKeyTyped

    private void txtTelefonoClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoClienteKeyPressed
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoClienteKeyPressed

    private void txtRazonSocialClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialClienteKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtRazonSocialClienteKeyTyped

    private void txtNitProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNitProveedorKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtNitProveedorKeyTyped

    private void txtTelefonoProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoProveedorKeyTyped

    private void txtCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtCodigoProductoKeyTyped

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtCantidadProductoKeyTyped

    private void txtCedulaVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaVendedorKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtCedulaVendedorKeyTyped

    private void txtTelefonoVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoVendedorKeyTyped
        // TODO add your handling code here:
        event.soloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoVendedorKeyTyped

    private void txtTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoClienteKeyTyped
        // TODO add your handling code here:
         event.soloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoClienteKeyTyped

    private void txtCodigoInsumosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoInsumosKeyTyped
        // TODO add your handling code here:
         event.soloNumeros(evt);
    }//GEN-LAST:event_txtCodigoInsumosKeyTyped

    private void txtid_proveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtid_proveedorKeyTyped
        // TODO add your handling code here:
         event.soloNumeros(evt);
    }//GEN-LAST:event_txtid_proveedorKeyTyped

    private void txtCantidadInsumoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadInsumoKeyTyped
        // TODO add your handling code here:
         event.soloNumeros(evt);
    }//GEN-LAST:event_txtCantidadInsumoKeyTyped

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        // TODO add your handling code here:
        event.soloCaracteres(evt);
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void txtNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorKeyTyped
        // TODO add your handling code here:
        event.soloCaracteres(evt);
    }//GEN-LAST:event_txtNombreProveedorKeyTyped

    private void txtDescripcionProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionProductoKeyTyped
        // TODO add your handling code here:
        event.soloCaracteres(evt);
    }//GEN-LAST:event_txtDescripcionProductoKeyTyped

    private void jTextField18KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyTyped
        // TODO add your handling code here:
        event.soloCaracteres(evt);
    }//GEN-LAST:event_jTextField18KeyTyped

    private void txtnombreVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreVendedorKeyTyped
        // TODO add your handling code here:
        event.soloCaracteres(evt);
    }//GEN-LAST:event_txtnombreVendedorKeyTyped

    private void txtJornadaVendedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJornadaVendedorKeyTyped
        // TODO add your handling code here:
        event.soloCaracteres(evt);
    }//GEN-LAST:event_txtJornadaVendedorKeyTyped

    private void txtNombreInsumosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreInsumosKeyTyped
        // TODO add your handling code here:
        event.soloCaracteres(evt);
    }//GEN-LAST:event_txtNombreInsumosKeyTyped

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         jTabbedPane2.setSelectedIndex(5);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtIdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdVentaActionPerformed

    private void tableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasMouseClicked
        // TODO add your handling code here:
         int fila = tableVentas.rowAtPoint(evt.getPoint());
        txtIdVenta.setText(tableVentas.getValueAt(fila,0).toString()); 
    }//GEN-LAST:event_tableVentasMouseClicked

    private void btnPdfVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfVentasActionPerformed
//        try {
//            int num_factura = Integer.parseInt(txtIdVenta.getText());
//
//            File ruta = new File("src\\Pdf"+num_factura+".pdf");
//            Desktop.getDesktop().open(ruta);
//        } catch (IOException ex) {
//            java.util.logging.Logger.getLogger(Proyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
    }//GEN-LAST:event_btnPdfVentasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Excel.reporte();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
    /**
     * @param args the command line arguments
     */
    
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
                new Proyecto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCliente;
    private javax.swing.JButton btnActualizarProducto;
    private javax.swing.JButton btnActualizarProveedor;
    private javax.swing.JButton btnAgregarVendedor;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnEliminarVendedor;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnInsumo;
    private javax.swing.JButton btnModificarVendedor;
    private javax.swing.JButton btnNuevaVentana;
    private javax.swing.JButton btnPdfVentas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnVendedor;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btneliminarinsumo;
    private javax.swing.JButton btningresarinsumo;
    private javax.swing.JButton btnmodificarinsumo;
    private javax.swing.JComboBox<String> cdxProveedorProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblCedulaCliente;
    private javax.swing.JLabel lblCedulaClienteVenta;
    private javax.swing.JLabel lblCedulaVendedor;
    private javax.swing.JLabel lblDireccionVendedor;
    private javax.swing.JLabel lblJornadaVendedor;
    private javax.swing.JLabel lblNombreClienteVenta;
    private javax.swing.JLabel lblNombreVendedor;
    private javax.swing.JLabel lblTelefonoVendedor;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalPagar;
    private javax.swing.JLabel lnbl2;
    private javax.swing.JTable tableCliente;
    private javax.swing.JTable tableInsumos;
    private javax.swing.JTable tableNuevaVenta;
    private javax.swing.JTable tablePrediccion;
    private javax.swing.JTable tableProducto;
    private javax.swing.JTable tableProveedor;
    private javax.swing.JTable tableVendedor;
    private javax.swing.JTable tableVentas;
    private javax.swing.JTextField txtCantidadInsumo;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCedulaCliente;
    private javax.swing.JTextField txtCedulaClienteVenta;
    private javax.swing.JTextField txtCedulaVendedor;
    private javax.swing.JTextField txtCodigoInsumos;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JTextField txtDescripcionVenta;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionClienteVenta;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtDireccionVendedor;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdNuevaVentaProducto;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtIdVendedor;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtJornadaVendedor;
    private javax.swing.JTextField txtNitProveedor;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreClienteVenta;
    private javax.swing.JTextField txtNombreInsumos;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtNombreVendedor;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioInsumo;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtRazonClienteVenta;
    private javax.swing.JTextField txtRazonSocialCliente;
    private javax.swing.JTextField txtRazonSocialProveedor;
    private javax.swing.JTextField txtStockDisponible;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JLabel txtTelefonoClienteVenta;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtTelefonoVendedor;
    private javax.swing.JTextField txtid_proveedor;
    private javax.swing.JTextField txtnombreVendedor;
    // End of variables declaration//GEN-END:variables

    private void limpiarcliente(){
        txtIdCliente.setText("");
        txtCedulaCliente.setText("");
        txtNombreCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
        txtRazonSocialCliente.setText("");
    }
    private void limpiarproveedor(){
        txtNitProveedor.setText("");
        txtRazonSocialProveedor.setText("");
        txtNombreProveedor.setText("");
        txtTelefonoProveedor.setText("");
        txtDireccionProveedor.setText("");
    }

    private void limpiarProductos() {
            txtCodigoProducto.setText("");
            txtDescripcionProducto.setText("");
            txtCantidadProducto.setText("");
            txtPrecio.setText("");
            cdxProveedorProducto.setSelectedItem(null);
        }
    
      private void limpiarVendedor(){
        txtCedulaVendedor.setText("");
        txtJornadaVendedor.setText("");
        txtnombreVendedor.setText("");
        txtTelefonoVendedor.setText("");
        txtDireccionVendedor.setText("");
        
    }

      private void limpiarInsumos(){
        txtCodigoInsumos.setText("");
        txtNombreInsumos.setText("");
        txtid_proveedor.setText("");
        txtCantidadInsumo.setText("");
        txtPrecioInsumo.setText("");
        
    }

   private void TotalPagar() {
        totalPagar = 0;
        int numFila = tableNuevaVenta.getRowCount();
        for (int i = 0; i < numFila; i++) {
            int cal = Integer.parseInt(String.valueOf(tableNuevaVenta.getModel().getValueAt(i, 4)));
            totalPagar = totalPagar + cal;
        }
        lblTotalPagar.setText(String.format("%d", totalPagar));
    }
   
   private void limpiarVenta() {
        txtCodigoVenta.setText("");
        txtDescripcionVenta.setText("");
        txtCantidadVenta.setText("");
        txtPrecioVenta.setText("");
        txtStockDisponible.setText("");
        txtIdNuevaVentaProducto.setText("");
    }
    

    private void RegistrarVenta() {
  
        String vendedor = txtNombreVendedor.getText();
        String cliente = txtNombreClienteVenta.getText();
        int monto = totalPagar;
 
        v.setNombre_vendedor(vendedor);
        v.setNombre_cliente(cliente);
        v.setPrecio_total(monto);
        vdao.RegistrarVenta(v);
    }

    private void RegistrarDetalle() {
        int id = vdao.IdVenta();
        for (int i = 0; i < tableNuevaVenta.getRowCount(); i++) {
            int cod = Integer.parseInt(tableNuevaVenta.getValueAt(i, 0).toString());
            int cantidad = Integer.parseInt(tableNuevaVenta.getValueAt(i, 2).toString());
            int precio = Integer.parseInt(tableNuevaVenta.getValueAt(i, 3).toString());
            Dv.setCod_pro(cod);
            Dv.setCantidad(cantidad);
            Dv.setPrecio(precio);
            Dv.setId(id);
            vdao.DetalleVenta(Dv);
        }
    }
    
    private void ActualizarStock(){
        for (int i = 0; i < tableNuevaVenta.getRowCount(); i++) {
            int codigo = Integer.parseInt(tableNuevaVenta.getValueAt(i, 0).toString());
            int cantidad = Integer.parseInt(tableNuevaVenta.getValueAt(i, 2).toString());
            p = pdao.BuscarProducto(codigo);
            int stockActual = p.getCantidad() - cantidad;
            vdao.ActualizarStock(stockActual, codigo);
        }
    }
    
    private void limpiarTableNvVenta(){
        tmp = (DefaultTableModel) tableNuevaVenta.getModel();
        int filas = tableNuevaVenta.getRowCount();
        for (int i = 0; i < filas; i++){
            tmp.removeRow(0);
        }
    }
    
//    private void pdf() throws FileNotFoundException, DocumentException{ 
//    try{
//            FileOutputStream archivo;
//            File file = new File("src\\Pdf\\venta.pdf");
//            archivo = new FileOutputStream(file);
//            Document doc = new Document();
//            PdfWriter.getInstance(doc, archivo);
//            doc.open();
//            Image img = new Image.getInstance("\"src\\\\Pdf\\\\venta.pdf\"");
//            
//            doc.close();
//            archivo.close();
//        }
//        catch(SQLException e){
//            System.out.println(e.toString());
//            return true;
//        }
//    } 

 

}
