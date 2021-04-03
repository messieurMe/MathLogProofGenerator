class FinalParser {
    private var pos: Int = 0
    private lateinit var s: String
    private fun posCheck() = pos < s.length
    private fun isVar() = (s[pos].isLetterOrDigit() || s[pos] == '\'')
    private fun pp(inc: Int = 1, res: String = ""): String {
        pos += inc
        skip()
        return res
    }

    private fun readVarName(): String {
        return if (posCheck() && isVar()) s[pos++].plus(readVarName()) else ""
    }

    private fun skip() {
        while (posCheck() && s[pos] == ' ') pos++
    }

    private fun readNext(): String {
        if (!posCheck()) return ""
        return when (s[pos]) {
            '&' -> pp(0, "&")
            '!' -> pp(0, "!")
            '-' -> pp(0, "->")
            '(' -> pp(0, "(")
            ')' -> pp(0, ")")
            '|' -> if (s[pos + 1] == '-') pp(0, "|-") else pp(0, "|")
            else -> readVarName()
        }
    }

    private fun parseVar(): FinalExpression {
        var next = readNext()
        return when (next) {
            "(", ")" -> {
                pp()
                skip()
                val a = parseImpl()
                pp()
                skip()
                a
            }
            "!" -> {
                pp(1)
                skip()
                use(FinalExpression("!", use(parseVar()), null)).getEx()//
            }
            else -> {
                skip()
                if (ourA == null || next == ourA) {
                    ourA = next
                } else if (ourB == null || (next == ourB!!)) {
                    ourB = next
                } else if (ourC == null || next == ourC) {
                    ourC = next
                }
                use(FinalExpression(next, null, null)).getEx()//
            }
        }
    }

    private fun universalFunction(
        fromAnd: Boolean, const: String, recFun: () -> FinalExpression, whileFun: () -> FinalExpression = ::parseImpl
    ): FinalExpression {
        skip()
        var parsingResult: FinalExpression = recFun()
        skip()
        while (posCheck() && readNext() == const) {
            pp(if (fromAnd) 2 else 1, "")
            skip()
            parsingResult = FinalExpression(const, use(parsingResult), use(whileFun()))
            use(parsingResult)
            skip()
        }
        skip()
        return parsingResult
    }

    private fun parseAnd() = universalFunction(false, "&", ::parseVar, ::parseVar)
    private fun parseOr() = universalFunction(false, "|", ::parseAnd, ::parseAnd)
    private fun parseImpl() = universalFunction(true, "->", ::parseOr)

    fun parse(s: String): FinalExpression {
        pos = 0
        this.s = s
        return parseImpl().also { this.s = "" }
    }
}