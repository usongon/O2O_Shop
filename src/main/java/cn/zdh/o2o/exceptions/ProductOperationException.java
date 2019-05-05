package cn.zdh.o2o.exceptions;

public class ProductOperationException extends RuntimeException{

    private static final long serialVersionUID = 1865286716324864969L;
    public ProductOperationException(String msg){
        super(msg);
    }

}
