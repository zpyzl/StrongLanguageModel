/*
 * Copyright(c)2018-2020, 赵鹏阳
 * 项目名称:Yearn 文件名称:YearnTreeFactory.java
 * Date:2020/1/1 下午9:21
 * Author: 赵鹏阳
 */

package com.zpy.yearn.yearnTree;

import com.zpy.yearn.pennTree.TreeTraverseContext;
import com.zpy.yearn.pennTree.TreeTraverser;
import edu.stanford.nlp.trees.Tree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by zpy on 2018/10/31.
 */
public class YearnTreeFactory {//implements TreeFactory {
    private static final Logger logger = LoggerFactory.getLogger(YearnTreeFactory.class);

    public static YearnTree createYearnTree(Tree pennTree){
        TreeTraverseContext yearnTreeFactoryContext = new TreeTraverseContext();
        return (YearnTree) TreeTraverser.traverseTreeNode(pennTree, yearnTreeFactoryContext,
                YearnTreeFactory::newLeaf,
                YearnTreeFactory::newTreeNode);
    }

/*
    public Tree newLeaf(Tree tree, TreeTraverseContext context, String leafString) {
        return newTreeNode(tree,context);
    }

    public Tree newTreeNode(Tree tree, TreeTraverseContext context) {
        YearnTree yearnTree = new YearnTree();
        yearnTree.setLabel(tree.label());
        return tree;
    }*/
/*
    @Override
    public Tree newLeaf(String s) {
        YearnTree yearnTree = new YearnTree();
        yearnTree.setLabel(YearnLabelFactory.createLabel(s));
        return yearnTree ;
    }

    @Override
    public Tree newTreeNode(String s, List<Tree> children) {
        YearnTree yearnTree = new YearnTree();
        yearnTree.setLabel(YearnLabelFactory.createLabel(s));
        yearnTree.setChildren(children);
        return yearnTree;
    }*/

    public static YearnTree newLeaf(Tree tree) {
        YearnTree yearnTree = new YearnTree();
        yearnTree.setLabel(YearnLabelFactory.createLabel(tree.label().value()));
        //yearnTree.setLeaf(TreeF.getLeaf(tree));
        return yearnTree;
    }

    public static YearnTree newTreeNode(Tree tree, List<Tree> children) {
        YearnTree yearnTree = new YearnTree();
        //yearnTree.setLeaf(TreeF.getLeaf(tree));
        yearnTree.setLabel(YearnLabelFactory.createLabel(tree.label().value()));
        yearnTree.setChildren(children);
        return yearnTree;
    }
}
