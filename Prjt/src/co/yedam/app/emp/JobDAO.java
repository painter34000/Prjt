package co.yedam.app.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import co.yedam.app.common.ConnectionManager;

public class JobDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤  : static 필드
	static JobDAO instance;	
	public static JobDAO getInstance() {
		if (instance == null)
			instance = new JobDAO();
		return instance;
	}
	
	//전체조회
	public List<JobVO> selectAll() {
		List<JobVO> datas = new ArrayList<JobVO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from hr.jobs order by job_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JobVO jobVO = new JobVO();
				jobVO.setJob_id(rs.getString("job_id"));
				jobVO.setJob_title(rs.getString("job_title"));
				datas.add(jobVO);   //dto를 리스트에 추가
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		return datas;
	}	
}
