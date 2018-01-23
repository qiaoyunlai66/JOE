package com.joe.qiao.datastructure;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author Joe Qiao
 * @ 07/01/2018.
 */
public class HashMapStructure<K,V> extends HashMap{

    /**
     * The default initial capacity - MUST be a power of two.
     * 默认的初始容量为16，必须是2的幂次
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    /**
     * The maximum capacity, used if a higher value is implicitly specified
     * by either of the constructors with arguments.
     * MUST be a power of two <= 1<<30.
     * 最大容量即2的30次方
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * The load factor used when none specified in constructor.
     * 默认加载因子
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * The bin count threshold for using a tree rather than list for a
     * bin.  Bins are converted to trees when adding an element to a
     * bin with at least this many nodes. The value must be greater
     * than 2 and should be at least 8 to mesh with assumptions in
     * tree removal about conversion back to plain bins upon
     * shrinkage.
     * 当put一个元素时，其链表长度达到8时将链表转换为红黑树
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * The bin count threshold for untreeifying a (split) bin during a
     * resize operation. Should be less than TREEIFY_THRESHOLD, and at
     * most 6 to mesh with shrinkage detection under removal.
     * 链表长度小于6时，解散红黑树
     */
    static final int UNTREEIFY_THRESHOLD = 6;

    /**
     * The smallest table capacity for which bins may be treeified.
     * (Otherwise the table is resized if too many nodes in a bin.)
     * Should be at least 4 * TREEIFY_THRESHOLD to avoid conflicts
     * between resizing and treeification thresholds.
     * 默认的最小的扩容量64，为避免重新扩容冲突，至少为4 * TREEIFY_THRESHOLD=32，即默认初始容量的2倍
     */
    static final int MIN_TREEIFY_CAPACITY = 64;

    /**
     * Basic hash bin node, used for most entries.  (See below for
     * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
     * 它实现了Map.Entry接口。其内部的变量含义也很明确，hash值、key\value对和实现链表和红黑树所需要的指针索引。
     */
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        HashMapStructure.Node<K,V> next;

        Node(int hash, K key, V value, HashMapStructure.Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

    /**
     * @transient 在HashMap内部定义的几个变量，包括桶数组本身都是transient修饰的，
     * 这代表了他们无法被序列化，而HashMap本身是实现了Serializable接口的。这很容易产生疑惑：
     * HashMap是如何序列化的呢？查了一下源码发现，HashMap内有两个用于序列化的函数 
     * @see java.util.HashMap#readObject(ObjectInputStream) 和 {@link #writeObject(ObjectOutputStream)}
     * 通过这个函数将table序列化。
     */

    /**
     * The table, initialized on first use, and resized as
     * necessary. When allocated, length is always a power of two.
     * (We also tolerate length zero in some operations to allow
     * bootstrapping mechanics that are currently not needed.)
     * HashMap的哈希桶数组，非常重要的存储结构，用于存放表示键值对数据的Node元素。
     */
    transient Node<K,V>[] table;

    /**
     * Holds cached entrySet(). Note that AbstractMap fields are used
     * for keySet() and values().
     * HashMap将数据转换成set的另一种存储形式，这个变量主要用于迭代功能。
     */
    transient Set<Map.Entry<K,V>> entrySet;

    /**
     * The number of key-value mappings contained in this map.
     * HashMap中实际存在的Node数量，注意这个数量不等于table的长度，甚至可能大于它，
     * 因为在table的每个节点上是一个链表（或RBT）结构，可能不止有一个Node元素存在。
     */
    transient int size;

    /**
     * The number of times this HashMap has been structurally modified
     * Structural modifications are those that change the number of mappings in
     * the HashMap or otherwise modify its internal structure (e.g.,
     * rehash).  This impl is used to make iterators on Collection-views of
     * the HashMap fail-fast.  (See ConcurrentModificationException).
     * HashMap的数据被修改的次数，这个变量用于迭代过程中的Fail-Fast机制，其存在的意义在
     * 于保证发生了线程安全问题时，能及时的发现（操作前备份的count和当前modCount不相等）并抛出异常终止操作。
     */
    transient int modCount;

    /**
     * The next size value at which to resize (capacity * load factor).
     * HashMap的扩容阈值，在HashMap中存储的Node键值对超过这个数量时，自动扩容容量为原来的二倍。
     *
     * @serial
     */
    // (The javadoc description is true upon serialization.
    // Additionally, if the table array has not been allocated, this
    // impl holds the initial array capacity, or zero signifying
    // DEFAULT_INITIAL_CAPACITY.)
    int threshold;

    /**
     * The load factor for the hash table.
     * HashMap的负载因子，可计算出当前table长度下的扩容阈值：threshold = loadFactor * table.length。
     *
     * @serial
     */
    final float loadFactor = 0f;

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the map
     *         previously associated <tt>null</tt> with <tt>key</tt>.)
     * @desc both methods have same erasure, yet neither overrides the other。
     *
     * 直接调用这个方法： 
     * @see HashMapStructure#putVal(int, Object, Object, boolean, boolean)
     * both methods have same erasure, yet neither overrides the other
     * 这个错误的意思是，两个方法在类型擦除后，具有相同的原生类型参数列表，但是也不能覆盖另一个方法。
     * 泛型类型在编译后，会做类型擦除，只剩下原生类型。如参数列表中的T类型会编译成Object，但是会有一个Signature。
     * 尽管两个test方法具有相同的字节码，但是类型参数信息用 一个新的签名（signature） 属性记录在类模式中。
     * JVM 在装载类时记录这个签名信息，并在运行时通过反射使它可用。这就导致了这个方法既不能作为覆盖父类test方法的方法，也不能作为test方法的重载。
     */
     @Override
     public V put(Object key,Object value) {
       return (V) super.put(key,value);
     }

    /**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash
     * to lower.  Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
     * 这里通过key.hashCode()计算出key的哈希值，然后将哈希值h右移16位，
     * 再与原来的h做异或^运算——这一步是高位运算。设想一下，如果没有高位运算，
     * 那么hash值将是一个int型的32位数。而从2的-31次幂到2的31次幂之间，有将近几十亿的空间，
     * 如果我们的HashMap的table有这么长，内存早就爆了。所以这个散列值不能直接用来最终的取模运算，
     * 而需要先加入高位运算，将高16位和低16位的信息"融合"到一起，也称为"扰动函数"。
     * 这样才能保证hash值所有位的数值特征都保存下来而没有遗漏，从而使映射结果尽可能的松散。
     * 最后，根据 n-1 做与操作的取模运算。这里也能看出为什么HashMap要限制table的长度为2的n次幂，
     * 因为这样，n-1可以保证二进制展示形式是（以16为例）0000 0000 0000 0000 0000 0000 0000 1111。
     * 在做"与"操作时，就等同于截取hash二进制值得后四位数据作为下标。这里也可以看出"扰动函数"的重要性了，
     * 如果高位不参与运算，那么高16位的hash特征几乎永远得不到展现，发生hash碰撞的几率就会增大，从而影响性能。
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
     
    /**
     * Implements Map.put and related methods
     * 
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     *                     这里onlyIfAbsent表示只有在该key对应原来的value为null的时候才插入，
     *                     也就是说如果value之前存在了，就不会被新put的元素覆盖。
     * @param evict if false, the table is in creation mode.
     *              evict参数用于LinkedHashMap中的尾部操作，这里没有实际意义。
     * @return previous value, or null if none
     * 
     * 
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i; //定义变量tab是将要操作的Node数组引用，p表示tab上的某Node节点，n为tab的长度，i为tab的下标。
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;//判断当table为null或者tab的长度为0时，即table尚未初始化，此时通过resize()方法得到初始化的table。
        if ((p = tab[i = (n - 1) & hash]) == null)
            /**此处通过（n - 1） & hash 计算出的值作为tab的下标i，并另p表示tab[i]，也就是该链表第一个节点的位置。并判断p是否为null
             当p为null时，表明tab[i]上没有任何元素，那么接下来就new第一个Node节点，调用newNode方法返回新节点赋值给tab[i]。*/
            tab[i] = newNode(hash, key, value, null);
        else {
            /**
             * 下面进入p不为null的情况，有三种情况：p为链表节点；p为红黑树节点；p是链表节点但长度为临界长度
             * @see TREEIFY_THRESHOLD，再插入任何元素就要变成红黑树了。
             * 定义e引用即将插入的Node节点，并且下文可以看出 k = p.key
             */
            Node<K,V> e; K k;
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                /**HashMap中判断key相同的条件是key的hash相同，并且符合equals方法。这里判断了p.key是否和插入的key相等，如果相等，则将p的引用赋给e。
                这里为什么要把p赋值给e，而不是直接覆盖原值呢？答案很简单，现在我们只判断了第一个节点，后面还可能出现key相同，所以需要在最后一并处理。*/
                e = p;
            //else if (p instanceof TreeNode)
                /**现在开始了第一种情况，p是红黑树节点，那么肯定插入后仍然是红黑树节点，所以我们直接强制转型p后调用TreeNode.putTreeVal方法，返回的引用赋给e。
                你可能好奇，这里怎么不遍历tree看看有没有key相同的节点呢？其实，putTreeVal内部进行了遍历，存在相同hash时返回被覆盖的TreeNode，否则返回null*/
              //  e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                /**接下里就是p为链表节点的情形，也就是上述说的另外两类情况：插入后还是链表/插入后转红黑树。另外，上行转型代码也说明了TreeNode是Node的一个子类。*/
                for (int binCount = 0; ; ++binCount) {
                    /**我们需要一个计数器来计算当前链表的元素个数，并遍历链表，binCount就是这个计数器*/
                    if ((e = p.next) == null) {
                       /** 遍历过程中当发现p.next为null时，说明链表到头了，直接在p的后面插入新的链表节点，即把新节点的引用赋给p.next，插入操作就完成了.
                         注意此时e赋给p。最后一个参数为新节点的next，这里传入null，保证了新节点继续为该链表的末端。*/
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        /**插入成功后，要判断是否需要转换为红黑树，因为插入后链表长度加1，而binCount并不包含新节点，所以判断时要将临界阈值减1。
                         当新长度满足转换条件时，调用treeifyBin方法，将该链表转换为红黑树。当然如果不满足转换条件，那么插入数据后结构也无需变动
                         ，所有插入操作也到此结束了，break退出即可*/
                            //         treeifyBin(tab, hash);
                        break;
                    }
                    /**在遍历链表的过程中，我之前提到了，有可能遍历到与插入的key相同的节点，此时只要将这个节点引用赋值给e，
                     * 最后通过e去把新的value覆盖掉就可以了。*/
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        /**老样子判断当前遍历的节点的key是否相同。找到了相同key的节点，那么插入操作也不需要了，直接break退出循环进行最后的value覆盖操作。 */
                        break;
                    /**e是当前遍历的节点p的下一个节点，p = e 就是依次遍历链表的核心语句。每次循环时p都是下一个node节点。*/
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                /**左边注释为jdk自带注释，说的很明白了，针对已经存在key的情况做处理。*/
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    /**前面提到，onlyIfAbsent表示存在key相同时不做覆盖处理，这里作为判断条件，可以看出当onlyIfAbsent为false或者oldValue为null时，进行覆盖操作。*/
                    e.value = value;
                    /**这个函数在hashmap中没有任何操作，是个空函数，他存在主要是为了linkedHashMap的一些后续处理工作。*/
             //   afterNodeAccess(e);
                return oldValue;
               /** 这里很有意思，他返回的是被覆盖的oldValue。我们在使用put方法时很少用他的返回值，甚至忘了它的存在，这里我们知道，他返回的是被覆盖的oldValue。*/
            }
        }
        /**收尾工作，值得一提的是，对key相同而覆盖oldValue的情况，在前面已经return，不会执行这里，所以那一类情况不算数据结构变化，并不改变modCount值。*/
        ++modCount;
        if (++size > threshold)
            /**同理，覆盖oldValue时显然没有新元素添加，除此之外都新增了一个元素，这里++size并与threshold判断是否达到了扩容标准。
             * 当HashMap中存在的node节点大于threshold时，hashmap进行扩容。*/
            resize();
            /**这里与前面的afterNodeAccess同理，是用于linkedHashMap的尾部操作，HashMap中并无实际意义。*/
      //  afterNodeInsertion(evict);
        return null;
    }

    /**
     * Initializes or doubles table size.  If null, allocates in
     * accord with initial capacity target held in impl threshold.
     * Otherwise, because we are using power-of-two expansion, the
     * elements from each bin must either stay at same index, or move
     * with a power of two offset in the new table.
     *
     * @return the table
     */
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
              //      else if (e instanceof TreeNode)
                //        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

    // Create a regular (non-tree) node
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
    }
    
}
