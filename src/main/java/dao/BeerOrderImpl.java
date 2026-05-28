package dao;

import entity.BeerOrder;
import jdbc.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BeerOrderImpl implements BeerOrderDAO {
    private static final String GET_ALL_QUERY = "SELECT * FROM BeerOrder";
    private static final String INSERT_BEER_ORDER_QUERY =
            "INSERT INTO BeerOrder(customerName, beerName, quantity) VALUES (?,?,?)";

    @Override
    public ArrayList<BeerOrder> getAll() {
        try {
            ArrayList<BeerOrder> lstBeerOrder = new ArrayList<>();
            Connection ketnoi = JDBC.getConnection();
            PreparedStatement ps = ketnoi.prepareStatement(GET_ALL_QUERY);
            ResultSet ketqua = ps.executeQuery();
            // hôm sau viết tiếp để lấy dữ liệu từ DB -> xuất tới jsp (luồng 5 điểm)
            // Mẹo để ko bị lỗi gọi sai tên ở DB, thì vào db copy phần tạo bảng ra đây
            // sau đó tương ứng từng dòng tên cột, viết code gọi tương ứng, copy paste cho
            // đỡ nhầm
            // NHỚ: Đừng có copy tên cột ở bên Entity.
            while (ketqua.next()) {
                int orderId = ketqua.getInt("orderId"); //orderId INT IDENTITY(1,1) PRIMARY KEY,
                int customerId = ketqua.getInt("customerId"); //customerId INT,
                String customerName = ketqua.getString("customerName"); //customerName NVARCHAR (100),
                String beerName = ketqua.getString("beerName"); //beerName NVARCHAR(100),
                int quantity = ketqua.getInt("quantity"); //quantity INT
                // tạo mới đối tượng BeerOrder
                // Mẹo: copy trong ngoặc của Constructor từ bên entity sang cho đỡ nhầm thứ tự
                BeerOrder doituong =
                        new BeerOrder(quantity, beerName, customerName, customerId, orderId);
                lstBeerOrder.add(doituong);
            }
            return lstBeerOrder;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createBeerOrder(BeerOrder beerOrder) {
        try {
            Connection ketnoi = JDBC.getConnection();
            PreparedStatement ps = ketnoi.prepareStatement(INSERT_BEER_ORDER_QUERY);
            // nôm na là cái hàm này, nhận beerOrder từ JSP, sau đó insert vào database
            // chú ý thứ tự tên các biến ở câu query, ví dụ ở đây thầy đang để thứ tự là
            // BeerOrder(customerName, beerName, quantity) tức là customerName là số 1,
            // beerName là số 2, quantity là cuối cùng, số 3
            ps.setString(1, beerOrder.getCustomerName());
            ps.setString(2, beerOrder.getBeerName());
            ps.setInt(3, beerOrder.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
