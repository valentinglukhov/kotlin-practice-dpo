fun main() {
    var numbers = 0
    loop@ do {
        println("Введите количество номеров:")
        numbers = readln().toIntOrNull() ?: continue@loop
    } while (numbers <= 0)
    val phoneNumbers = enterNumbers(numbers)
    println("Полный список номеров:")
    println(phoneNumbers.joinToString())
    val filteredNumbers = phoneNumbers.filter { it.startsWith("+7") }
    println("Список номеров начинающиеся с +7")
    println(filteredNumbers.joinToString())
    val setOfNumbers = phoneNumbers.toHashSet()
    println("Количество уникальных номеров: ${setOfNumbers.size}")
    val sumNumbers = setOfNumbers.sumOf { it.length }
    println("Длина всех номеров включая символы: $sumNumbers")
    val contacts = enterNames(setOfNumbers)
    println("Итоговый список контактов:")
    for (contact in contacts) {
        println("Человек: ${contact.value}. Номер телефона: ${contact.key}")
    }
}

fun enterNames(phoneSet: HashSet<String>): MutableMap<String, String> {
    val phoneContacts = mutableMapOf<String, String>()
    for (phone in phoneSet) {
        println("Введите имя для телефона: $phone")
        val name = readln()
        phoneContacts.put(phone, name)
    }
    return phoneContacts
}

fun enterNumbers(n: Int): MutableList<String> {
    val phoneNumbers = mutableListOf<String>()
    if (n <= 0) return phoneNumbers
    for (n in 1..n) {
        println("Введите номер телефона:")
        val number = readln()
        phoneNumbers.add(number)
    }
    return phoneNumbers
}