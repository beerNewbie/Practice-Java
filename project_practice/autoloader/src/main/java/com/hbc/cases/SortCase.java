package com.hbc.cases;

import com.hbc.Case;
import com.hbc.annotation.Benchmark;
import com.hbc.annotation.Measurement;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Author: Beer
 * @Date: 2019/7/15 17:28
 * @Description:
 */
@Measurement(iterations = 100, group = 5)
public class SortCase implements Case {
    @Benchmark
    public int[] sort() {
        int[] arr = {2,4,7,2,9};
        Arrays.sort(arr);
        return arr;
    }
}
