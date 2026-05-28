package dao;

import entity.BeerOrder;

import java.util.ArrayList;

public interface BeerOrderDAO {
    // hàm để query tất cả dữ liệu
    ArrayList<BeerOrder> getAll();

    // các hàm khác viết ở đây
    // hàm thêm mới
    void createBeerOrder(BeerOrder beerOrder);
}
