package Java核心技术卷代码练习.泛型程序设计.泛型类型.消除受查异常实例;


/**
 * @Author: Beer
 * @Date: 2019/8/12 0:14
 * @Description:
 */

public abstract class Block {

    public abstract void body() throws Exception;

    public Thread toThread() {
        return new Thread(){
            @Override
            public void run() {
                try {
                    body();
                }catch ( Throwable t) {
                    Block.<RuntimeException>throwAs(t);
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    public static <T extends Throwable> void throwAs(Throwable e) throws T {
        throw (T) e;
    }
}
