package lamdas;

public class Libro {
	
	private String nombreString="";
	private int pagina=0;
	
	public Libro(String nombreString, int pagina) {
		super();
		this.nombreString = nombreString;
		this.pagina = pagina;
	}

	public String getNombreString() {
		return nombreString;
	}

	public void setNombreString(String nombreString) {
		this.nombreString = nombreString;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
	
	
	

}
