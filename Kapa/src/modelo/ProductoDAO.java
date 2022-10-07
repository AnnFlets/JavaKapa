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
      Conector c = new Conector();
        
        try{
        
        c.conectar();
        
        String query= "INSERT INTO producto (descripcion_producto, marca_producto, presentacion_producto, "+
        "categoria_producto, precio_compra_producto, precio_venta_producto, existencia_producto, "+
        "img_producto, id_proveedor_fk) VALUES ('"+
        pvo.getDescripcionProducto()+"', '"+
        pvo.getMarcaProducto()+"', '"+
        pvo.getPresentacionProducto()+"', '"+
        pvo.getCategoriaProducto()+"', "+
        pvo.getPrecioCompraProducto()+", "+
        pvo.getPrecioVentaProducto()+", "+
        pvo.getExistenciaProducto()+", "+
        pvo.getImgProducto()+", "+
        pvo.getIdProveedor()+")";
        
        c.consultasMultiples(query);
        return true;        
        }
        
        catch (Exception e){
        
        System.err.println("Error [PABLO INSERTAR PRODUCTO]: "+e.getMessage());
        c.desconectar();
        }
        c.desconectar();
        return false;
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
                    + "FROM dbkapa.producto p";
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
                pvo.setImgProducto(resultSet.getBlob(9));
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
      
        Conector c = new Conector();
        
        try{
            
            c.conectar();
        String query = "UPDATE dbkapa.producto SET "+
        " descripcion_producto = '"+ pvo.getDescripcionProducto()+"',"+ 
        " marca_producto = '"+ pvo.getMarcaProducto()+"',"+
        "presentacion_producto = '"+ pvo.getPresentacionProducto()+"',"+
        "categoria_producto = '"+ pvo.getCategoriaProducto()+"',"+
        "precio_compra_producto= "+ pvo.getPrecioCompraProducto()+","+
        "precio_venta_producto = "+ pvo.getPrecioVentaProducto()+","+
        "existencia_producto = "+ pvo.getExistenciaProducto()+","+
        "img_producto = "+ pvo.getImgProducto()+","+
        "id_proveedor_fk" + pvo.getIdProveedor()+ " WHERE id_producto = "+ pvo.getIdProducto();
        c.consultasMultiples(query);
        
        }
        
        catch(Exception e){
        System.err.println("Error [PABLO ACTUALIZAR PRODUCTO]: "+e.getMessage());
        c.desconectar();
        return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean eliminarProducto(ProductoVO pvo) {
           Conector c = new Conector();
       
       try {
       c.conectar();
       
       String query = "DELETE FROM dbkapa.producto WHERE id_producto = "+ pvo.getIdProducto();
       c.consultasMultiples(query);
       
       }
       
       catch (Exception e){
       System.err.println("Error [PABLO ELIMINAR PRODUCTO]: "+e.getMessage());
       c.desconectar();
       return false;
       
       }
      c.desconectar();
      return true;
    }

    @Override
    public void reporteProducto() {

    }

    @Override
    public ArrayList<ProductoVO> actualizarTabla() {
          Conector c = new Conector();
      ArrayList<ProductoVO> info = new ArrayList<>();
      
      try{
      c.conectar();
      
      String query = "SELECT p.id_producto, p.descripcion_producto, "+
        "p.marca_producto, p.presentacion_producto, p.categoria_producto, p.precio_compra_producto, "+
        "p.precio_venta_producto, p.existencia_producto, p.img_producto, p.id_proveedor_fk FROM dbkapa.producto p";
      
      ResultSet resultSet = c.consultaDatos(query);
      
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
                pvo.setImgProducto(resultSet.getBlob(9));
                pvo.setIdProveedor(resultSet.getInt(10));
      
        info.add(pvo);        
      }
      c.desconectar();
      }
      
      catch(Exception e){
      System.err.println("Error [PABLO ACTUALIZAR TABLA PRODUCTO]: "+e.getMessage());
      c.desconectar();
      }
      return info;
    }
}
