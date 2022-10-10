/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Extras;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Locale.filter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoDAO;
import modelo.ProductoVO;
import vista.FrmProducto;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Pablo_Fuentes
 */
public class ControladorProducto implements ActionListener, WindowListener, MouseListener{

    FrmProducto vProducto = new FrmProducto();
    ProductoVO pdvo = new ProductoVO();
    ProductoDAO pddao = new ProductoDAO();
    Extras extras = new Extras();
    DefaultTableModel modeloTablaProductos;
    boolean banderaReporte = false;
    
    /**
     * Controlador con parámetro
     *
    @param vProducto -> Representa la vista del administrador
     */   
    
    public ControladorProducto(FrmProducto vProducto){
    
    this.vProducto = vProducto;
    this.vProducto.addWindowListener(this);
    this.vProducto.btncrearProducto.addActionListener(this);
    this.vProducto.btnActualizarProducto.addActionListener(this);
    this.vProducto.btnEliminarProducto.addActionListener(this);
    this.vProducto.btnReporteProducto.addActionListener(this);
    this.vProducto.btnSalirProducto.addActionListener(this);
    this.vProducto.btnImagenAgregar.addActionListener(this);
    this.vProducto.btnLimpiarCampos.addActionListener(this);
    this.vProducto.tblProductos.addMouseListener(this);
    
    }
    
    private void mostrarProductos(){
        modeloTablaProductos = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        modeloTablaProductos.setColumnCount(0);
        modeloTablaProductos.addColumn("ID");
        modeloTablaProductos.addColumn("Descripción");
        modeloTablaProductos.addColumn("Marca");    
        modeloTablaProductos.addColumn("Presentación");
        modeloTablaProductos.addColumn("Categoria");
        modeloTablaProductos.addColumn("Precio de Compra Q");
        modeloTablaProductos.addColumn("Precio de Venta");
        modeloTablaProductos.addColumn("Existencias");
        modeloTablaProductos.addColumn("Imagen");
        modeloTablaProductos.addColumn("Proveedor");
    
            for (ProductoVO pdvo : pddao.consultarProducto()) {
            modeloTablaProductos.addRow(new Object[]{pdvo.getIdProducto(),
                pdvo.getDescripcionProducto(), pdvo.getMarcaProducto(), pdvo.getPresentacionProducto(),
                pdvo.getCategoriaProducto(), pdvo.getPrecioCompraProducto(), pdvo.getPrecioVentaProducto(),
                pdvo.getExistenciaProducto(), pdvo.getImgProducto(), pdvo.getIdProveedor()
            });
        }
            
        this.vProducto.tblProductos.setModel(modeloTablaProductos);
        this.vProducto.tblProductos.getTableHeader().setReorderingAllowed(false);
        this.vProducto.tblProductos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        this.vProducto.tblProductos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        this.vProducto.tblProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        this.vProducto.tblProductos.getColumnModel().getColumn(0).setMinWidth(0);       
        
}

    private void llenarCamposProductos() {
        int numero = 0;
        while (numero < 10) {
            switch (numero) {
                case 0:
                    this.vProducto.txtIdProducto.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
                case 1:
                    this.vProducto.txtDescripcionProducto.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
                case 2:
                    this.vProducto.txtMarcaProducto.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
                case 3:
                    this.vProducto.txtPresentacionProducto.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
                case 4:
                    this.vProducto.txtCategoriaProducto.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
                case 5:
                    this.vProducto.txtPrecioCompraProducto.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
                case 6:
                    this.vProducto.txtPrecioVentaProducto.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
                case 7:
                    this.vProducto.txtExistenciasProducto.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
                case 8:
                    this.vProducto.txtImagen.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
                case 9:
                    this.vProducto.txtProveedorProducto.setText(String.valueOf(this.vProducto.tblProductos.getValueAt(this.vProducto.tblProductos.getSelectedRow(), numero)));
                    break;
            }
            numero++;
        }
    }    
    
    private boolean verificarProductoDuplicado(int opcion) {
        
        boolean banderaProducto = true;
        if (opcion == 1) {
            for (ProductoVO Producto : pddao.consultarProducto()) {
                if (Producto.getIdProducto()==Integer.parseInt(this.vProducto.txtIdProducto.getText())) {
                    banderaProducto = false;
                    
                    this.vProducto.jop_mensajes.showMessageDialog(null, "Ya existe un Producto con el mismo ID.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                    if (!this.vProducto.txtIdProducto.getText().isEmpty()) {
                        limpiarCampos();
                    }
                    break;
                }
            }
        } else {
            ArrayList<ProductoVO> Producto = pddao.consultarProducto();
            for (int i = 0; i < Producto.size(); i++) {
                if (Producto.get(i).getIdProducto() == Integer.parseInt(this.vProducto.txtIdProducto.getText())) 
                {
                    if (i != this.vProducto.tblProductos.getSelectedRow()) {
                        banderaProducto = false;
                        this.vProducto.jop_mensajes.showMessageDialog(null, "Ya existe un Producto con el mismo nombre y/o teléfono.",
                                "Advertencia", JOptionPane.WARNING_MESSAGE);
                        limpiarCampos();
                        break;
                    }
                }
            }
        }
        return banderaProducto;
    }
    

    private void registrarProducto() {
        if (!this.vProducto.txtDescripcionProducto.getText().isEmpty()
                && !this.vProducto.txtMarcaProducto.getText().isEmpty()
                && !this.vProducto.txtPresentacionProducto.getText().isEmpty()
                && !this.vProducto.txtCategoriaProducto.getText().isEmpty()
                && !this.vProducto.txtPrecioCompraProducto.getText().isEmpty()
                && !this.vProducto.txtPrecioVentaProducto.getText().isEmpty()
                && !this.vProducto.txtExistenciasProducto.getText().isEmpty()
                && !this.vProducto.txtImagen.getText().isEmpty()
                && !this.vProducto.txtProveedorProducto.getText().isEmpty()) {

//  
            if (verificarProductoDuplicado(1)) {
                this.pdvo.setDescripcionProducto(this.vProducto.txtDescripcionProducto.getText());
                this.pdvo.setMarcaProducto(this.vProducto.txtMarcaProducto.getText());
                this.pdvo.setPresentacionProducto(this.vProducto.txtPresentacionProducto.getText());
                this.pdvo.setCategoriaProducto(this.vProducto.txtCategoriaProducto.getText());
                this.pdvo.setPrecioCompraProducto(Double.parseDouble(this.vProducto.txtPrecioCompraProducto.getText()));
                this.pdvo.setPrecioVentaProducto(Double.parseDouble(this.vProducto.txtPrecioVentaProducto.getText()));
                this.pdvo.setExistenciaProducto(Integer.parseInt(this.vProducto.txtExistenciasProducto.getText()));
                //this.pdvo.setImgProducto( this.vProducto.txtImagen.getText());
                this.pdvo.setIdProveedor(Integer.parseInt(this.vProducto.txtProveedorProducto.getText()));
                
                
                if (pddao.insertarProducto(pdvo) == true) {
                    limpiarCampos();
                    this.vProducto.jop_mensajes.showMessageDialog(null, "Producto registrado correctamente.",
                            "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    this.vProducto.jop_mensajes.showMessageDialog(null, "Error, datos no registrados.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            this.vProducto.jop_mensajes.showMessageDialog(null, "Todos los campos deben de tener información según corresponda",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

//

    }    


    private void modificarProducto() {
        if (!this.vProducto.txtDescripcionProducto.getText().isEmpty()
                && !this.vProducto.txtMarcaProducto.getText().isEmpty()
                && !this.vProducto.txtPresentacionProducto.getText().isEmpty()
                && !this.vProducto.txtCategoriaProducto.getText().isEmpty()
                && !this.vProducto.txtPrecioCompraProducto.getText().isEmpty()
                && !this.vProducto.txtPrecioVentaProducto.getText().isEmpty()
                && !this.vProducto.txtExistenciasProducto.getText().isEmpty()
                && !this.vProducto.txtImagen.getText().isEmpty()
                && !this.vProducto.txtProveedorProducto.getText().isEmpty()) {
        
            if (verificarProductoDuplicado(2)) {
                
                this.pdvo.setIdProducto(Integer.parseInt(this.vProducto.txtIdProducto.getText()));
                this.pdvo.setDescripcionProducto(this.vProducto.txtDescripcionProducto.getText());
                this.pdvo.setMarcaProducto(this.vProducto.txtMarcaProducto.getText());
                this.pdvo.setPresentacionProducto(this.vProducto.txtPresentacionProducto.getText());
                this.pdvo.setCategoriaProducto(this.vProducto.txtCategoriaProducto.getText());
                this.pdvo.setPrecioCompraProducto(Double.parseDouble(this.vProducto.txtPrecioCompraProducto.getText()));
                this.pdvo.setPrecioVentaProducto(Double.parseDouble(this.vProducto.txtPrecioVentaProducto.getText()));
                this.pdvo.setExistenciaProducto(Integer.parseInt(this.vProducto.txtExistenciasProducto.getText()));
                //this.pdvo.setImgProducto( this.vProducto.txtImagen.getText());
                this.pdvo.setIdProveedor(Integer.parseInt(this.vProducto.txtProveedorProducto.getText()));
                
                if (pddao.actualizarProducto(pdvo) == true) {
                    limpiarCampos();
                    this.vProducto.jop_mensajes.showMessageDialog(null, "Producto actualizado correctamente.",
                            "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    this.vProducto.jop_mensajes.showMessageDialog(null, "Error, no se pudo actualizar el producto.",
                            "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            this.vProducto.jop_mensajes.showMessageDialog(null, "No ha seleccionado ningún producto.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }    
 
    private void eliminarProducto() {
        if (!this.vProducto.txtIdProducto.getText().isEmpty()) {
            this.pdvo.setIdProducto(Integer.parseInt(this.vProducto.txtIdProducto.getText()));
            if (pddao.eliminarProducto(pdvo) == true) {
                limpiarCampos();
                this.vProducto.jop_mensajes.showMessageDialog(null, "Producto eliminado correctamente.",
                        "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.vProducto.jop_mensajes.showMessageDialog(null, "Error, no se pudo eliminar el producto.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            this.vProducto.jop_mensajes.showMessageDialog(null, "No ha seleccionado ningún producto.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void reporteProductos() {
        pddao.reporteProducto();
        pddao.jasperViewer.setDefaultCloseOperation(this.vProducto.DISPOSE_ON_CLOSE);
        pddao.jasperViewer.setVisible(true);
        banderaReporte = true;
        
    }
    
    private void limpiarCampos() {
        this.vProducto.txtIdProducto.setText("");
        this.vProducto.txtDescripcionProducto.setText("");
        this.vProducto.txtMarcaProducto.setText("");
        this.vProducto.txtPresentacionProducto.setText("");
        this.vProducto.txtCategoriaProducto.setText("");
        this.vProducto.txtPrecioCompraProducto.setText("");
        this.vProducto.txtPrecioVentaProducto.setText("");
        this.vProducto.txtExistenciasProducto.setText("");
        this.vProducto.txtImagen.setText("");
        this.vProducto.txtProveedorProducto.setText("");
        this.vProducto.labelImagenProducto.setIcon(null);
    }
 
   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.vProducto.btnLimpiarCampos) {
    
            limpiarCampos();     
        } 
 
        
        if (e.getSource() == this.vProducto.btncrearProducto) {
            registrarProducto();
        }
        
        if (e.getSource() == this.vProducto.btnActualizarProducto) {
            modificarProducto();
        }
        
        if (e.getSource() == this.vProducto.btnEliminarProducto) {
            eliminarProducto();
        }
        
        if (e.getSource() == this.vProducto.btnReporteProducto) {
            reporteProductos();
        }
        
        if (e.getSource() == this.vProducto.btnSalirProducto ) {
            limpiarCampos();
            this.vProducto.dispose();
            
            if (!this.vProducto.txtIdProducto.getText().isEmpty()) {
                limpiarCampos();
            }
            if (banderaReporte) {
                pddao.jasperViewer.setVisible(false);
            }
        }
        
    //BOTON PARA AGREGAR LA IMAGEN
        if (e.getSource() == this.vProducto.btnImagenAgregar ) {
    
            this.vProducto.jop_mensajes.showMessageDialog(null, "BOTON IMAGEN!!.",
            "Advertencia", JOptionPane.WARNING_MESSAGE);   
            
            seleccionarImagen();
        }
        
       
    }

    @Override
    public void windowOpened(WindowEvent e) {
        limpiarCampos();
        mostrarProductos();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
                this.vProducto.jop_mensajes.showMessageDialog(null, "Se saldrá de Productos!!.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);    
    }

    @Override
    public void windowClosed(WindowEvent e) {
    
            if (!this.vProducto.txtIdProducto.getText().isEmpty()) {
            limpiarCampos();
        }
        if (banderaReporte) {
            pddao.jasperViewer.setVisible(false);
        }
    }

    @Override
    public void windowIconified(WindowEvent e) {
    
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    
    }

    @Override
    public void windowActivated(WindowEvent e) {
    
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
     
    }

    @Override
    public void mousePressed(MouseEvent e) {
            if (e.getSource() == this.vProducto.tblProductos) {
                if (e.getClickCount() == 2) {
                   llenarCamposProductos();
           }
      }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void seleccionarImagen() {
        
        final JFileChooser elegirImagen = new JFileChooser(".");
        
       FileFilter filtro = new FileNameExtensionFilter("Archivos de Imagen (.png)", "png", "jpeg"); 
           
        elegirImagen.addChoosableFileFilter(filtro);
        elegirImagen.setFileFilter(filtro);
        
        elegirImagen.setMultiSelectionEnabled(false);
        
        int o = elegirImagen.showOpenDialog(this.vProducto);
        
        if(o == JFileChooser.APPROVE_OPTION){
            String ruta = elegirImagen.getSelectedFile().getAbsolutePath();
            String nombre = elegirImagen.getSelectedFile().getName();
            vProducto.txtImagen.setText(nombre);
            
            Image preview = Toolkit.getDefaultToolkit().getImage(ruta);

            if(preview != null){
                vProducto.labelImagenProducto.setText("");
                ImageIcon icon = new ImageIcon(preview.getScaledInstance(vProducto.labelImagenProducto.getWidth(), vProducto.labelImagenProducto.getHeight(), Image.SCALE_DEFAULT));
                vProducto.labelImagenProducto.setIcon(icon);
            }
        }
    

            }
    
}
