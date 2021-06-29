package lib;

import java.util.HashMap;

public class LibDataSet {

    public static HashMap<String, LibMemVo> Lib = new HashMap<String, LibMemVo>();/// 객체를 새롭게 만들어준다


    public LibDataSet(){

    }

    public static void LibDataSet() {
        Lib.put("라이트노벨상", new LibMemVo("101","라이트노벨상","노벨","인문","C2",true));
        Lib.put("에세이 시", new LibMemVo("102","에세이 시","에이","인문","C2",true));
        Lib.put("생각하는-여행", new LibMemVo("103","생각하는-여행","여성직","여행","C2-1",true));
        Lib.put("리얼제주", new LibMemVo("104","리얼제주","김태연","여행","C2-1",true));
        Lib.put("신화의주책", new LibMemVo("105","신화의주책","이진숙","예술","C2-2",true));
        Lib.put("예술의-주름", new LibMemVo("106","예술의-주름","나희덕","예술","C2-2",true));
        Lib.put("역사의-순간", new LibMemVo("107","역사의-순간","조한욱","역사","C2-3",true));
        Lib.put("바다의-시간", new LibMemVo("10C","바다의-시간","볼프강 이치로","역사","C2-3",true));
    }
}
