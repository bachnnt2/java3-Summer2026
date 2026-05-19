package dao;

import entity.BeerOrder;
import jdbc.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BeerOrderImpl implements BeerOrderDAO {
    private static final String GET_ALL_QUERY = "SELECT * FROM BeerOrder";
    @Override
    public ArrayList<BeerOrder> getAll() {
        try {
            Connection ketnoi = JDBC.getConnection();
            PreparedStatement ps = ketnoi.prepareStatement(GET_ALL_QUERY);
            ResultSet ketqua = ps.executeQuery();
            // hôm sau viết tiếp để lấy dữ liệu từ DB -> xuất tới jsp (luồng 5 điểm)
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
