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
	 * @param kamerNummer
	 * @param vierkanteMeters
	 * @param huurprijs
	 * @param plaats
	 * @param aantalPersonen
	 */
	public Kamer(int kamerNummer,int vierkanteMeters, double huurprijs, String plaats, int aantalPersonen) {
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
	 * @return the vierkanteMeters
	 */
	public int getVierkanteMeters() {
		return vierkanteMeters;
	}
	
	/**
	 * @return the huurprijs
	 */
	public double getHuurprijs() {
		return huurprijs;
	}
	
	/**
	 * @return the plaats
	 */
	public String getPlaats() {
		return plaats;
	}
	
	/**
	 * @return the aantalPersonen
	 */
	public int getAantalPersonen() {
		return aantalPersonen;
	}
	 
	
	
}
