package org.techtown.listview;

/**
 * Created by Administrator on 2018-02-07.
 */

public class SingerItem {

    private String name;
    private String mobile;
    private int resId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public SingerItem(String name, String mobile, int resId) {
        this.name = name;
        this.mobile = mobile;
        this.resId = resId;
    }

    @Override
    public String toString() {
        return "SingerItem{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", resId=" + resId +
                '}';
    }
}
