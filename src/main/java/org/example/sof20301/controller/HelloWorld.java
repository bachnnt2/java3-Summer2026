package org.example.sof20301.controller;

import dao.BeerOrderDAO;
import dao.BeerOrderImpl;
import entity.BeerOrder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.JDBC;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/view"}) // bắt mọi đường dẫn có /view, sau này khi đi thi, đề bài sẽ yêu cầu anh em
// bắt thêm các đường dẫn như là /delete, /update,.. thì anh em viết thêm vào đây
public class HelloWorld extends HttpServlet {
    private BeerOrderDAO dao = new BeerOrderImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bien1", "Nguyễn Ngọc Trần Bách"); // dòng này có nghĩa là request
        req.setAttribute("age", 10);
        req.setAttribute("ketnoi", JDBC.getConnection());
        // mang trong mình 1 biến có tên là bien1, giá trị là abcxyz, và đích đến là index.jsp


        // Từ sau dòng này, kết nối thử đến DB và xuất dữ liệu về index.jsp
        ArrayList<BeerOrder> lstBeerOrder = new ArrayList<BeerOrder>();
        lstBeerOrder = dao.getAll();
        // set cái list trên vào 1 attribute trong request
        // ở bên jsp, thì cái tên ở trong ngoặc "" ở dòng dưới,
        // được dùng trong thuộc tính items của forEach
        req.setAttribute("lstBeerOrder", lstBeerOrder);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Đã vào đến dopost");
        // lấy dữ liệu từ form bên jsp thông qua request
        String customerName = request.getParameter("customerName");
        String beerName = request.getParameter("beerName");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // tạo đối tượng beerOrder
        BeerOrder beerOrder = new BeerOrder(customerName, beerName, quantity);

        // dùng đối tượng ở trên, nhét vào trong db
        dao.createBeerOrder(beerOrder);

        // sau khi thêm xong, sử dụng redirect để quay lại form view
        // redirect khác cái dispatcher ở doget, đó là reset lại URL, và tránh lỗi
        // submit 2 lần hoặc nhiều lần
        response.sendRedirect("/view");
    }
}
