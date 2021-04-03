import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

//!!A->C|B&!A&B->C->!!!!!C->C|B&A
class Sherlock {
    var forSomeCases = HashSet<String>()
    private var yepAnotherOne = LinkedList<Int>()

    private var letItBeVar: Int = 0
    fun startDeduction(vars: Triple<Boolean?, Boolean?, Boolean?>) {


        for (anotherVar in vars.toList().indices) {
            val varName = if (anotherVar == 0) ourA!! else if (anotherVar == 1) ourB!! else ourC!!
            if (!vars.toList()[anotherVar]!!) {
                forSomeCases.add(
                    use(FinalExpression("!", use(FinalExpression(varName, null, null)), null)).getEx().stringView()
                )
            } else {
                forSomeCases.add(use(FinalExpression(varName, null, null)).getEx().stringView())
            }
        }
        printOrNot = false
        for (i in vars.toList().indices) {
            if (false) {
                var otchayanie: Array<String>? = Array(fullProof.size) { it -> fullProof[it].getEx().stringView() }
                ahSheetHereWeGoAgain()
                otchayanie!!.forEach { use(pp.parse(it)) }
                use(pp.parse(ourA!!))
                use(pp.parse(ourB!!))
                use(pp.parse(ourC!!))
                use(pp.parse("!$ourA"))
                use(pp.parse("!$ourB"))
                use(pp.parse("!$ourC"))
                otchayanie = null
            }
            var varName = if (i == 0) ourA!! else if (i == 1) ourB!! else ourC!!
            if (!vars.toList()[i]!!) varName = "!$varName"
            forSomeCases.remove(varName)
            if (i == 2) printOrNot = true
            fullProof.forEach { j ->
                if (!weDid.contains(j)) {
                    if (tryHypo(varName, j) || tryAx(varName, j) || tryMP(varName, j)) {
                        letItBeVar = if (!printOrNot) {
                            yepAnotherOne.last.getEx().r!!
                        } else {
                            letItBeVar.getEx().r!!
                        }
                        weDid.add(letItBeVar)
                        if (letItBeVar.getEx().op == "->") {
                            if (!implications.containsKey(letItBeVar.getEx().r)) {
                                implications[letItBeVar.getEx().r!!] = HashSet()
                            }
                            implications[letItBeVar.getEx().r]!!.add(letItBeVar)
                        }
                    } else {
                        throw Exception()
                    }
                }
            }
            implications.clear()
            weDid.clear()
            fullProof.clear()
            fullProof = ArrayList(yepAnotherOne.size)

            if (!printOrNot) {
                yepAnotherOne.forEach {
                    fullProof.add(it)
                }
            }
            yepAnotherOne.clear()

        }
        if(!printOrNot) {
            fullProof.forEach {
                println(it.getEx().stringView())
            }
        }
        printOrNot = false
    }

    var weDid: HashSet<Int> = HashSet()
    var implications: HashMap<Int, HashSet<Int>> = HashMap()

    private fun tryMP(varName: String, j: Int): Boolean {
        var number = -1
        var modusPonus: Int? = null
        if (implications.contains(j)) {
            implications[j]!!.forEach {
                if (weDid.contains(it.getEx().l!!)) {
                    modusPonus = it
                    number++
                }
            }
            if (number > -1) {
                val method = methhodOne.javaClass.methods.find {
                    it.annotations.isNotEmpty() && it.annotations[0].annotationClass == NewProof::class
                            &&
                            it.getAnnotation(NewProof::class.java).op == "DedMP"
                }

//                var method = allMethods["DedMP"]
                if (!printOrNot) {
                    yepAnotherOne.addAll(method!!.invoke(methhodOne, varName, modusPonus) as ArrayList<Int>)
                } else {
                    letItBeVar = (method!!.invoke(methhodOne, varName, modusPonus) as ArrayList<Int>).last()
                    println(letItBeVar.getEx().stringView())

                }
                return true
            }
        }
        return false
    }

    fun tryAx(varName: String, exe: Int): Boolean {
        for (i in axiomas.indices) {
            isWas.clear()
            if (get(exe)!!.weNeedAxiom(axiomas[i])) {
                val method = methhodOne.javaClass.methods.find {
                    it.annotations.isNotEmpty() && it.annotations[0].annotationClass == NewProof::class
                            &&
                            it.getAnnotation(NewProof::class.java).op == "DedA"
                }
//                var method = allMethods["DedA"]
                if (!printOrNot) {
                    yepAnotherOne.addAll(method!!.invoke(methhodOne, varName, exe) as ArrayList<Int>)
                } else {
                    letItBeVar = (method!!.invoke(methhodOne, varName, exe) as ArrayList<Int>).last()
                    println(letItBeVar.getEx().stringView())
                    //                    letItBeVar = (method!!.invoke(methhodOne, varName, modusPonus) as ArrayList<Int>).last()
                }
                return true
            }
        }
        if ((forSomeCases.contains(exe.getEx().stringView()))) {
            val method = methhodOne.javaClass.methods.find {
                it.annotations.isNotEmpty() && it.annotations[0].annotationClass == NewProof::class
                        &&
                        it.getAnnotation(NewProof::class.java).op == "DedA"
            }
//            var method = allMethods["DedA"]
            if (!printOrNot) {
                yepAnotherOne.addAll(method!!.invoke(methhodOne, varName, exe) as ArrayList<Int>)
            } else {
                letItBeVar = (method!!.invoke(methhodOne, varName, exe) as ArrayList<Int>).last()
                println(letItBeVar.getEx().stringView())

                //                    letItBeVar = (method!!.invoke(methhodOne, varName, modusPonus) as ArrayList<Int>).last()
            }

            return true
        }
        return false
    }

    private fun tryHypo(varName: String, j: Int): Boolean {
        if ((varName == j.getEx().op) || (varName == j.getEx().stringView())) {
            val method = methhodOne.javaClass.methods.find {
                it.annotations.isNotEmpty() && it.annotations[0].annotationClass == NewProof::class
                        && it.getAnnotation(NewProof::class.java).op == "DedH"
            }
//            var method = allMethods["DedH"]
            if (!printOrNot) {
                yepAnotherOne.addAll(method!!.invoke(methhodOne, varName) as ArrayList<Int>)
            } else {
                letItBeVar = (method!!.invoke(methhodOne, varName) as ArrayList<Int>).last()
                println(letItBeVar.getEx().stringView())

            }

            return true
        }
        return false
    }
}
