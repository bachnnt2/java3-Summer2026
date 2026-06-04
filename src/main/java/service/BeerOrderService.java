package service;

import dao.BeerOrderDAO;
import dao.BeerOrderImpl;
import entity.BeerOrder;

import java.util.ArrayList;

public class BeerOrderService {
    private BeerOrderDAO dao = new BeerOrderImpl();

    public ArrayList<BeerOrder> getAll() {
        ArrayList<BeerOrder> lstBeerOrder = new ArrayList<BeerOrder>();
        lstBeerOrder = dao.getAll();
        return lstBeerOrder;
    }

    public void createBeerOrder(BeerOrder beerOrder) {
        dao.createBeerOrder(beerOrder);
    }
}
