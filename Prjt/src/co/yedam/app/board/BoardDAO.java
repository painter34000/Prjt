//package co.yedam.app.board;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import co.yedam.app.common.ConnectionManager;
//
//public class BoardDAO {
//
//   public void BoardInsert(BoardVO vo) {
//      Connection conn = null;
//      PreparedStatement psmt = null;
//      
//      // sql 구문 준비
//      String sql = "insert into board (seq, title, contents, regdt, id) values ((select nvl(max(seq),0)+1 from board), ?, ?, sysdate, ?)";
//      
//      // DB연결
//      conn = ConnectionManager.getConnnect();
//      try {
//         psmt = conn.prepareStatement(sql);
//         psmt.setString(1, vo.getTitle());
//         psmt.setString(2, vo.getContents());
//         psmt.setString(3, vo.getId());
//
//         psmt.executeUpdate();
//      } catch (SQLException e) {
//         e.printStackTrace();
//      } finally {
//         ConnectionManager.close(conn);
//      }
//   }
//
//public ArrayList<BoardVO> getBoardList() {
//	// TODO Auto-generated method stub
//	return null;
//}
//
//public ArrayList<BoardVO> getBoardList1() {
//
//	ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//	Connection conn = null;
//	PreparedStatement psmt = null;
//	try {
//		
//		
//		
//	
//	
//	}catch (Exception e) {
//		e.printStackTrace();
//	}finally {
//		// 연결해제
//
//	}
//	
//	return null;
//}
//}

package co.yedam.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.yedam.app.common.ConnectionManager;

public class BoardDAO {

   public int BoardInsert(BoardVO vo) {
      Connection conn = null;
      PreparedStatement psmt = null;

      String sql = "insert into board (seq, title, contents, regdt, id) values ((select nvl(max(seq),0)+1 from board), ?, ?, sysdate, ?)";

      conn = ConnectionManager.getConnnect();
      try {
         psmt = conn.prepareStatement(sql);

         psmt.setString(1, vo.getTitle());
         psmt.setString(2, vo.getContents());
         psmt.setString(3, vo.getId());

         psmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         ConnectionManager.close(conn);
      }
   }
   
   public ArrayList<BoardVO> getBoardList() {
      ArrayList<BoardVO> list = new ArrayList<BoardVO>();
      
      try {
         Connection conn = null;
         PreparedStatement psmt = null;
         conn = ConnectionManager.getConnnect();
         String sql = "select b.*, m.name from board b join member m on (b.id = m.id) order by seq desc";
         psmt = conn.prepareStatement(sql);
         ResultSet rs = psmt.executeQuery();
         while(rs.next()) {
            BoardVO vo = new BoardVO();
            vo.setContents(rs.getString("contents"));
            vo.setId(rs.getString("id"));
            vo.setRegdt(rs.getString("regdt"));
            vo.setSeq(rs.getInt("seq"));
            vo.setTitle(rs.getString("title"));
            list.add(vo);
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return list;
   }

}