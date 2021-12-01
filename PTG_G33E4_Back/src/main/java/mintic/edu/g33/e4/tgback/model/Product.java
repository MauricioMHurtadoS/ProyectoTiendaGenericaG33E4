package mintic.edu.g33.e4.tgback.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="productos")
public class Product {
	
	//atributos tabla
	@Id
	private int codigo_producto;
	
	private String nombre_producto;
	
	private int nitproveedor;
	
	private double precio_compra;
	
	private double ivacompra;
	
	private double precio_venta;

	public Product(int codigo_producto, String nombre_producto, int nitproveedor, double precio_compra,
			double ivacompra, double precio_venta) {
		this.codigo_producto = codigo_producto;
		this.nombre_producto = nombre_producto;
		this.nitproveedor = nitproveedor;
		this.precio_compra = precio_compra;
		this.ivacompra = ivacompra;
		this.precio_venta = precio_venta;
	}

	public Product() {
	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	@Override
	public String toString() {
		return "Product [codigo_producto=" + codigo_producto + ", nombre_producto=" + nombre_producto
				+ ", nitproveedor=" + nitproveedor + ", precio_compra=" + precio_compra + ", ivacompra=" + ivacompra
				+ ", precio_venta=" + precio_venta + "]";
	}
	
}
