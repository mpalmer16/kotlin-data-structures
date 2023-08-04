package linkedlist

import org.junit.jupiter.api.Test

class DoublyLinkedListTests {

    @Test
    fun `create a doubly linked list`() {
        val dll = DoublyLinkedList<Int>()

        assert(dll.head == null)
        assert(dll.tail == null)
    }

    @Test
    fun `push data`() {
        val dll = DoublyLinkedList<Int>()

        dll.push(123)

        assert(dll.head!!.data == 123)
        assert(dll.tail!!.data == 123)

        dll.push(456)

        assert(dll.tail!!.data == 456)
        assert(dll.head!!.data == 123)
        assert(dll.head!!.next!!.data == 456)
    }

    @Test
    fun pop() {
        val dll = createDoublyLinkedList()

        val expected = 1011
        val actual = dll.pop()

        assert(actual == expected)
    }

    @Test
    fun `remove a value`() {
        val dll = createDoublyLinkedList()
        assert(dll.length() == 4)

        dll.remove(456)

        assert(dll.length() == 3)
    }

    @Test
    fun `pop tail`() {
        val dll = createDoublyLinkedList()

        val expected = 123
        val actual = dll.popTail()

        assert(actual == expected)
    }

    private fun createDoublyLinkedList(values: List<Int> = listOf(123, 456, 789, 1011)) =
        DoublyLinkedList<Int>().apply {
            values.forEach { value -> this.push(value) }
        }
}