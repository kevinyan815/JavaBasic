package com.learngenerics.ext;

public class GrandParent {
    private int num;

    public GrandParent (int num) {
        this.num = num;
    }

    public GrandParent() {
        this(-1);
    }

    public int getNum() {
        return num;
    }

    public void setNum() {
        this.num = num;
    }
}
