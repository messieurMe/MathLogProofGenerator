class Evaluater {
    companion object {
        fun evalIt(ex: Int?, first: Boolean?, second: Boolean? = null, third: Boolean? = null): Boolean {
            return evaluate(ex, first, second, third)!!
        }

        private fun evaluate(ex: Int?, first: Boolean?, second: Boolean?, third: Boolean?): Boolean? {
            if (ex == null) return null // O_o It cant't
            return when (ex.getEx().op[0]) {
                ourA!![0] -> first
                ourB!![0] -> second
                ourC!![0] -> third
                '-' -> (!(evaluate(ex.getEx().l, first, second, third))!!
                        || evaluate(ex.getEx().r, first, second, third)!!)
                '|' -> (evaluate(ex.getEx().l, first, second, third)!!
                        || evaluate(ex.getEx().r, first, second, third)!!)
                '&' -> (evaluate(ex.getEx().l, first, second, third)!!
                        && evaluate(ex.getEx().r, first, second, third)!!)
                '!' -> !evaluate(ex.getEx().l, first, second, third)!!
                else -> {null.also{ println(ex.getEx().op[0])} }// it can't happen
            }
        }
    }

}