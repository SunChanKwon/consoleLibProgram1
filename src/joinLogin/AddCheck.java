package joinLogin;

import java.util.HashMap;

public class AddCheck {
    private final String ADminUSERID = "Admin";
    private final String ADminUSERPWD = "Admin";
    HashMap<String, LoginVo> LoginList = new HashMap<String, LoginVo>();/// 객체를 새롭게 만들어준다

    public AddCheck() {
    }

    public int LoginCh(String cID, String cPW) {
        String id = cID;
        String pw = cPW;
        LoginVo vo = LoginDataSet.LoginList.get(id);
        LoginDataSet.LoginDataSet();
        int result;

        try {
            if (id.equals(ADminUSERID) && (pw.equals(ADminUSERPWD))) {
                result = 1;
                return result; //어드민으로 넘어감
            }
            else if (LoginDataSet.LoginList.containsKey(id)) {
                if (vo.getUserPw().equals(pw)) {//LoginList.get(id).getUserPw().equals(pw)) {
                    System.out.println("로그인성공하셧습니다");
                    result = 2;
                    return result;
                } else {
                    result = 3;
                    return result;
                }
            }
            else {
                result = 0;
                return result;
            }
        } catch (NullPointerException e) {
            result = 4;
        }
        return result;
    }
}

