fun main() {
    print("Nhập số lượng phân số: ")
    val n = readln().toInt()
    val mang = Array(n) { PhanSo(1, 1) }

    // Nhập mảng
    for (i in 0 until n) {
        println("Nhập phân số thứ ${i + 1}:")
        val ps = PhanSo(1, 1)
        ps.nhap()
        mang[i] = ps
    }

    println("\nMảng phân số vừa nhập:")
    mang.forEach { it.inPhanSo() }

    println("\nMảng sau khi tối giản:")
    mang.forEach { it.toiGian(); it.inPhanSo() }

    // Tổng
    var tong = PhanSo(0, 1)
    for (ps in mang) {
        tong = tong.cong(ps)
    }
    println("\nTổng các phân số: ")
    tong.inPhanSo()

    // Phân số lớn nhất
    var max = mang[0]
    for (ps in mang) {
        if (ps.soSanh(max) > 0) {34
            max = ps
        }
    }
    println("\nPhân số lớn nhất: ")
    max.inPhanSo()

    // Sắp xếp giảm dần
    val sapXep = mang.sortedWith { a, b -> b.soSanh(a) }
    println("\nMảng sau khi sắp xếp giảm dần:")
    sapXep.forEach { it.inPhanSo() }
}
