package pers.hbc.testThrowable;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Beer
 * @Date: 2019/4/26 22:25
 * @Description: Test OutOfMemoryError:对象在堆中没有足够的内存分配
 */
public class TestOOM {
    static class OOM{
    }

    public static void main(String[] args) {
        List<OOM> list = new ArrayList<>();
        while (true) {
            list.add(new OOM());
        }
    }
}
