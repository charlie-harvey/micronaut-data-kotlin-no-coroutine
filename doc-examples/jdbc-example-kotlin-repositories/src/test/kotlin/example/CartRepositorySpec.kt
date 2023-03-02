package example

import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

@MicronautTest
class CartRepositorySpec(private val cartRepository: CartRepository) {

    @Test
    fun testCrud() {
        val cart = cartRepository.save(
            Cart(items = listOf(CartItem(name = "Food"), CartItem(name = "Drinks")))
        )
        assertNotNull(cart.id)
        assertNotNull(cart.items)
        assertEquals(2, cart.items.size)
        assertNotNull(cart.items[0].id)
        assertNotNull(cart.items[1].id)
        val cart2 = cartRepository.findById(cart.id!!)
        assertNotNull(cart2)
        assertNotNull(cart2!!.id)
        assertNotNull(cart2.items)
        assertEquals(2, cart2.items.size)
        assertNotNull(cart2.items[0].id)
        assertNotNull(cart2.items[1].id)
        assertEquals("Food", cart2.items[0].name)
        assertEquals("Drinks", cart2.items[1].name)
    }
}
