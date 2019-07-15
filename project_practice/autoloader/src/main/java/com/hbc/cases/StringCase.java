package com.hbc.cases;

import com.hbc.Case;
import com.hbc.annotation.Benchmark;
import com.hbc.annotation.Measurement;

/**
 * @Author: Beer
 * @Date: 2019/7/15 17:28
 * @Description:
 */
@Measurement(iterations = 100, group = 5)
public class StringCase implements Case {
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
