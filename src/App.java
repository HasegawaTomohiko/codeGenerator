import frame.Myframe;

public class App {
    public static void main(String[] args) throws Exception {
        init();
    }
    /**
     * create frame and initalize contents
     */
    public static void init(){
        new Myframe();
    }
}
/* 
 * 今後やること
 * ・新規クラスにPanelやフレームを再定義 -> Myframeファイルに定数値を設定
 * ・各種ボタンが押されるとエクスプローラーが起動するようにする
 * ・生成ボタンの挙動について定義
 * -指定されたファイルやフォルダが存在するかをチェックする
 * -ディレクトリ構造の正規表現が正しいかをチェックする
 * -実行予測件数と実行ボタンを実装
 * -まず第一に新規にタイトル名のディレクトリを指定されたフォルダ下に生成する
 * -ディレクトリ構造のパターンをString型配列に配置()
 * 正規表現：^((?!-)[\w,/]+(?:-(?!-)[\w,/]+)*)((?:/[\w,]+)+|(?:-[\w,]+)|())$
 * -実行状況を把握するプログレスバーを実装
 * -終わったら「生成完了」と表示
 * 
 * 
 */

