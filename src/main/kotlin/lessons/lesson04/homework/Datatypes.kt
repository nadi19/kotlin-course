package lessons.lesson04.homework

import java.math.BigDecimal


//часть 1
val v1: Int = 42
val v2: Long = 98765432123456789L
val v3: Float = 23.45f
val v4: Double = 0.123456789
val v5: String = "Kotlin & Java"

//v6 - ошибка: FALSE не существует в Kotlin, ключевое слово пишется строчными — false
//val v6: Boolean = FALSE
val v7: Char = 'c'
val v8: Int = 500
val v9: Long = 4294967296L
val v10: Float = 18.0f
val v11: Double = -0.001
val v12: String = "OpenAI"
val v13: String = "true"
val v14: List<Int> = listOf(3, 14)
val v15: Char = '9'
val v16: Int = 2048
val v17: Long = 10000000000L
val v18: Set<String> = setOf("OpenAI", "Quantum Computing")
val v19: Float = 5.75f

//v20 - ошибка: должно быть либо без кавычек, если это Double, либо в двойных кавычках, если это String
//val v20 = `1.414`
val v21: String = "Artificial Intelligence"
val v22: Array<Any> = arrayOf('x', "A")
val v23: String = "Android Studio"
val v24: Char = '@'
val v25: Int = 1024
val v26: Long = 1234567890123L
val v27: Float = 10.01f
val v28: Double = -273.15
val v29: String = "SpaceX"

//v30 - ошибка: FALSE не существует в Kotlin, нужно false
//val v30: Boolean = FALSE
val v31: Double = 0.007

//v32 - ошибка. должны прямые двойные кавычки "", одинарные '' - тут не подойдут, смайл в char не влезет
//val v32 = “🤯”
val v33: Map<String, Int> = mapOf(
    "true" to 2,
    "false" to 34
)

//v34 - ошибка. должны прямые двойные кавычки  "", одинарные '' - тут не подойдут, в char не влезет
//val v34 = ‘65535’
val v35: Long = 72057594037927935L
val v36: Float = 2.71828f
val v37: Double = 101.0101
val v38: String = "Quantum Computing"
val v39: Map<Int, String> = mapOf(
    2 to "true",
    34 to "false"
)
val v40: Char = 'x'
val v41: Int = 314
val v42: Long = 123456789123456789L
val v43: Float = 6.626f
//v44 - ошибка: TRUE не существует в Kotlin, нужно true
//val v44: Boolean = TRUE

//часть 2
val v45_1: Char = 'a'
val v46_2: Int = 5
val v47_3: List<Double> = listOf(100.50, 2000.00, 1500.50)
val v48_4: Double = 0.00000000001
val v49_5: Boolean = true
val v50_6: Int = 30
val v51_7: Long = 10000000000L
val v51_8: Long = 20000000000L
val v51_9: Double = 1.00000000000001
val v52_10: Map<String, Double> = mapOf(
    "Название" to 22222.04,
    "Название2" to 1000
)
val v52_11: String = "починилось само"
val v52_12: List<String> = listOf(
    "Тема1",
    "Тема2"
)