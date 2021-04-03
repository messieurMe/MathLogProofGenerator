//var = PrintWriter("D:\\hello.txt")

class FinishHim {
    companion object {
        
        //Why we still here?
        //Just to suffer
        //©...I'll remember, I promise
        private fun suffer(steps: Triple<java.util.ArrayList<Int>, java.util.ArrayList<Int>, java.util.ArrayList<Int>>) {
            if (!allIsBad) {
                for (i in steps.first) {
                    val expression: Int = use(
                        FinalExpression(
                            "->",
                            if ((i and 1) != 0) hyposC else hyposC, use(
                                FinalExpression(
                                    "->",
                                    if ((i and 2) != 0) hyposB else nhyposB,
                                    use(
                                        FinalExpression(
                                            "->",
                                            if ((i and 4) != 0) hyposA else nhyposA,
                                            sentence
                                        )
                                    )
                                )
                            )
                        )
                    )
                    if (hypos.contains(hyposC)) {
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherH"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
                            //printlnln(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())
                        }
                    } else {
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherA"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())

                        }
                    }
                }

                for (i in steps.second) {
                    val expression = use(
                        (FinalExpression(
                            "->",
                            if ((i and 2) != 0) hyposB else hyposB,
                            use(FinalExpression("->", if ((i and 4) != 0) hyposA else nhyposA, sentence))
                        ))
                    )
                    if (hypos.contains(hyposB)) {
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherH"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())
                        }
                    } else {
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherA"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())

                        }

                    }
                }

                for (i in steps.third) {
                    val expression = use((FinalExpression("->", if ((i and 4) != 0) hyposA else hyposA, sentence)))
                    if (hypos.contains(hyposA)) {
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherH"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())

                        }

                    } else {


                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherA"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())

                        }

                    }
                }
            } else {
                for (i in steps.first) {
                    var expression = use(
                        FinalExpression(
                            "->",
                            if ((i and 1) == 0) hyposC else hyposC,
                            use(
                                FinalExpression(
                                    "->",
                                    if ((i and 2) != 0) hyposB else nhyposB,
                                    use(FinalExpression("->", if ((i and 4) != 0) hyposA else nhyposA, sentence))
                                )
                            )
                        )
                    )
                    if (hypos.contains(nhyposC)) {
                        expression = use(
                            FinalExpression(
                                "->",
                                if ((i and 1) == 0) nhyposC else nhyposC,
                                use(
                                    FinalExpression(
                                        "->",
                                        if ((i and 2) != 0) hyposB else nhyposB,
                                        use(FinalExpression("->", if ((i and 4) != 0) hyposA else nhyposA, sentence))
                                    )
                                )
                            )
                        )
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherH"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())

                        }
                    } else {
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherA"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())
                        }
                    }
                }

                for (i in steps.second) {
                    var expression = use(
                        (FinalExpression(
                            "->",
                            if ((i and 2) == 0) hyposB else hyposB,
                            use(FinalExpression("->", if ((i and 4) != 0) hyposA else nhyposA, sentence))
                        ))
                    )
                    if (hypos.contains(nhyposB)) {
                        expression = use(
                            (FinalExpression(
                                "->",
                                if ((i and 2) == 0) nhyposB else nhyposB,
                                use(FinalExpression("->", if ((i and 4) != 0) hyposA else nhyposA, sentence))
                            ))
                        )
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherH"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())
                        }
                    } else {
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherA"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())
                        }
                    }
                }
                for (i in steps.third) {
                    var expression = use((FinalExpression("->", if ((i and 4) == 0) hyposA else hyposA, sentence)))
                    if (hypos.contains(nhyposA)) {
                        expression = use((FinalExpression("->", if ((i and 4) == 0) nhyposA else nhyposA, sentence)))
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherH"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().op)
                            //printlnln(it.getEx().stringView())
                        }
                    } else {
                        val method = methhodOne.javaClass.methods.find {
                            it.annotations.isNotEmpty()
                                    && it.annotations[0].annotationClass == NewProof::class
                                    && it.getAnnotation(NewProof::class.java).op == "FinisherA"
                        }
                        (method!!.invoke(methhodOne, expression) as ArrayList<Int>).forEach {
//                            println(it.getEx().stringView())
                            //printlnln(it.getEx().stringView())

                        }
                    }
                }
            }
        }


        var hyposA = 0
        var hyposB = 0
        var hyposC = 0
        var nhyposA = 0
        var nhyposB = 0

        var nhyposC = 0


        fun fin() {
            printOrNot = true
            val steps = Triple<ArrayList<Int>, ArrayList<Int>, ArrayList<Int>>(ArrayList(), ArrayList(), ArrayList())
            val parser = FinalParser()
            hyposA = use(parser.parse(ourA!!))
            hyposB = use(parser.parse(ourB!!))
            hyposC = use(parser.parse(ourC!!))
            nhyposA = use(parser.parse("!$ourA"))
            nhyposB = use(parser.parse("!$ourB"))
            nhyposC = use(parser.parse("!$ourC"))

            for (i in 0 until 8) {
//                println(allIsBad)
                if (!allIsBad) {
                    if (((i and 4) == 0 && hypos.contains(hyposA))) continue
                    if (((i and 2) == 0 && hypos.contains(hyposB))) continue
                    if (((i and 1) == 0 && hypos.contains(hyposC))) continue
                } else {
                    if (toBool(i and 4) && hypos.contains(nhyposA)) continue
                    if (toBool(i and 2) && hypos.contains(nhyposB)) continue
                    if (toBool(i and 1) && hypos.contains(nhyposC)) continue
                }
                steps.first.add(i)
            }
            steps.first.forEach { if (!steps.second.contains(it)) steps.second.add(it) }
            steps.second.forEach { if (!steps.third.contains(it)) steps.third.add(it) }
            suffer(steps)
        }
    }
}
