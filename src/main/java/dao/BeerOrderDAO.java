package dao;

import entity.BeerOrder;

import java.util.ArrayList;

public interface BeerOrderDAO {
    // hàm để query tất cả dữ liệu
    ArrayList<BeerOrder> getAll();

    // các hàm khác viết ở đây
    // hàm thêm mới
    void createBeerOrder(BeerOrder beerOrder);

    // hàm xem chi tiết theo orderId
    BeerOrder selectByOrderId(int orderId);

    // hàm xoá
    void delebeById(int orderId);

    // hàm sửa
    void updateById(int orderId, BeerOrder beerOrderUpdate);
}
