package io.github.linxiaobaixcg.util;

/**
 * @program: vw
 * @description: 单例模式
 * @author: LCQ
 * @create: 2019-11-09 22:08
 **/
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
