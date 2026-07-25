import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;



public class GUI {
    
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str); 
            return true; 
        } catch (NumberFormatException e) {
            return false; 
        }
    }
    
    private boolean isAlphabetic(String str) {
    return str.matches("[a-zA-Z\\s]+"); 
    }

    private boolean isValidCNIC(String cnic) {
    return cnic.matches("\\d{5}-\\d{7}-\\d{1}"); 
    }
    
    public GUI(){
        AdmissionManager manager = new AdmissionManager();

        JFrame frame = new JFrame("Admission Management System");
        frame.setUndecorated(false);                
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,940);
        
        frame.setLayout(new CardLayout());
        frame.setResizable(false);      
        frame.setVisible(true);
    
        JPanel mainPanel = new JPanel(new CardLayout());
        frame.add(mainPanel);
        
        JPanel introPanel = new JPanel(null); 

        JPanel startPanel = new JPanel(null);
        startPanel.setBackground(Color.WHITE); 

        JPanel loginPanel = new JPanel(null);
        loginPanel.setBackground(Color.WHITE);

        JPanel registerPanel = new JPanel(null);
        registerPanel.setBackground(Color.WHITE);

        JPanel dashboardPanel = new JPanel(null);
        dashboardPanel.setBackground(Color.WHITE);
        
        try {
        
            final Image backgroundImage = ImageIO.read(new File("intropage.jpg")); 

            
            Image scaledImage = backgroundImage.getScaledInstance(900, 950, Image.SCALE_SMOOTH);
            
            
            JPanel imagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Draw the image as background
                    g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), null);  
                }
            };
            imagePanel.setBounds(0, 400, 900, 400); 
            introPanel.add(imagePanel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton applyOnlineButton = new JButton("Apply Online");
        applyOnlineButton.setBounds(310, 250, 200, 40);
        applyOnlineButton.setBackground(Color.RED);
        applyOnlineButton.setForeground(Color.BLACK);
        Font applyButtonFont = new Font("Arial", Font.PLAIN, 16);
        applyOnlineButton.setFont(applyButtonFont);
        introPanel.add(applyOnlineButton);
        
        JLabel contactUsLabel = new JLabel("<html>"+
                                            "<div style='font-size:12px; background-color:white; text-allign:center;'>For Admission Related Querries Contact Us At onlineadmission@gcu.edu.pk OR Dial 042 111 000 010 </div>"+
                                            "</html>",
                                            SwingConstants.CENTER
                                            );
        contactUsLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        contactUsLabel.setForeground(Color.RED);
        contactUsLabel.setBackground(Color.WHITE);
        contactUsLabel.setBounds(30, 300, 800, 80); 
        introPanel.add(contactUsLabel);      
        
        JLabel introLabel = new JLabel(
                "<html>" +
                        "<div style='font-size:20px; text-align:center;'>Government College University Lahore</div>" + 
                        "<div style='font-size:17px; text-align:center;'>Kacheri Road Lahore</div>" + 
                        "<div style='font-size:16px; text-align:center;'><br>     ADMISSIONS IN UNDERGRADUATE PROGRAMS HAS BEEN OPENED LAST DATE TO APPLY IS 31st-JULY-2024</div>" + 
                        "</html>",
                SwingConstants.CENTER
        );
        
        introLabel.setFont(new Font("Arial", Font.BOLD, 18));
        introLabel.setForeground(Color.BLACK);
        introLabel.setBounds(60, 20, 700, 150);  
        introPanel.add(introLabel);
        
        JLabel introLabel2 = new JLabel(
                "<html>" +
                        "<div style='font-size:14px; text-align:center;'>CANDIDATES HAVING 50% MARKS IN FSC ARE ELIGIBLE TO APPLY </div>" + 
                        "<div style='font-size:14px; text-align:center;'>WEIGHTAGE: MATRIC=10%, FSC=50%, ENTRY TEST=30%, INTERVIEW=10%</div>" +
                        "</html>",
                SwingConstants.CENTER
        );
        
        introLabel2.setFont(new Font("Arial", Font.BOLD, 14));
        introLabel2.setForeground(Color.RED);
        introLabel2.setBounds(60, 135, 700, 150);  
        introPanel.add(introLabel2); 
        
        ImageIcon logo = new ImageIcon("updatedlogo.png"); 
        JLabel logoLabel = new JLabel(logo);  
        Image logoImage = logo.getImage();  
        logoLabel.setBounds(10, 10, 90, 110); 
        startPanel.add(logoLabel);
    
        ImageIcon logo2 = new ImageIcon("updatedlogo2.png"); 
        JLabel logoLabel2 = new JLabel(logo2);  
        Image logo2Image = logo2.getImage();  
        logoLabel2.setBounds(750, 30, 80, 93); 
        startPanel.add(logoLabel2);
        
        ImageIcon intro = new ImageIcon("updatedlogo.png"); 
        JLabel introImg = new JLabel(intro);  
        Image introImage = intro.getImage();  
        introImg.setBounds(10, 10, 90, 110); 
        introPanel.add(introImg);


        JLabel titleLabel = new JLabel(
        "<html>" +
                "<span style='font-size:20px;'>Government College University Lahore</span><br>" +  
               "<div style='text-align:center;<span style='font-size:18px;'>Kacheri Road Lahore<br>Department of Computer Science<br>BSCS Admission Fall 2024</span></div>" +
       "</html>",
        SwingConstants.CENTER
       );


       titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
       titleLabel.setForeground(Color.BLACK);
       titleLabel.setBounds(50, 20, 700, 120);  
       startPanel.add(titleLabel);

       JButton loginButton = new JButton("Login");
       loginButton.setBounds(300, 180, 200, 40); 
       loginButton.setBackground(Color.RED);
       Font buttonFont = new Font("Arial", Font.PLAIN, 16);
       loginButton.setForeground(Color.BLACK);
       loginButton.setFont(buttonFont);
       startPanel.add(loginButton);

       JButton registerButton = new JButton("Register");
       registerButton.setBounds(300, 240, 200, 40);  
       Font registerFont = new Font("Arial", Font.PLAIN, 16);
       registerButton.setForeground(Color.BLACK);
       registerButton.setFont(registerFont);
       registerButton.setBackground(Color.RED);
       startPanel.add(registerButton);

       JButton meritListButton = new JButton("Merit List");
       meritListButton.setBounds(300, 300, 200, 40);  
       Font meritFont = new Font("Arial", Font.PLAIN, 16);
       meritListButton.setForeground(Color.BLACK);
       meritListButton.setFont(meritFont);
       meritListButton.setBackground(Color.RED);
       startPanel.add(meritListButton);

        try {
            
            final Image backgroundImage = ImageIO.read(new File("lightsky.jpg")); 

            
            Image scaledImage = backgroundImage.getScaledInstance(900, 950, Image.SCALE_SMOOTH);
            
           
            JPanel imagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    
                    g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), null);  
                }
            };
            imagePanel.setBounds(0, 0, 900, 400); 
            startPanel.add(imagePanel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            
            final Image backgroundImage = ImageIO.read(new File("gc uni.jpg")); 

            
            Image scaledImage = backgroundImage.getScaledInstance(900, 950, Image.SCALE_SMOOTH);
            
            
            JPanel imagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    
                    g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), null);  
                }
            };
            imagePanel.setBounds(0, 400, 900, 400); 
            startPanel.add(imagePanel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        applyOnlineButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "Start");
        });

        JLabel loginLabel = new JLabel("Enter Roll Number", SwingConstants.CENTER);
        loginLabel.setBounds(150, 50, 500, 40);
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 14));
        loginPanel.add(loginLabel);

        JTextField loginRollNumberField = new JTextField();
        loginRollNumberField.setText("Enter Roll Number");
        loginRollNumberField.setBounds(250, 100, 300, 40);
        loginRollNumberField.setBackground(new Color(255, 236, 200));
        loginPanel.add(loginRollNumberField);

        loginRollNumberField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginRollNumberField.setText("");
            }
        });

        JButton loginSubmitButton = new JButton("Login");
        loginSubmitButton.setBounds(408, 160, 140, 40);
        loginSubmitButton.setBackground(Color.CYAN);
        loginSubmitButton.setForeground(Color.RED);
        contactUsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        loginPanel.add(loginSubmitButton);
        loginSubmitButton.addActionListener(e -> {
            loginRollNumberField.setText("Enter Roll Number");
        });

        JButton backButtonLogin = new JButton("Back");
        backButtonLogin.setBounds(10, 10, 100, 30);
        backButtonLogin.setBackground(Color.CYAN);
        loginPanel.add(backButtonLogin);

        JButton PassRecoveryButton = new JButton("Recover Password");
        PassRecoveryButton.setBounds(250, 160, 150, 40);
        PassRecoveryButton.setBackground(Color.CYAN);
        PassRecoveryButton.setForeground(Color.BLACK);
        loginPanel.add(PassRecoveryButton);
        
        try {
            
            final Image backgroundImage = ImageIO.read(new File("img.jpg")); 

            
            Image scaledImage = backgroundImage.getScaledInstance(900, 950, Image.SCALE_SMOOTH);
            
         
            JPanel imagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                 
                    g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), null);  
                }
            };
            imagePanel.setBounds(0, 0, 900, 950); 
            loginPanel.add(imagePanel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        JLabel registerLabel = new JLabel("Get Registered !", SwingConstants.CENTER);
        registerLabel.setBounds(150, 10, 500, 40);
        registerLabel.setForeground(new Color(128, 0, 0));
        registerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        registerPanel.add(registerLabel);
        
        JTextField formField = new JTextField("Form Number");
        formField.setBounds(250, 60, 300, 40);
        formField.setBackground(new Color(255, 236, 200));
        registerPanel.add(formField);
        formField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formField.setText("");
            }
        });

        JTextField nameField = new JTextField("Enter Name");
        nameField.setBounds(250, 120, 300, 40);
        nameField.setBackground(new Color(255, 236, 200));
        registerPanel.add(nameField);
        nameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameField.setText("");
            }
        });

        JTextField fatherNameField = new JTextField("Enter Father's Name");
        fatherNameField.setBounds(250, 180, 300, 40);
        fatherNameField.setBackground(new Color(255, 236, 200));
        registerPanel.add(fatherNameField);
        fatherNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fatherNameField.setText("");
            }
        });

        JTextField matricMarksField = new JTextField("Enter Matric Marks (Out of 1000)");
        matricMarksField.setBounds(250, 240, 300, 40);
        matricMarksField.setBackground(new Color(255, 236, 200));
        registerPanel.add(matricMarksField);
        matricMarksField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                matricMarksField.setText("");
            }
        });

        JTextField fscMarksField = new JTextField("Enter F.Sc Marks (Out of 1100)");
        fscMarksField.setBounds(250, 300, 300, 40);
        fscMarksField.setBackground(new Color(255, 236, 200));
        registerPanel.add(fscMarksField);
        fscMarksField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fscMarksField.setText("");
            }
        });

        JTextField CNICField = new JTextField("Enter Your CNIC");
        CNICField.setBounds(250, 360, 300, 40);
        CNICField.setBackground(new Color(255, 236, 200));
        registerPanel.add(CNICField);
        CNICField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CNICField.setText("");
            }
        });
        
        JButton registerSubmitButton = new JButton("Register");
        registerSubmitButton.setBounds(350, 440, 100, 40);
        registerSubmitButton.setBackground(Color.RED);
        registerSubmitButton.setForeground(Color.BLACK);
        registerSubmitButton.setFont(new Font("Arial", Font.BOLD, 15));
        registerPanel.add(registerSubmitButton);

        registerButton.addActionListener(e -> {
            formField.setText("Enter Form Number");
            nameField.setText("Enter Name");
            fatherNameField.setText("Enter Father's Name");
            matricMarksField.setText("Enter Matric Marks (Out of 1000)");
            fscMarksField.setText("Enter F.Sc Marks (Out of 1100)");
            CNICField.setText("Enter Your CNIC");
        });

        JButton backButtonRegister = new JButton("Back");
        backButtonRegister.setBounds(10, 10, 100, 30);
        backButtonRegister.setBackground(Color.CYAN);
        registerPanel.add(backButtonRegister);
        
        try {
            
            final Image backgroundImage = ImageIO.read(new File("reg.jpeg")); 

            
            Image scaledImage = backgroundImage.getScaledInstance(900, 950, Image.SCALE_SMOOTH);
            
            
            JPanel imagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    
                    g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), null);  
                }
            };
            imagePanel.setBounds(0, 0, 900, 950); 
            registerPanel.add(imagePanel);

        } catch (IOException e) {
            e.printStackTrace();
        }

        meritListButton.addActionListener(e -> {
            try {
                List<Student> eligibleStudents = manager.getEligibleStudentsForMeritList();

                if (eligibleStudents.isEmpty()) {
                    throw new IllegalArgumentException("No Eligible Students Found For The Merit List.");
                }

                String input = JOptionPane.showInputDialog(frame, "Enter The Number Of Top Students For Merit List Generation:");
                int topCount = Integer.parseInt(input.trim());

                if (topCount <= 0 || topCount > eligibleStudents.size()) {
                    throw new IllegalArgumentException("Invalid Number Entered. Please Try Again!!!");
                }

                StringBuilder meritList = new StringBuilder("<html><table border='1'><tr><th>Rank</th><th>Name</th><th>Roll No</th><th>Final Score</th></tr>");
                for (int i = 0; i < topCount; i++) {
                    Student s = eligibleStudents.get(i);
                    meritList.append("<tr><td>").append(i + 1).append("</td><td>")
                            .append(s.name).append("</td><td>")
                            .append(s.rollNumber).append("</td><td>")
                            .append(String.format("%.2f", s.finalScore)).append("</td></tr>");
                }
                meritList.append("</table></html>");

                JLabel meritListLabel = new JLabel(meritList.toString());
                JOptionPane.showMessageDialog(frame, meritListLabel, "Merit List", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please Enter A Valid Number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        PassRecoveryButton.addActionListener(e -> {
            JTextField CNICRecoveryField = new JTextField("Enter Your CNIC in this format XXXXX-XXXXXXX-X");
            

            CNICRecoveryField.addFocusListener(new java.awt.event.FocusAdapter() {
                public void focusGained(java.awt.event.FocusEvent evt) {
                    CNICRecoveryField.setText("");
                }
            });


            Object[] recoveryFields = {
                    "CNIC:", CNICRecoveryField,
            };

            int option = JOptionPane.showConfirmDialog(frame, recoveryFields, "Recover Roll Number", JOptionPane.OK_CANCEL_OPTION);
            
            

            if (option == JOptionPane.OK_OPTION) {
                String CNIC = CNICRecoveryField.getText().trim();

                
                Student student = manager.recoverRollNumber(CNIC);
                

                if (student != null) {
                    JOptionPane.showMessageDialog(frame, "Roll Number: " + student.rollNumber);
                } 
                else {
                    JOptionPane.showMessageDialog(frame, "No Record Found.", "Error!!!", JOptionPane.ERROR_MESSAGE);
                 
                }
            }
            
        });

        mainPanel.add(introPanel, "Intro");
        mainPanel.add(startPanel, "Start");
        mainPanel.add(loginPanel, "Login");
        mainPanel.add(registerPanel, "Register");
        mainPanel.add(dashboardPanel, "Dashboard");

        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();

        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        registerButton.addActionListener(e -> cardLayout.show(mainPanel, "Register"));

        backButtonLogin.addActionListener(e -> cardLayout.show(mainPanel, "Start"));
        backButtonRegister.addActionListener(e -> cardLayout.show(mainPanel, "Start"));

        registerSubmitButton.addActionListener(e -> {
            try {
                String formNumber = formField.getText().trim();
                String name = nameField.getText().trim();
                String fatherName = fatherNameField.getText().trim();
                String CNIC = CNICField.getText().trim();

                if (!isAlphabetic(name)) {
                throw new IllegalArgumentException("Name must contain only alphabets and spaces.");
                }
        
                if (!isAlphabetic(fatherName)) {
                throw new IllegalArgumentException("Father's Name must contain only alphabets and spaces.");
                }
                
                String matricMarksText = matricMarksField.getText().trim();
                if (!isNumeric(matricMarksText)) {
                throw new IllegalArgumentException("Matric Marks must be a valid number.");
                }
                double matricMarks = Double.parseDouble(matricMarksText);

                String fscMarksText = fscMarksField.getText().trim();
                if (!isNumeric(fscMarksText)) {
                throw new IllegalArgumentException("F.Sc Marks must be a valid number.");
                }
                double fscMarks = Double.parseDouble(fscMarksText);
            
                if (matricMarks < 0 || matricMarks > 1000) {
                    throw new IllegalArgumentException("Matric marks must be between 0 and 1000.");
                }
                if (fscMarks < 0 || fscMarks > 1100) {
                    throw new IllegalArgumentException("F.Sc marks must be between 0 and 1100.");
                }
                if (fscMarks < 550) {
                    throw new IllegalArgumentException("You Are Not Eligible");
                } 
       
               if (!isValidCNIC(CNIC)) {
               throw new IllegalArgumentException("CNIC must be in the format XXXXX-XXXXXXX-X.");
               }
               
               if (manager.isFormNumberDuplicate(formNumber)) {
               throw new IllegalArgumentException("This Form Number is already registered.");
               } 
             
               if (manager.isCnicDuplicate(CNIC)) {
               throw new IllegalArgumentException("This CNIC is already registered.");
               }
               
                Student student = manager.registerStudent(formNumber, name, fatherName, CNIC, matricMarks, fscMarks);
                JOptionPane.showMessageDialog(frame, "Registration Successful! Roll Number: " + student.rollNumber);
                cardLayout.show(mainPanel, "Start");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter valid numeric values for marks.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        loginSubmitButton.addActionListener(e -> {
            try {
                int rollNumber = Integer.parseInt(loginRollNumberField.getText().trim());
                Student student = manager.findStudentByRollNumber(rollNumber);

                if (student == null) {
                    throw new IllegalArgumentException("Roll Number not found. Please register first.");
                }

                dashboardPanel.removeAll();

                JLabel welcomeLabel = new JLabel("Welcome " + student.name, SwingConstants.CENTER);
                welcomeLabel.setForeground(Color.BLACK);
                welcomeLabel.setBounds(150, 50, 500, 40);
                welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
                dashboardPanel.add(welcomeLabel);

                JButton updateMarksButton = new JButton("Upload Marks");
                updateMarksButton.setBounds(300, 120, 200, 40);
                updateMarksButton.setBackground(Color.CYAN);
                updateMarksButton.setForeground(Color.BLACK);
                updateMarksButton.setFont(new Font("Arial", Font.BOLD, 16));
                dashboardPanel.add(updateMarksButton);

                JButton studentDetailsButton = new JButton("Student Details");
                studentDetailsButton.setBounds(300, 180, 200, 40);
                studentDetailsButton.setBackground(Color.CYAN);
                studentDetailsButton.setForeground(Color.BLACK);
                studentDetailsButton.setFont(new Font("Arial", Font.BOLD, 16));
                dashboardPanel.add(studentDetailsButton);

                JButton logoutButton = new JButton("Logout");
                logoutButton.setBounds(300, 240, 200, 40);
                logoutButton.setBackground(Color.CYAN);
                logoutButton.setForeground(Color.BLACK);
                logoutButton.setFont(new Font("Arial", Font.BOLD, 16));
                dashboardPanel.add(logoutButton);

                cardLayout.show(mainPanel, "Dashboard");
                
                try {
            
                     final Image backgroundImage = ImageIO.read(new File("c4.png")); 

                     Image scaledImage = backgroundImage.getScaledInstance(900, 950, Image.SCALE_SMOOTH);
           
                     JPanel imagePanel = new JPanel() {
                       @Override
                       protected void paintComponent(Graphics g) {
                       super.paintComponent(g);
                       g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), null);  
                       }
                    };
                    imagePanel.setBounds(0, 0, 900, 950); 
                    dashboardPanel.add(imagePanel);

                   } catch (IOException ex) {
                   ex.printStackTrace();
                };

                    updateMarksButton.addActionListener(updateEvent -> {
                    JTextField testMarksField = new JTextField("Enter Test Marks (out of 50)");
                    JTextField interviewMarksField = new JTextField("Enter Interview Marks (out of 20)");

                    testMarksField.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                            testMarksField.setText("");
                        }
                    });

                    interviewMarksField.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                            interviewMarksField.setText("");
                        }
                    });

                    Object[] updateFields = {
                            "Test Marks:", testMarksField,
                            "Interview Marks:", interviewMarksField
                    };

                    int option = JOptionPane.showConfirmDialog(frame, updateFields, "Update Marks", JOptionPane.OK_CANCEL_OPTION);

                    if (option == JOptionPane.OK_OPTION) {
                        try {
                            double testMarks = Double.parseDouble(testMarksField.getText().trim());
                            double interviewMarks = Double.parseDouble(interviewMarksField.getText().trim());

                            if (testMarks < 0 || testMarks > 50) {
                                throw new IllegalArgumentException("Test marks must be between 0 and 50.");
                            }
                            if (interviewMarks < 0 || interviewMarks > 20) {
                                throw new IllegalArgumentException("Interview marks must be between 0 and 20.");
                            }

                            student.testMarks = testMarks;
                            student.interviewMarks = interviewMarks;
                            student.calculateFinalScore();

                            JOptionPane.showMessageDialog(frame, "Marks updated successfully.");
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Please Enter Valid Numeric Values.", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (IllegalArgumentException ex) {
                            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

                logoutButton.addActionListener(logoutEvent -> cardLayout.show(mainPanel, "Start"));
                studentDetailsButton.addActionListener(studentDetailsEvent -> {
                    String studentDetails =
                            "<html>" +
                            "<table border='1' cellpadding='5' cellspacing='0'>" +
                            "<tr><th>Field</th><th>Value</th></tr>" +
                            "<tr><td>Form Number</td><td>" + student.formNumber + "</td></tr>" +
                            "<tr><td>Roll Number</td><td>" + student.rollNumber + "</td></tr>" +
                            "<tr><td>Name</td><td>" + student.name + "</td></tr>" +
                            "<tr><td>Father's Name</td><td>" + student.fatherName + "</td></tr>" +
                            "<tr><td>Matric Marks</td><td>" + student.matricMarks + "</td></tr>" +
                            "<tr><td>F.Sc Marks</td><td>" + student.fscMarks + "</td></tr>" +
                            "<tr><td>Test Marks</td><td>" + student.testMarks + "</td></tr>" +
                            "<tr><td>Interview Marks</td><td>" + student.interviewMarks + "</td></tr>" +
                            "<tr><td>Final Score</td><td>" + String.format("%.2f", student.finalScore) + "</td></tr>" +
                            "</table>" +
                            "</html>";

                    JOptionPane.showMessageDialog(frame, studentDetails, "Student Details", JOptionPane.INFORMATION_MESSAGE);
                });


            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please Enter A Valid Roll Number.", "Error!!!", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error!!!", JOptionPane.ERROR_MESSAGE);
            }
        });
 
        frame.setVisible(true);
    }
};

        
