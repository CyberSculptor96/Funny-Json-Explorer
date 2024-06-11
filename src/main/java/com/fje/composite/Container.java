package com.fje.composite;

import java.util.ArrayList;
import java.util.List;

import com.fje.Icon.Icon;

/**
 * Container 类使用了组合设计模式
 * 该类表示一个容器节点，可以包含子组件
 */
public abstract class Container implements Component {
    private List<Component> children = new ArrayList<>();
    private String name;
    private int level;
    private Icon icon;

    public Container(String name, int level, Icon icon) {
        this.name = name;
        this.level = level;
        this.icon = icon;
    }

    // 添加子组件到容器中
    public void add(Component child) {
        this.children.add(child);
    }

    public abstract void draw(int level, boolean isFirst, boolean isLast, List<Boolean> parentIsLast);

    // 获取子组件列表
    public List<Component> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Icon getIcon() {
        return icon;
    }

    // 抽象方法，用于创建容器实例
    public abstract Container createInstance(String name, int level, Icon icon);
}
