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

    public void deleteBeerOrder(String idXoa) {
        int orderIdXoa = Integer.parseInt(idXoa); // ép kiếu về kiểu int
        dao.delebeById(orderIdXoa);
    }

    public BeerOrder viewDetail(int orderId) {
        return dao.selectByOrderId(orderId);
    }

    public void updateBeerOrder(int orderId, BeerOrder beerOrderUpdate) {
        dao.updateById(orderId, beerOrderUpdate);
    }
}
