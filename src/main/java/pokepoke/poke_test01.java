package pokepoke;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;




public class poke_test01 {
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		
//		オーキド
		System.out.println("わしはオーキドというものじゃ。");
		scan.nextLine();
		System.out.println("みんなからはポケモン博士から呼ばれておるよ。");
		scan.nextLine();
		System.out.println("まずは君の名前を教えてくれるかな？ ");
		scan.nextLine();
		System.out.println("お名前を入力してください。");
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String name = br.readLine();
	   
	    System.out.println(name.length());
	   
	  
	    if(name.length() < 1) {
	    	System.out.println("入力もまともにできんのか。かわいそうにのう。");
	    }
	   
	    else if(name.length() > 5){
	    	System.out.println("名前は五文字以内じゃ。ゲームとかするの初めてなのかのう。");
	    }
	   
	    else {
	    System.out.println("ほう、" + name + "というのか。");
	    }
	}
}
