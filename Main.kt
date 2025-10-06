
package tp14_1

suspend fun verifierDisponibilite() {
    print("Verification en cours)
    delay(2000)
    println(" disponibles")
}

suspend fun preparerCommandes() {
    print("Preparation de commande")
    delay(5000)
    println(" disponibles")
}

suspend fun livrerRepas() = withContext(Dispatchers.IO) {
    println("Livraison en cours")
    delay(3000)
    println(" disponibles")
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        val deferred1 = async { verifierDisponibilite() }
        val deferred2 = async { preparerCommandes() }
        val deferred3 = async { livrerRepas() }
        deferred1.await()
        deferred2.await()
        deferred3.await()
    }
    println("les operations terminees en $time ms")
}