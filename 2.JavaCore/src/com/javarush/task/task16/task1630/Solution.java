package com.javarush.task.task16.task1630;

class MyException extends  Exception{

}
class  MyRuntimeException extends  RuntimeException{

}

class A {
    void method1() throws MyException{ throw new MyException();}
    void method2 ()  {throw new MyRuntimeException();}
}