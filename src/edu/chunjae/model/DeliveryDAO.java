package edu.chunjae.model;

import edu.chunjae.dto.Delivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeliveryDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    String sql = "";

    //배송 등록(DeliveryDAO.addDelivery(del))
    public int addDelivery(Delivery del){
        int cnt = 0;

        return cnt;
    }
}
