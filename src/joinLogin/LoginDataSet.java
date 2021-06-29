package joinLogin;


import java.util.HashMap;

public class LoginDataSet {
    public static HashMap<String, LoginVo> LoginList = new HashMap<String, LoginVo>();/// 객체를 새롭게 만들어준다
    public LoginDataSet(){

    }

    public static void LoginDataSet(){
        //LoginList.put("101", new LoginVo("101","101","010-2750-7662"));//관리자
        //LoginList.put("a", new LoginVo("a","a","010-2750-7662"));//관리자
    }

}
