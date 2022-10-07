/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import extras.Extras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.ProductoDAO;
import modelo.ProductoVO;
import vista.FrmProducto;

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
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
