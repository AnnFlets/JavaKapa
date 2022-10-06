package modelo;

import conexion.Conector;
import extras.Extras;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO implements ConsultarProducto {

    ErrorVO evo = new ErrorVO();
    ErrorDAO edao = new ErrorDAO();
    Extras extras = new Extras();

    @Override
    public boolean insertarProducto(ProductoVO pvo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ProductoVO> consultarProducto() {
        Conector conector = new Conector();
        ArrayList<ProductoVO> informacionProducto = new ArrayList<>();
        try {
            conector.conectar();
            String query = "SELECT "
                    + "p.id_producto, "
                    + "p.descripcion_producto, "
                    + "p.marca_producto, "
                    + "p.presentacion_producto, "
                    + "p.categoria_producto, "
                    + "p.precio_compra_producto, "
                    + "p.precio_venta_producto, "
                    + "p.existencia_producto, "
                    + "p.img_producto, "
                    + "p.id_proveedor_fk "
                    + "FROM producto p";
            ResultSet resultSet = conector.consultaDatos(query);
            while (resultSet.next()) {
                ProductoVO pvo = new ProductoVO();
                pvo.setIdProducto(resultSet.getInt(1));
                pvo.setDescripcionProducto(resultSet.getString(2));
                pvo.setMarcaProducto(resultSet.getString(3));
                pvo.setPresentacionProducto(resultSet.getString(4));
                pvo.setCategoriaProducto(resultSet.getString(5));
                pvo.setPrecioCompraProducto(resultSet.getDouble(6));
                pvo.setPrecioVentaProducto(resultSet.getDouble(7));
                pvo.setExistenciaProducto(resultSet.getInt(8));
                pvo.setImgProducto(resultSet.getString(9));
                pvo.setIdProveedor(resultSet.getInt(10));
                informacionProducto.add(pvo);
            }
            conector.desconectar();
        } catch (Exception e) {
            evo.setDescripcionError("[Consultar-Producto]: " + e.getMessage());
            evo.setFechaError(extras.devolverFechaActual());
            edao.insertarError(evo);
            conector.desconectar();
        }
        return informacionProducto;
    }

    @Override
    public boolean actualizarProducto(ProductoVO pvo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarProducto(ProductoVO pvo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reporteProducto() {

    }
}
