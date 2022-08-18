package com.open.alg.category.datastructure.stack;

import java.util.Random;

/**
 * @Description: TODO
 * @author: liuxiaowei
 * @date: 2021年06月05日 14:55
 */
public class StackTest {

    public static void main(String[] args) {
        //generatorStack();
        //testStack();
        System.out.println((new StackTest()).isValid("()[]{}"));
        System.out.println((new StackTest()).isValid2("()[]{}"));
        //System.out.println((new StackTest()).isValid("([)]"));
    }

    private static void testStack() {
        int opCount = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: " + time2 + " s");
    }

    /**
     * 创建栈
     */
    private static void generatorStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    // 测试使用stack运行opCount个push和pop操作所需要的时间，单位：秒
    private static double testStack(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i = 0 ; i < opCount ; i ++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 数组栈实战-括号匹配
     *
     * @param s
     * @return
     */
    private boolean isValid(String s) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * 链表栈实战-括号匹配
     * @param s
     * @return
     */
    public boolean isValid2(String s) {

        LinkedListStack<Character> stack = new LinkedListStack<>();
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else{
                if(stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if(c == ')' && topChar != '(') {
                    return false;
                }
                if(c == ']' && topChar != '[') {
                    return false;
                }
                if(c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
