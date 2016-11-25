fun nth(l1: List<Int>, l2: List<Int>, n: Int): Int {
    if (l1.isEmpty()) return l2[n]
    if (l2.isEmpty()) return l1[n]
    if (n == l1.size + l2.size - 1) return arrayOf(l1[l1.size - 1], l2[l2.size - 1]).max()!!
    if (l1.size == 1) {
        return if (l2[n-1] <= l1[0] && l1[0] <= l2[n]) l1[0] else if (l1[0] < l2[n-1]) l2[n-1] else l2[n]
    }
    if (l2.size == 1) {
        return if (l1[n-1] <= l2[0] && l2[0] <= l1[n]) l2[0] else if (l2[0] < l1[n-1]) l1[n-1] else l1[n]
    }
    val i1 = n * l1.size / (l1.size + l2.size)
    val i2 = n * l2.size / (l1.size + l2.size)
    if (l1[i1] < l2[i2]) {
        return nth(l1.slice(i1 until l1.size), l2.slice(0..i2), n - i1)
    } else {
        return nth(l1.slice(0..i1), l2.slice(i2 until l2.size), n - i2)
    }
}

fun median(l1: List<Int>, l2: List<Int>): Int {
    return nth(l1, l2, (l1.size + l2.size) / 2)
}
