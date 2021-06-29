package lib;

import joinLogin.LoginDataSet;
import joinLogin.LoginManger;
import joinLogin.LoginVo;

import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class LibManger {
    LoginManger Lo = new LoginManger();
    Scanner scan = new Scanner(System.in);
    private boolean SetState;
    private String Data;

    public LibManger() {
    }

    String UserMenuSelectTab = "1.[책 조회] 2.[희망도서 추가하기] 3.[희망도서 신청목록] 4.[로그아웃] 5.[프로그램 종료] ";
    String AdminMenuSelectTab = "1.[책 조회] 2.[책 추가] 3.[회원관리] 4.[로그아웃] 5.[프로그램 종료] ";

    public void UserBookStart() {
        boolean state = false;
        do {
            String Section = inData(UserMenuSelectTab);   //데이터를 집어넣음

            if(Section.equals("1"))
            {
                BookallList();
            }
            else if(Section.equals("2"))
            {
                System.out.println("희망도서 추가하기");
                HBookAdd();
            }
            else if(Section.equals("3"))
            {
                System.out.println("희망도서 추가목록");
                HopeBooklList();
            }
            else if(Section.equals("4"))
            {
                System.out.println("로그아웃");
                Lo.LoginStart();
            }
            else if(Section.equals("5"))
            {
                System.out.println("프로그램 종료합니다.");
                System.exit(0);
            }
            else {
                System.out.println("잘못입력했습니다.");
                System.out.println("다시입력하세요.");
                UserBookStart();
            }
        }
        while (true);

        // BookallList();
    }

    public void AdminBookStart() {
        do {
            String Section = inData(AdminMenuSelectTab);   //데이터를 집어넣음
            if (Section.equals("1")) {
                System.out.println("책조회");
                BookallList();
                System.out.println("책 상태를 바꾸시겠습니까?");
                String Updata = inData("예 아니오로 대답해주세요");
                if(Updata.equals("예"))
                {
                    AdminBookUpdate();
                    AdminBookStart();
                }
                else if(Updata.equals("아니오"))
                {
                    AdminBookStart();
                }
                else
                {
                    System.out.println("잘못 입력하셧습니다 초기상태로 돌아갑니다.");
                    AdminBookStart();
                }
            }
            else if (Section.equals("2")) {
                HopeBooklList();
                BookAdd();  //책추가
            }
            else if (Section.equals("3")) {///------------------
                String meunTitle = "1번 회원목록 조회 2.회원 삭제";
                String Section2 = inData(meunTitle);   //데이터를 집어넣음

                if (Section2.equals("1")) {
                    Lo.MemberList();
                    AdminBookStart();
                } else if (Section2.equals("2")) {
                    Boolean A = AdminDelete();
                    if (A == false) {
                        System.out.println("=일치하지 사용자가 없습니다");
                        AdminDelete();
                    }
                    AdminBookStart();
                } else {
                    System.out.print("잘못 입력하셧습니다");
                }
            }//----------------------------------------------------

            else if (Section.equals("4"))
            {
                System.out.println("로그아웃");
                Lo.LoginStart();
            }
            else if (Section.equals("5"))
            {
                System.out.println("프로그램 종료합니다.");

                System.exit(0);
            }
            else {
                System.out.println("잘못입력했습니다.");
                System.out.println("다시입력하세요.");
                AdminBookStart();
            }
        }while(true);
    }
    public void AdminBookUpdate() {
        String SetState;
        String Booknumber = inData("상태 수정할 책 넘버");
        LibMemVo LB = LibDataSet.Lib.get(Booknumber);
        System.out.println(Booknumber);
        while (true) {

            if (LibDataSet.Lib.containsKey(Booknumber)) {
                System.out.println("수정할 상태를 1 TRUE,2 FALSE로 입력해주세요");
                SetState = scan.nextLine();
                if (SetState.equals("1")) {
                    LB.setsBook(true);
                    System.out.println("책이 업데이트 되었습니다");
                    break;
                } else if (SetState.equals("2")) {
                    LB.setsBook(false);
                    System.out.println("책이 업데이트 되었습니다");
                    break;
                } else {
                    System.out.println("숫자를 잘못입력하셧습니다.");
                    System.out.println("다시입력해주세요");
                }
            }
        }
    }
    public Boolean AdminDelete() {
        boolean a = false;
        LoginManger LP = new LoginManger();
        LP.MemberList();
        System.out.println("삭제관리해야되는 회원의 이름을 입력해주세요");
        String delName = inData("삭제할 user 입력");
        LoginVo vo = LoginDataSet.LoginList.get(delName);
        LoginDataSet.LoginDataSet();
        if (LoginDataSet.LoginList.containsKey(delName)) {
            if (vo.getUserId().equals(delName)) {
                LoginDataSet.LoginList.remove(delName);
                System.out.println(delName + "=" + "삭제되었습니다.");
                a = true;
            }
        }
        System.out.println("현재 회원목록 ");
        LP.MemberList();
        return a;
    }

    public void BookallList()
    {
        LibDataSet.LibDataSet();
        Collection<LibMemVo> BookList = LibDataSet.Lib.values();
        Iterator<LibMemVo> LibMe =BookList.iterator();
        while(LibMe.hasNext())
        {
            LibMemVo Book = LibMe.next();
            Book.BookPrint();
        }
    }
    public void HopeBooklList()
    {
       HopeDataSet.HopeDataSet();
        Collection<LibHopeVo> HBookList = HopeDataSet.Hope.values();
        Iterator<LibHopeVo> HBook =HBookList.iterator();
        while(HBook.hasNext())
        {
            LibHopeVo Book = HBook.next();
            Book.BookHopePrint();
        }
    }

    public void BookAdd()
    {
        LibMemVo LM = new LibMemVo();
        LM.setBookNumber(HBookaddData("책 넘버"));
        LM.setBookName(HBookaddData("책이름"));
        LM.setBookWrite(HBookaddData("책저자"));
        LM.setBookType(HBookaddData("책의 종류"));
        LM.setBookLocation(HBookaddData("책의공간"));
        LM.setsBook(SetBookData("책의상태"));
        LibDataSet.Lib.put(LM.getBookName(),LM);
        AdminBookStart();
    }

    public void BookCheck()
    {
        LibMemVo LB = new LibMemVo();
        HopeDataSet HB = new HopeDataSet();

        LibDataSet.LibDataSet();
        Collection<LibMemVo> BookList = LibDataSet.Lib.values();
        Iterator<LibMemVo> LibMe =BookList.iterator();
    }
    public void HBookAdd() {
        LibHopeVo Hb = new LibHopeVo();
        System.out.println("필요하신 책 데이터를 입력해주세요");
        Hb.setHBookName(HBookaddData("책의 이름"));
        Hb.setHBookWrite(HBookaddData("책의 저자"));
        Hb.setHBookType(HBookaddData("책의 종류"));
        HopeDataSet.Hope.put(Hb.getBookName(),Hb);
        System.out.println("희망도서가 신청되었습니다");
    }

    public String inData(String msg){
        System.out.println(msg+"->");
        return scan.nextLine();
    }
    public String HBookaddData(String msg) {
        int count=0;
        while (true) {
            if(msg.equals("책의 종류")) {
                System.out.println(msg + "->");
                System.out.println("역사,의학,인문만 입력해주세요");
                Data = scan.nextLine();
                if (!Data.equals("")) {
                    if (Data.equals("역사") || Data.equals("의학") || Data.equals("인문")) {
                        break;
                    }
                } else {
                    System.out.println("빈값을 입력하셧습니다.");
                }
            }
            else
                System.out.println(msg + "->");
                Data = scan.nextLine();
                if(Data.length() >= 3 && !Data.equals("")) {
                break;
            } else {
                System.out.println("2자리 이상 또는 값을해주세요 다시 입력해주세요");
            }
        }
        return Data;
    }

    public boolean SetBookData(String msg){
        String number;
        System.out.println("1번 입력시 true 2번 입력시 false");
        number =scan.nextLine();
        System.out.println(msg+"->");
            if (number.equals("1")) {
                SetState = true;
            } else if (number.equals("2")) {
                SetState = false;
            }
            else {
                System.out.print("잘못입렿했습니다 다시입력해주세요");
                SetBookData("책의 상태");
           }
        return SetState;
    }
}

