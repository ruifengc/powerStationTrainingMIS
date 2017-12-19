package persistences.depart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import util.CommUtil;
import util.DBUtil;
import dto.department.DepartDTO;


public class DepartDAO {
	private DBUtil dbUtil;
	private Connection conn;
	
	public DepartDAO(){
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
	}
	
	public int getDepartCount(){
		int departCount = 0;
		String sql = "select count(*) from t_base_unit_info";
		QueryRunner qr = new QueryRunner();
		
		
		try {
			departCount = (qr.query(conn, sql, new ScalarHandler<Long>())).intValue();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return departCount;
	}
	public boolean saveDepart(DepartDTO scores) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
		String sql = "insert into t_base_unit_info (unit_id,up_unit_id,unit_name) values(?,?,?)";
		try {
			insertRows = qr.update(conn, sql,scores.getUnit_id(),scores.getUp_unit_id(),scores.getUnit_name());

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
	public boolean delDepart(DepartDTO dto) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
//		System.out.println("bit «£∫"+bir);
		String sql = "delete from t_base_unit_info where unit_name = ?";

		try {
			insertRows = qr.update(conn, sql,dto.getUnit_name());

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
	public Object selUnitId(DepartDTO departDTO) {
		QueryRunner qr = new QueryRunner();
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
		String sql = "select unit_id from t_base_unit_info where unit_name = ?";
		Object unit_id = null;
		try {
			unit_id = qr.query(conn, sql,new ScalarHandler(),departDTO.getUnit_name());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return unit_id;
	}
	public Object selUpId(DepartDTO departDTO) {
		QueryRunner qr = new QueryRunner();
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
		String sql = "select up_unit_id from t_base_unit_info where unit_name = ?";
		String ScoresId = CommUtil.getId();
		Object unit_id = null;
		try {
			unit_id = qr.query(conn, sql,new ScalarHandler(),departDTO.getUnit_name());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return unit_id;
	}
	public List<DepartDTO> getAllDeparts(){
		List<DepartDTO> allDeparts =  new ArrayList<DepartDTO>();
		String sql = "select unit_id,up_unit_id,unit_name from t_base_unit_info order by unit_id";
		QueryRunner qr = new QueryRunner();
		
		try {
			allDeparts = qr.query(conn, sql, new BeanListHandler<DepartDTO>(DepartDTO.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return allDeparts;
	}
	
	public DepartDTO getDepartById(String id){
		DepartDTO depart = new DepartDTO();
		QueryRunner qr = new QueryRunner();
		String sql = "select unit_id,up_unit_id,unit_name from t_base_unit_info where unit_id = ?";
		
		try {
			depart = qr.query(conn, sql, new BeanHandler<DepartDTO>(DepartDTO.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return depart;
	}
	public static void main(String[] args) {
		DepartDAO d = new DepartDAO();
		DepartDTO dto = new DepartDTO();
		dto.setUnit_name("‘À ‰∂”1");
		
		String s = d.selUnitId(dto).toString();
		System.out.println(s);
	}

}
