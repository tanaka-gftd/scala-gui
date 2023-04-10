//JavaFXでGUIを作るのに必要なクラス群をインポート
import javafx.application.Application
import javafx.event.{ActionEvent, EventHandler}
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.StackPane
import javafx.stage.Stage


//本アプリケーションが実行された時に、最初に呼び出される関数
object Main extends App {
  //Application.launch関数...JavaFXのアプリケーションを起動するための関数
  //args: _* で、Appトレイトで定義されているargsという文字列の配列を可変長引数として渡している
  //* ... 型指定の後につけることで、可変長引数を渡すことができるようになる
  //_* ... 型指定の後につけることで、可変長引数にSeqを渡すことができるようになる
  Application.launch(classOf[Main], args: _*)
}


//Main というクラスの定義
/* 
  Scala ではオブジェクトと同様の名前のクラス(ここではMain)を作成できる。
*/
class Main extends Application {
  override def start(primaryStage: Stage): Unit = {

    //ボタンを新規に作成し、その中に「押してね」という文字列をはめ込む
    val btn = new Button()
    btn.setText("押してね")

    //ボタンが押されたことを検知して、コンソールに「こんにちは」と出力する
    btn.setOnAction(new EventHandler[ActionEvent] {
      override def handle(event: ActionEvent): Unit = {
        println("こんにちは")
      }
    })

    //UIコントロールを重ねて配置するレイアウトを新規に作成し、そこに上記で作成したボタンを追加
    val root = new StackPane()
    root.getChildren.add(btn)

    //JavaFXアプリケーションの画面の大きさを設定
    val scene = new Scene(root, 300, 250)
    
    //アプリケーションのタイトルを設定
    primaryStage.setTitle("コンソールにこんにちはを出力")

    //画面の大きさの設定をアプリケーション側に渡す
    primaryStage.setScene(scene)

    //アプリケーションの表示
    primaryStage.show()
  }
}
