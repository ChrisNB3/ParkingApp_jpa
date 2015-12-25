package generated.parking;

/**
 * @author yo
 */
public class Personne {
	private Badge _badge;

	public Personne(Badge aB) {
		_badge=aB;
        }

	public void goToParking() {
		if(Badgeuse.getInstance().checkBadge(_badge)){
                    Parking.getInstance().addVehicule();
                    BarriereEntree.getInstance().open();
                }
	}

	public void leaveParking() {
		throw new UnsupportedOperationException();
	}

	public void goToSensor() {
		throw new UnsupportedOperationException();
	}

	public void setBadge(Badge aBadge) {
		this._badge = aBadge;
	}

	public Badge getBadge() {
		return this._badge;
	}
}