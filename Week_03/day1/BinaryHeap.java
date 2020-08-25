import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author yangxing
 * @version 1.0
 * @date 2020/8/24 0024 14:00
 * 构建二叉堆
 */
public class BinaryHeap {
    private int heapSize;
    private int[] heap;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    /**
     * 定义 N 叉数
     */
    private int k;

    public BinaryHeap(int capacity){
        this.heap = new int[capacity];
        this.k = 2;
    }

    public BinaryHeap(int capacity,int k){
        this.heap = new int[capacity];
        this.k = k;
    }

    /**
     * 判断堆是否为空
     * @return
     */
    public boolean isEmpty(){
        return heapSize == 0;
    }

    /**
     * 判断堆是否满了
     * @return
     */
    public boolean isFull(){
        return heapSize == heap.length;
    }

    /**
     * 获取索引 i 的父节点索引
     * @param i 当前索引
     * @return 父节点索引
     */
    private int parent(int i){
        return (i - 1) / k;
    }

    /**
     * 获取当前节点的左节点
     * @return
     */
    private int kthChildLeft(int i){
        return i * k + 1;
    }

    /**
     * 获取当前节点的右节点
     * @return
     */
    private int kthChildRight(int i){
        return i * k + 2;
    }

    /**
     * 扩容
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = heap.length;
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        heap = Arrays.copyOf(heap, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        // overflow
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    /**
     * 插入
     * @param e
     */
    public void insert(Integer e){
        if (e == null)
            throw new NullPointerException();
        int i = heapSize;
        if (isFull()){
            grow(i + 1);
        }
        heapSize ++;
        if (i == 0){
            heap[i] = e;
        }else{
            siftUp(i, e);
        }
    }

    private void siftUp(int i, Integer e) {
        int insertElement = heap[i];
        while (i > 0 && insertElement < heap[parent(i)]){
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = insertElement;
    }

    /**
     * 删除
     * @param x
     * @return
     */
    public int delete(int x){
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty, No element to delete");
        }
        int maxElement = heap[x];
        heap[x] = heap[x - 1];
        heapSize --;
        heapifyDown(x);
        return maxElement;
    }

    private void heapifyDown(int i) {
        int deleteElement = heap[i];
        while (kthChildLeft(i) < heapSize){
            int maxChild = maxChild(i);
            if (deleteElement >= heap[maxChild]){
                break;
            }
            heap[i] = heap[maxChild];
            i = maxChild;
        }
        heap[i] = deleteElement;
    }

    private int maxChild(int i) {
        int leftElement = heap[kthChildLeft(i)];
        int rightElement = heap[kthChildRight(i)];
        return leftElement > rightElement ? kthChildLeft(i) : kthChildRight(i);
    }

    public void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < heapSize; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public int findMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }
        return heap[0];
    }
}
