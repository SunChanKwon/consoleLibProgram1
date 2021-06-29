package joinLogin;

import lib.LibManger;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class LoginManger {
    Scanner scan = new Scanner(System.in);
    boolean State=false;
    int count=0;
    public LoginManger()
    {  }
    String Data;
    public void LoginStart()
    {
        LoginDataSet.LoginDataSet();

        while (true) {
            System.out.println("어서오세요 [1.로그인] [2.회원가입] [3.프로그램 종료]");
            String Section = inData("선택");   //데이터를 집어넣음

            if (Section.equals("1")) {
                System.out.println("로그인");
                System.out.println("아이디를 입력해주세요");
                String ID = inData("아이디를 입력해주세요");
                System.out.println("비밀번호를 입력해주세요");
                String PW = inData("");
                AddCheck log = new AddCheck();
                int State = log.LoginCh(ID, PW);
                if (State == 1) {
                    AdminLOGIN(); //어드민으로 넘어감
                } else if (State == 2) {
                    UesrLogin(); //사용자로 넘어감
                } else if (State == 3) {
                    System.out.println("아이디랑 비밀번호를 확인해주세요");
                    LoginStart();
                } else if (State == 4) {
                    System.out.println(System.out.printf("로그인정보가 없습니다."));
                    LoginStart();
                }
                else if(count ==3)
                {
                    System.out.println(count+":번 틀리셧습니다");
                    System.out.println("5번 로그인 실패시 자동적으로 프로그램이 종료됩니다.");
                }
                else if(count >=5)
                {
                    System.out.println(count+":번 틀리셧습니다");
                    System.out.println("자동적으로 프로그램이 종료됩니다.");
                    System.exit(0);
                }
                else {
                    System.out.println("로그인정보가 없습니다.");
                    LoginStart();
                }
            } else if (Section.equals("2")) {
                System.out.println("회원가입 선택");
                LoginInsert();
            } else if (Section.equals("3")) {
                System.out.println("프로그램 종료합니다.");
                System.exit(0);
            } else {
                System.out.println("잘못 입력하셧습니다.");
                System.out.println("다시 입력해주세요.");
            }
            LoginStart();
        }
    }
    public void AdminLOGIN(){
        System.out.println("관리자 입니다");
        LibManger La =  new LibManger();
        La.AdminBookStart();
    }

    public void UesrLogin(){
        System.out.println("사용자 입니다");
        LibManger La =  new LibManger();
        La.UserBookStart();
    }

    public void LoginInsert() {
        LoginVo Lo = new LoginVo();
        Lo.setUserId(LoginDataCheck("아이디"));
        Lo.setUserPw(LoginDataCheck("비밀번호"));

        do {
            boolean State = true;
            try {
            Lo.setUserTel(LoginDataCheck("핸드폰번호"));
            }catch (NumberFormatException number)
            {
                State =false;
                System.out.print("핸드폰 번호 숫자로만 입력해주세요");
            }
            if(State==true) break;
        }while(true);

        LoginDataSet.LoginList.put(Lo.getUserId(),Lo);
        System.out.println("회원가입이 완료되었습니다.");
        System.out.println("로그인이 가능합니다");
        LoginStart();
    }
    public void MemberList()
    {
        Collection<LoginVo> LoginList =LoginDataSet.LoginList.values();
        Iterator<LoginVo> Login =LoginList.iterator();

        while(Login.hasNext())
        {
            LoginVo vo = Login.next();
            vo.LoginPrint();
        }

    }
    public void PrintMake()
    {

    }
    public String inData(String msg){
        System.out.println(msg+"->");
        return scan.nextLine();
    }
    public String LoginDataCheck(String msg) {
        int count=0;
        while (true) {
            if(msg.equals("비밀번호"))
            {
                System.out.println("비밀번호는 8글자 이상으로 만들어주세요");
                System.out.println(msg + "->");
                Data = scan.nextLine();
                if (Data.length() >= 8 && !Data.equals("")) {
                    break;
                } else {
                    System.out.println("8자리 이상 또는 값을해주세요 다시 입력해주세요");
                }
            }
            if(msg.equals("아이디")) {
                System.out.println("아이디는 5글자 이상으로 만들어주세요");
                System.out.println(msg + "->");
                Data = scan.nextLine();
                if (Data.length() >= 5 && !Data.equals("")) {
                    break;
                } else {
                    System.out.println("5자리 이상 또는 값을해주세요 다시 입력해주세요");
                }
            }
            if(msg.equals("핸드폰번호"))
            {
                System.out.println("핸드폰 번호는 -뺴고 12자리 입력해주세요");
                System.out.println(msg + "->");
                Data = scan.nextLine();
                if (Data.length() == 12 && !Data.equals("")) {
                    break;
                } else {
                    System.out.println("8자리 이상 또는 값을해주세요 다시 입력해주세요");
                }
            }
        }
        return Data;
    }

}
