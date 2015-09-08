/**
 * 
 */
package model;

/**
 * @author chris
 *
 */
public class Kamer {
	
	private int kamerNummer;
	private int vierkanteMeters;
	private double huurprijs;
	private String plaats;
	private int aantalPersonen;
	/**
	 * @param vierkanteMeters
	 * @param huurprijs
	 * @param plaats
	 * @param aantalPersonen
	 */
	public Kamer(int kamernummer,int vierkanteMeters, double huurprijs, String plaats, int aantalPersonen) {
		super();
		this.kamerNummer = kamerNummer;
		this.vierkanteMeters = vierkanteMeters;
		this.huurprijs = huurprijs;
		this.plaats = plaats;
		this.aantalPersonen = aantalPersonen;
	}
	
	
	
	/**
	 * @return the kamerNummer
	 */
	public int getKamerNummer() {
		return kamerNummer;
	}



	/**
	 * @param kamerNummer the kamerNummer to set
	 */
	public void setKamerNummer(int kamerNummer) {
		this.kamerNummer = kamerNummer;
	}



	/**
	 * @return the vierkanteMeters
	 */
	public int getVierkanteMeters() {
		return vierkanteMeters;
	}
	/**
	 * @param vierkanteMeters the vierkanteMeters to set
	 */
	public void setVierkanteMeters(int vierkanteMeters) {
		this.vierkanteMeters = vierkanteMeters;
	}
	/**
	 * @return the huurprijs
	 */
	public double getHuurprijs() {
		return huurprijs;
	}
	/**
	 * @param huurprijs the huurprijs to set
	 */
	public void setHuurprijs(double huurprijs) {
		this.huurprijs = huurprijs;
	}
	/**
	 * @return the plaats
	 */
	public String getPlaats() {
		return plaats;
	}
	/**
	 * @param plaats the plaats to set
	 */
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}
	/**
	 * @return the aantalPersonen
	 */
	public int getAantalPersonen() {
		return aantalPersonen;
	}
	/**
	 * @param aantalPersonen the aantalPersonen to set
	 */
	public void setAantalPersonen(int aantalPersonen) {
		this.aantalPersonen = aantalPersonen;
	}
	
	
}
