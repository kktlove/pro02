package edu.chunjae.controller.payment;

import edu.chunjae.dto.Delivery;
import edu.chunjae.dto.Payment;
import edu.chunjae.dto.Serve;
import edu.chunjae.model.PaymentDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/AddPaymentPro.do")
public class AddPaymentProCtrl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //결제 처리(PaymentDAO.addPayment(pay))
        Payment pay = new Payment();
        pay.setCid(request.getParameter("cid"));
        pay.setPno(Integer.parseInt(request.getParameter("pno")));
        pay.setAmount(Integer.parseInt(request.getParameter("amount")));
        pay.setPmethod(request.getParameter("pmethod"));
        pay.setPcom(request.getParameter("pcom2"));
        pay.setCnum(request.getParameter("cnum"));
        pay.setPayprice(Integer.parseInt(request.getParameter("payAmount")));

        PaymentDAO payDAO = new PaymentDAO();
        int cnt1 = payDAO.addPayment(pay);

        //출고 처리(PaymentDAO.addServe(serv))
        Serve serv = new Serve();
        serv.setPno(Integer.parseInt(request.getParameter("pno")));
        serv.setAmount(Integer.parseInt(request.getParameter("amount")));
        serv.setSprice(Integer.parseInt(request.getParameter("sprice")));

        int cnt2 = payDAO.addServe(serv);

        //배송 등록(DeliveryDAO.addDelivery(del))
        Delivery del = new Delivery();
        del.setSno(payDAO.getSno());
        del.setCid(request.getParameter("cid"));
        del.setDaddr(request.getParameter("address1")+"<br>"+request.getParameter("address2")+"<br>"+request.getParameter("postcode"));
        del.setCustel(request.getParameter("custel"));

        //쇼핑카트에서 결제한 정보라면 (CartDAO.delCart(cartno));

    }
}
