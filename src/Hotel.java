package hotel;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Hotel implements ActionListener
{
JLabel heading,lpubname,lphone,laddress,htl,chkin,chkout,lb1,rst;
JTextField pub_name,pub_phone,pub_address,pub_city,pub_state,pub_zip;
JButton insert,exit,Reset,view;
JPanel p1;
JFrame f1;
JRadioButton c1,c2,c3;
JComboBox v1,v2,v3,v4,v5,v6;
ImageIcon image1;
ButtonGroup bg;
 String dte[];
 String mte[];
 String yr[];
 static int status=1;
 static int stat=0,stat1=0,stat2=0,stat3=0;
 
public void compshow()
{
    dte= new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    mte=new String[]{"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
    yr=new String[]{"2017","2018","2019","2020"};
    c1=new JRadioButton("DELUXE");
    c2=new JRadioButton("SUPER DELUXE");
    c3=new JRadioButton("SUITE");
    v1=new JComboBox(dte);
    v2=new JComboBox(mte);
    v3=new JComboBox(yr);
    v4=new JComboBox(dte);
    v5=new JComboBox(mte);
    v6=new JComboBox(yr);
    f1=new JFrame("HOTEL");
    p1=new JPanel();
    heading=new JLabel("ENTER DETAILS");
    rst=new JLabel("CONFIRM BOOKING");

    lpubname=new JLabel("ENTER NAME");
    lphone=new JLabel("ENTER MOBILENUMBER");
    laddress=new JLabel("ENTER ADDRESS");
    htl=new JLabel("SELECT ROOM:");
    chkin=new JLabel("CHECK-IN DATE");
    chkout=new JLabel("CHECK-OUT DATE");

    pub_name=new JTextField(50);
    pub_phone=new JTextField(10);
    pub_address=new JTextField(50);  
         
    insert=new JButton("BOOK");
    insert.setBackground(java.awt.Color.green);
    exit=new JButton("EXIT");
    exit.setBackground(java.awt.Color.red);
    view=new JButton("VIEW LOGS");
    view.setBackground(java.awt.Color.orange);
    Reset=new JButton("CLEAR LOGS");
    Reset.setBackground(java.awt.Color.orange);
   
    p1.setLayout(null);
    heading.setBounds(250,75,200,50);
    p1.add(heading);    
   
    lpubname.setBounds(75,140,200,30);
    pub_name.setBounds(350,140,200,25);
    p1.add(lpubname);
    p1.add(pub_name);
    pub_name.setText("");
    
    
    lphone.setBounds(75,170,200,30);
    pub_phone.setBounds(350,170,200,25);
    p1.add(lphone);
    p1.add( pub_phone);
   
    laddress.setBounds(75,200,200,30);
    pub_address.setBounds(350,200,200,25);
    p1.add(laddress);
    p1.add(pub_address);    
    c1.setBounds(130,250,200,30);
    c2.setBounds(130,270,200,30);
    c3.setBounds(130,290,200,30);
    
    htl.setBounds(75,225,200,30);
    bg=new ButtonGroup();
    bg.add(c1);
    bg.add(c2);
    bg.add(c3);
    p1.add(c1);
    p1.add(c2);
    p1.add(c3);
    p1.add(htl);
    v1.setBounds(250,330,60,18);
    v2.setBounds(320,330,60,18);
    v3.setBounds(390,330,60,18);
    v4.setBounds(250,360,60,18);
    v5.setBounds(320,360,60,18);
    v6.setBounds(390,360,60,18);
    chkin.setBounds(75,322,200,30);
    chkout.setBounds(75,352,200,30);
    p1.add(chkin);
    p1.add(chkout);
    p1.add(v1);
    p1.add(v2);
    p1.add(v3);
    p1.add(v4);
    p1.add(v5);
    p1.add(v6);
    
 image1 = new ImageIcon(("majestic.jpg"));
 lb1=new JLabel(image1);
 lb1.setBounds(8,8,200,125);
  p1.add(lb1);   
      
    insert.setBounds(70,400,100,30);
    exit.setBounds(460,400,100,30);
    view.setBounds(200,400,110,30);
    Reset.setBounds(320,400,110,30);
     p1.add(insert);
     p1.add(exit);   
     p1.add(view);
     p1.add(Reset);
         
    f1.add(p1);
    f1.setSize(680,500);
    f1.setVisible(true);
    p1.setBackground(java.awt.Color.cyan);
    c1.setBackground(java.awt.Color.cyan);
    c2.setBackground(java.awt.Color.cyan);
    c3.setBackground(java.awt.Color.cyan);
    pub_name.setBackground(java.awt.Color.yellow);
    pub_phone.setBackground(java.awt.Color.yellow);
    pub_address.setBackground(java.awt.Color.yellow);
    v1.setBackground(java.awt.Color.magenta);
    v2.setBackground(java.awt.Color.magenta);
    v3.setBackground(java.awt.Color.magenta);
    v4.setBackground(java.awt.Color.magenta);
    v5.setBackground(java.awt.Color.magenta);
    v6.setBackground(java.awt.Color.magenta);
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    insert.addActionListener(this);
    view.addActionListener(this);
    Reset.addActionListener(this);
    exit.addActionListener(this);
}

   
@Override
public void actionPerformed(ActionEvent ae)
{
    if("EXIT".equals(ae.getActionCommand()))
    {
        System.exit(0);
    }
    
     if("BOOK".equals(ae.getActionCommand()))
     {
                  int i = 0;
                  int d1=0,d2=0,m1=0,m2=0,y1=0,y2=0;
                  if(c1.isSelected())
                          i=1;
                  if(c2.isSelected())
                          i=2;
                   if(c3.isSelected())
                          i=3;         
                    for(int j=0;j<dte.length;j++)
                          if(dte[j].equals(v1.getSelectedItem().toString()))
                              d1=j+1;
                    for(int j=0;j<mte.length;j++)
                          if(mte[j].equals(v2.getSelectedItem().toString()))
                              m1=j+1;
                    for(int j=0;j<yr.length;j++)
                          if(yr[j].equals(v3.getSelectedItem().toString()))
                              y1=j+1;
                    for(int j=0;j<dte.length;j++)
                          if(dte[j].equals(v4.getSelectedItem().toString()))
                              d2=j+1;
                    for(int j=0;j<mte.length;j++)
                          if(mte[j].equals(v5.getSelectedItem().toString()))
                              m2=j+1;
                    for(int j=0;j<yr.length;j++)
                          if(yr[j].equals(v6.getSelectedItem().toString()))
                              y2=j+1;         
                                       
                customer s=new customer();
                FileHandle h=new FileHandle("BookingLogs.txt");
       
                  s.setName(pub_name.getText());
                  s.setRoomType(i);
                  s.setCheckIn(y1,m1,d1);
                  s.setCheckOut(y2,m2,d2);
                  double feet=s.getFees();
                  String pphone=pub_phone.getText();
                  try
                  {
                      stat3=1;
                      if(pub_name.getText().isEmpty()){
                       throw new InvalNmAdd("Exception");
                      }
                  }
                  catch(InvalNmAdd e1)
                  {
                      stat3=0;
                     JOptionPane.showMessageDialog(f1,"Please enter a name","Warning",JOptionPane.WARNING_MESSAGE);
                      pub_name.setText("");
                  }
                          
                  try{
                      stat=1;
                      pphone=pub_phone.getText();
                      if((pphone.length()!=10)||(!(pphone.matches("[0-9]+"))))
                          throw new MobileNoException("Exception");                                  
                  }
                  catch(MobileNoException r)
                  { stat3=0;
                     JOptionPane.showMessageDialog(f1,"Invalid Mobile No.","Warning",JOptionPane.WARNING_MESSAGE);
                  
                       pub_phone.setText("");
                  }
                  try
                  {
                      if(stat != 0)
                      stat1=1;
                     
                     if(s.checkDate() || !s.isValidDate())
                        throw new InvalidDateExp("Exception");
                  }
                  catch(InvalidDateExp e)
                      {
                          stat1=0;
                       JOptionPane.showMessageDialog(f1,"Invalid Date.","Warning",JOptionPane.WARNING_MESSAGE);
                      System.out.println("Date catc"+stat);
                       if(stat1==0){
                   f1.setVisible(true);
                   v1.setSelectedIndex(0);
                   v2.setSelectedIndex(0);
                   v3.setSelectedIndex(0);
                   v4.setSelectedIndex(0);
                   v5.setSelectedIndex(0);
                   v6.setSelectedIndex(0);    
                      }
                       }
                   try{
                          stat2=1;
                      if(!c1.isSelected()&&!c2.isSelected()&&!c3.isSelected())                       
                          throw new Nobutttonsel("Exception");
                     }
                      catch(Nobutttonsel e)
                              {
                                  stat2=0;
                                   JOptionPane.showMessageDialog(f1,"Please select a room type.","Warning",JOptionPane.WARNING_MESSAGE);
                                   if(stat2==0)
                                      bg.clearSelection();
                                    //insert.setEnabled(false);
                              }
                  String paddress=pub_address.getText();
           
                  String room="";  
                  String room1="";
                  String name="NAME: "+ pub_name.getText();
                  int s1 = 1;
                  if(stat==1&&stat1==1&&stat2==1&&stat3==1)
                {
                  if(c1.isSelected()){
                           room="ROOM: "+c1.getText(); 
                           room=""+c1.getText();
                  }
                  if(c2.isSelected()){
                           room="ROOM: "+c2.getText(); 
                           room=""+c2.getText();
                  }
                  if(c3.isSelected()){
                      room="ROOM: "+c3.getText(); 
                      room=""+c3.getText();
                  }
                  
                      String dtci="DATE OF CHECK-IN: "+v1.getSelectedItem().toString()+"/"+v2.getSelectedItem().toString()+"/"+v3.getSelectedItem().toString();
                      String dtco="DATE OF CHECK-OUT: "+v4.getSelectedItem().toString()+"/"+v5.getSelectedItem().toString()+"/"+v6.getSelectedItem().toString();
                      String feest="AMOUNT: "+feet;
             
                      String finl=name+"\n"+room+"\n"+dtci+"\n"+dtco+"\n"+feest;
                    s1=JOptionPane.showConfirmDialog(rst,finl,"CONFIRM BOOKING",JOptionPane.YES_NO_OPTION);
                }  
                    if(s1==0 && stat==1&&stat1==1&&stat2==1&&stat3==1)
                    {
                    try {
                       String dtci1=""+v1.getSelectedItem().toString()+"/"+v2.getSelectedItem().toString()+"/"+v3.getSelectedItem().toString();
                      String dtco1=""+v4.getSelectedItem().toString()+"/"+v5.getSelectedItem().toString()+"/"+v6.getSelectedItem().toString();
                      String feest1=""+feet;
                            h.SaveName(pub_name.getText()+"\t"+room1+"\t"+pub_phone.getText()+"\t"+dtci1+"\t"+dtco1+"\t"+feest1);
                          } 
                     catch (IOException ex) {
                            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
                              }
                     JOptionPane.showMessageDialog(f1,"Information has beeen inserted.","Information",JOptionPane.INFORMATION_MESSAGE);
                    }
                if(stat==1&&stat1==1&&stat2==1&&stat3==1){
                   pub_name.setText("");
                   pub_phone.setText("");
                   pub_address.setText("");
                   bg.clearSelection();
                   f1.setVisible(true);
                   v1.setSelectedIndex(0);
                   v2.setSelectedIndex(0);
                   v3.setSelectedIndex(0);
                   v4.setSelectedIndex(0);
                   v5.setSelectedIndex(0);
                   v6.setSelectedIndex(0);
                }
     }
                 
    else if("VIEW LOGS".equals(ae.getActionCommand()))
    {
        FileHandle fh = new FileHandle("BookingLogs.txt");    
        Desktop dt = Desktop.getDesktop();
        try {
            dt.open(fh.f);
        } catch (IOException ex) {
            Logger.getLogger(Hotel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  else  if("CLEAR LOGS".equals(ae.getActionCommand()))
    {
        FileHandle st=new FileHandle("BookingLogs.txt");
        st.clearRecords();
         JOptionPane.showMessageDialog(f1,"Data is cleared.","Information",JOptionPane.INFORMATION_MESSAGE);
    }
        else
         {
               JOptionPane.showMessageDialog(f1,"Please fill details properly","ERROR Message",JOptionPane.ERROR_MESSAGE);
         }
     }    
    public static void main(String[] args) {
        Hotel p=new Hotel();
        p.compshow();
     }
    
}
