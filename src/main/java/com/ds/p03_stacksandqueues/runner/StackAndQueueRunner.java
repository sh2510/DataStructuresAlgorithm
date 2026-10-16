package com.ds.p03_stacksandqueues.runner;

import com.ds.p03_stacksandqueues.model.CustomQueue;
import com.ds.p03_stacksandqueues.model.CustomStack;

public class StackAndQueueRunner {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(24);
        System.out.println(customStack.printDetails());

        customStack.push(56);
        System.out.println(customStack.printDetails());

        customStack.push(77);
        System.out.println(customStack.printDetails());

        customStack.pop();
        System.out.println(customStack.printDetails());

        customStack.pop();
        System.out.println(customStack.printDetails());

        customStack.pop();
        System.out.println(customStack.printDetails());


        CustomQueue customQueue = new CustomQueue(55);
        System.out.println(customQueue.printDetails());

        customQueue.enqueue(44);
        System.out.println(customQueue.printDetails());

        customQueue.enqueue(77);
        System.out.println(customQueue.printDetails());

        customQueue.enqueue(37);
        System.out.println(customQueue.printDetails());

        System.out.println(customQueue.dequeue().getValue());
        System.out.println(customQueue.printDetails());

        System.out.println(customQueue.dequeue().getValue());
        System.out.println(customQueue.printDetails());

        System.out.println(customQueue.dequeue().getValue());
        System.out.println(customQueue.printDetails());

        System.out.println(customQueue.dequeue().getValue());
        System.out.println(customQueue.printDetails());
    }
}
