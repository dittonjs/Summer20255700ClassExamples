fun main() {
    val a = 0x16 // 00010110
                 // 00001111
                 // 00000110
    val b = 0x30
    val operation = a shr 4
    val operand1 = a and 0x0f
    println(operation)
    println(operand1)

    val jump1 = 0x51
    val jump2 = 0x12
    val addressFirstNibble = jump1 and 0x0f
    // 0001 << 8 = 000100000000
    //             000000010010
    //             000100010010
    val address = (addressFirstNibble shl 8) or jump2
    println(address.toString(16))





}