package sort.selectionsort;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-05 16:52
 **/
// 堆排序 不稳定 时间复杂度最好最坏 O(NlogN)
// 元素 a 、b  a = b  b在a的右边（树的同一层），在某次交换中，b与其父节点交换了
public class Heap {

    private int size;
    private int capacity;
    private int[] nums;
    private boolean isSmallHeap;

    public Heap(boolean isSmallHeap) {
        this.isSmallHeap = isSmallHeap;
    }


    public int[] getKNums(int[] arr, int k) {
        this.capacity = k;
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
        return nums;
    }
    private void add(int num) {
        if (isSmallHeap) {// 小根堆 ==> k大个数
            if (size == capacity) {
                if (num > nums[0]) {
                    nums[0] = num;
                    heapify(nums, 0, capacity);
                }
            } else {
                nums[capacity - size - 1] = num;
                heapify(nums, capacity - size - 1, capacity);
                size++;
            }
        } else {// 大根堆 ==> k小个数
            if (size == capacity) {
                if (num < nums[0]) {
                    nums[0] = num;
                    heapify(nums, 0, capacity);
                }
            } else {
                nums[capacity - size - 1] = num;
                heapify(nums, capacity - size - 1, capacity);
                size++;
            }
        }
    }

    /*
     * @Description //TODO
     * 1、将序列构建为一个大顶堆（或小顶堆）
     * 2、将堆顶元素与末尾元素交换，将堆顶元素沉到数组末尾
     * 3、重新调整结构，使其满足堆定义，然后继续交换堆顶元素与末尾元素
     * 4、 反复调整+交换步骤，直到序列完全有序
     * @Param nums:
     * @return : void
     **/
    public void sort(int[] nums) {
        int n = nums.length;
        //构建堆，从最后一个叶子结点的父节点开始
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }

        int temp;
        for (int j = n - 1; j >= 0; j--) {
            temp = nums[j];
            nums[j] = nums[0];
            nums[0] = temp;
            heapify(nums, 0, j);
        }
    }

    /*
     * @Description //TODO 维护堆的性质 (顺序二叉树，基于完全二叉树)
     *                 物理上还是一个数组，只不过使用的是下标之间的关系模拟的二叉树的逻辑关系
     *                 下标为i的节点的父节点下标：（i - 1）/ 2
     *                 左子节点：（i * 2）+ 1
     *                 右子节点：（i * 2）+ 2 i从0开始
     *
     * @Param arr: 存储堆的数组
     * @param n: 待维护的数组的长度
     * @param i: 待维护节点的下标
     * @return : void
     **/
    private void heapify(int[] nums, int i, int n) {
        int curIndex = i;
        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        if (isSmallHeap) {// 构建小根堆
            if (leftIndex < n && nums[leftIndex] < nums[curIndex]) {
                curIndex = leftIndex;
            }
            if (rightIndex < n && nums[rightIndex] < nums[curIndex]) {
                curIndex = rightIndex;
            }
        } else { // 构建大根堆
            if (leftIndex < n && nums[leftIndex] > nums[curIndex]) {
                curIndex = leftIndex;
            }
            if (rightIndex < n && nums[rightIndex] > nums[curIndex]) {
                curIndex = rightIndex;
            }
        }
        if (curIndex != i) {
            int temp = nums[curIndex];
            nums[curIndex] = nums[i];
            nums[i] = temp;
            heapify(nums, curIndex, n);
        }
    }
}