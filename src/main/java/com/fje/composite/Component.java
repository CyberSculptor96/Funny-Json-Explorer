package com.fje.composite;

import java.util.List;

/**
 * Component 接口使用了组合设计模式
 * 该接口定义了 draw 方法，用于绘制组件
 */
public interface Component {
    void draw(int level, boolean isFirst, boolean isLast, List<Boolean> parentIsLast);
}