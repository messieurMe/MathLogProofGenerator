var methhodOne = CreateProofBase()

fun findHypos(sentence: Int): String? {
    val table = (WhittleTable.whittle(sentence).t)
    if (!table.last()) {
        return null
    }
    val goodHypos = HashSet<Int>()

    var counter = 0
    for (i in 0 until 8) {
        for (j in 0 until 8) {
            if (hypos.size < 3) {
                if (hypos.size == 1) {
                    if (j != 4 && j != 0) {
                        counter++
                        continue
                    }
                } else if (hypos.size == 2) {
                    if (j != 0 && j != 2 && j != 4 && j != 6) {
                        counter++
                        continue
                    }
                }
            }

            if (table[(i or j)]) {
                counter++
            }
        }
        if (counter == 8) goodHypos.add(i)
        counter = 0
    }

//I was bored and lazy, so enjoy copypaste
    if (goodHypos.contains(0)) return ""
    if (goodHypos.contains(4)) return "$ourA"
    if (goodHypos.contains(2)) return "$ourB"
    if (goodHypos.contains(1)) return "$ourC"
    if (goodHypos.contains(6)) return "$ourA, $ourB"
    if (goodHypos.contains(5)) return "$ourA, $ourC"
    if (goodHypos.contains(3)) return "$ourB, $ourC"
    if (goodHypos.contains(7)) return "$ourA, $ourB, $ourC"
    return null
}

fun findBadHyposYepItsCopypastCauseImLazy(sentence: Int): String? {
    val table = (WhittleTable.whittle(sentence)).t

    if (!table.first()) {
        return null
    }

    val goodHypos = HashSet<Int>()

    var counter = 0
    for (i in 0 until 8) {
        for (j in 0 until 8) {
            if (hypos.size < 3) {
                if (hypos.size == 1) {
                    if (j != 4 && j != 0) {
                        counter++
                        continue
                    }
                } else if (hypos.size == 2) {
                    if (j != 0 && j != 2 && j != 4 && j != 6) {
                        counter++
                        continue
                    }
                }
            }

            if (table[(i and j)]) {
                counter++
            }
        }
        if (counter == 8) goodHypos.add(i)
        counter = 0
    }

    //I was bored and lazy, so enjoy copypaste
    if (goodHypos.contains(7)) return ""
    if (goodHypos.contains(3)) return "!$ourA"
    if (goodHypos.contains(5)) return "!$ourB"
    if (goodHypos.contains(6)) return "!$ourC"
    if (goodHypos.contains(1)) return "!$ourA, !$ourB"
    if (goodHypos.contains(2)) return "!$ourA, !$ourC"
    if (goodHypos.contains(4)) return "!$ourB, !$ourC"
    if (goodHypos.contains(0)) return "!$ourA, !$ourB, !$ourC"
    return null
}


