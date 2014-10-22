package logic.datatypes;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="Transaction")
//@XmlType(namespace="ACMEv3")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {
	
	
	@XmlElement( required = true )
	private long id;
	
	@XmlElement( required = true )
	private String fecha;			//Formato ddmmyy
	
	@XmlElement( required = true )
	private String hora;			//Formato hhmmss
	
	@XmlElement( required = true )
	private String tipo; 			//compra, deposito, consulta de saldo
	
	@XmlElement( required = true )
	private String codigoComercio;
	
	@XmlElement( required = true )
	private String nombreComercio;
	
	@XmlElement( required = true )
	private String numeroTarjeta;
	
	@XmlElement( required = true )
	private String tipoTarjeta;		//debito, credito, prepaga
	
	@XmlElement( required = true )
	private String codigoMoneda;	//UYU, USD
	
	@XmlElement( required = true )
	private String tipoDispositivo;	//POS, WEB, ATM
	
	@XmlElement( required = true )
	private BigDecimal monto;			
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodigoComercio() {
		return codigoComercio;
	}
	public void setCodigoComercio(String codigoComercio) {
		this.codigoComercio = codigoComercio;
	}
	public String getNombreComercio() {
		return nombreComercio;
	}
	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public String getCodigoMoneda() {
		return codigoMoneda;
	}
	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}
	public String getTipoDispositivo() {
		return tipoDispositivo;
	}
	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	

}
