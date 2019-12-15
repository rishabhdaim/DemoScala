package com.monads

sealed trait Validation[E, A] {
  def map[B] (f: A => B) : Validation[E, B]
  def flatMap[B] (f: A => Validation[E, B]) : Validation[E, B]
  def liftFail[F](f : E => F): Validation[F, A]
}

case class Success[E, A](a: A) extends Validation[E, A] {
  override def map[B](f: A => B): Validation[E, B] = new Success[E, B](f(a))
  override def flatMap[B](f: A => Validation[E, B]): Validation[E, B] = f(a)
  override def liftFail[F](f: E => F): Validation[F, A] = new Success[F, A](a)
}

case class Failure[E, A](e: E) extends Validation[E, A] {
  override def map[B](f: A => B): Validation[E, B] = new Failure[E, B](e)
  override def flatMap[B](f: A => Validation[E, B]): Validation[E, B] = new Failure[E, B](e)
  override def liftFail[F](f: E => F): Validation[F, A] = new Failure[F, A](f(e))
}
