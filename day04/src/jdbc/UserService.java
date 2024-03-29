package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jdbc2.DBUtil;

/***
 * 用户管理系统 功能： 注册用户 用户登录 修改用户信息(登陆后) 查看用户余额(登录后) 显示所有用户信息(登陆后、除密码以外) 转账功能 注销
 * userinfo
 * 
 * @author admin
 *
 */
public class UserService {
//	private UserInfo user = null;// 全局静态，保存登录的用户信息
	private Connection conn = null;
	private Statement state;
	private Scanner sc;
	
	private UserInfo userInfo;
	
	private UserInfoDao userInfoDao;
	
	public UserService(){
		/**
		 * 将来不会直接new这个DAO的实现类
		 * 而是靠工厂反射一个实例回来
		 * 若使用spring框架，DAO的初始化也是靠spring注入实例实现的
		 * 这些都是可以达到业务层与DAO层解耦的目的
		 * 
		 */
		userInfoDao = new UserInfoDaoImpl();
	}
		
	// 输出菜单
	public static void printMenu() {
		System.out.println("---------------------------");
		System.out.println("欢迎使用用户管理系统");
		System.out.println("功能列表：");
		System.out.println("1.注册用户");
		System.out.println("2.用户登录");
		System.out.println("3.修改用户信息");
		System.out.println("4.查看用户余额");
		System.out.println("5.显示所有用户信息");
		System.out.println("6.转账");
		System.out.println("7.注销");
		System.out.println("8.删除用户");
		System.out.println("9.分页显示用户列表");
		System.out.println("---------------------------");
	}

	// 退出
	public  void logout() {
		userInfo = null;
		System.out.println("退出成功！");
	}

	// 登录功能
	public  void login() throws Exception {
		sc = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = sc.nextLine();
		UserInfo user = userInfoDao.findByName(username);
		while (user == null) {
			System.out.println("不存在此用户！请重新输入");
			username = sc.nextLine();
			user = userInfoDao.findByName(username);
		}
		System.out.println("请输入密码：");
		String password = sc.nextLine();
//		user = getUserByName(username);
		
		if (!password.equals(user.getPassword())) {
			System.out.println("用户密码错误！");
		} else {
			System.out.print("登录成功!    ");
			userInfo = user;
			System.out.println("用户为" + userInfo.getNickname());
		}
	}

	// 根据用户名查询用户
	private  UserInfo getUserByName(String username) throws Exception {
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		// conn =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		// "system", "Or175824");
		conn = DBUtil.getConnection();
		System.out.println("链接数据库成功");
		state = conn.createStatement();
		UserInfo u = new UserInfo();
		try {
			String sql = "SELECT * FROM userinfo WHERE username = '" + username + "'";
			// System.out.println(sql);
			ResultSet rs = state.executeQuery(sql);
			if (rs.next()) {
				int id = rs.getInt("id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				double account = rs.getDouble("account");
				u.setId(id);
				u.setPassword(password);
				u.setUsername(username);
				u.setPassword(password);
				u.setEmail(email);
				u.setNickname(nickname);
				u.setAccount(account);
			} else {
				u = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		return u;
	}

//	/*public  void updateAccount(String uname, double d) throws Exception {
//		UserInfo temp = getUserByName(uname);
//		try {
////			/**
////			 * JDBC默认是自动提交事务的，即： 每当执行一条dml操作后，就自动执行commit，
////			 * 若希望控制事务，需要取消自动提交事务控制，然后再控制事务 事务控制是由Connection管理的。
////			 */
//			conn = DBUtil.getConnection();
//			//取消自動提交事務
//			conn.setAutoCommit(false);
//			if (d <= user.getAccount()) {
//				double acc = user.getAccount() - d;
//				user.setAccount(acc);
//				String sql = "UPDATE userinfo SET " + "account = ? " + "WHERE id = ?";
//				PreparedStatement ps = conn.prepareStatement(sql);
//				ps.setDouble(1, acc);
//				ps.setInt(2, user.getId());
//				int i = ps.executeUpdate();
//				if (i > 0) {
//
//					if (temp != null) {
//						ps.setDouble(1, temp.getAccount() + d);
//						ps.setInt(2, temp.getId());
//						i = ps.executeUpdate();
//						if (i > 0) {
//							System.out.println("转账成功");
//							conn.commit();
//						} else {
//							System.err.println("转账失败");
//							conn.rollback();
//						}
//					} else {
//						System.err.println("不存在此用户");
//					}
//
//				} else {
//					System.err.println("转账失败");
//					conn.rollback();
//				}
//			} else {
//				System.err.println("输入的金额必须小于持有的金额。");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				DBUtil.closeConnection(conn);
//			}
//		}
//
//	}
//*/
	// 转账
	private  void transfroAccont() throws Exception {
		/**
		 * 转账业务： 首先必须是登录用户 要求用户输入转账账号的用户名 然后输入转出金额，该金额必须小于等于当前余额
		 * 然后执行sql，将当前用户余额与转入账户的余额进行相应的修改 最终通知当前用户转账操作是否成功。
		 * 
		 * 修改所有的连接方式为DBUtil,返回连接均嵌入finally中
		 * 
		 * 
		 * 
		 *
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入转账用户名：");
		String tname = sc.nextLine();
//		if (getUserByName(tname) == null) {
		UserInfo toUser = userInfoDao.findByName(tname);
		while (toUser == null) {
			System.out.println("用户不存在，请重新输入：");
			toUser = userInfoDao.findByName(tname);
			tname = sc.nextLine();
		}
		System.out.println("您当前余额为" + userInfo.getAccount());
		System.out.println("请输入转账金额");
		double taccount = sc.nextDouble();
		while (taccount > userInfo.getAccount() || taccount < 0) {
			System.out.println("请输入0~" + userInfo.getAccount() + "的值：");
			taccount = sc.nextDouble();
		}
//		updateAccount(tname, taccount);
		userInfo.setAccount(userInfo.getAccount() - taccount);
		toUser.setAccount(toUser.getAccount() + taccount);
		boolean t = userInfoDao.updateForTransfor(userInfo, toUser);
		if(t){
			System.out.println("转账成功");
			System.out.println("当前账户余额为:"+userInfo.getAccount());
		}else {
			System.out.println("转账失败");
		}
	}

	// 注册功能
	public  void insertUser() throws Exception {
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		// conn =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		// "system", "Or175824");
//		conn = DBUtil.getConnection();
//		System.out.println("链接数据库成功");
//		state = conn.createStatement();
		sc = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String username = sc.nextLine();
//		UserInfo tempUser = getUserByName(username);
		UserInfo tempUser = userInfoDao.findByName(username);
		while (tempUser == null) {
			System.out.println("该用户名已经存在，请重新输入：");
			username = sc.nextLine();
			tempUser = userInfoDao.findByName(username);
		}
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		System.out.println("请输入邮箱：");
		String email = sc.nextLine();
		System.out.println("请输入昵称：");
		String nickname = sc.nextLine();
		System.out.println("请输入工资：");
		double account = sc.nextDouble();
		
		//DAO 保存用户
		UserInfo userInfo = new UserInfo(-1,username,password,email,nickname,account);
		boolean tf = userInfoDao.save(userInfo);
		if(tf){
			System.out.println("注册成功！");
			System.out.println("id:"+userInfo.getId());
			this.userInfo = userInfo;
		}else {
			System.err.println("注册失败!");
		}
		/*String sql = "INSERT INTO userinfo " + "(id,username,password,email,nickname,account) " + "VALUES "
				+ "(seq_userinfo_id.NEXTVAL," + "'" + username + "','" + password + "','" + email + "','" + nickname
				+ "'," + account + ")";
		System.out.println(sql);

		int i = 0;
		try {
			i = state.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		if (i > 0) {
			System.out.println("注册成功");
		}*/

	}

	// 显示登录账户的工资
	public  void checkAccount() {
		System.out.println(userInfo.getUsername() + "的工资为：" + userInfo.getAccount());
	}

	// 显示所有用户
	public  void listUser() throws Exception {
		// Class.forName("oracle.jdbc.driver.OracleDriver");
		// conn =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		// "system", "Or175824");
	/*	conn = DBUtil.getConnection();
		System.out.println("链接数据库成功");
		state = conn.createStatement();
		String sql = "SELECT * FROM userinfo";
		List<UserInfo> userlist = new ArrayList<UserInfo>();
		try {
			ResultSet rs = state.executeQuery(sql);
			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setAccount(rs.getDouble("account"));
				userlist.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}*/
		List<UserInfo> userlist = userInfoDao.findAll();
		printUser(userlist);
	}

	// 打印用户
	public  void printUser(List<UserInfo> userlist) {
		for (UserInfo user : userlist) {
			System.out.println(user.getId() + "," + user.getUsername() + "," + user.getEmail() + ","
					+ user.getNickname() + "," + user.getAccount());
		}
	}

	// 修改用户相关信息
	public  void updateUser() throws Exception {
		// conn =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		// "system", "Or175824");
//		conn = DBUtil.getConnection();
//		// System.out.println("链接数据库成功");
//		state = conn.createStatement();
		sc = new Scanner(System.in);
		System.out.println("原用户信息为:");
		System.out.println(
				"用户id：" + userInfo.getId() + "\n" + "用户名：" + userInfo.getUsername() + "\n" + "密码" + userInfo.getPassword() + "\n"
						+ "邮箱" + userInfo.getEmail() + "\n" + "昵称" + userInfo.getNickname() + "\n" + "工资" + userInfo.getAccount());
		System.out.println("请输入用户名:");
		String username = sc.nextLine();
//		UserInfo tempUser = getUserByName(username);
		UserInfo tempUser = userInfoDao.findByName(username);
		if (tempUser != null) {
			System.out.println("该用户名已经存在，请重新输入：");
			username = sc.nextLine();
		}
		System.out.println("请输入密码：");
		String password = sc.nextLine();
		System.out.println("请输入邮箱：");
		String email = sc.nextLine();
		System.out.println("请输入昵称：");
		String nickname = sc.nextLine();
		System.out.println("请输入工资：");
		double account = sc.nextDouble();
		
		
		// DAO 更新
		UserInfo user = new UserInfo(userInfo.getId(),username,password,email,nickname,account);
		boolean tf = userInfoDao.update(user);
		if(tf){
			System.out.println("更新成功！");
			System.out.println("id:"+userInfo.getId());
			this.userInfo = user;
		}else {
			System.err.println("更新失败!");
		}
		/*String sql = "UPDATE userinfo SET" + " username='" + username + "', password='" + password + "', email='"
				+ email + "', nickname='" + nickname + "', account=" + account + " WHERE id=" + user.getId();
		System.out.println(sql);
		int i = 0;
		try {
			i = state.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn);
		}
		if (i > 0) {
			System.out.println("修改成功");
		}*/
	}
	public void run() throws Exception{
		sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			printMenu();
			System.out.println("请选择功能：");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				insertUser();// 注册功能
				break;
			case 2:
				login();// 登录
				break;
			case 3:
				if (userInfo == null) {
					System.out.println("请登录再进行修改");
				} else {
					updateUser();// 修改用户信息
				}
				break;
			case 4:
				if (userInfo == null) {
					System.out.println("请登录再进行余额查询");
				} else {
					checkAccount();// 显示账户工资
				}
				break;
			case 5:
				if (userInfo == null) {
					System.out.println("请登录再进行查看");
				} else {
					listUser();// 显示所有用户
				}
				break;
			case 6:
				if (userInfo == null) {
					System.out.println("请登录再进行转账");
				} else {
					transfroAccont();
				}
				break;
			case 7:
				logout();// 注销
				break;
			case 8:
				if (userInfo == null) {
					System.out.println("请登录再执行删除操作");
				} else {
					deleteUser();// 删除用户
				}
				break;
			case 9:
				if (userInfo == null) {
					System.out.println("请登录再执行删除操作");
				} else {
					showUserByPage();// 分页显示用户列表
				}
				break;
			case 0:// 退出
				flag = false;
				System.out.println("谢谢使用，再见！");
				break;
			default:
				System.out.println("请输入正确的序号：");
			}
		}
	}
	public void showUserByPage() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入条数：");
		int pageSize = Integer.parseInt(scan.nextLine());
		System.out.println("请输入页数：");
		int page = Integer.parseInt(scan.nextLine());
		
		List<UserInfo> uList = userInfoDao.findAllByPage(pageSize, page);
		printUser(uList);
	}

	public void deleteUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要删除的用户名:");
		String username = scan.nextLine();
		UserInfo tuser = userInfoDao.findByName(username);
		while(tuser == null){
			System.out.println("用户不存在，请重新输入");
			username = sc.nextLine();
			tuser = userInfoDao.findByName(username);
		}
		boolean t = userInfoDao.deleteById(tuser.getId());
		if(t){
			System.out.println("删除成功");
		}else {
			System.err.println("删除失败");
		}
		
	}

	public  static void main(String[] args) {
		UserService us = new UserService();
		try {
			us.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
