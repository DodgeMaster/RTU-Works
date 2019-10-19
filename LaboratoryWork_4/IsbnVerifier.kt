package LaboratoryWork_4

class IsbnVerifier {
    fun isValid(isbn: String): Boolean {
        return isbn
                .filter { it != '-' }
                .apply { if (this.length != 10) return false }
                .apply { if (any { !it.isDigit() && it != 'X' }) return false }
                .apply { if (indexOf('X') !in listOf(-1, 9)) return false }
                .reversed()
                .mapIndexed { index, it ->
                    val intVal = if (it == 'X') 10 else it.toString().toInt()
                    intVal * (index + 1)
                }
                .sum()
                .rem(11) == 0
    }
}