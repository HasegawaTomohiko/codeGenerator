package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
  private final String INI_PATH = "./codeGenerator.properties";

  private Properties properties = new Properties();
  
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
      String tempFile;
      String rootDirectory;
      try{
        properties.load(Files.newBufferedReader(Paths.get(INI_PATH)));
        tempFile = properties.getProperty("templateFile");
        rootDirectory = properties.getProperty("rootDirectory");
        System.out.printf("template file:%s\n",tempFile);
        System.out.printf("root directory:%s\n",rootDirectory);
        
        JFileChooser fileChooser = new JFileChooser(new File(tempFile));
        int returnVal = fileChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
          File file = fileChooser.getSelectedFile();
          textTemplate.setText(file.getAbsolutePath());
        }
      }catch(IOException exseption){
        System.out.println(String.format("ファイルの読取に失敗 ファイル名:%s",INI_PATH));
      }
    }
    if(e.getSource() == buttonRoot){
      String tempFile;
      String rootDirectory;
      try{
        properties.load(Files.newBufferedReader(Paths.get(INI_PATH)));
        tempFile = properties.getProperty("templateFile");
        rootDirectory = properties.getProperty("rootDirectory");
        System.out.printf("template file:%s\n",tempFile);
        System.out.printf("root directory:%s\n",rootDirectory);
        JFileChooser direChooser = new JFileChooser();
        direChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        direChooser.setCurrentDirectory(new File(rootDirectory));
        int returnVal = direChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
          File directory = direChooser.getSelectedFile();
          textRoot.setText(directory.getAbsolutePath());
        }
      }catch(IOException exseption){
        System.out.println(String.format("ファイルの読取に失敗 ファイル名:%s",INI_PATH));
      }
      
    }
    if(e.getSource() == submit){
      //構文チェック()
      //エラー -> ポップアップでもう一度入力させる
      //実行している
    }
    if(e.getSource() == setting){

      /* 新規クラス:SettingFrameを生成します。 */
      new SettingFrame();

    }
  }
}
