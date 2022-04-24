package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        // connection to the data base to get the tempreture

        System.out.println("Version base de donnees");
        double temp=Math.random()*40;
        return temp;
    }
}
