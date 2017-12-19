package util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//提供数据库连接
public class DBUtil {
	private String driver;
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	Statement stmt;
	ResultSet rs;

	public  void initParam(String paramFile) throws Exception {
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		String fullFileName = DBUtil.class.getResource(paramFile).getFile();
		props.load(new FileInputStream(fullFileName));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	public   Connection getConnection(){
		
		//加载驱动
		try {
			initParam("mysql.ini");
			Class.forName(driver);
			conn = DriverManager.getConnection(url , user , pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeConn(Connection conn){
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void executeSql(String sql)throws Exception	{
		try	{
			//加载驱动
			Class.forName(driver);
			//获取数据库连接
			conn = DriverManager.getConnection(url , user , pass);
			//使用Connection来创建一个Statment对象
			stmt = conn.createStatement();
			//执行SQL,返回boolean值表示是否包含ResultSet
			boolean hasResultSet = stmt.execute(sql);
			//如果执行后有ResultSet结果集
			if (hasResultSet){
				//获取结果集
				rs = stmt.getResultSet();
				
				//ResultSetMetaData是用于分析结果集的元数据接口
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnCount = rsmd.getColumnCount();
				//迭代输出ResultSet对象
				while (rs.next()){
					//依次输出每列的值
					for (int i = 0 ; i < columnCount ; i++ ){
						System.out.print(rs.getString(i + 1) + "\t");
					}
					System.out.print("\n");
				}
			}
			else {
				System.out.println("该SQL语句影响的记录有" + stmt.getUpdateCount() + "条");
			}
		}
		//使用finally块来关闭数据库资源
		finally	{
			if (rs != null)	{
				rs.close();
			}
			if (stmt != null){
				stmt.close();
			}
			if (conn != null){
				conn.close();
			}
		}
	}

}
