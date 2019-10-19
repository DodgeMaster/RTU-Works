package LaboratoryWork_4

class Isogram {
    companion object {
        fun isIsogram(input: String): Boolean{
            val clean = input.replace(Regex("[ -]"), "")
            return (clean.length == clean.toLowerCase().toCharArray().distinct().size)
        }
    }
}