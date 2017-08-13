package model;

public class Clientes {
	public String cdcl;
	public String dsnome;
	public String idtipo;
	public Vendedores vendedor;
	public String cdvend;
	public float dslim;
	

	public Clientes(String cdcl, String dsnome, String idtipo, String cdvend, float dslim) {
		this.cdcl = cdcl;
		this.dsnome = dsnome;
		this.idtipo = idtipo;
		this.cdvend = cdvend;
		this.dslim = dslim;
	}
	
	
	public String getCdcl() {
		return cdcl;
	}
	public void setCdcl(String cdcl) {
		this.cdcl = cdcl;
	}
	public String getDsnome() {
		return dsnome;
	}
	public void setDsnome(String dsnome) {
		this.dsnome = dsnome;
	}
	public String getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(String idtipo) {
		this.idtipo = idtipo;
	}
	public Vendedores getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedores vendedor) {
		this.vendedor = vendedor;
	}
	public float getDslim() {
		return dslim;
	}
	public void setDslim(float dslim) {
		this.dslim = dslim;
	}
	
	public String getCdvend() {
		return cdvend;
	}
	
	
	
}
