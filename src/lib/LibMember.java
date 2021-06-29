package lib;

public class LibMember {
    
    private String BookNumber; //책번호
    private String BookName; //책이름
    private String BookWrite; //책저자
    private String BookType; //책의 종류 ex 의학 문학 어린이
    private String BookLocation; //책의 공간
    private boolean sBook;//책의 상태

    public LibMember()
    {

    }
    public LibMember(String BookNumber,String BookName,String BookWrite,String BookType,String BookLocation,Boolean sBook)
    {
        this.BookNumber=BookNumber;
        this.BookName=BookName;
        this.BookWrite=BookWrite;
        this.BookLocation=BookLocation;
        this.sBook=sBook;
    }

    public  void BookAllPrint()
    {
        System.out.printf("%5s %10s %20s %10d %10s\n",BookNumber,BookName,BookWrite,BookLocation,sBook);
    }
    public String getBookNumber() {
        return BookNumber;
    }

    public void setBookNumber(String bookNumber) {
        BookNumber = bookNumber;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookWrite() {
        return BookWrite;
    }

    public void setBookWrite(String bookWrite) {
        BookWrite = bookWrite;
    }

    public String getBookLocation() {
        return BookLocation;
    }

    public void setBookLocation(String bookLocation) {
        BookLocation = bookLocation;
    }

    public boolean issBook() {
        return sBook;
    }

    public void setsBook(boolean sBook) {
        this.sBook = sBook;
    }
}
