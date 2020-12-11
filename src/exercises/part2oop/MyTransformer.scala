package exercises.part2oop

trait MyTransformer[-A, B] {
  def transform(element: A): B

}
