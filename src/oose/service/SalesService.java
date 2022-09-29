package oose.service;

import oose.persistence.dao.ConnectionProvider;
import oose.persistence.dao.SalesDAO;
import oose.persistence.dto.SalesDTO;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

public class SalesService {
    private static SalesDAO salesDAO = null;
    private static Connection conn;

    public SalesService() {
        conn = ConnectionProvider.getConnection();
        salesDAO = SalesDAO.getInstance(conn);
    }

    // 기간별 매출조회
    public static ArrayList<SalesDTO> byPeriodService(Date startDate, Date endDate) {
        return salesDAO.selectByPeriod(startDate, endDate);
    }

    // 강좌별 매출조회
    public ArrayList<SalesDTO> byLecService(int classCode) {
        return salesDAO.selectByLecture(classCode);
    }
}