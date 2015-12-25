package generated.parking;

/**
 * @author yo
 */
public class BadgeEmploye extends Badge {
	private String _nom;
	private int _personelNumber;
	private int _departtementNumber;

    public int getPersonelNumber() {
        return _personelNumber;
    }

    public void setPersonelNumber(int _personelNumber) {
        this._personelNumber = _personelNumber;
    }

	public BadgeEmploye(String aNom, int aPersonelNumber, int aDeparttementNumber) {
            _nom=aNom;
            _personelNumber=aPersonelNumber;
            _departtementNumber=aDeparttementNumber;
        }
}