package com.fje.composite;

import java.util.List;

import com.fje.Icon.Icon;

/**
 * RectangleStyleContainer 类使用了组合设计模式
 * 该类是 Container 的具体实现，表示矩形风格的容器
 */
public class RectangleStyleContainer extends Container {
    private static final int maxLength = 55;

    public RectangleStyleContainer(String name, int level, Icon icon) {
        super(name, level, icon);
    }

    @Override
    public void draw(int level, boolean isFirst, boolean isLast, List<Boolean> parentIsLast) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level - 1; i++) {
            indent.append("│   ");
        }
        String branch = (level == 1 && isFirst) ? "┌─" : "├─";
        String suffix = (level == 1 && isFirst) ? "┐" : "┤";
        String prefix = indent.toString() + branch + getIcon().getContainerIcon();
        System.out.println(
                prefix + " " + getName() + " " + "─".repeat(maxLength - prefix.length() - getName().length() - 1)
                        + suffix);
        parentIsLast.add(isLast);
        for (int i = 0; i < getChildren().size(); i++) {
            Component child = getChildren().get(i);
            child.draw(level + 1, i == 0, i == getChildren().size() - 1, parentIsLast);
        }
        parentIsLast.remove(parentIsLast.size() - 1);
    }

    @Override
    public Container createInstance(String name, int level, Icon icon) {
        return new RectangleStyleContainer(name, level, icon);
    }
}
