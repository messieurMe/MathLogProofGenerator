data class FinalExpression(var op: String, var l: Int?, var r: Int?) {
    fun weNeedHypo(e: FinalExpression?): Boolean {
        return (this.op == e?.op)
                && (getExprFromBase(l)?.weNeedHypo(getExprFromBase(e.l)) ?: (l == e.l))
                && (getExprFromBase(r)?.weNeedHypo(getExprFromBase(e.r)) ?: (r == e.r))
    }

    fun weNeedAxiom(e: Int?): Boolean {

        if (getExprFromBase(e)?.op != null && getExprFromBase(e)!!.l == null && getExprFromBase(e)!!.r == null) {
            return if (isWas[getExprFromBase(e)!!.op] != null) {
                weNeedHypo(isWas[getExprFromBase(e)!!.op])
            } else {
                true.also { isWas[getExprFromBase(e)!!.op] = this }
            }
        }
        return (this.op == getExprFromBase(e)?.op)
                && (getExprFromBase(l)?.weNeedAxiom(getExprFromBase(e)?.l) ?: (l == getExprFromBase(e)?.l))
                && (getExprFromBase(r)?.weNeedAxiom(getExprFromBase(e)?.r) ?: (r == getExprFromBase(e)?.r))
    }

    fun stringView(): String {
        return if (r != null && l != null) {
            ("(" + (getExprFromBase(l)?.stringView() ?: "") + op + (getExprFromBase(r)?.stringView() ?: "") + ")")
        } else if (l != null) {
            ("" + op + (getExprFromBase(l)?.stringView() ?: "") + "")
        } else {
            op
        }
    }

    fun gL() = allData[l]
    fun gR() = allData[r]

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FinalExpression

        if (op != other.op) return false
        if (l != other.l) return false
        if (r != other.r) return false

        return true
    }

    override fun hashCode(): Int {
        var result = op.hashCode()
        result = 3571 * result + (l?.hashCode() ?: 0)
        result = 27644437 * result + (r?.hashCode() ?: 0)
        result *= 1471
        var str = this.op + l.toString() + r.toString()
        var i = 1
        for (ch in str) {
            result += ch.hashCode() * i
            i *= 31
        }
        return result
    }
}
