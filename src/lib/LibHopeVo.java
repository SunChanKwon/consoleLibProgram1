package lib;

public class LibHopeVo extends LibMemVo {

    private String HBookName; //책이름
    private String HBookWrite; //책저자
    private String HBookType; //책의 종류 ex 의학 문학 어린이

    public LibHopeVo() {

    }

    public LibHopeVo(String HBookName, String HBookWrite, String HBookType) {
        this.HBookName=HBookName;
        this.HBookWrite=HBookWrite;
        this.HBookType=HBookType;
    }

    public String getHBookName() {
        return HBookName;
    }

    public void setHBookName(String HBookName) {
        this.HBookName = HBookName;
    }

    public String getHBookWrite() {
        return HBookWrite;
    }

    public void setHBookWrite(String HBookWrite) {
        this.HBookWrite = HBookWrite;
    }

    public String getHBookType() {
        return HBookType;
    }

    public void setHBookType(String HBookType) {
        this.HBookType = HBookType;
    }

    public void BookHopePrint() {
        System.out.println("--------------------희망도서  목록--------------------");
        System.out.printf("(책이름: %5s) (책 저자:%5s) (책 종류:%3s) \n", HBookName, HBookWrite, HBookType);
    }


}
