package linkedlist

data class DLLNode<T>(
    val data: T,
    var prev: DLLNode<T>? = null,
    var next: DLLNode<T>? = null,
)

data class DoublyLinkedList<T>(
    var head: DLLNode<T>? = null,
    var tail: DLLNode<T>? = null,
) : LinkedList<T> {

    override fun length(): Int {
        var current = this.head
        var count = 0

        while (current != null) {
            count++
            current = current.next
        }
        return count
    }

    override fun peek() = this.tail?.data

    override fun push(data: T) {
        val newNode = DLLNode(data)

        if (this.head == null) {
            this.head = newNode
            this.tail = newNode
        } else {
            this.tail!!.next = newNode
            newNode.prev = this.tail
            this.tail = newNode
        }
    }

    override fun pop(): T? {
        if (tail == null) {
            return null
        }

        val value = tail?.data

        if (head == tail) {
            head = null
            tail = null
        } else {
            val prevNode = tail?.prev
            prevNode?.next = null
            tail = prevNode
        }

        return value
    }

    override fun popTail(): T? {
        // there are no nodes
        if (head == null) {
            return null
        }

        val data = head!!.data

        // there is only one node
        if (head!!.next == null) {
            head = null
            tail = null
        } else {
            // there is more than one node
            head = head!!.next
        }

        return data
    }

    override fun isEmpty() = this.head == null

    fun remove(data: T) {
        var current = this.head
        var previous: DLLNode<T>? = null

        while (current != null) {
            if (current.data == data) {
                if (previous == null) {
                    this.head = current.next
                } else {
                    previous.next = current.next
                }
            }
            previous = current
            current = current.next
        }
    }
}



