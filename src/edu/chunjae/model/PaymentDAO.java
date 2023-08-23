package edu.chunjae.model;

import edu.chunjae.dto.Payment;
import edu.chunjae.dto.Serve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaymentDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    String sql = "";

    //결제 처리(PaymentDAO.addPayment(pay))
    public int addPayment(Payment pay){
        int cnt = 0;

        return cnt;
    }

    //출고 처리(PaymentDAO.addServe(serv))
    public int addServe(Serve serv){
        int cnt = 0;

        return cnt;
    }

    public int getSno(){
        int sno = 0;

        return sno;
    }
}
