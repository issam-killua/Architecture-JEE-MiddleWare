package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")
public class MetierImpl implements IMetier{
    //couplage faible

    /*@Autowired
    @Qualifier("dao2")*/
    private IDao dao;

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double tmp=dao.getData();
        double res = tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }
    /*Inject in the variable dao an object of class
     that implements the interface IDao
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
