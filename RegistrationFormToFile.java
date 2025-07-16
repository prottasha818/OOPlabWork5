import javax.swing.*;
import java.io.*;

public class RegistrationFormToFile {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IIT Football Team Registration");
        frame.setSize(650, 650);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 20, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 20, 250, 25);
        frame.add(nameLabel);
        frame.add(nameField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 60, 100, 25);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 60, 250, 25);
        frame.add(phoneLabel);
        frame.add(phoneField);


        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 100, 100, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 100, 250, 25);
        frame.add(emailLabel);
        frame.add(emailField);

        //address
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 140, 100, 25);
        JTextField addressField = new JTextField();
        addressField.setBounds(150, 140, 250, 25);
        frame.add(addressLabel);
        frame.add(addressField);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 180, 100, 25);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(150, 180, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(220, 180, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);


        // DOB
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 230, 150, 25);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years = new String[100];
        for (int i = 0; i < 100; i++) years[i] = String.valueOf(2025 - i);

        JComboBox<String> dayBox = new JComboBox<>(days);
        JComboBox<String> monthBox = new JComboBox<>(months);
        JComboBox<String> yearBox = new JComboBox<>(years);
        dayBox.setBounds(150, 250, 70, 25);
        monthBox.setBounds(230, 250, 100, 25);
        yearBox.setBounds(340, 250, 100, 25);
        frame.add(dobLabel);
        frame.add(dayBox);
        frame.add(monthBox);
        frame.add(yearBox);

        
        //position
        JLabel positionLabel = new JLabel("Playing position:");
        positionLabel.setBounds(30, 300, 200, 25);
        String[] positions = {"Select", "Forward", "Defence", "Goalkeeper", "Mid Field"};
        JComboBox<String> positionBox = new JComboBox<>(positions);
        positionBox.setBounds(150, 300, 250, 25);
        frame.add(positionLabel);
        frame.add(positionBox);

        // match
        JLabel playedInterDeptLabel = new JLabel("Played Inter departmental competition?");
        playedInterDeptLabel.setBounds(30, 340, 320, 25);
        JRadioButton no = new JRadioButton("NO");
        no.setBounds(150, 360, 70, 25);
        JRadioButton yes = new JRadioButton("YES");
        yes.setBounds(230, 360, 80, 25);
        ButtonGroup choiceGroup = new ButtonGroup();
        choiceGroup.add(no);
        choiceGroup.add(yes);
        frame.add(playedInterDeptLabel);
        frame.add(no);
        frame.add(yes);

        //degree
        JLabel degreeLabel = new JLabel("Degree:");
        degreeLabel.setBounds(30, 400, 100, 25);
        JRadioButton masters = new JRadioButton("Masters");
        masters.setBounds(150, 400, 100, 25);
        JRadioButton bechelor = new JRadioButton("Bechelor");
        bechelor.setBounds(230, 400, 100, 25);
        ButtonGroup degreeChoice = new ButtonGroup();
        degreeChoice.add(masters);
        degreeChoice.add(bechelor);
        frame.add(degreeLabel);
        frame.add(masters);
        frame.add(bechelor);

        //experiences
        JLabel expLabel = new JLabel("Experience:");
        expLabel.setBounds(30, 440, 100, 25);
        JTextField expField = new JTextField();
        expField.setBounds(150, 440, 250, 25);
        frame.add(expLabel);
        frame.add(expField);


        // File Upload
        JLabel fileLabel = new JLabel("Profile Photo:");
        fileLabel.setBounds(30, 480, 100, 25);
        JButton fileButton = new JButton("Choose File");
        fileButton.setBounds(150, 480, 120, 25);
        JLabel filePathLabel = new JLabel();
        filePathLabel.setBounds(280, 480, 180, 25);
        frame.add(fileLabel);
        frame.add(fileButton);
        frame.add(filePathLabel);

        final String[] selectedFilePath = {""};
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                selectedFilePath[0] = file.getAbsolutePath();
                filePathLabel.setText(file.getName());
            }
        });

        // Register Button
        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(160, 540, 120, 30);
        frame.add(registerBtn);

        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = new String(phoneField.getText());
            String email = emailField.getText();
            String address = addressField.getText();
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not selected");
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String degree = masters.isSelected() ? "Masters" : (bechelor.isSelected() ? "Bechelor" : "Not selected");
            String position=(String)positionBox.getSelectedItem();
            String playedInterDept = no.isSelected() ? "NO" : (yes.isSelected() ? "YES" : "Not selected");
            String experience = nameField.getText();
            String photo = selectedFilePath[0].isEmpty() ? "Not uploaded" : selectedFilePath[0];

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.equals("Not selected") || address.isEmpty() || position.equals("Select") || degree.equals("Not selected") || photo.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all Information!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    FileWriter writer = new FileWriter("registration_data.txt", true); // true = append mode
                    writer.write("Name: " + name + "\n");
                    writer.write("Phone: " + phone + "\n");
                    writer.write("Email: " + email + "\n");
                    writer.write("Address: "+address+"\n");
                    writer.write("Gender: " + gender + "\n");
                    writer.write("DOB: " + dob + "\n");
                    writer.write("Degree: "+degree+"\n");
                    writer.write("Preferred position:"+position+"\n");
                    writer.write("Played Inter-departmental competition: " + playedInterDept + "\n");
                    writer.write("Experience: "+experience+"\n");
                    writer.write("Profile Photo: " + photo + "\n");
                    writer.write("----------------------------------\n");
                    writer.close();

                    JOptionPane.showMessageDialog(frame, "Registration Saved Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Clear the form
                    nameField.setText("");
                    phoneField.setText("");
                    emailField.setText("");
                    addressField.setText("");
                    genderGroup.clearSelection();
                    choiceGroup.clearSelection();
                    dayBox.setSelectedIndex(0);
                    monthBox.setSelectedIndex(0);
                    yearBox.setSelectedIndex(0);
                    positionBox.setSelectedIndex(0);
                    degreeChoice.clearSelection();
                    filePathLabel.setText("");
                    selectedFilePath[0] = "";
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error writing to file!", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }
}