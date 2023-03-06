package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateTemplate extends JPanel implements ActionListener{

  private final int HEIGHT = 10;
  private final int WIDTH = 400;
  private final int TEXT_HEIGHT = 30;
  private final int TEXT_WIDTH_FILE = 200;
  private final int TEXT_WIDTH_OTHER = 250;

  JLabel labelTemplate = new JLabel("テンプレートファイル");
  JTextField textTemplate = new JTextField(35);
  JButton buttonTemplate = new JButton("ファイルを開く");
  JLabel labelRoot = new JLabel("生成先ディレクトリ");
  JTextField textRoot = new JTextField(35);
  JButton buttonRoot = new JButton("フォルダを開く");
  JLabel labelTitle = new JLabel("タイトル");
  JTextField textTitle = new JTextField(40);
  JLabel labelDirectory = new JLabel("ディレクトリ構成(','区切りで各ディレクトリを生成します)");
  JTextField textDirectory = new JTextField(40);
  JButton submit = new JButton("生成");
  JButton setting = new JButton("設定");


  public CreateTemplate(){
    setPreferredSize(new Dimension(250,270));
    setBackground(Color.white);
    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    JPanel tempPanel = new JPanel();
    JPanel rootPanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JPanel directoryPanel = new JPanel();
    JPanel lowerPanel = new JPanel();

    textTemplate.setPreferredSize(new Dimension(TEXT_WIDTH_FILE,TEXT_HEIGHT));
    textRoot.setPreferredSize(new Dimension(TEXT_WIDTH_FILE,TEXT_HEIGHT));
    textTitle.setPreferredSize(new Dimension(TEXT_WIDTH_OTHER,TEXT_HEIGHT));
    textDirectory.setPreferredSize(new Dimension(TEXT_WIDTH_OTHER,TEXT_HEIGHT));

    buttonTemplate.addActionListener(this);
    buttonRoot.addActionListener(this);

    labelTemplate.setFont(new Font(Font.SERIF,Font.BOLD,18));
    labelRoot.setFont(new Font(Font.SERIF,Font.BOLD,18));
    labelTitle.setFont(new Font(Font.SERIF,Font.BOLD,18));
    labelDirectory.setFont(new Font(Font.SERIF,Font.BOLD,18));

    add(labelTemplate);
    add(tempPanel);
    tempPanel.setLayout(new FlowLayout());
    tempPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    tempPanel.setBackground(Color.white);
    tempPanel.add(textTemplate);
    tempPanel.add(buttonTemplate);
    add(labelRoot); 
    add(rootPanel);
    rootPanel.setLayout(new FlowLayout());
    rootPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    rootPanel.setBackground(Color.white);
    rootPanel.add(textRoot);
    rootPanel.add(buttonRoot);
    add(labelTitle);
    add(titlePanel);
    titlePanel.setLayout(new FlowLayout());
    titlePanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    titlePanel.setBackground(Color.white);
    titlePanel.add(textTitle);
    add(labelDirectory);
    add(directoryPanel);
    directoryPanel.setLayout(new FlowLayout());
    directoryPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    directoryPanel.setBackground(Color.white);
    directoryPanel.add(textDirectory);
    add(lowerPanel);
    lowerPanel.setLayout(new FlowLayout());
    lowerPanel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    lowerPanel.setBackground(Color.white);
    lowerPanel.add(submit);
    lowerPanel.add(setting);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == buttonTemplate){
      JFileChooser fileChooser = new JFileChooser();
      fileChooser.setCurrentDirectory(new File("C:\\Programing\\Java\\Atcoder\\codeGenerator\\template"));
      int returnVal = fileChooser.showOpenDialog(this);
      if(returnVal == JFileChooser.APPROVE_OPTION){
        File file = fileChooser.getSelectedFile();
        textTemplate.setText(file.getAbsolutePath());
      }
    }
    if(e.getSource() == buttonRoot){
      JFileChooser direChooser = new JFileChooser();
      direChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      direChooser.setCurrentDirectory(new File(".\\"));
      int returnVal = direChooser.showOpenDialog(this);
      if(returnVal == JFileChooser.APPROVE_OPTION){
        File directory = direChooser.getSelectedFile();
        textRoot.setText(directory.getAbsolutePath());
      }
    }
    if(e.getSource() == submit){
      //構文チェック()
      //エラー -> ポップアップでもう一度入力させる
      //実行している
    }
  }
}
