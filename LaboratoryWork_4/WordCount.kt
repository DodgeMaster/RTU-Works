package LaboratoryWork_4

class WordCount {
    companion object {
        fun phrase(text: String): Map<String, Int> {
            return text.toLowerCase()
                    .split(Regex("[^a-zA-Z0-9']+"))
                    .filter(String::isNotEmpty)
                    .groupBy { it }.mapValues { it.value.size }
        }
    }
}