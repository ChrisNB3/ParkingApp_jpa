package generated.parking;

import java.util.Date;

/**
 * @author yo
 */
public class BadgeVisiteur extends Badge {
	private Date _currentDate;
	private int _visitorNumber;

    public int getVisitorNumber() {
        return _visitorNumber;
    }

    public void setVisitorNumber(int _visitorNumber) {
        this._visitorNumber = _visitorNumber;
    }

    public BadgeVisiteur(Date _currentDate, int _visitorNumber) {
        this._currentDate = _currentDate;
        this._visitorNumber = _visitorNumber;
    }

}