package part2actors

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

object ActorsIntro extends App {
  // part 1 - actor system
  val actorSystem = ActorSystem("firstActorSystem")
  println(actorSystem.name)

  /**
   * 1. Actors are uniquely identified
   * 2. Messages are asynchronous
   * 3. Each actor may respond differently
   * 4. Actors are encapsulated
   */
  // part 2 - create actors (actors are like humans talking to each other)
  // word count actor

  class WordCountActor extends Actor {
    var wordCount = 0
    override def receive: PartialFunction[Any, Unit] = {
      case message: String => wordCount += message.split(" ")
      case msg => println(s"[word counter] I can not understand ${msg.toString}")
    }
  }

  // part 3 - instantiate our actor
  val wordCounter: ActorRef = actorSystem.actorOf(Props[WordCountActor], "wordCounter")

}
