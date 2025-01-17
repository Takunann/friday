package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Pokemart;

public class PokemartDAO extends DAO {

	//検索を行うserchメソッド。検索キーワードを指定すると、キーワードを商品名に含む商品の一覧を返します。
	public List<Pokemart> search(String keyword) throws Exception {
		List<Pokemart> list=new ArrayList<>();

		Connection con=getConnection();

		//ResultSetオブジェクトの内容をリストのインターフェースに返すため、その詰め替え用のリストを宣言
		PreparedStatement st=con.prepareStatement(
			"select * from pokemart where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();

		//検索結果であるResultSetオブジェクトから1行づつ取り出し、新たに生成したPokemartオブジェクトに対して
		while (rs.next()) {
			Pokemart p=new Pokemart();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}

		//データベースからの切断
		st.close();
		con.close();

		//while～の処理が終わると、ResultSetに含まれる行と同じ数の要素が出来上がるのでそのリストを返します。
		return list;
	}

	//追加を行うinsertメソッド　引数に商品情報のBeanを指定すると、Beanに保存された情報を取得し、データベースに一行追加する。
	public int insert(Pokemart Pokemart) throws Exception { //例外についてはメソッドの呼び出し元で処理するため、throws Exceptionと記述
		Connection con=getConnection();

		//データの追加を行うためのinsert文。
		PreparedStatement st=con.prepareStatement(
			"insert into product(name, price) values(?, ?)");
		//プレースホルダを置き換えている。引数として受け取ったProductオブジェクトから、ゲッタを使ってname列とprice列の値を取り出して、setStringメソッドとsetIntメソッドの台に引数に指定しています。	
		st.setString(1, Pokemart.getName());
		st.setInt(2, Pokemart.getPrice());
		//作成したSQL文は、executeUpdateメソッドを使って実行します。
		int line=st.executeUpdate();

		st.close();
		con.close();
		//executeUpdateメソッドは変更した行数を返すので、これinsertメソッドの戻り値にします。
		return line;
	}
}
