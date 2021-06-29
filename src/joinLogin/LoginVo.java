package joinLogin;

public class LoginVo {

    private String userId;
    private String userPw;
    private String userTel;

    public LoginVo()
    { }

    public LoginVo(String userId, String userPw, String userTel)
    {
        this.userId=userId;     //아이디
        this.userPw=userPw;     //비밀번호
        this.userTel=userTel;   //전화번호 3가지 이용합니다.
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public void LoginPrint(){
        System.out.printf("%5s %10s %20s\n",userId,userPw,userTel);

    }



}
