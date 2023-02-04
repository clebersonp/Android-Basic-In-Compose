fun main() {
    // :: function reference operator
//    val trickFunction = ::trick
    val trickFunction = trick
    // invocar lambda expression
    trick()
    repeat(4) {
        println("Repeat $it times")
        trickFunction()
    }

    treat()

    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcakes: (Int) -> String = {// pode omitir o nome do parametro se n for utilizar
        "Have a cupcake!"
    }

    val hotdogs: (Int) -> String =
        {// quando so existir um parametro, n precisa nomea-lo, e pode ser acessado atraves da palavra it
            "$it hotdogs"
        }

    val treatFunction = trickOrTreat(false, cupcakes)
    val trickFunction2 = trickOrTreat(true, coins)
    val trickFunction3 = trickOrTreat(false, null)
    val trickFunction4 = trickOrTreat(false, hotdogs)
    val trickFunction5 =
        trickOrTreat(false, { "$it ice creams" }) // passando lambda expression diretamente como argumento

    val trickFunction6 =
    // trailing lambda syntax quando o ultimo parametro for uma function
        // The composable functions that you used to declare your UI take functions as parameters and are typically called using trailing lambda syntax.
        trickOrTreat(false) { "$it candy" }


}


// function q retorna outra function, passando uma function como parametro que posse ser nullable com (function)?
fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        println(extraTreat?.invoke(5) ?: "has no function to perform")
    }
    return treat
}

// tudo depois do = e expression lambda
val trick = {
    println("no treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}