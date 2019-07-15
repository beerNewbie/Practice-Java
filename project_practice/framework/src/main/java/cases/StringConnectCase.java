package cases;

import annotations.Benchmark;
import annotations.Measurement;

/**
 * @Author: Beer
 * @Date: 2019/7/15 16:09
 * @Description:
 */
@Measurement(iterations = 1000, group = 10)
public class StringConnectCase {
    private void doNothing() {
    }
    @Benchmark
    public String testStringAdd() {
        doNothing();
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += i;
        }
        return s;
    }
    @Benchmark
    public String testStringBuilder() {
        doNothing();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
}
