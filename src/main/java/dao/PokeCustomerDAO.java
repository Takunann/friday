package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.PokeCustomer;

public class PokeCustomerDAO extends DAO {
	public PokeCustomer search(String login, String password)
		throws Exception {
		PokeCustomer PokeCustomer=null;

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
			"select * from customer where login=? and password=?");
		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			PokeCustomer=new PokeCustomer();
			PokeCustomer.setId(rs.getInt("id"));
			PokeCustomer.setLogin(rs.getString("login"));
			PokeCustomer.setPassword(rs.getString("password"));
		}

		st.close();
		con.close();
		return PokeCustomer;
	}
}
