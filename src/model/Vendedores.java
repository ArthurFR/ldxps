package model;
import java.util.Date;

public class Vendedores {
	private String cdvend;
	private String dsnome;
	private int cdtab;
	private Date dtnasc;
	
	
	
	public Vendedores(String cdvend, String dsnome, int cdtab, Date dtnasc) {
		this.cdvend = cdvend;
		this.dsnome = dsnome;
		this.cdtab = cdtab;
		this.dtnasc = dtnasc;
	}
	
	
	public String getCdvend() {
		return cdvend;
	}
	public void setCdvend(String cdvend) {
		this.cdvend = cdvend;
	}
	public String getDsnome() {
		return dsnome;
	}
	public void setDsnome(String dsnome) {
		this.dsnome = dsnome;
	}
	public int getCdtab() {
		return cdtab;
	}
	public void setCdtab(int cdtab) {
		this.cdtab = cdtab;
	}
	public Date getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}
	
	
}
