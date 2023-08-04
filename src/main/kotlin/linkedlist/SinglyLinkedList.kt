package linkedList

data class LLNode<T>(
    val data: T,
    var next: LLNode<T>? = null
)

data class SinglyLinkedList<T>(
    var head: LLNode<T>? = null
) : LinkedList<T> {

    override fun push(data: T) {
        val oldHead = this.head
        this.head = LLNode(data, oldHead)
    }

    override fun pop() =
        when (this.head) {
            null -> null
            else -> {
                val current = this.head
                this.head = head!!.next
                current?.data
            }
        }

    override fun popTail(): T? {
        // there are no nodes
        if (this.head == null) {
            return null
        }

        var current = this.head!!

        // there is only one node
        if (current.next == null) {
            this.head = null
            return current.data
        }

        // there is more than one node
        var previous = current
        current = current.next!!

        while (current.next != null) {
            previous = current
            current = current.next!!
        }

        previous.next = null
        return current.data
    }

    override fun peek() = this.head?.data

    fun tail(): T? {
        var current = this.head

        while (current != null) {
            when (current.next) {
                null -> return current.data
                else -> current = current.next
            }
        }
        return null
    }

    override fun isEmpty() = this.head == null

    override fun length(): Int {
        var current = this.head
        var count = 0

        while (current != null) {
            count++
            current = current.next
        }
        return count
    }

    fun contains(value: T): Boolean {
        var current = this.head
        while (current != null) {
            if (current.data == value) {
                return true
            } else {
                current = current.next
            }
        }
        return false
    }

    fun remove(value: T) {
        var current = this.head
        var prev: LLNode<T>? = null

        while (current != null) {
            if (current.data == value) {
                if (prev == null) {
                    this.head = current.next
                } else {
                    prev.next = current.next
                }
                return
            }
            prev = current
            current = current.next
        }
    }

    fun getAtIndex(idx: Int): T? {
        var current = this.head
        var n = 0

        while (current != null) {
            if (n == idx) {
                return current.data
            } else {
                current = current.next
                n++
            }
        }
        return null
    }
}