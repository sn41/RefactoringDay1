package org.example



fun main() {
    fun process(p: List<String>, a: Double, d: Boolean) {
        var t = 0.0
        for (i in p) {
            if (i == "Phone") {
                t += 500.0
            } else if (i == "Laptop") {
                t += 1200.0
            } else {
                t += 10.0
            }
        }

        if (t > 1000) {
            t = t - (t * 0.1)
        }

        if (d) {
            t += 50.0
        }

        println("Items: " + p)
        println("Total sum: " + t)

        // Сохранение в "базу данных"
        println("Saving to DB...")
    }
}