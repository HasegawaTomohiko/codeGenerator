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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateTemplate extends JPanel implements ActionListener{

  private final int HEIGHT = 10;
  private final int WIDTH = 400;
  private final int TEXT_HEIGHT = 40;
  private final int TEXT_WIDTH_FILE = 200;
  private final int TEXT_WIDTH_OTHER = 250;
  private final int LABEL_FONT = 18;
  private final int TEXT_FONT = 16;

  JPanel tempPanel = new JPanel();
  JPanel rootPanel = new JPanel();
  JPanel titlePanel = new JPanel();
  JPanel directoryPanel = new JPanel();
  JPanel lowerPanel = new JPanel();

  JLabel labelTemplate = new JLabel("テンプレートファイル");
  JLabel labelRoot = new JLabel("生成先ディレクトリ");
  JLabel labelTitle = new JLabel("タイトル");
  JLabel labelDirectory = new JLabel("ディレクトリ構成(','区切りで各ディレクトリを生成します)");
  JTextField textTemplate = new JTextField(35);
  JTextField textRoot = new JTextField(35);
  JTextField textTitle = new JTextField(40);
  JTextField textDirectory = new JTextField(40);
  JButton buttonTemplate = new JButton("ファイルを開く");
  JButton buttonRoot = new JButton("フォルダを開く");
  JButton submit = new JButton("生成");
  JButton setting = new JButton("設定");


  public CreateTemplate(){
    setPreferredSize(new Dimension(250,270));
    setBackground(Color.white);
    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
  
    textTemplate.setPreferredSize(new Dimension(TEXT_WIDTH_FILE,TEXT_HEIGHT));
    textRoot.setPreferredSize(new Dimension(TEXT_WIDTH_FILE,TEXT_HEIGHT));
    textTitle.setPreferredSize(new Dimension(TEXT_WIDTH_OTHER,TEXT_HEIGHT));
    textDirectory.setPreferredSize(new Dimension(TEXT_WIDTH_OTHER,TEXT_HEIGHT));
  
    buttonTemplate.addActionListener(this);
    buttonRoot.addActionListener(this);
    submit.addActionListener(this);
    setting.addActionListener(this);
  
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
    if(e.getSource() == setting){

      /* 新規クラス:SettingFrameを生成します。 */

      JFrame settingFrame = new JFrame("設定");
      settingFrame.setSize(300,400);
      settingFrame.setResizable(false);
      settingFrame.setBackground(Color.white);
      settingFrame.setVisible(true);
      JLabel templateFileLabel = new JLabel("テンプレートファイルを指定");
      JLabel rootDirectoryLable =new JLabel("ルートディレクトリを指定");
      JTextField templateFileText = new JTextField(40);
      JTextField rootDirectoryText = new JTextField(40);
      JButton templateFileButton = new JButton("ファイルを指定");
      JButton rootDirectoryButton = new JButton("フォルダを指定");

      settingFrame.add(templateFileLabel);
      settingFrame.add(templateFileText);
      settingFrame.add(templateFileButton);
      settingFrame.add(rootDirectoryLable);
      settingFrame.add(rootDirectoryText);
      settingFrame.add(rootDirectoryButton);
    }
  }
}
