package ch.lars.your.app.components;

import com.ibm.icu.math.BigDecimal;
import com.webobjects.foundation.NSMutableArray;

public class Artikel {
	
	private String bezeichnung = null;
	private BigDecimal preis = null;
	//private Double preis = null;
	
	private String srcIcon = null;
	
	
	public Artikel(String bezeichnung, BigDecimal preis) {
		super();
		this.bezeichnung = bezeichnung;
		this.preis = preis;
	}
	
	public Artikel() {
		
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public BigDecimal getPreis() {
		return this.preis;
	}

	public void setPreis(Double wert) {
		BigDecimal preis = new BigDecimal(wert);
		this.preis = preis;
	}
	
	public void setIcon(String img) {
		this.srcIcon = img;
	}
	public String getIcon() {
		return srcIcon;
	}
	
	public NSMutableArray<Inhalt> inhalte(){
		NSMutableArray<Inhalt> inhalte = null;
		return inhalte;
	}
	
	


}
