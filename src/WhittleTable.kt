class WhittleTable {
    companion object {
        fun whittle(expression: Int): Table {
            val table = Table()
            for (i in 0 until 8) {
                table.add(
                    i,
                    Evaluater.evalIt(expression, toBool(i.and(4)), toBool(i.and(2)), toBool(i.and(1)))
                )
            }
            return table
        }
    }
}