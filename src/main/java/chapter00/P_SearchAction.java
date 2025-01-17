package chapter00;

import java.util.List;

import bean.Product;
import dao.ProductDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.P_Action;

public class P_SearchAction extends P_Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		
		//p_serch.jspで入力された検索キーワードを、リクエストパラメータから取得
		String keyword=request.getParameter("keyword");
		
		//検索の実行　PriductDAOクラスのserchメソッドを使用
		ProductDAO dao=new ProductDAO();
		List<Product> list=dao.search(keyword);
		
		//検索を実行した結果（商品のリスト）を、リクエスト属性に設定
		request.setAttribute("list", list);
		
		//各アクションはフォワード先のURLを返すようにするため、ここでは「p_list.jsp」を返している。
		return "p_list.jsp";
	}
}