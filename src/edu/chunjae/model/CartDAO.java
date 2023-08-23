package edu.chunjae.model;

import edu.chunjae.dto.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;
    String sql = "";

    public int addCart(Cart cart){
        int cnt = 0;
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.CART_INSERT);
            pstmt.setString(1, cart.getCid());
            pstmt.setInt(2, cart.getPno());
            pstmt.setInt(3, 1);
            cnt = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(pstmt, conn);
        }
        return cnt;
    }

    public List<Cart> getByIdCartList(String cid){
        List<Cart> cartList = new ArrayList<>();
        DBConnect con = new PostgreCon();
        conn = con.connect();
        try {
            pstmt = conn.prepareStatement(DBConnect.CART_SELECT_CID);
            pstmt.setString(1, cid);
            rs = pstmt.executeQuery();
            while(rs.next()){
                Cart cart = new Cart();
                cart.setCartno(rs.getInt("cartno"));
                cart.setCid(rs.getString("cid"));
                cart.setPno(rs.getInt("pno"));
                cart.setAmount(rs.getInt("amount"));
                cartList.add(cart);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cartList;
    }
}
