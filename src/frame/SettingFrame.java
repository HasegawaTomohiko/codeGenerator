package frame;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingFrame extends JFrame {
  public SettingFrame(){

    setSize(300,400);
    setResizable(false);
    setBackground(Color.white);
    setVisible(true);

    JPanel settingPanel = new JPanel();
    JLabel templateFileLabel = new JLabel("テンプレートファイルを指定");
    JLabel rootDirectoryLable =new JLabel("ルートディレクトリを指定");
    JTextField templateFileText = new JTextField(20);
    JTextField rootDirectoryText = new JTextField(20);
    JButton templateFileButton = new JButton("ファイルを指定");
    JButton rootDirectoryButton = new JButton("フォルダを指定");

    add(settingPanel,BorderLayout.CENTER);
    settingPanel.add(templateFileLabel);
    settingPanel.add(templateFileText);
    settingPanel.add(templateFileButton);
    settingPanel.add(rootDirectoryLable);
    settingPanel.add(rootDirectoryText);
    settingPanel.add(rootDirectoryButton);
  }
}
