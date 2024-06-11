package com.fje.composite;

import java.util.List;

import com.fje.Icon.Icon;

/**
 * Leaf 类使用了组合设计模式
 * 该类表示一个叶子节点
 */
public abstract class Leaf implements Component {
    private String name;
    private String value;
    private Icon icon;

    public Leaf(String name, String value, Icon icon) {
        this.name = name;
        this.value = value;
        this.icon = icon;
    }

    public abstract void draw(int level, boolean isFirst, boolean isLast, List<Boolean> parentIsLast);

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Icon getIcon() {
        return icon;
    }

    // 抽象方法，用于创建叶子实例
    public abstract Leaf createInstance(String name, String value, Icon icon);
}
