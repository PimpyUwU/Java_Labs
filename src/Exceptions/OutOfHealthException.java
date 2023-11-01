package Exceptions;

public class OutOfHealthException extends Exception{
    public OutOfHealthException(){
        super();
    }

    public OutOfHealthException(String errMsg){
        super(errMsg);
    }
}
