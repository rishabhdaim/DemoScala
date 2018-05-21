package com.alvinalexander

/**
  * Created by diam on 5/22/2018.
  */

// a LoginService must have a 'login' method
trait LoginService {
  def login(name: String, password: String): Option[User]
}

// a very simple User class
case class User(name: String)


