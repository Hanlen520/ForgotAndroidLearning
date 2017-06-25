package tech.fuge.www.forgotheadfirstandroid.model;

import tech.fuge.www.forgotheadfirstandroid.R;

/**
 * Created by Lin Zongfu on 2017/6/25.
 */

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

public static final Drink[] drinks={
        new Drink("cokecole","汽水饮料", R.mipmap.ic_launcher),
        new Drink("雪碧","也是汽水饮料", R.mipmap.ic_launcher),
        new Drink("农夫山泉","矿泉水", R.mipmap.ic_launcher)
};
    public Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
