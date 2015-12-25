package generated.parking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yo
 */
public class Badgeuse {
	private static List<Badge> _listBadge;
        private static Badgeuse badgeuse;

	private Badgeuse() {
	    _listBadge = new LinkedList<>();
            initList();
        }
        
        public static Badgeuse getInstance(){
            if(badgeuse==null) badgeuse = new Badgeuse();
            return badgeuse;
        }

	public boolean checkBadge(Badge aBadge) {
            if(aBadge instanceof BadgeEmploye){
                BadgeEmploye b = (BadgeEmploye) aBadge;
                return b.getPersonelNumber()<50;
            }else{
                BadgeVisiteur b = (BadgeVisiteur) aBadge;
                return b.getVisitorNumber()<50;
            }
	    //return _listBadge.contains(aBadge);
	}

    private void initList() {
        for(int i = 0; i<50; i++)
        {
            
            //this._listBadge.
        }
    }
}