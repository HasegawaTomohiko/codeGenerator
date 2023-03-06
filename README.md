## Code Generator

AtcoderやTopcoderなどの競技プログラミングでいちいちテンプレートファイルをコピーしては...というのが死ぬほど面倒だったので作りました。

## 使い方

- `テンプレートファイルの指定`:自身が所有するテンプレートファイルを指定します。(一応zipとかもいけると思う)
- `ディレクトリの指定`:生成したい場所を指定します。
- `タイトルの設定`:生成するディレクトリの名前を設定します。
- `ディレクトリ構造の設定`:生成したディレクトリ内部でどのようなディレクトリ構造をとるかを指定します

# ディレクトリ構造の正規表現

- `alpha,beta,...`:alpha,betaのようにディレクトリを生成します
- `a-z`,`1-100` : aからzまで、1から100までのディレクトリを生成します
- `app/main` : appディレクトリ内にmainディレクトリを生成します

例

App/bin,lib,src
App内にbin,lib,srcを生成し、内部にテンプレートファイルを生成します。

a-z/aiueo,kakikukeko
aからzまでのフォルダ内にaiueoとkakikukekoを生成し、内部にテンプレートファイルを生成します。
## フォルダ構造

- `src`: ソースファイルです。
- `src/frame`: フレームでの処理についてです。

> エラー等がありましたら随時対応します(気が向いたらの意)

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
