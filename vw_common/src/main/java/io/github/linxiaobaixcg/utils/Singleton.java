package io.github.linxiaobaixcg.utils;



/**
 * @program: vw
 * @description: 单例模式
 * @author: LCQ
 * @create: 2020-03-15 12:35
 **/
public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){};
    public static Singleton getInstance(){
        return singleton;
    }
}
