package linkedlist

interface LinkedList<T> {
    fun push(data: T)
    fun pop(): T?
    fun popTail(): T?
    fun peek(): T?
    fun isEmpty(): Boolean
    fun length(): Int
}