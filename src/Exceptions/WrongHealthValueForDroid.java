package Exceptions;

public class WrongHealthValueForDroid extends Exception{
    public WrongHealthValueForDroid(){
        super();
    }

    public WrongHealthValueForDroid(String errMsg){
        super(errMsg);
    }
}
