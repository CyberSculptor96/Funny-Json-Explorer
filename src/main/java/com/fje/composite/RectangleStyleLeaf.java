package com.fje.composite;

import java.util.List;

import com.fje.Icon.Icon;

/**
 * RectangleStyleLeaf 类使用了组合设计模式
 * 该类是 Leaf 的具体实现，表示矩形风格的叶子
 */
public class RectangleStyleLeaf extends Leaf {
    private static final int maxLength = 55;

    public RectangleStyleLeaf(String name, String value, Icon icon) {
        super(name, value, icon);
    }

    @Override
    public void draw(int level, boolean isFirst, boolean isLast, List<Boolean> parentIsLast) {
        StringBuilder indent = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < level - 1; i++) {
            if (!parentIsLast.get(i)) {
                flag = false;
            }
            indent.append("│   ");
        }
        if (flag && isLast) {
            indent = new StringBuilder("└───");
            for (int i = 0; i < level - 2; i++) {
                indent.append("└───");
            }
        }
        String branch = (flag && isLast) ? "┴─" : "├─";
        String suffix = (flag && isLast) ? "┘" : "┤";
        String prefix = indent.toString() + branch + getIcon().getLeafIcon();
        if (getValue() != "null") {
            System.out.println(prefix + " " + getName() + ": " + getValue() + " "
                    + "─".repeat(maxLength - prefix.length() - getName().length() - getValue().length() - 3) + suffix);
        } else {
            System.out
                    .println(prefix + " " + getName() + " "
                            + "─".repeat(maxLength - prefix.length() - getName().length() - 1)
                            + suffix);
        }
    }

    @Override
    public Leaf createInstance(String name, String value, Icon icon) {
        return new RectangleStyleLeaf(name, value, icon);
    }
}
