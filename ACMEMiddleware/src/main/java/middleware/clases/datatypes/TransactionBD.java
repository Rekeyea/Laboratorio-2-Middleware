package middleware.clases.datatypes;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionBD {
	private long id;
	private Date fecha;
	private String transaccion; // C,D,S
	private String codigoComercio;
	private String nombreComercio;
	private String numeroTarjeta;
	private String tipoTarjeta;	//D, C, P
	private String codigoMoneda;
	private BigDecimal monto;
	
	
	public TransactionBD(Transaction t) throws Exception{
		try{
			this.id= t.getId();
			SimpleDateFormat formatter = new SimpleDateFormat("MMddyy-HHmmss");
			this.fecha= formatter.parse(t.getFecha()+ "-" +t.getHora());		
			this.transaccion = Constants.transactionTypesMap.get(t.getTipo());		
			this.codigoComercio=t.getCodigoComercio();
			this.nombreComercio=t.getNombreComercio();
			this.numeroTarjeta=t.getNumeroTarjeta();			
			this.tipoTarjeta = Constants.cardTypesMap.get(t.getTipoTarjeta());
			this.codigoMoneda=t.getCodigoMoneda();		
			this.monto=t.getMonto();
		}catch(Exception e){
			throw new Exception("ERROR EN EL PARSEO DE LA FECHA: " + e.getMessage());	//no deberia pasar, fecha ya vino validada.
		}
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getTransaccion() {
		return transaccion;
	}
	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
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
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}



}
