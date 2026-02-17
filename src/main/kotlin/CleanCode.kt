package org.example

data class Item(val name: String, val price: Double)

data class Order(
    val items: List<Item>,
    val hasDelivery: Boolean = false
)

class OrderProcessor {
    companion object {
        const val DISCOUNT_THRESHOLD = 1000.0
        const val DISCOUNT_RATE = 0.1
        const val DELIVERY_FEE = 50.0
    }

    fun processOrder(order: Order) {
        val baseTotal = order.items.sumOf { it.price }
        val finalTotal = calculateFinalPrice(baseTotal, order.hasDelivery)

        printSummary(order.items, finalTotal)
        saveToDatabase()
    }

    private fun calculateFinalPrice(base: Double, needsDelivery: Boolean): Double {
        var total = base
        if (total > DISCOUNT_THRESHOLD) {
            total -= total * DISCOUNT_RATE
        }
        if (needsDelivery) {
            total += DELIVERY_FEE
        }
        return total
    }

    private fun printSummary(items: List<Item>, total: Double) {
        println("Order Summary: ${items.joinToString { it.name }}")
        println("Total Amount: $total")
    }

    private fun saveToDatabase() = println("Saving to DB...")
}