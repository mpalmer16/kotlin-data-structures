package linkedlist

import org.junit.jupiter.api.Test

class SinglyLinkedListTests {

    @Test
    fun `create a linked list`() {
        val sll = SinglyLinkedList<Int>()
        assert(sll.head == null)

        sll.head = LLNode(123)
        assert(sll.head!!.data == 123)
    }

    @Test
    fun `empty list functions`() {
        val sll = SinglyLinkedList<Int>()

        assert(sll.pop() == null)
        assert(sll.tail() == null)
    }

    @Test
    fun `push values`() {
        val sll = SinglyLinkedList(
            LLNode(
                123
            )
        )

        sll.push(456)

        assert(sll.head!!.data == 456)
    }

    @Test
    fun `pop a value`() {
        val sll = createLinkedList()

        val expected = 1011
        val actual = sll.pop()

        assert(actual == expected)
        assert(sll.head!!.data == 789)
    }

    @Test
    fun `get the tail`() {
        val sll = createLinkedList()

        val expected = 123
        val actual = sll.tail()

        assert(actual == expected)
    }

    @Test
    fun `get the length`() {
        val sll = createLinkedList()

        val expected = 4
        val actual = sll.length()

        assert(actual == expected)
    }

    @Test
    fun `find an element`() {
        val sll = createLinkedList()

        assert(sll.length() == 4)
        assert(sll.tail() == 123)

        assert(!sll.contains(0))
        assert(sll.contains(456))
    }

    @Test
    fun `remove an element`() {
        val sll = createLinkedList()
        assert(sll.length() == 4)

        sll.remove(789)

        assert(sll.length() == 3)
        assert(sll.tail() == 123)
    }

    @Test
    fun `get value at index`() {
        val sll = createLinkedList()

        val expectedIndexOne = 789
        val actualIndexOne = sll.getAtIndex(1)

        assert(actualIndexOne == expectedIndexOne)

        val expectedIndexTwo = 456
        val actualIndexTwo = sll.getAtIndex(2)

        assert(actualIndexTwo == expectedIndexTwo)
    }

    @Test
    fun `pop tail`() {
        val sll = createLinkedList()

        val expected = 123
        val actual = sll.popTail()

        assert(actual == expected)
    }

    private fun createLinkedList(values: List<Int> = listOf(123, 456, 789, 1011)) =
        SinglyLinkedList<Int>().apply {
            values.forEach { value -> this.push(value) }
        }
}