fun startThisHell() {
    val weWere = HashSet<String>()
    for (i in 0 until 8) {
        expressionMark.clear()
        if (!allIsBad) {
            if (ourA != null) expressionMark[ourA!!] = (toBool(i and 4) || hypos.contains(use(pp.parse(ourA!!))))
            if (ourB != null) expressionMark[ourB!!] = (toBool(i and 2) || hypos.contains(use(pp.parse(ourB!!))))
            if (ourC != null) expressionMark[ourC!!] = (toBool(i and 1) || hypos.contains(use(pp.parse(ourC!!))))
            val s =
                "" + expressionMark[ourA].toString() + expressionMark[ourB].toString() + expressionMark[ourC].toString()
            if (weWere.contains(s)) {
                continue
            } else {
                weWere.add(s)
            }
        } else {
            if (ourA != null) expressionMark[ourA!!] = (toBool(i and 4) && !hypos.contains(use(pp.parse("!$ourA"))))
            if (ourB != null) expressionMark[ourB!!] = (toBool(i and 2) && !hypos.contains(use(pp.parse("!$ourB"))))
            if (ourC != null) expressionMark[ourC!!] = (toBool(i and 1) && !hypos.contains(use(pp.parse("!$ourC"))))

            val s =
                "" + expressionMark[ourA].toString() + expressionMark[ourB].toString() + expressionMark[ourC].toString()
            if (weWere.contains(s)) {
                continue
            } else {
                weWere.add(s)
            }
        }
        createProve(sentence)

        Sherlock().startDeduction(
            Triple(expressionMark[ourA], expressionMark[ourB], expressionMark[ourC])
        )
        fullProof.clear()
        ahSheetHereWeGoAgain()
    }


}

var fullProof = ArrayList<Int>()
var expressionMark = HashMap<String, Boolean>()

var depth = 0

fun createProve(expr: Int): Boolean {
    when (getExpressionType(expr.getEx())) {
        FinalExpressionType.Variable -> {
            var negExpr = expr
            if (expressionMark[expr.getEx().stringView()]!!) {
                fullProof.add(expr)
                while (depth > 0) {
                    val method = methhodOne.javaClass.methods.find {
                        it.annotations.isNotEmpty() && it.annotations[0].annotationClass == NewProof::class
                                && it.getAnnotation(NewProof::class.java).op == "DoubleNeg"
                    }
//                    var method = allMethods["DoubleNeg"]
                    fullProof.addAll(method!!.invoke(methhodOne, negExpr) as ArrayList<Int>)
                    negExpr = use(FinalExpression("!", use(FinalExpression("!", negExpr, null)), null))
                    depth -= 2
                }
            } else {
                depth--
                negExpr = use(FinalExpression("!", negExpr, null))
                while (depth > 0) {
                    val method = methhodOne.javaClass.methods.find {
                        it.annotations.isNotEmpty() && it.annotations[0].annotationClass == NewProof::class
                                &&
                                it.getAnnotation(NewProof::class.java).op == "DoubleNeg"
                    }
//                    var method = allMethods["DoubleNeg"]
                    fullProof.addAll(method!!.invoke(methhodOne, negExpr) as ArrayList<Int>)
                    negExpr = use(FinalExpression("!", use(FinalExpression("!", negExpr, null)), null))
                    depth -= 2
                }
            }
            depth = 0
            return expressionMark[expr.getEx().op]!!
        }

        FinalExpressionType.UnaryExpression -> {
            depth++
            return !createProve(expr.getEx().l!!)
        }

        FinalExpressionType.BinaryExpression -> {
            var ourDepth = depth.also { depth = 0 }
            var inFinalEx = expr
            val leftMark = createProve(inFinalEx.getEx().l!!)
            val rightMark = createProve(inFinalEx.getEx().r!!)

            val yaUstal = when (inFinalEx.getEx().op) {
                "|" -> (leftMark || rightMark)
                "&" -> (leftMark && rightMark)
                "->" -> ((!leftMark) || rightMark)
                else -> throw Exception()
            }

            if (!yaUstal) {
                inFinalEx = use(FinalExpression("!", inFinalEx, null))
                ourDepth--
            }

            var method = methhodOne.javaClass.methods.find {
                it.annotations.isNotEmpty() && it.annotations[0].annotationClass == NewProof::class
                        && it.getAnnotation(NewProof::class.java).op == expr.getEx().op
                        && it.getAnnotation(NewProof::class.java).left == leftMark.toString()
                        && it.getAnnotation(NewProof::class.java).right == rightMark.toString()
            }
//            var method = allMethods[expr.getEx().op + leftMark.toString() + rightMark.toString()]
            fullProof.addAll(method!!.invoke(methhodOne, expr) as ArrayList<Int>)

            if (ourDepth != 0) {
                var doubleNegExpression = inFinalEx
                while (ourDepth > 0) {
                    method = methhodOne.javaClass.methods.find {
                        it.annotations.isNotEmpty() && it.annotations[0].annotationClass == NewProof::class
                                && it.getAnnotation(NewProof::class.java).op == "DoubleNeg"
//                                && it.getAnnotation(NewProof::class.java).left == leftMark.toString()
//                                && it.getAnnotation(NewProof::class.java).right == rightMark.toString()
                    }
//                    var method = allMethods["DoubleNeg"]
                    fullProof.addAll(method!!.invoke(methhodOne, doubleNegExpression) as ArrayList<Int>)
                    doubleNegExpression = use(
                        FinalExpression("!", use(FinalExpression("!", doubleNegExpression, null)), null)
                    )
                    ourDepth -= 2
                }
            }
            depth = 0
            return when (expr.getEx().op) {
                "|" -> (leftMark || rightMark)
                "&" -> (leftMark && rightMark)
                "->" -> ((!leftMark) || rightMark)
                else -> throw Exception()
            }
        }
        else -> throw Exception()
    }
}


fun getExpressionType(expr: FinalExpression?): FinalExpressionType {
    if (expr == null) return FinalExpressionType.EmptyExpression
    if (expr.l == null) return FinalExpressionType.Variable
    if (expr.r == null) return FinalExpressionType.UnaryExpression
//    if (expr.op == "@" || expr.op == "?") return FinalExpressionType.Predicate
    return FinalExpressionType.BinaryExpression
}
