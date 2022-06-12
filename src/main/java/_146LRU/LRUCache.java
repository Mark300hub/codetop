package _146LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : i.Boss
 * @program : codetop
 * @description :
 * @create : 2022-06-04 17:41
 **/
// 设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构
public class LRUCache {

    static class CacheNode{
        int key;
        int value;

        CacheNode prev;
        CacheNode next;

        public CacheNode() {
        }

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private int size;

    private CacheNode head;
    private CacheNode tail;

    private Map<Integer, CacheNode> cacheMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cacheMap = new HashMap<>();
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        CacheNode cacheNode = cacheMap.get(key);
        if (cacheNode != null) {// 存在
            //将该节点移动到缓存链表的首部
            moveToHead(cacheNode);
            return cacheNode.value;
        }
        return -1;
    }

    private void moveToHead(CacheNode cacheNode) {
        removeCacheNode(cacheNode);
        addToHead(cacheNode);
    }

    private void addToHead(CacheNode cacheNode) {
        cacheNode.next = head.next;
        head.next.prev = cacheNode;
        head.next = cacheNode;
        cacheNode.prev = head;
    }

    private void removeCacheNode(CacheNode cacheNode) {
        cacheNode.prev.next = cacheNode.next;
        cacheNode.next.prev = cacheNode.prev;
    }

    public void put(int key, int value) {
        CacheNode targetNode = cacheMap.get(key);
        if (targetNode != null) {
            targetNode.value = value;
            moveToHead(targetNode);
        }
        else {
            if (size == capacity) {
                size--;
                cacheMap.remove(tail.prev.key);
                removeCacheNode(tail.prev);
            }
            targetNode = new CacheNode(key, value);
            addToHead(targetNode);
            cacheMap.put(key, targetNode);
            size++;
        }
    }

}