package tool;

//例外エラー処理のインポート
import java.io.IOException;
//Javaでオブジェクトの書式付き表現をテキスト出力ストリームに出力するクラス
import java.io.PrintWriter;

//サーブレットの例外を構築
import jakarta.servlet.ServletException;
//Java で書かれたサーブレットを作成するために必要な import 文
import jakarta.servlet.annotation.WebServlet;
//Java のパッケージ「jakarta.servlet.http」をインポートするためのコード
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//URLパターンの指定 布団とコントローラのサーブレットを、末尾がp_actionで終わるURLに対応づけ
@WebServlet(urlPatterns={"*.p_action"})
//HttpServletクラスの継承
public class P_FrontController extends HttpServlet {
	//POSTリクエストを処理するdoPostメソッド
	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			//パスの取得　HttpServletRequestインターフェースのgetServletPathメソッドを使って、フロントコントローラが呼び出されたパスを取得します。
			String path=request.getServletPath().substring(1);
			//パスの加工　.aをAに、/を.に
			String name=path.replace(".a", "A").replace('/', '.');
			//アクションの生成。アクションのクラス名を使って、インスタンスを作成。
			P_Action p_action=(P_Action)Class.forName(name).//forNameメソッド。指定した名前のクラスまたはインターフェースに関連付けられたClassオブジェクトを返します。
				//getDeclaredConstructorメソッド。Classオブジェクトが表すクラスの、コンストラクタ（Constructor）を返します。
				getDeclaredConstructor().newInstance();//newInstanceメソッド　Construntorオブジェクトが表すコンストラクタを使って、新しいインスタンスを生成します。
			//アクションの実行
			String url=p_action.execute(request, response);
			//フォワードの実行　↑で取得したフォワード先のURLを、RequestDispatcherインターフェースのforwardメソッドに渡すことで指定先にフォワードする
			request.getRequestDispatcher(url).
				forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

	//Getリクエストを処理するdoGestメソッド
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		doPost(request, response);
	}
}
