package controlador;

import extras.Extras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.ClienteDAO;
import modelo.ClienteVO;
import vista.FrmCliente;

public class ControladorCliente implements ActionListener, WindowListener, MouseListener {

    FrmCliente vCliente = new FrmCliente();
    ClienteVO cvo = new ClienteVO();
    ClienteDAO cdao = new ClienteDAO();
    Extras extras = new Extras();
    DefaultTableModel modeloTablaProveedor;
    boolean banderaReporte = false;

    /**
     * Constructor con parámetro
     *
     * @param vCliente -> Representa la vista del administrador de clientes
     */
    public ControladorCliente(FrmCliente vCliente) {
        this.vCliente = vCliente;
        this.vCliente.addWindowListener(this);
        this.vCliente.tblClientes.addMouseListener(this);
        this.vCliente.btnCrearCliente.addActionListener(this);
        this.vCliente.btnActualizarCliente.addActionListener(this);
        this.vCliente.btnEliminarCliente.addActionListener(this);
        this.vCliente.btnReporteCliente.addActionListener(this);
        this.vCliente.btnSalirCliente.addActionListener(this);
    }
    
    private void reporteProveedores() {
        cdao.reporteCliente();
        cdao.jasperViewer.setDefaultCloseOperation(this.vCliente.DISPOSE_ON_CLOSE);
        cdao.jasperViewer.setVisible(true);
        banderaReporte = true;
    }
    
    private void limpiarCampos() {
        this.vCliente.txtIdCliente.setText("");
        this.vCliente.txtUsuarioCliente.setText("");
        this.vCliente.txtContraseniaCliente.setText("");
        this.vCliente.txtNombreCliente.setText("");
        this.vCliente.txtApellidoCliente.setText("");
        this.vCliente.txtNitCliente.setText("");
        this.vCliente.txtTelefonoCliente.setText("");
        this.vCliente.txtCorreoCliente.setText("");
        this.vCliente.txtDireccionCliente.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.vCliente.btnCrearCliente) {

        }
        if (ae.getSource() == this.vCliente.btnActualizarCliente) {

        }
        if (ae.getSource() == this.vCliente.btnEliminarCliente) {

        }
        if (ae.getSource() == this.vCliente.btnReporteCliente) {

        }
        if (ae.getSource() == this.vCliente.btnSalirCliente) {

        }
    }

    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
