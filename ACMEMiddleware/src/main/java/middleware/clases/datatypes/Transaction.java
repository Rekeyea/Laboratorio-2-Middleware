package middleware.clases.datatypes;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Transaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {
	
	private long id;
	private String fecha;			//Formato ddmmyy
	private String hora;			//Formato hhmmss
	private String tipo; 			//compra, deposito, consulta de saldo
	private String codigoComercio;
	private String nombreComercio;	
	private String numeroTarjeta;
	private String tipoTarjeta;		//debito, credito, prepaga
	private String codigoMoneda;	//UYU, USD
	private String tipoDispositivo;	//POS, WEB, ATM
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
	
	private String getErrorMessage(long id, String msg){
		return String.format("Transaccion [ %d ] invalida: %s", id,msg);
	}
	
	/***
	 * Valida transaccion. Tira excepcion si algun campo es invalido.
	 * @throws Exception
	 */
	public void ValidateTransaction() throws Exception{
				

		//validar fecha
		try{
			SimpleDateFormat parser = new SimpleDateFormat(Constants.dateFormat);
			parser.parse(this.getFecha());
		}
		catch(Exception e){
			throw new Exception(this.getErrorMessage(this.getId(), "Fecha invalida."));
		}
		
		//validar hora
		try{
			SimpleDateFormat parser = new SimpleDateFormat(Constants.timeFormat);
			parser.parse(this.getHora());
		}
		catch(Exception e){
			throw new Exception(this.getErrorMessage(this.getId(), "Hora invalida."));
			
		}
		
		//validar tipo de transaccion
		boolean validTransactionType = false;
		if(this.getTipo() != null){
			for(String type:Constants.transactionTypes){
				if(this.getTipo().equals(type)){
					validTransactionType = true;
					break;
				}
			}
		}		
		if(!validTransactionType){
			throw new Exception(this.getErrorMessage(this.getId(), "Tipo de transaccion invalido."));			
		}
		
		
		//validar tipo de tarjeta
		boolean validCardType = false;
		if(this.getTipoTarjeta() != null){
			for(String type:Constants.cardTypes){
				if(this.getTipoTarjeta().equals(type)){
					validCardType = true;
					break;
				}
			}
		}		
		if(!validCardType){
			throw new Exception(this.getErrorMessage(this.getId(), "Tipo de tarjeta invalido."));		
		}
		
		//Validar moneda
		boolean validCurrencyType = false;
		if(this.getCodigoMoneda() != null){
			for(String type:Constants.currencyTypes){
				if(this.getCodigoMoneda().equals(type)){
					validCurrencyType = true;
					break;
				}
			}
		}		
		if(!validCurrencyType){
			throw new Exception(this.getErrorMessage(this.getId(), "Tipo de moneda invalido."));			
		}
		
		//validar tipo dispositivo.		
		boolean validDevice = false;
		if(this.getTipoDispositivo() != null){
			for(String type:Constants.deviceTypes){
				if(this.getTipoDispositivo().equals(type)){
					validDevice = true;
					break;
				}
			}
		}		
		if(!validDevice){
			throw new Exception(this.getErrorMessage(this.getId(), "Tipo de dispositivo invalido."));			
		}
		
	}

}
