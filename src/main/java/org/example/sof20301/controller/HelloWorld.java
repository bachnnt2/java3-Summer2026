package org.example.sof20301.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdbc.JDBC;

import java.io.IOException;

@WebServlet({"/view"}) // bắt mọi đường dẫn có /view, sau này khi đi thi, đề bài sẽ yêu cầu anh em
// bắt thêm các đường dẫn như là /delete, /update,.. thì anh em viết thêm vào đây
public class HelloWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("bien1", "Nguyễn Ngọc Trần Bách"); // dòng này có nghĩa là request
        req.setAttribute("age", 10);
        req.setAttribute("ketnoi", JDBC.getConnection());
        // mang trong mình 1 biến có tên là bien1, giá trị là abcxyz, và đích đến là index.jsp
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
