package com.open.alg.category.datastructure.queue;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 14:42
 */
public class QueueTest {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 队列实现-二叉树的层序遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        // 使用ArrayQueue来做为我们的先入先出的队列
        ArrayQueue<Pair<TreeNode, Integer>> queue = new ArrayQueue<Pair<TreeNode, Integer>>();
        queue.enqueue(new Pair<TreeNode, Integer>(root, 0));

        while (!queue.isEmpty()) {

            Pair<TreeNode, Integer> front = queue.dequeue();
            TreeNode node = front.getKey();
            int level = front.getValue();
            if (level == res.size()) {
                res.add(new ArrayList<Integer>());
            }
            assert level < res.size();
            res.get(level).add(node.val);
            if (node.left != null) {
                queue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        // 使用LoopQueue来做为我们的先入先出的队列
        LoopQueue<Pair<TreeNode, Integer>> queue = new LoopQueue<Pair<TreeNode, Integer>>();
        queue.enqueue(new Pair<TreeNode, Integer>(root, 0));

        while(!queue.isEmpty()){

            Pair<TreeNode, Integer> front = queue.dequeue();
            TreeNode node = front.getKey();
            int level = front.getValue();
            if(level == res.size()) {
                res.add(new ArrayList<Integer>());
            }
            assert level < res.size();
            res.get(level).add(node.val);
            if(node.left != null) {
                queue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
            }
            if(node.right != null) {
                queue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
            }
        }
        return res;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {

        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        // 使用LinkedListQueue来做为我们的先入先出的队列
        LinkedListQueue<Pair<TreeNode, Integer>> queue = new LinkedListQueue<Pair<TreeNode, Integer>>();
        queue.enqueue(new Pair<TreeNode, Integer>(root, 0));

        while(!queue.isEmpty()){

            Pair<TreeNode, Integer> front = queue.dequeue();
            TreeNode node = front.getKey();
            int level = front.getValue();

            if(level == res.size())
                res.add(new ArrayList<Integer>());
            assert level < res.size();

            res.get(level).add(node.val);
            if(node.left != null)
                queue.enqueue(new Pair<TreeNode, Integer>(node.left, level + 1));
            if(node.right != null)
                queue.enqueue(new Pair<TreeNode, Integer>(node.right, level + 1));
        }

        return res;
    }

    // 测试使用q运行opCount个enqueueu和dequeue操作所需要的时间，单位：秒
    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0 ; i < opCount ; i ++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s");
    }
}
