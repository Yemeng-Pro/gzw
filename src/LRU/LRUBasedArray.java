package LRU;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2021-05-20 17:08
 */
public class LRUBasedArray<T> {
    public static void main(String[] args) {

    }

    private static final int DEFAULT_CAPACITY = 8;
    private int capacity;
    private int count;
    private T[] value;
    private HashMap<T, Integer> holder;  //记录每个元素在数组中的位置
    public LRUBasedArray(){};

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        this.value = (T[]) new Object[capacity];
        this.count = 0;
        this.holder = new HashMap<T, Integer>(capacity);
    }

    /**
     * 访问某个值
     */
    public void offer(T data) {
        if (data == null) {
            throw new IllegalArgumentException("该容器不支持NULL");
        }
        Integer index = holder.get(data);
        if (index == null) {
            if (isFull()) {
                removeAndCache(data);
            } else {
                cache(data,count);
            }
        } else {
            update(index);
        }
    }

    /**
     * 更新数组
     * @param index
     */
    private void update(int index) {
        T target = value[index];
        rightShift(index);
        value[0] = target;
        holder.put(target, 0);
    }


    /**
     * 缓存满的情况，踢出后，再缓存到数组头部
     * @param object
     */
    public void removeAndCache(T object) {
        T key = value[--count];
        holder.remove(key);
        cache(object, count);
    }

    /**
     * 缓存数据到头部，但要先右移
     * @param object
     * @param index 数组右移的边界
     */
    public void cache(T object, int index) {
        rightShift(index);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    /**
     * index左边的数据统一右移一位
     * @param index
     */
    private void rightShift(int index) {
        for (int i = index - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    /**
     * 判断是否已满
     */
    private boolean isFull(){
        return count == capacity;
    }

    /**
     * 判断是否为空
     */
    private boolean isEmpty() {
        return count == 0;
    }

    /**
     * 判断是否存在元素
     */
    private boolean isContian(T data) {
        return holder.containsKey(data);
    }

}
