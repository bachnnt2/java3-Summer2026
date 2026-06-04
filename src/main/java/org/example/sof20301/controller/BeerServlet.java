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
import service.BeerOrderService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/view", "", "/create", "/delete", "/detail", "/update"})
// bắt mọi đường dẫn có /view, sau này khi đi thi, đề bài sẽ yêu cầu anh em
// bắt thêm các đường dẫn như là /delete, /update,.. thì anh em viết thêm vào đây
public class BeerServlet extends HttpServlet {

    private BeerOrderService beerOrderService = new BeerOrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String URI = req.getRequestURI(); // bắt đường dẫn hiện tại
        System.out.println("Đường dẫn hiện nay là " + URI);
        if (URI.contains("/view")) {
            // gọi hàm hiển thị
            init(req);
            // trả về trang index.jsp
            req.getRequestDispatcher("/index.jsp").forward(req, resp);

        } else if (URI.contains("/detail")) {
            // gọi chức năng xem chi tiết
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Đã vào đến dopost");
        // lấy dữ liệu từ form bên jsp thông qua request
        String URIPost = request.getRequestURI(); // bắt đường dẫn hiện tại
        System.out.println("Đường dẫn hiện nay là " + URIPost);
        if (URIPost.contains("/create")) {
            String customerName = request.getParameter("customerName");
            String beerName = request.getParameter("beerName");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            // tạo đối tượng beerOrder
            BeerOrder beerOrder = new BeerOrder(customerName, beerName, quantity);

            // dùng đối tượng ở trên, nhét vào trong db
            beerOrderService.createBeerOrder(beerOrder);

            // sau khi thêm xong, sử dụng redirect để quay lại form view
            // redirect khác cái dispatcher ở doget, đó là reset lại URL, và tránh lỗi
            // submit 2 lần hoặc nhiều lần
            response.sendRedirect("/view");
        } else if (URIPost.contains("/delete")) {
            // gọi chức năng xoá
        } else if (URIPost.contains("/update")) {
            // gọi chức năng sửa
        }
    }

    // hàm init: kết nối với DB và lấy hết bản ghi, vì việc này làm nhiều lần, nên
    // viết vào 1 hàm để tăng tính tái sử dụng
    public void init(HttpServletRequest request) {
        // Từ sau dòng này, kết nối thử đến DB và xuất dữ liệu về index.jsp
        // set cái list trên vào 1 attribute trong request
        // ở bên jsp, thì cái tên ở trong ngoặc "" ở dòng dưới,
        // được dùng trong thuộc tính items của forEach
        ArrayList<BeerOrder> lstBeerOrder = beerOrderService.getAll();
        request.setAttribute("lstBeerOrder", lstBeerOrder);
    }
}
