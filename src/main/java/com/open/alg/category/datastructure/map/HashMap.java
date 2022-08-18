package com.open.alg.category.datastructure.map;

import java.io.Serializable;
import java.util.*;

/**
 * @author liuxiaowei
 * @date 2022年04月02日 14:17
 * @Description
 */
public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Serializable {

    /**
     * 桶的最初的的容量大小
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 桶的最大的容量
     */
    private static final int MAX_CAPACITY = 1 << 30;

    /**
     * 默认的负载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 需要扩容的阈值
     */
    private int threshold;

    /**
     * 桶容器
     */
    private transient Node<K, V>[] tables;

    /**
     * 容器大小
     */
    private transient int size;

    /**
     * 负载因子
     */
    private final float loadFactor;

    public HashMap() {
        this(DEFAULT_LOAD_FACTOR);
    }

    public HashMap(float loadFactor) {
        this(DEFAULT_INITIAL_CAPACITY, loadFactor);
    }

    public HashMap(int initialCapacity, float loadFactor) {
        if (Float.isNaN(loadFactor) || loadFactor <= 0) {
            throw new IllegalArgumentException("Illegal load factor:" + loadFactor);
        }
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal initialCapacity:" + initialCapacity);
        }
        if (initialCapacity > MAX_CAPACITY) {
            initialCapacity = MAX_CAPACITY;
        }
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    /**
     * 主要作用为确定容器为目标容量的2背幂
     *
     * @param capacity
     * @return
     */
    static final int tableSizeFor(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n > MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }

    private int hash(Object key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    private V putVal(int hash, K key, V value) {
        Node<K, V>[] tab = tables;
        Node<K, V> p;
        // n 记录桶的大小，i记录
        int n, i;
        if (tab == null || (n = tab.length) == 0) {
            // 当桶等于null 或者桶大小为0时先进行一次扩容
            n = (tab = resize()).length;
        }
        if ((p = tab[i = (n - 1) & hash]) == null) {
            // 桶中这个元素不存在，将其放在第一个
            tab[i] = new Node<>(hash, key, value, null);
        } else {
            // 桶中存在这个元素
            Node<K, V> e;
            K k;
            // 判断是否当前put的值是否为桶上的节点
            // 第一步判断 p节点的hash值是不是等于当前的hash
            // 第一步判断 p节点的key 是否等于当前put的key 基础类型判断==,  对象类型判断equals
            if (p.hash == hash && (key == (k = p.key) || (key != null && key.equals(k)))) {
                // 相等e指向p，后续做处理
                e = p;
            } else {
                // 1.8优化这里需要做是否未树的判断，这里简化
                while (true) {
                    // 如果链表遍历完了都没有找到相同key的元素，说明该key对应的元素不存在，则在链表最后插入一个新节点
                    if ((e = p.next) == null) {
                        p.next = new Node<>(hash, key, value, null);

                    }
                    // 如果待插入的key在链表中找到了，则退出循环
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;
                    }
                    p = e;
                }
            }
            // 如果找到了对应key的元素
            if (e != null) { // existing mapping for key
                // 记录下旧值
                V oldValue = e.value;
                e.value = value;
                // 返回旧值
                return oldValue;
            }
        }
        // 元素数量加1，判断是否需要扩容
        if (++size > threshold) {
            // 扩容
            resize();
        }
        return null;
    }

    private Node<K, V>[] resize() {
        // 记录旧数组
        Node<K, V>[] oldTab = tables;
        // 记录旧桶的大小
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        // 记录旧的扩容阈值
        int oldThr = threshold;
        // 记录新桶大小与阈值大小
        int newCap, newThr = 0;
        if (oldCap > 0) {
            // 老桶的大小 > 最大容量时，不进行扩容
            if (oldCap > MAX_CAPACITY) {
                // 对阈值进行修改，改为Integer最大值
                threshold = Integer.MAX_VALUE;
                // 返回元桶
                return oldTab;
            } else if ((newCap = oldCap << 1) < MAX_CAPACITY && oldCap > DEFAULT_INITIAL_CAPACITY) {
                newThr = threshold << 1;
            }
        } else if (oldThr < 0) {
            // 如果旧容量为0且旧扩容门槛大于0，则把新容量赋值为旧门槛
            newCap = oldThr;
        } else {
            // 桶与阈值都为0说明没有初始化话，全部进行初始化
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            // 如果阈值为0 这计算阈值
            float ft = newCap * loadFactor;
            newThr = (newCap < MAX_CAPACITY && ft < (float) MAX_CAPACITY) ? (int) ft : MAX_CAPACITY;
        }
        // 赋值新阈值
        threshold = newThr;
        // 创建新的桶
        Node<K, V>[] newTab = (Node<K, V>[]) new Node[newCap];
        // 将新桶赋值给tables
        tables = newTab;

        if (oldTab != null) {
            // 当旧桶不为空时，进行数据转移
            for (int i = 0; i < oldCap; ++i) {
                Node<K, V> e = oldTab[i];
                if (e != null) {
                    // 清空旧桶的数据
                    oldTab[i] = null;
                    if (e.next == null) {
                        // 根据hash值 &上 容易大小计算位置
                        newTab[e.hash & (newCap - 1)] = e;
                    } else {
                        // 本应该再判断是否未树节点，这里简化
                        Node<K, V> loHead = null, loTail = null;
                        Node<K, V> hiHead = null, hiTail = null;
                        Node<K, V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null) {
                                    loHead = e;
                                } else {
                                    loTail.next = e;
                                }
                                loTail = e;
                            } else {
                                // (e.hash & oldCap) != 0的元素放在高位链表中
                                // 比如，7 & 4 != 0
                                if (hiTail == null) {
                                    hiHead = e;
                                } else {
                                    hiTail.next = e;
                                }
                                hiTail = e;
                            }
                        } while ((e = next) != null);

                        if (loTail != null) {
                            loTail.next = null;
                            newTab[i] = loHead;
                        }
                        // 高位链表在新桶中的位置正好是原来的位置加上旧容量（即7和15搬移到七号桶了）
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[i + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    @Override
    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    /**
     * 获取节点的方法
     *
     * @param hash
     * @param key
     * @return
     */
    private Node<K, V> getNode(int hash, Object key) {
        Node<K, V>[] tab;
        Node<K, V> first, e;
        int n;
        K k;
        // 判断桶不为null，桶不为空，同时hash值对应的第一个节点不为空
        if ((tab = tables) != null && (n = tab.length) > 0 && (first = tab[hash & (n - 1)]) != null) {
            // 当hash值与key都为第一个时，直接返回第一个
            if (hash == first.hash && ((k = first.key) == key || (key != null && key.equals(k)))) {
                return first;
            }
            // 如果next为null 不存在
            if ((e = first.next) != null) {
                // 1.8这里需要判断是否为数，这里简化
                do {
                    // 找到相同直接返回
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        return e;
                    }
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        return getNode(hash(key), key) != null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    /**
     * 遍历的方法
     *
     * @return
     */
    @Override
    public Set<K> keySet() {
        Set<K> ks = new HashSet<>();
        Node<K, V>[] tab;
        Node<K, V> e;
        int n;
        // 如果table 为null 或者 tab桶为空  或者 元素也为0 就直接返回
        if ((tab = tables) != null && (n = tab.length) > 0 && size > 0) {
            for (int i = 0; i < n; i++) {
                if ((e = tab[i]) != null) {
                    // 当e.next 不会空时需要循环遍历
                    if (e.next != null) {
                        do {
                            ks.add(e.key);
                        } while ((e = e.next) != null);
                    } else {
                        // 只有一个元素
                        ks.add(e.key);
                    }
                }
            }
        }
        return ks;
    }

    /**
     * 清空元素列表
     */
    @Override
    public void clear() {
        Node<K, V>[] tab;
        int n;
        if ((tab = tables) != null && (n = tab.length) > 0) {
            size = 0;
            for (int i = 0; i < n; i++) {
                tab[i] = null;
            }
        }
    }

    /**
     * 删除元素
     *
     * @param key
     * @return
     */
    @Override
    public V remove(Object key) {
        Node<K, V> p;
        return (p = removeNode(hash(key), key)) == null ? null : p.value;
    }

    private Node<K, V> removeNode(int hash, Object key) {
        Node<K, V>[] tab;
        // hash值对应的第一个节点
        Node<K, V> p;
        // n为桶的长度，index为hash值对应桶的索引
        int n, index;
        // 只有当桶不为null且不为空，同时hash对应的的第一个节点也不为null才会进行移除
        if ((tab = tables) != null && (n = tab.length) > 0 && (p = tab[index = hash & (n - 1)]) != null) {
            Node<K, V> node = null, e;
            K k;
            // 刚好第一个为当前
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                node = p;
            } else if ((e = p.next) != null) {
                // 1.8这里还需要判断是否为树节点，这里简化
                // 当第一个不是时，e指向p的next节点
                do {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        // 查找到相同时，node直线e节点突出
                        node = e;
                        break;
                    }
                    // p 向下移动一个节点也就是指向e
                    p = e;
                } while ((e = e.next) != null);
            }
            // 说明找到了需要删除的节点
            if (node != null) {
                // 如果删除的正好是第一个节点
                if (node == p) {
                    tab[index] = p.next;
                } else {
                    // 如果不是第一个节点
                    p.next = node.next;
                }
                --size;
                return node;
            }
        }
        return null;
    }

    /**
     * 节点类
     *
     * @param <K>
     * @param <V>
     */
    static class Node<K, V> implements Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?, ?> node = (Node<?, ?>) o;
            return Objects.equals(key, node.key) && Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
