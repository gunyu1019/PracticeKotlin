fun main() {
    // 1. variable
    // val, var 에는 String, Int, Double, Float 등이 있다.

    // 불변하는 값 (val을 사용할 때에는 값을 재할당할 수 없다.)
    val hello1: String = "Hello World!"
    var hello2: String = "Bye World!"

    // 이렇게 하시면 Null를 삽입할 수 있다 "?"를 통하여, Null의 존재여부를 구분할 수 있음.
    var hello3: String?;

    // 2. function
    hello4()
    hello5()

    // 3. array(list)
    val arr1 = listOf("1", "2")  // 불변하는 값 (listOf을 사용할 때에는 값을 재할당할 수 없다.)
    val arr2 = arrayOf("1", 2)
    val arr3 = mutableListOf("1", "2") // 재할당이 가능한 배열
    val arr4 = arrayListOf("1", '2')

    arr3.add("3") // 배열 수정이 가능하다.
    arr4.add("3")

    // 4. for and while
    println("-----------------")
    for (i in 1..10) { // 1부터 10까지 돌아가게 됨.
        println(i)
    }

    for (item in arr1) { // 배열(arr1) 안에 있는 인자 갯수 만큼 반복을 할 수 있음.
        println(item)
    }

    for ((index, item) in arr1.withIndex()) { // withIndex를 사용하면 위치값까지 알 수 있다.
        println("$index 회차: $item")
    }

    var count: Int = 0
    while (count > 10) {
        println("$count 회차 while 반복")
        count += 1
    }

    // 5. casting object -> TypeOf
    val casting: Any = "Hello";
    if (casting is String) {
        var str: String = casting
    }

    // 6. Class and Data Class
    println("-----------------")
    val cls1 = HelloClass()
    val cls2 = HelloClass(18)

    val person = DataClass(18, "gunyu1019")
    println(person.name)
    println(person.age)

    // 7. Map
    // map - key, value JSON name!
    // {"name": "value"}
    println("-----------------")
    val map1 = mapOf(Pair("name", "value"))
    val map2 = mutableMapOf<String, String>()

    map2.put("name", "value")

    print(map2.keys)

    // 8. When, If
    // When은 자바의 Case와, 파이썬의 Match와 동일함.
    println("-----------------")
    var score: Int = 200;

    // 조건문의 기본 사용 방법
    if (score == 200) {
        println("True")
    } else {
        println("False")
    }

    // 삼항연산자
    val result: String = if (score == 200) "True" else "False"

    // score에 따른 특정 함수를 실행 시킬 수 있음.
    // in ()..()를 사용하면 범위를 지정할 수 있음.
    when(score) {
        200 -> println("OK")
        in 400..500 -> println("HTTP Exception")
        502 -> println("Bad Gateway")
    }

    // 변수처럼 사용 가능하다.
    // else 꼭 사용해야함.
    var final1: String = when(score) {
        200 -> "OK"
        502 -> "Bad Gateway"
        else -> "HTTP Exception"
    }

    // 9. Null 과 Nullable
    // NPE: NullPointerException
    println("-----------------")
    val Name: String = "gunyu1019"
    val NullName: String? = null // "?"

    val fullName: String = Name + " " + (NullName?: "No Name")
    println(fullName)

    // 10. Lamda
    val square = {size: Int -> size * size};
    val nameAge = { name: String, age: Int ->
        "My Name is $name and I am $age years old"
    }

    println(square(10))
    println(nameAge("Brain", 16))

    // 확장 함수
    val pizza: String.() -> String = {
        this + "said, My favorite food is pizza."
    }
    println(pizza("Brian"))
    println(pizza("Alice"))

    val Lamda = {number : Double ->
        number == 4.23
    }

    fun invodeLamda(lamda: (Double) -> Boolean): Boolean {
        return lamda(5.2343)
    }

    println(invodeLamda(Lamda))
    println(invodeLamda { it > 3.22 }) // ()의 경우는 생략해주어도 무관하다.
    println(invodeLamda ({ it > 3.22 }))
}

fun hello4(): String { // 자바 int 형 함수와 동일함. -> 리턴값이 존재하는 함수. 대신 리턴되는 인자의 유형을 알맞게 잡아주어야함.
    return ""
}

fun hello5() { // 자바의 void 형 함수와 동일함

}

// 6. Class and Data Class(Model)
open class HelloClass {
    var age: Int = 0;
    init {

    }

    // def 생성자
    constructor() // 기본 생성자
    constructor(Age: Int) {
        this.age = Age;
    } // 보조 생성자

    open fun yourAge() {
        println("너의 나이는 $age 살 입니다.")
    }
}

class UpperClass: HelloClass() {
    override fun yourAge() {
        super.yourAge()
        println("임의 나이는 $age 살 입니다.")
    }
}

data class DataClass(var age: Int, val name: String)