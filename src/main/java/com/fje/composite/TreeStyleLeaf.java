package com.fje.composite;

import java.util.List;

import com.fje.Icon.Icon;

/**
 * TreeStyleLeaf 类使用了组合设计模式
 * 该类是 Leaf 的具体实现，表示树形风格的叶子
 */
public class TreeStyleLeaf extends Leaf {

    public TreeStyleLeaf(String name, String value, Icon icon) {
        super(name, value, icon);
    }

    @Override
    public void draw(int level, boolean isFirst, boolean isLast, List<Boolean> parentIsLast) {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level - 1; i++) {
            if (parentIsLast.get(i)) {
                indent.append("   ");
            } else {
                indent.append("│  ");
            }
        }
        String branch = isLast ? "└─" : "├─";
        String prefix = indent.toString() + branch + getIcon().getLeafIcon();
        if (getValue() != "null") {
            System.out.println(prefix + " " + getName() + ": " + getValue());
        } else {
            System.out.println(prefix + " " + getName());
        }
    }

    @Override
    public Leaf createInstance(String name, String value, Icon icon) {
        return new TreeStyleLeaf(name, value, icon);
    }
}
