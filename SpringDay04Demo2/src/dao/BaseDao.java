package dao;

import db.DataSource;

public class BaseDao {
	protected DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void testDB(){
		dataSource.getConn();
	}
}
