package edu.chunjae.controller.cart;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AddCart.do")
public class AddCartCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pno = Integer.parseInt(request.getParameter("pno"));
        HttpSession session = request.getSession();
        String cid = (String) session.getAttribute("sid");


    }
}
