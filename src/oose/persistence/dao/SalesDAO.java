package oose.persistence.dao;

import oose.persistence.dto.SalesDTO;

import java.sql.*;
import java.util.ArrayList;

public class SalesDAO {
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    private final Connection conn;

    private static SalesDAO dao;

    private SalesDAO(Connection conn) {
        this.conn = conn;
    }

    public static SalesDAO getInstance(Connection conn) {
        dao = new SalesDAO(conn);
        return dao;
    }

    // 기간 내에 해당하는 결제날짜로 전체 조회
    public ArrayList<SalesDTO> selectByPeriod(Date startDate, Date endDate) {
        ArrayList<SalesDTO> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM SalesManage WHERE payment_date BETWEEN ? AND ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setDate(1, startDate);
            pstmt.setDate(2, endDate);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                SalesDTO salesDTO = new SalesDTO();
                salesDTO.setPaymentId(rs.getInt("payment_id"));
                salesDTO.setPaymentPrice(rs.getString("payment_price"));
                salesDTO.setPaymentContent(rs.getString("payment_content"));
                salesDTO.setPaymentMethod(rs.getString("payment_method"));
                salesDTO.setPaymentTime(rs.getString("payment_time"));
                salesDTO.setPaymentDate(rs.getDate("payment_date"));
                list.add(salesDTO);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 강습별 매출조회
    // 사용자에게 강좌 id 입력받아 조회
    public ArrayList<SalesDTO> selectByLecture(int classCode){
        ArrayList<SalesDTO> list = new ArrayList<>();

        try {
            String sql = "SELECT * FROM SalesManage WHERE class_code=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, classCode);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                SalesDTO salesDTO = new SalesDTO();
                salesDTO.setClassCode(rs.getInt("class_code"));
                salesDTO.setPaymentId(rs.getInt("payment_id"));
                salesDTO.setPaymentPrice(rs.getString("payment_price"));
                salesDTO.setPaymentContent(rs.getString("payment_content"));
                salesDTO.setPaymentMethod(rs.getString("payment_method"));
                salesDTO.setPaymentTime(rs.getString("payment_time"));
                salesDTO.setPaymentDate(rs.getDate("payment_date"));
                list.add(salesDTO);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
