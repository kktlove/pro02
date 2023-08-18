package edu.chunjae.model;

import edu.chunjae.dto.Custom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomDAO {
    static Connection conn = null;
    static PreparedStatement pstmt = null;
    static ResultSet rs = null;

    public List<Custom> getCustomList(){
        List<Custom> cusList = new ArrayList<>();

        return cusList;
    }

    public Custom getCustom(String id){
        Custom cus = new Custom();
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CUSTOM_SELECT_ONE);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                cus.setId(rs.getString("id"));
                cus.setPw(rs.getString("pw"));
                cus.setName(rs.getString("name"));
                cus.setPoint(rs.getInt("point"));
                cus.setGrade(rs.getString("grade"));
                cus.setTel(rs.getString("tel"));
                cus.setEmail(rs.getString("email"));
                cus.setBirth(rs.getString("birth"));
                cus.setRegdate(rs.getString("regdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return cus;
    }

    public boolean login(String id, String pw){
        boolean pass = false;
        DBConnect con = new PostgreCon();
        try {
            conn = con.connect();
            pstmt = conn.prepareStatement(DBConnect.CUSTOM_SELECT_LOG);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            if(rs.next()){
                pass = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close(rs, pstmt, conn);
        }
        return pass;
    }


}
