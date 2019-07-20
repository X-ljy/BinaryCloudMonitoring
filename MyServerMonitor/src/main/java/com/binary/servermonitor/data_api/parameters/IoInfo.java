package com.binary.servermonitor.data_api.parameters;

import java.util.Arrays;

public class IoInfo {
    String tag;
    String[][] data;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "IoInfo{" +
                "tag='" + tag + '\'' +
                ", data=" + Arrays.deepToString(data) +
                '}';
    }
}
