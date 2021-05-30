package com.example.app.entity

/**
 * @author wangyou
 * @desc:
 * @date :2021/4/12
 */
class User {
    var username: String? = null
    var password: String? = null
//    @JvmField//使编译器生成公开的成员变量
    var code: String? = null

    constructor() {}

    constructor(username:String, password:String, code:String){
        this.username = username
        this.password = password
        this.code = code
    }
}