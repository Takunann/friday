package chapter00;

import java.util.List;

import bean.Pokemart;
import dao.PokemartDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.P_Action;

public class P_InsertAction extends P_Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		//リクエストパラメータの取得。商品名（name）と価格（price）を取得します。
		String name=request.getParameter("name");
		Integer price=Integer.parseInt(request.getParameter("price"));

		//追加の実行。PokemartDAOクラスのinsertメソッドを使います。
		Pokemart p=new Pokemart();
		p.setName(name);
		p.setPrice(price);
		PokemartDAO dao=new PokemartDAO();
		dao.insert(p);

		//リクエスト属性の設定。検索を実行した結果をリクエストに設定。
		List<Pokemart> list=dao.search("");
		request.setAttribute("list", list);

		//SearchActionの場合と同じく、フォワード先であるp_list.jspを返します。
		return "p_list.jsp";
	}
}
