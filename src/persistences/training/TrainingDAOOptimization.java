package persistences.training;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dto.training.TrainingDTO;

import util.CommUtil;
import util.DBUtil;
//登陆要用到t_base_Scores_info 里的 Scores_name password 属性

public class TrainingDAOOptimization {
	private DBUtil dbUtil;
	private Connection conn;

	public TrainingDAOOptimization() {
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
	public List<TrainingDTO> getSomeTraining(TrainingDTO training) {
		QueryRunner qr = new QueryRunner();
		List<TrainingDTO> allTraining = null;

		String sql = "select train_plan_id,train_plan_name,train_plan_type,train_plan_year,is_finish from train_plan_info where train_plan_type = ? and train_plan_year = ? and is_finish = ?";
		try {
			allTraining = qr.query(conn, sql,new BeanListHandler<TrainingDTO>(
					TrainingDTO.class), training.getTrain_plan_type(),training.getTrain_plan_year(),training.getIs_finish());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allTraining;
	}
	public List<TrainingDTO> getAllTraining() {
		QueryRunner qr = new QueryRunner();
		List<TrainingDTO> allTraining = null;

		String sql = "select train_plan_id,train_plan_name,train_plan_type,train_plan_year,is_finish from train_plan_info";
		try {
			allTraining = qr.query(conn, sql,new BeanListHandler<TrainingDTO>(
					TrainingDTO.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allTraining;
	}
	public boolean saveTraining(TrainingDTO training) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

		String sql = "insert into train_plan_info (train_plan_id,train_plan_name,train_plan_type,train_plan_year,is_finish) values(?,?,?,?,?)";
		String train_plan_id = CommUtil.getId();
		try {
			insertRows = qr.update(conn, sql,train_plan_id,training.getTrain_plan_name(),training.getTrain_plan_type(),training.getTrain_plan_year(),training.getIs_finish());

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
	public boolean delTraining(String ScoresId) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

//		System.out.println("bit是："+bir);
		String sql = "delete from train_plan_info where train_plan_id = ?";

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

    public static void main(String[] args){
    	TrainingDTO ScoresDTO= new TrainingDTO();
    	System.out.println();
    }
}
