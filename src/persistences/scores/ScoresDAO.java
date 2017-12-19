package persistences.scores;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dto.scores.ScoresDTO;

import util.CommUtil;
import util.DBUtil;
//登陆要用到t_base_Scores_info 里的 Scores_name password 属性

public class ScoresDAO {
	private DBUtil dbUtil;
	private Connection conn;

	public ScoresDAO() {
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
	}

//	public boolean findScores(String name, String psw) {
//		boolean result = false;
//		QueryRunner qr = new QueryRunner();
//		ScoresDTO ScoresDTO = null;
//
//		String sql = "select * from t_base_Scores_info where Scores_name=? and password=?";
//
//		try {
//			ScoresDTO = qr.query(conn, sql, new BeanHandler<ScoresDTO>(
//					ScoresDTO.class), name, psw);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		if (ScoresDTO != null) {
//			result = true;
//			System.out.println(ScoresDTO.getScores_name() + "  "
//					+ ScoresDTO.getPassword());
//		}
//
//		return result;
//	}
//
//public List<ScoresDTO> getSomeScores(String name,String sex) {
//	QueryRunner qr = new QueryRunner();
//	List<ScoresDTO> allScoress = null;
//
//	String sql = "select Scores_id,NAME,sex,card_id,birthday,ScoresInfo.unit_id,depart.unit_name,ScoresInfo.telphone,duty,TECDUTY,ScoresInfo.email from t_base_Scores_info ScoresInfo,t_base_unit_info depart where ScoresInfo.unit_id = depart.unit_id and ScoresInfo.name = ? and ScoresInfo.sex = ?";
//	Object[] params =new Object[]{name, sex};
//	try {
//		allScoress = qr.query(conn, sql, new BeanListHandler<ScoresDTO>(
//				ScoresDTO.class),params);
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally {
//		try {
//			DbUtils.close(conn);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	return allScoress;
//}
	public List<ScoresDTO> getAllScores() {
		QueryRunner qr = new QueryRunner();
		List<ScoresDTO> allScoress = null;

		String sql = "select * from train_scores ;";
		try {
			allScoress = qr.query(conn, sql, new BeanListHandler<ScoresDTO>(
					ScoresDTO.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allScoress;
	}

	public boolean saveScores(ScoresDTO Scores) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

		String sql = "insert into train_scores (id,user_name,unit_name,attendance_score,test_score,total_score) values(?,?,?,?,?,?)";
		String ScoresId = CommUtil.getId();
		String total;
		if(Double.parseDouble(Scores.getAttendance_score())>0&&Double.parseDouble(Scores.getAttendance_score())<100&&Double.parseDouble(Scores.getTest_score())>0&&Double.parseDouble(Scores.getTest_score())<100){
			BigDecimal bg = new BigDecimal( Double.parseDouble(Scores.getAttendance_score())*0.3 + Double.parseDouble(Scores.getTest_score())*0.7); 
			double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		    total = f1 +"";	
		}
		else{
			total = "0.0";
		}
		try {
			insertRows = qr.update(conn, sql, ScoresId,
					Scores.getUser_name(),Scores.getUnit_name(),Scores.getAttendance_score(),Scores.getTest_score(),total);

			System.out.println("*******" + insertRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		result = (insertRows == 1) ? true : false;
		System.out.println("*******" + result);
		return result;
	}
	public boolean delEmployee(String ScoresId) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

//		System.out.println("bit是："+bir);
		String sql = "delete from train_scores where id = ?";

		try {
			insertRows = qr.update(conn, sql,ScoresId);

			System.out.println("*******" + insertRows);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		result = (insertRows == 1) ? true : false;
		System.out.println("*******" + result);
		return result;
	}
//	public boolean updateScores(ScoresDTO Scores) {
//		boolean result = false;
//		int insertRows = 0;
//		QueryRunner qr = new QueryRunner();
//
//		String sql = "UPDATE  t_base_Scores_info SET password = ? WHERE Scores_name = ?";
//
//		try {
//			System.out.println();
//			System.out.println();
//			Object[] params = {Scores.getPassword(),Scores.getScores_name()};
//			insertRows = qr.update(conn, sql, params);
//
//			System.out.println("*******" + insertRows);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				DbUtils.close(conn);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		result = (insertRows == 1) ? true : false;
//		System.out.println("*******" + result);
//		return result;
//	}
//	public Boolean nameExisted(String ScoresName) {
//		boolean existed = false;
//		ScoresDTO ScoresDTO = null;
//
//		QueryRunner qr = new QueryRunner();
//		String sql = "select Scores_id,Scores_name,password from t_base_Scores_info where Scores_name = ?";
//		try {
//			ScoresDTO = qr.query(conn, sql, new BeanHandler<ScoresDTO>(
//					ScoresDTO.class), ScoresName);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				DbUtils.close(conn);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if (ScoresDTO != null) {
//			System.out.println("inputed name:" + ScoresName + "****");
//			System.out.println("query name:" + ScoresDTO.getScores_name() + "****");
//		}
//		existed = ScoresDTO == null ? false : true;
//		return existed;
//	}
    public static void main(String[] args){
    	ScoresDTO ScoresDTO= new ScoresDTO();
    	System.out.println();
    }
}
