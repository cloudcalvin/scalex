package scalex
package db

import index.Def

class DefRepoTest extends ScalexTest {

  val repo = env.defRepo

  "The index repo" should {
    "find by declaration" in {
      "list map simple" in {
        val declaration = "scala.collection.immutable.List#map[B]: List[+A] => (f: (A => B)) => List[B]"
        val docUrl = "http://www.scala-lang.org/api/current/scala/collection/immutable/List#map[B]((A) ⇒ B):List[B]"
        val encodedDocUrl = "http://www.scala-lang.org/api/current/scala/collection/immutable/List#map%5BB%5D((A)%20%E2%87%92%20B)%3AList%5BB%5D"
        val listmap = repo findByDeclaration declaration
        "def docUrl" in {
          listmap must beSome.like {
            case d => d.docUrl must_== docUrl
          }
        }
        "def encoded docUrl" in {
          listmap must beSome.like {
            case d => d.encodedDocUrl must_== encodedDocUrl
          }
        }
      }
      "list map with canbuildfrom" in {
        val declaration = "scala.collection.immutable.List#map[B, That]: List[+A] => (f: (A => B))(implicit bf: CanBuildFrom[List[A], B, That]) => That"
        val docUrl = "http://www.scala-lang.org/api/current/scala/collection/immutable/List#map[B, That]((A) ⇒ B)(CanBuildFrom[List[A], B, That]):That"
        val encodedDocUrl = "http://www.scala-lang.org/api/current/scala/collection/immutable/List#map%5BB%2C%20That%5D((A)%20%E2%87%92%20B)(CanBuildFrom%5BList%5BA%5D%2C%20B%2C%20That%5D)%3AThat"
        val listmap = repo findByDeclaration declaration
        "def docUrl" in {
          listmap must beSome.like {
            case d => d.docUrl must_== docUrl
          }
        }
        "def encoded docUrl" in {
          listmap must beSome.like {
            case d => d.encodedDocUrl must_== encodedDocUrl
          }
        }
      }
    }
  }
}