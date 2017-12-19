package persistences;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dto.UserDTO;
import forms.user.UpdateUserForm;
import util.CommUtil;
import util.DBUtil;
//登陆要用到t_base_user_info 里的 user_name password 属性

public class UserDAO {
	private DBUtil dbUtil;
	private Connection conn;

	public UserDAO() {
		dbUtil = new DBUtil();
		conn = dbUtil.getConnection();
	}

	public boolean findUser(String name, String psw) {
		boolean result = false;
		QueryRunner qr = new QueryRunner();
		UserDTO userDTO = null;

		String sql = "select * from t_base_user_info where user_name=? and password=?";

		try {
			userDTO = qr.query(conn, sql, new BeanHandler<UserDTO>(
					UserDTO.class), name, psw);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (userDTO != null) {
			result = true;
			System.out.println(userDTO.getUser_name() + "  "
					+ userDTO.getPassword());
		}

		return result;
	}

public List<UserDTO> getSomeUser(String name,String sex) {
	QueryRunner qr = new QueryRunner();
	List<UserDTO> allUsers = null;

	String sql = "select user_id,NAME,sex,card_id,birthday,userInfo.unit_id,depart.unit_name,userInfo.telphone,duty,TECDUTY,userInfo.email from t_base_user_info userInfo,t_base_unit_info depart where userInfo.unit_id = depart.unit_id and userInfo.name = ? and userInfo.sex = ?";
	Object[] params =new Object[]{name, sex};
	try {
		allUsers = qr.query(conn, sql, new BeanListHandler<UserDTO>(
				UserDTO.class),params);
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return allUsers;
}
	public List<UserDTO> getAllUser() {
		QueryRunner qr = new QueryRunner();
		List<UserDTO> allUsers = null;

		String sql = "select user_id,NAME,sex,card_id,birthday,userInfo.unit_id,depart.unit_name,userInfo.telphone,duty,TECDUTY,userInfo.email from t_base_user_info userInfo,t_base_unit_info depart where userInfo.unit_id = depart.unit_id;";
		try {
			allUsers = qr.query(conn, sql, new BeanListHandler<UserDTO>(
					UserDTO.class));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return allUsers;
	}

	public boolean saveUser(UserDTO user) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

		String sql = "insert into t_base_user_info (user_id,user_name,password) values(?,?,?)";
		String userId = CommUtil.getId();

		try {
			insertRows = qr.update(conn, sql, userId, user.getUser_name(),
					user.getPassword());

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
	public boolean saveEmployee(UserDTO user) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String bir = sd.format(user.getBirthday());
		String userId = CommUtil.getId();
//		System.out.println("bit是："+bir);
		String sql = "insert into t_base_user_info (user_id,name,sex,card_id,birthday,unit_id,telphone,duty,tecduty) values(?,?,?,?,?,?,?,?,?)";
		try {
			System.out.println(user.getBirthday());
			insertRows = qr.update(conn, sql,  userId,user.getName(),
					user.getSex(),user.getCard_id(),bir,user.getUnit_id(),user.getTelphone(),user.getDuty(),user.getTelduty());

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
	public boolean delEmployee(String userId) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

//		System.out.println("bit是："+bir);
		String sql = "delete from t_base_user_info where user_id = ?";

		try {
			insertRows = qr.update(conn, sql,userId);

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
	public boolean updateUser(UserDTO user) {
		boolean result = false;
		int insertRows = 0;
		QueryRunner qr = new QueryRunner();

		String sql = "UPDATE  t_base_user_info SET password = ? WHERE user_name = ?";

		try {
			System.out.println();
			System.out.println();
			Object[] params = {user.getPassword(),user.getUser_name()};
			insertRows = qr.update(conn, sql, params);

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
	public Boolean nameExisted(String userName) {
		boolean existed = false;
		UserDTO userDTO = null;

		QueryRunner qr = new QueryRunner();
		String sql = "select user_id,user_name,password from t_base_user_info where user_name = ?";
		try {
			userDTO = qr.query(conn, sql, new BeanHandler<UserDTO>(
					UserDTO.class), userName);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DbUtils.close(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (userDTO != null) {
			System.out.println("inputed name:" + userName + "****");
			System.out.println("query name:" + userDTO.getUser_name() + "****");
		}
		existed = userDTO == null ? false : true;
		return existed;
	}
    public static void main(String[] args){
    	UserDTO userdto= new UserDTO("a","passwd");
    	Boolean a = new UserDAO().updateUser(userdto);
    	System.out.println();
    }
}
