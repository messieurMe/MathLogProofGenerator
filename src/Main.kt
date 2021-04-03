import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.system.exitProcess

//Proofer. Input example:
//A->B->C
fun main(args: Array<String>) {
    val parser: FinalParser? = FinalParser()
    val sc = BufferedReader(InputStreamReader(System.`in`))
    sentence = use(parser!!.parse(sc.readLine()))

    if (ourA == null) throw Exception()
    if (ourB == null) {
        ourB = "PUTINPAMAGI"
    }
    if (ourC == null) {
        ourC = "IISUSSPASI"
    }

    fillAx(parser)
    var myHypos = findHypos(sentence)


    if (myHypos != null) {
        myHypos.split(", ").forEach {
            hypos.add(use(FinalExpression(it, null, null)))
        }
        if (hypos.size >= 1) {
            for (i in 0 until hypos.size - 1) {
                print(hypos[i].getEx().stringView() + ", ")

            }
            println(hypos.last().getEx().stringView() + " |- " + sentence.getEx().stringView())
        } else {
            println("|- " + sentence.getEx().stringView())
        }
    } else {
        allIsBad = true
        sentence = use(FinalExpression("!", sentence, null))
        myHypos = findBadHyposYepItsCopypastCauseImLazy(sentence)

        if (myHypos != null) {
            myHypos.split(", ").forEach {
                hypos.add(use(parser.parse(it)))
            }
            if (hypos.size >= 1) {
                for (i in 0 until hypos.size - 1) {
                    print(hypos[i].getEx().stringView() + ", ")
                }
                println(hypos.last().getEx().stringView() + " |- " + sentence.getEx().stringView())

            } else {
                println("|- " + sentence.getEx().stringView())
            }

        } else {
            println(":(")
            exitProcess(0)
        }
    }
    iWillCallYouBilly.add(sentence.getEx().stringView())
    hypos.forEach { iWillCallYouBilly.add(it.getEx().stringView()) }


    startThisHell()
    FinishHim.fin()

}

var iWillCallYouBilly = ArrayList<String>()

fun ahSheetHereWeGoAgain() {
    allData.clear()
    iWillCallYouBilly.forEach {
        use(pp.parse(it))
    }
    fillAx(pp)
}

var ourA: String? = null
var ourB: String? = null
var ourC: String? = null

var allIsBad = false

fun toBool(i: Int) = i != 0

var sentence: Int = 0

var allData: HashMap<Int, FinalExpression> = HashMap()

val hypos: ArrayList<Int> = ArrayList()

val axiomas: LinkedList<Int> = LinkedList()

fun use(finalExpression: FinalExpression): Int {
    return finalExpression.hashCode().also { allData[it] = finalExpression }
}

fun get(i: Int) = allData[i]
fun get(e: FinalExpression) = e.hashCode()
fun Int.getEx() = allData[this]!!

fun getExprFromBase(code: Int?) = allData[code]

fun fillAx(parser: FinalParser) {
    axiomas.addLast(use(parser.parse("a->b->a")))
    axiomas.addLast(use(parser.parse("(a->b)->(a->b->c)->(a->c)")))
    axiomas.addLast(use(parser.parse("a->b->a&b")))
    axiomas.addLast(use(parser.parse("a&b->a")))
    axiomas.addLast(use(parser.parse("a&b->b")))
    axiomas.addLast(use(parser.parse("a->a|b")))
    axiomas.addLast(use(parser.parse("b->a|b")))
    axiomas.addLast(use(parser.parse("(a->c)->(b->c)->(a|b->c)")))
    axiomas.addLast(use(parser.parse("(a->b)->(a->!b)->!a")))
    axiomas.addLast(use(parser.parse("!!a->a")))
}
