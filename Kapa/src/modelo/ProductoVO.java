package modelo;

import java.awt.Image;
import java.sql.Blob;


public class ProductoVO {
    /**
     * Atributos de la clase
     */
    private int idProducto;
    private String descripcionProducto;
    private String marcaProducto;
    private String presentacionProducto;
    private String categoriaProducto;
    private double precioCompraProducto;
    private double precioVentaProducto;
    private int existenciaProducto;
    //private Image imgProducto;
    private Blob imgProducto;
    private int idProveedor;
    private Blob blob;
    private String ImagenNombreProducto;
    

    /**
     * Constructor vacío
     */
    public ProductoVO() {
    }

    /**
     * Getters & Setters
     * @return -> Retorna el valor almacenado en las variables
     */
     
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public String getPresentacionProducto() {
        return presentacionProducto;
    }

    public void setPresentacionProducto(String presentacionProducto) {
        this.presentacionProducto = presentacionProducto;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public double getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    public void setPrecioCompraProducto(double precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }

    public int getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(int existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

   // public Image getImgProducto() {
   //     return imgProducto;
   // }

  //  public void setImgProducto(Image imgProducto) {
  //      this.imgProducto = imgProducto;
  //  }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    public String getImagenNombreProducto() {
        return ImagenNombreProducto;
    }

    public void setImagenNombreProducto(String ImagenNombreProducto) {
        this.ImagenNombreProducto = ImagenNombreProducto;
    }

    Blob getBlob(String imagen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Blob getImgProducto() {
        return imgProducto;
   }

    public void setImgProducto(Blob imgProducto) {
       this.imgProducto = imgProducto;
   }   
}