package jdbc;

import java.util.List;

/**
 * dao是数据链接对象
 * DAO泛指一个层
 * DAO是在业务逻辑和数据库之间的层次
 * 作用是让业务逻辑对数据库的操作完全面向对象
 * 并且度数据库的具体操作透明，业务逻辑层的类只需要关注业务操作即可
 * 
 * @author admin
 *
 */
public interface  UserInfoDao {
	/**
	 * 将给定的userinfo实例表示的用户记录进行保存
	 */
	public boolean save(UserInfo userinfo);
	/**
	 * 根据用户名查询信息
	 * @param username
	 * @return
	 */
	public UserInfo findByName(String username);
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<UserInfo> findAll();
	/**
	 * 分页查看用户信息
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public List<UserInfo> findAllByPage(int pageSize, int page);
	/**
	 * 修改制定用户信息
	 * @param userinfo
	 * @return
	 */
	public boolean update(UserInfo userinfo);
	/**
	 * 转账业务需要修改的用户操作
	 * 在一个业务中完毕
	 * 成功表示修改成功，否则修改失败
	 * @param u1
	 * @param u2
	 * @return
	 */
	public boolean updateForTransfor(UserInfo u1, UserInfo u2);
	/**
	 * 根据id删除对应用户
	 * @param id
	 * @return
	 */
	public boolean deleteById(int id);
}
