import kotlin.math.abs

class PhanSo(var tu: Int, var mau: Int) {

    init {
        if (mau == 0) {
            throw IllegalArgumentException("Mẫu số không được bằng 0")
        }
    }


    fun nhap() {
        while (true) {
            print("Nhập tử số: ")
            tu = readln().toInt()
            print("Nhập mẫu số: ")
            mau = readln().toInt()
            if (mau != 0) break
            println("Mẫu số không được bằng 0, nhập lại!")
        }
    }


    fun inPhanSo() {
        println("$tu/$mau")
    }


    fun toiGian() {
        val gcd = gcd(abs(tu), abs(mau))
        tu /= gcd
        mau /= gcd
        if (mau < 0) { // luôn để mẫu dương
            tu = -tu
            mau = -mau
        }
    }


    fun soSanh(ps: PhanSo): Int {
        val left = tu * ps.mau
        val right = ps.tu * mau
        return when {
            left < right -> -1
            left > right -> 1
            else -> 0
        }
    }


    fun cong(ps: PhanSo): PhanSo {
        val newTu = tu * ps.mau + ps.tu * mau
        val newMau = mau * ps.mau
        val kq = PhanSo(newTu, newMau)
        kq.toiGian()
        return kq
    }


    fun giaTri(): Double {
        return tu.toDouble() / mau
    }


    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
