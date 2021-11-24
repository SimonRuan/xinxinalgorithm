package mapper.ruanxinxin.mvc01.employee

import org.junit.Test
import kotlin.test.assertEquals

class KotlinTest {

    @Test
    fun lambdaTest() {
        //调用构造函数，不需要用new关键字
        val productList = ArrayList<ProductDO>()

       // productList.add(ProductDO("佳得乐", 4.5, 10, "好喝"))
       // productList.add(ProductDO("脉动", 5.0, 18, "广告多"))
       // productList.add(ProductDO("可爱多", 3.5, 17, "好吃"))
//        productList.add(ProductDO("奥利奥", 6.0, 5, "经典"))
//        productList.add(ProductDO("乐事", 4.0, 3, "热量高"))
//        productList.add(ProductDO("洗衣液", 30.0, 2, "好用"))
//        productList.add(ProductDO("MacBook", 13000.0, 1))
//        productList.add(ProductDO("iphone X", 9800.0, 2))
//        productList.add(ProductDO("清风抽纸", 5.0, 20))
//        productList.add(ProductDO("自行车", 1500.0, 1))

       // val result = productList.stream().map { p -> p.name }.reduce { sum, item -> sum +"," +item }.or("muyou")
        //print(result)
       // println(KotlinServiceTest().getSum(x = 3, y = 9))

//        var a="nihao"
//        var b="nihao"
//        var isEqual1=a=="nihao"
//        var isEqual2=a==="nihao"
//        var isEq3=a==b
//        var isEq4=a===b
//        print(i
// sEqual1.toString() + " "+isEqual2+isEq3+isEq4)
        var ll="nihao"
        print(ll.toLongOrNull()==null)

    }
}