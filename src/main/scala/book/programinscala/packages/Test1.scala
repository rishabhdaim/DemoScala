package book.programinscala.packages {
  package navigation {
    package tests {

      import book.programinscala.packages.tests.Test2
      import _root_.tests.Test3
      import book.programinscala.packages.Fruits.{Apple => McInTosh, Pear => _, _}

      /**
        * Created by diam on 6/16/2018.
        */
      object Test1 {
        def test() = println("Inside Test1")

        def showFruit(f: Fruit) = {
          import f._
          println(name + "s are " + color)
        }
      }

      object TestPackage extends App {
        Test1.test()
        Test2.test()
        Test3.test()

        // Test fruits
        Fruits.menu.foreach(Test1.showFruit)

        Test1.showFruit(McInTosh)
        Test1.showFruit(Orange)
//        Test1.showFruit(Pear)
      }
    }
  }

  package tests {
    object Test2 {
      def test() = println("Inside Test2")
    }
  }
}

package tests {
  object Test3 {
    def test() = println("Inside Test3")
  }
}


