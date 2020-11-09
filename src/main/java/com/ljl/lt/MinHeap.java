package com.ljl.lt;

/**
 * @author liujialei
 */
public class MinHeap {

    /**
     * 堆的存储结构 - 数组
     */
    private int[] data;

    /**
     * 将一个数组传入构造方法，并转换成一个小根堆
     * @param data
     */
    public MinHeap(int[] data) {
        this.data = data;
        buildHeap();
    }

    /**
     * 将数组转换为小根堆
     */
    private void buildHeap() {
        //完全二叉树只有数组下标小于或等于（data.length）/ 2 - 1 的元素有孩子节点，遍历这些节点
        //比如上面图中，数组有10个元素，(data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
        for (int i = (data.length) / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < data.length && data[l] < data[i])
            smallest = l;
        if (r < data.length && data[r] < data[smallest])
            smallest = r;
        if (i == smallest)
            return;
        swap(i, smallest);
        heapify(smallest);
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private int right(int i) {
        return (i + 1) << 1;
    }

    private int left(int i) {
        return (i + 1) << 1 - 1;
    }

}
