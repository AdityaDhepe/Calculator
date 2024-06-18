package miniProject;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

class MainPage {
    public static void main(String []args) {
        new LoginForm();
    }
}

class LoginForm {    
    LoginForm(){
        JLabel lblh = new JLabel("-- Please Login to Access the Calculator --");
        lblh.setBounds(70, 20, 250, 30);
        JLabel lblresult = new JLabel();
        lblresult.setBounds(50, 235, 400, 35);
        JFrame F1 = new JFrame();
        JLabel lblun = new JLabel("Username :");
        lblun.setBounds(50, 100, 150, 35);
        JTextField txtun = new JTextField();
        txtun.setBounds(230, 100, 100, 35);
        JLabel lblpw = new JLabel("Password :");
        lblpw.setBounds(50, 145, 150, 35);
        JPasswordField PFpw = new JPasswordField();
        PFpw.setBounds(230, 145, 100, 35);
        JLabel lblcf = new JLabel("Confirm \nPassword :");
        lblcf.setBounds(50, 190, 150, 35);
        JPasswordField PFcf = new JPasswordField();
        PFcf.setBounds(230, 190, 100, 35);
        JButton btn = new JButton("Login");
        btn.setBounds(150, 280, 70, 30);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae) {
                String pw = new String(PFpw.getPassword());
                String cf = new String(PFcf.getPassword());
                if(cf.equals(pw)){
                    lblresult.setText("Login Successful!!");
                    F1.dispose();
                    new Dashboard();
                }
                else{
                    lblresult.setText("Password doesn't match. Enter correct password");
                }
            }
        });

        F1.add(lblh);
        F1.add(lblun);
        F1.add(txtun);
        F1.add(lblpw);
        F1.add(PFpw);
        F1.add(lblcf);
        F1.add(PFcf);
        F1.add(lblresult);
        F1.add(btn);
        F1.setTitle("Login Form");
        F1.setSize(400, 500);
        F1.setLayout(null);
        F1.setVisible(true);
        F1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Dashboard {
    Dashboard() {
        JFrame F2 = new JFrame();
        JButton btnC = new JButton("Calculator");
        btnC.setBounds(10, 20, 185, 185);
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F2.dispose();
                new Calculator();
            }
        });

        JButton btnT = new JButton("Thermal");
        btnT.setBounds(205, 20, 185, 185);
        btnT.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F2.dispose();
                new Thermal();
            }
        });

        JButton btnL = new JButton("Length");
        btnL.setBounds(10, 215, 185, 185);
        btnL.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F2.dispose();
                new Length();
            }
        });

        JButton btnB = new JButton("BMI");
        btnB.setBounds(205, 215, 185, 185);
        btnB.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F2.dispose();
                new BMI();
            }
        });

        F2.add(btnC);
        F2.add(btnT);
        F2.add(btnL);
        F2.add(btnB);
        F2.setTitle("Dashboard");
        F2.setSize(420, 500);
        F2.setLayout(null);
        F2.setVisible(true);
        F2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Calculator {
    Calculator() {
        JLabel Exp = new JLabel();
        Exp.setBounds(250, 50, 150, 50);
        JLabel Result = new JLabel();
        Result.setBounds(300, 110, 100, 50);
        StringBuffer s1 = new StringBuffer();
        JFrame F3 = new JFrame();

        JButton Ans = new JButton("Ans");
        Ans.setBounds(290, 380, 60, 60);
        Ans.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                int i = 0;
                for(char s : s1.toString().toCharArray()){
                    if (s == '.' || s == '/')
                        i++;
                }
                if(i == 0){
                    int answer = evaluateExpression1(s1.toString());
                    Result.setText(Integer.toString(answer));
                }
                else{
                    double answer = evaluateExpression(s1.toString());
                    Result.setText(Double.toString(answer));
                }
            }
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(220, 380, 60, 60);
        Dot.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(".");
                Exp.setText(s1.toString());
            }
        });

        JButton Zero = new JButton("0");
        Zero.setBounds(150, 380, 60, 60);
        Zero.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("0");
                Exp.setText(s1.toString());
            }
        });

        JButton Change = new JButton("C");
        Change.setBounds(80, 380, 60, 60);
        Change.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.delete(0, (s1.length()));
                Exp.setText(s1.toString());
                Result.setText(null);
            }
        });

        JButton CBracket = new JButton(")");
        CBracket.setBounds(10, 380, 60, 60);
        CBracket.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(" ) ");
                Exp.setText(s1.toString());
            }
        });

        JButton Add = new JButton("+");
        Add.setBounds(290, 310, 60, 60);
        Add.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(" + ");
                Exp.setText(s1.toString());
            }
        });

        JButton Three = new JButton("3");
        Three.setBounds(220, 310, 60, 60);
        Three.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("3");
                Exp.setText(s1.toString());
            }
        });

        JButton Two = new JButton("2");
        Two.setBounds(150, 310, 60, 60);
        Two.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("2");
                Exp.setText(s1.toString());
            }
        });

        JButton One = new JButton("1");
        One.setBounds(80, 310, 60, 60);
        One.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("1");
                Exp.setText(s1.toString());
            }
        });

        JButton OBracket = new JButton("(");
        OBracket.setBounds(10, 310, 60, 60);
        OBracket.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(" ( ");
                Exp.setText(s1.toString());
            }
        });

        JButton Sub = new JButton("-");
        Sub.setBounds(290, 240, 60, 60);
        Sub.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(" - ");
                Exp.setText(s1.toString());
            }
        });

        JButton Six = new JButton("6");
        Six.setBounds(220, 240, 60, 60);
        Six.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("6");
                Exp.setText(s1.toString());
            }
        });

        JButton Five = new JButton("5");
        Five.setBounds(150, 240, 60, 60);
        Five.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("5");
                Exp.setText(s1.toString());
            }
        });

        JButton Four = new JButton("4");
        Four.setBounds(80, 240, 60, 60);
        Four.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("4");
                Exp.setText(s1.toString());
            }
        });

        JButton Div = new JButton("/");
        Div.setBounds(10, 240, 60, 60);
        Div.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(" / ");
                Exp.setText(s1.toString());
            }
        });

        JButton Mul = new JButton("x");
        Mul.setBounds(290, 170, 60, 60);
        Mul.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(" x ");
                Exp.setText(s1.toString());
            }
        });

        JButton Nine = new JButton("9");
        Nine.setBounds(220, 170, 60, 60);
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("9");
                Exp.setText(s1.toString());
            }
        });

        JButton Eight = new JButton("8");
        Eight.setBounds(150, 170, 60, 60);
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("8");
                Exp.setText(s1.toString());
            }
        });

        JButton Seven = new JButton("7");
        Seven.setBounds(80, 170, 60, 60);
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("7");
                Exp.setText(s1.toString());
            }
        });
        
        JButton Raise = new JButton("< -");
        Raise.setBounds(10, 170, 60, 60);
        Raise.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.deleteCharAt(s1.length());
                s1.deleteCharAt(s1.length());
                Exp.setText(s1.toString());
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Dashboard();
            }
        });

        F3.add(Ans);
        F3.add(Dot);
        F3.add(Zero);
        F3.add(Change);
        F3.add(CBracket);
        F3.add(Add);
        F3.add(Three);
        F3.add(Two);
        F3.add(One);
        F3.add(OBracket);
        F3.add(Sub);
        F3.add(Six);
        F3.add(Five);
        F3.add(Four);
        F3.add(Div);
        F3.add(Mul);
        F3.add(Nine);
        F3.add(Eight);
        F3.add(Seven);
        F3.add(Raise);
        F3.add(Dash);
        F3.add(Exp);
        F3.add(Result);
        F3.setTitle("Calculator");
        F3.setSize(400, 500);
        F3.setLayout(null);
        F3.setVisible(true);
        F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static double evaluateExpression(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ' ')
                continue;
            if (Character.isDigit(c) || c == '.') {
                StringBuilder sb = new StringBuilder();
                // Collect all consecutive digits to form the complete number
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    char currentChar = expression.charAt(i);
                    sb.append(currentChar);
                    i++;
                }
                i--; // Decrement i to ensure the next iteration starts from the correct position
                values.push(Double.parseDouble(sb.toString()));
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c);
            }
        }
        
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }
        
        return values.pop();
    }    

    public static int evaluateExpression1(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ' ')
                continue;
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                values.push(Integer.parseInt(sb.toString()));
                i--;
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator1(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (isOperator(c)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    values.push(applyOperator1(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c);
            }
        }
        
        while (!operators.isEmpty()) {
            values.push(applyOperator1(operators.pop(), values.pop(), values.pop()));
        }
        
        return values.pop();
    }

    private static int applyOperator1(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Division by zero");
                return a / b;
        }
        return 0;
    }    
    
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == 'x' || c == '/';
    }
    
    private static int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        if (op == 'x' || op == '/')
            return 2;
        return 0;
    }
    
    private static double applyOperator(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case 'x':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Division by zero");
                return a / b;
        }
        return 0;
    }
}

class Length {
    Length() {
        JFrame F4 = new JFrame();
        JButton btnmm = new JButton("mm");
        btnmm.setBounds(50, 75, 100, 50);
        btnmm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F4.dispose();
                new milimeter();
            }
        });

        JButton btncm = new JButton("cm");
        btncm.setBounds(200, 75, 100, 50);
        btncm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F4.dispose();
                new centimeter();
            }
        });

        JButton btnm = new JButton("m");
        btnm.setBounds(50, 150, 100, 50);
        btnm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F4.dispose();
                new meter();
            }
        });

        JButton btnkm = new JButton("km");
        btnkm.setBounds(200, 150, 100, 50);
        btnkm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F4.dispose();
                new kilometer();
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F4.dispose();
                new Dashboard();
            }
        });

        F4.add(btnmm);
        F4.add(btncm);
        F4.add(btnm);
        F4.add(btnkm);
        F4.add(Dash);
        F4.setTitle("Length Calculator");
        F4.setSize(400, 500);
        F4.setLayout(null);
        F4.setVisible(true);
        F4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class milimeter {
    milimeter() {
        JLabel Exp = new JLabel();
        Exp.setBounds(250, 50, 150, 50);
        JLabel mili = new JLabel("mm");
        mili.setBounds(320, 50, 35, 50);
        JLabel Result = new JLabel();
        Result.setBounds(250, 110, 100, 50);
        StringBuffer s1 = new StringBuffer();
        JFrame F3 = new JFrame();

        JButton m = new JButton("m");
        m.setBounds(290, 380, 60, 60);
        m.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "m");
                Result.setText(Double.toString(answer) + "  m");
            }
        });

        JButton dm = new JButton("dm");
        dm.setBounds(220, 380, 60, 60);
        dm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "dm");
                Result.setText(Double.toString(answer) + "  dm");
            }
        });

        JButton cm = new JButton("cm");
        cm.setBounds(290, 170, 60, 60);
        cm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "cm");
                Result.setText(Double.toString(answer) + "  cm");
            }
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(150, 380, 60, 60);
        Dot.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(".");
                Exp.setText(s1.toString());
            }
        });

        JButton Zero = new JButton("0");
        Zero.setBounds(80, 380, 60, 60);
        Zero.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("0");
                Exp.setText(s1.toString());
            }
        });

        JButton Change = new JButton("C");
        Change.setBounds(10, 380, 60, 60);
        Change.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.delete(0, (s1.length()));
                Exp.setText(s1.toString());
            }
        });

        JButton dam = new JButton("dam");
        dam.setBounds(290, 310, 60, 60);
        dam.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "dam");
                Result.setText(Double.toString(answer) + "  dam");
            }
        });

        JButton hm = new JButton("hm");
        hm.setBounds(220, 310, 60, 60);
        hm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "hm");
                Result.setText(Double.toString(answer) + "  hm");
            }
        });

        JButton Three = new JButton("3");
        Three.setBounds(150, 310, 60, 60);
        Three.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("3");
                Exp.setText(s1.toString());
            }
        });

        JButton Two = new JButton("2");
        Two.setBounds(80, 310, 60, 60);
        Two.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("2");
                Exp.setText(s1.toString());
            }
        });

        JButton One = new JButton("1");
        One.setBounds(10, 310, 60, 60);
        One.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("1");
                Exp.setText(s1.toString());
            }
        });

        JButton nm = new JButton("nm");
        nm.setBounds(290, 240, 60, 60);
        nm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "nm");
                Result.setText(Double.toString(answer) + "  nm");
            }
        });

        JButton um = new JButton("um");
        um.setBounds(220, 240, 60, 60);
        um.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "um");
                Result.setText(Double.toString(answer) + "  um");
            }
        });

        JButton Six = new JButton("6");
        Six.setBounds(150, 240, 60, 60);
        Six.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("6");
                Exp.setText(s1.toString());
            }
        });

        JButton Five = new JButton("5");
        Five.setBounds(80, 240, 60, 60);
        Five.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("5");
                Exp.setText(s1.toString());
            }
        });

        JButton Four = new JButton("4");
        Four.setBounds(10, 240, 60, 60);
        Four.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("4");
                Exp.setText(s1.toString());
            }
        });

        JButton Back = new JButton("< -");
        Back.setBounds(10, 5, 60, 60);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Length();
            }
        });

        JButton km = new JButton("km");
        km.setBounds(220, 170, 60, 60);
        km.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "km");
                Result.setText(Double.toString(answer) + "  km");
            }
        });

        JButton Nine = new JButton("9");
        Nine.setBounds(150, 170, 60, 60);
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("9");
                Exp.setText(s1.toString());
            }
        });

        JButton Eight = new JButton("8");
        Eight.setBounds(80, 170, 60, 60);
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("8");
                Exp.setText(s1.toString());
            }
        });
        
        JButton Seven = new JButton("7");
        Seven.setBounds(10, 170, 60, 60);
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("7");
                Exp.setText(s1.toString());
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Dashboard();
            }
        });

        F3.add(Exp);
        F3.add(mili);
        F3.add(Result);
        F3.add(m);
        F3.add(dm);
        F3.add(cm);
        F3.add(Dot);
        F3.add(Zero);
        F3.add(Change);
        F3.add(dam);
        F3.add(hm);
        F3.add(Three);
        F3.add(Two);
        F3.add(One);
        F3.add(nm);
        F3.add(um);
        F3.add(Six);
        F3.add(Five);
        F3.add(Four);
        F3.add(Back);
        F3.add(km);
        F3.add(Nine);
        F3.add(Eight);
        F3.add(Seven);
        F3.add(Dash);
        F3.setTitle("Length Calculator");
        F3.setSize(400, 500);
        F3.setLayout(null);
        F3.setVisible(true);
        F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public double convert(String s, String l) {
        double r = Double.parseDouble(s);
        if(l.equals("m"))
            return (r/1000);
        
        if(l.equals("cm"))
            return (r/10);

        if(l.equals("dm"))
            return (r/100);

        if(l.equals("dam"))
            return (r/10000);
            
        if(l.equals("hm"))
            return (r/100000);

        if(l.equals("km"))
            return (r/1000000);

        if(l.equals("um"))
            return (r*1000);

        if(l.equals("nm"))
            return (r*1000000);
        
        return r;
    }
}

class centimeter {
    centimeter() {
        JLabel Exp = new JLabel();
        Exp.setBounds(250, 50, 150, 50);
        JLabel centi = new JLabel("cm");
        centi.setBounds(320, 50, 35, 50);
        JLabel Result = new JLabel();
        Result.setBounds(250, 110, 100, 50);
        StringBuffer s1 = new StringBuffer();
        JFrame F3 = new JFrame();

        JButton meter = new JButton("m");
        meter.setBounds(290, 380, 60, 60);
        meter.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "m");
                Result.setText(Double.toString(answer) + "  m");
            }
        });

        JButton dm = new JButton("dm");
        dm.setBounds(220, 380, 60, 60);
        dm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "dm");
                Result.setText(Double.toString(answer) + "  dm");
            }
        });

        JButton mm = new JButton("mm");
        mm.setBounds(290, 170, 60, 60);
        mm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "mm");
                Result.setText(Double.toString(answer) + "  mm");
            }
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(150, 380, 60, 60);
        Dot.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(".");
                Exp.setText(s1.toString());
            }
        });

        JButton Zero = new JButton("0");
        Zero.setBounds(80, 380, 60, 60);
        Zero.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("0");
                Exp.setText(s1.toString());
            }
        });

        JButton Change = new JButton("C");
        Change.setBounds(10, 380, 60, 60);
        Change.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.delete(0, (s1.length()));
                Exp.setText(s1.toString());
            }
        });

        JButton dam = new JButton("dam");
        dam.setBounds(290, 310, 60, 60);
        dam.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "dam");
                Result.setText(Double.toString(answer) + "  dam");
            }
        });

        JButton hm = new JButton("hm");
        hm.setBounds(220, 310, 60, 60);
        hm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "hm");
                Result.setText(Double.toString(answer) + "  hm");
            }
        });

        JButton Three = new JButton("3");
        Three.setBounds(150, 310, 60, 60);
        Three.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("3");
                Exp.setText(s1.toString());
            }
        });

        JButton Two = new JButton("2");
        Two.setBounds(80, 310, 60, 60);
        Two.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("2");
                Exp.setText(s1.toString());
            }
        });

        JButton One = new JButton("1");
        One.setBounds(10, 310, 60, 60);
        One.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("1");
                Exp.setText(s1.toString());
            }
        });

        JButton nm = new JButton("nm");
        nm.setBounds(290, 240, 60, 60);
        nm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "nm");
                Result.setText(Double.toString(answer) + "  nm");
            }
        });

        JButton um = new JButton("um");
        um.setBounds(220, 240, 60, 60);
        um.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "um");
                Result.setText(Double.toString(answer) + "  um");
            }
        });

        JButton Six = new JButton("6");
        Six.setBounds(150, 240, 60, 60);
        Six.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("6");
                Exp.setText(s1.toString());
            }
        });

        JButton Five = new JButton("5");
        Five.setBounds(80, 240, 60, 60);
        Five.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("5");
                Exp.setText(s1.toString());
            }
        });

        JButton Four = new JButton("4");
        Four.setBounds(10, 240, 60, 60);
        Four.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("4");
                Exp.setText(s1.toString());
            }
        });

        JButton Return = new JButton("< -");
        Return.setBounds(10, 5, 60, 60);
        Return.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Length();
            }
        });

        JButton km = new JButton("km");
        km.setBounds(220, 170, 60, 60);
        km.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "km");
                Result.setText(Double.toString(answer) + "  km");
            }
        });

        JButton Nine = new JButton("9");
        Nine.setBounds(150, 170, 60, 60);
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("9");
                Exp.setText(s1.toString());
            }
        });

        JButton Eight = new JButton("8");
        Eight.setBounds(80, 170, 60, 60);
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("8");
                Exp.setText(s1.toString());
            }
        });
        
        JButton Seven = new JButton("7");
        Seven.setBounds(10, 170, 60, 60);
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("7");
                Exp.setText(s1.toString());
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Dashboard();
            }
        });

        F3.add(centi);
        F3.add(meter);
        F3.add(mm);
        F3.add(Dot);
        F3.add(Zero);
        F3.add(Change);
        F3.add(km);
        F3.add(dam);
        F3.add(Three);
        F3.add(Two);
        F3.add(One);
        F3.add(dm);
        F3.add(nm);
        F3.add(Six);
        F3.add(Five);
        F3.add(Four);
        F3.add(um);
        F3.add(hm);
        F3.add(Nine);
        F3.add(Eight);
        F3.add(Seven);
        F3.add(Return);
        F3.add(Dash);
        F3.add(Exp);
        F3.add(Result);
        F3.setTitle("Length Calculator");
        F3.setSize(400, 500);
        F3.setLayout(null);
        F3.setVisible(true);
        F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public double convert(String s, String l) {
        double r = Double.parseDouble(s);
        if(l.equals("m"))
            return (r/100);
        
        if(l.equals("mm"))
            return (r*10);

        if(l.equals("dm"))
            return (r/10);

        if(l.equals("dam"))
            return (r/1000);
            
        if(l.equals("hm"))
            return (r/10000);

        if(l.equals("km"))
            return (r/100000);

        if(l.equals("um"))
            return (r*10000);

        if(l.equals("nm"))
            return (r*10000000);
        
        return r;
    }
}

class meter {
    meter() {
        JLabel Exp = new JLabel();
        Exp.setBounds(250, 50, 150, 50);
        JLabel meter = new JLabel("m");
        meter.setBounds(320, 50, 35, 50);
        JLabel Result = new JLabel();
        Result.setBounds(250, 110, 100, 50);
        StringBuffer s1 = new StringBuffer();
        JFrame F3 = new JFrame();

        JButton cm = new JButton("cm");
        cm.setBounds(290, 380, 60, 60);
        cm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "cm");
                Result.setText(Double.toString(answer) + "  cm");
            }
        });

        JButton dm = new JButton("dm");
        dm.setBounds(220, 380, 60, 60);
        dm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "dm");
                Result.setText(Double.toString(answer) + "  dm");
            }
        });

        JButton mm = new JButton("mm");
        mm.setBounds(290, 170, 60, 60);
        mm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "mm");
                Result.setText(Double.toString(answer) + "  mm");
            }
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(150, 380, 60, 60);
        Dot.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(".");
                Exp.setText(s1.toString());
            }
        });

        JButton Zero = new JButton("0");
        Zero.setBounds(80, 380, 60, 60);
        Zero.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("0");
                Exp.setText(s1.toString());
            }
        });

        JButton Change = new JButton("C");
        Change.setBounds(10, 380, 60, 60);
        Change.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.delete(0, (s1.length()));
                Exp.setText(s1.toString());
            }
        });

        JButton dam = new JButton("dam");
        dam.setBounds(290, 310, 60, 60);
        dam.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "dam");
                Result.setText(Double.toString(answer) + "  dam");
            }
        });

        JButton hm = new JButton("hm");
        hm.setBounds(220, 310, 60, 60);
        hm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "hm");
                Result.setText(Double.toString(answer) + "  hm");
            }
        });

        JButton Three = new JButton("3");
        Three.setBounds(150, 310, 60, 60);
        Three.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("3");
                Exp.setText(s1.toString());
            }
        });

        JButton Two = new JButton("2");
        Two.setBounds(80, 310, 60, 60);
        Two.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("2");
                Exp.setText(s1.toString());
            }
        });

        JButton One = new JButton("1");
        One.setBounds(10, 310, 60, 60);
        One.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("1");
                Exp.setText(s1.toString());
            }
        });

        JButton nm = new JButton("nm");
        nm.setBounds(290, 240, 60, 60);
        nm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "nm");
                Result.setText(Double.toString(answer) + "  nm");
            }
        });

        JButton um = new JButton("um");
        um.setBounds(220, 240, 60, 60);
        um.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "um");
                Result.setText(Double.toString(answer) + "  um");
            }
        });

        JButton Six = new JButton("6");
        Six.setBounds(150, 240, 60, 60);
        Six.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("6");
                Exp.setText(s1.toString());
            }
        });

        JButton Five = new JButton("5");
        Five.setBounds(80, 240, 60, 60);
        Five.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("5");
                Exp.setText(s1.toString());
            }
        });

        JButton Four = new JButton("4");
        Four.setBounds(10, 240, 60, 60);
        Four.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("4");
                Exp.setText(s1.toString());
            }
        });

        JButton Return = new JButton("< -");
        Return.setBounds(10, 5, 60, 60);
        Return.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Length();
            }
        });

        JButton km = new JButton("km");
        km.setBounds(220, 170, 60, 60);
        km.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "km");
                Result.setText(Double.toString(answer) + "  km");
            }
        });

        JButton Nine = new JButton("9");
        Nine.setBounds(150, 170, 60, 60);
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("9");
                Exp.setText(s1.toString());
            }
        });

        JButton Eight = new JButton("8");
        Eight.setBounds(80, 170, 60, 60);
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("8");
                Exp.setText(s1.toString());
            }
        });
        
        JButton Seven = new JButton("7");
        Seven.setBounds(10, 170, 60, 60);
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("7");
                Exp.setText(s1.toString());
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Dashboard();
            }
        });

        F3.add(cm);
        F3.add(meter);
        F3.add(mm);
        F3.add(Dot);
        F3.add(Zero);
        F3.add(Change);
        F3.add(km);
        F3.add(dam);
        F3.add(Three);
        F3.add(Two);
        F3.add(One);
        F3.add(dm);
        F3.add(nm);
        F3.add(Six);
        F3.add(Five);
        F3.add(Four);
        F3.add(um);
        F3.add(hm);
        F3.add(Nine);
        F3.add(Eight);
        F3.add(Seven);
        F3.add(Return);
        F3.add(Dash);
        F3.add(Exp);
        F3.add(Result);
        F3.setTitle("Length Calculator");
        F3.setSize(400, 500);
        F3.setLayout(null);
        F3.setVisible(true);
        F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public double convert(String s, String l) {
        double r = Double.parseDouble(s);
        if(l.equals("mm"))
            return (r*1000);
        
        if(l.equals("cm"))
            return (r*100);

        if(l.equals("dm"))
            return (r*10);

        if(l.equals("dam"))
            return (r/10);
            
        if(l.equals("hm"))
            return (r/100);

        if(l.equals("km"))
            return (r/1000);

        if(l.equals("um"))
            return (r*1000000);

        if(l.equals("nm"))
            return (r*1000000000);
        
        return r;
    }
}

class kilometer {
    kilometer() {
        JLabel Exp = new JLabel();
        Exp.setBounds(250, 50, 150, 50);
        JLabel km = new JLabel("km");
        km.setBounds(320, 50, 35, 50);
        JLabel Result = new JLabel();
        Result.setBounds(250, 110, 100, 50);
        StringBuffer s1 = new StringBuffer();
        JFrame F3 = new JFrame();

        JButton meter = new JButton("m");
        meter.setBounds(290, 380, 60, 60);
        meter.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "m");
                Result.setText(Double.toString(answer) + "  m");
            }
        });

        JButton dm = new JButton("dm");
        dm.setBounds(220, 380, 60, 60);
        dm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "dm");
                Result.setText(Double.toString(answer) + "  dm");
            }
        });

        JButton mm = new JButton("mm");
        mm.setBounds(290, 170, 60, 60);
        mm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "mm");
                Result.setText(Double.toString(answer) + "  mm");
            }
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(150, 380, 60, 60);
        Dot.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(".");
                Exp.setText(s1.toString());
            }
        });

        JButton Zero = new JButton("0");
        Zero.setBounds(80, 380, 60, 60);
        Zero.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("0");
                Exp.setText(s1.toString());
            }
        });

        JButton Change = new JButton("C");
        Change.setBounds(10, 380, 60, 60);
        Change.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.delete(0, (s1.length()));
                Exp.setText(s1.toString());
            }
        });

        JButton dam = new JButton("dam");
        dam.setBounds(290, 310, 60, 60);
        dam.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "dam");
                Result.setText(Double.toString(answer) + "  dam");
            }
        });

        JButton hm = new JButton("hm");
        hm.setBounds(220, 310, 60, 60);
        hm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "hm");
                Result.setText(Double.toString(answer) + "  hm");
            }
        });

        JButton Three = new JButton("3");
        Three.setBounds(150, 310, 60, 60);
        Three.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("3");
                Exp.setText(s1.toString());
            }
        });

        JButton Two = new JButton("2");
        Two.setBounds(80, 310, 60, 60);
        Two.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("2");
                Exp.setText(s1.toString());
            }
        });

        JButton One = new JButton("1");
        One.setBounds(10, 310, 60, 60);
        One.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("1");
                Exp.setText(s1.toString());
            }
        });

        JButton nm = new JButton("nm");
        nm.setBounds(290, 240, 60, 60);
        nm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "nm");
                Result.setText(Double.toString(answer) + "  nm");
            }
        });

        JButton um = new JButton("um");
        um.setBounds(220, 240, 60, 60);
        um.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "um");
                Result.setText(Double.toString(answer) + "  um");
            }
        });

        JButton Six = new JButton("6");
        Six.setBounds(150, 240, 60, 60);
        Six.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("6");
                Exp.setText(s1.toString());
            }
        });

        JButton Five = new JButton("5");
        Five.setBounds(80, 240, 60, 60);
        Five.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("5");
                Exp.setText(s1.toString());
            }
        });

        JButton Four = new JButton("4");
        Four.setBounds(10, 240, 60, 60);
        Four.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("4");
                Exp.setText(s1.toString());
            }
        });

        JButton Return = new JButton("< -");
        Return.setBounds(10, 5, 60, 60);
        Return.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Length();
            }
        });

        JButton cm = new JButton("cm");
        cm.setBounds(220, 170, 60, 60);
        cm.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = convert(s1.toString(), "cm");
                Result.setText(Double.toString(answer) + "  cm");
            }
        });

        JButton Nine = new JButton("9");
        Nine.setBounds(150, 170, 60, 60);
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("9");
                Exp.setText(s1.toString());
            }
        });

        JButton Eight = new JButton("8");
        Eight.setBounds(80, 170, 60, 60);
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("8");
                Exp.setText(s1.toString());
            }
        });
        
        JButton Seven = new JButton("7");
        Seven.setBounds(10, 170, 60, 60);
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("7");
                Exp.setText(s1.toString());
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Dashboard();
            }
        });

        F3.add(km);
        F3.add(meter);
        F3.add(mm);
        F3.add(Dot);
        F3.add(Zero);
        F3.add(Change);
        F3.add(cm);
        F3.add(dam);
        F3.add(Three);
        F3.add(Two);
        F3.add(One);
        F3.add(dm);
        F3.add(nm);
        F3.add(Six);
        F3.add(Five);
        F3.add(Four);
        F3.add(um);
        F3.add(hm);
        F3.add(Nine);
        F3.add(Eight);
        F3.add(Seven);
        F3.add(Return);
        F3.add(Dash);
        F3.add(Exp);
        F3.add(Result);
        F3.setTitle("Length Calculator");
        F3.setSize(400, 500);
        F3.setLayout(null);
        F3.setVisible(true);
        F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public double convert(String s, String l) {
        double r = Double.parseDouble(s);
        if(l.equals("mm"))
            return (r*1000000);
        
        if(l.equals("cm"))
            return (r*100000);

        if(l.equals("dm"))
            return (r*10000);

        if(l.equals("dam"))
            return (r*100);
            
        if(l.equals("hm"))
            return (r*10);

        if(l.equals("m"))
            return (r*1000);

        if(l.equals("um"))
            return (r*1000000000);

        if(l.equals("nm"))
            return r;
        
        return r;
    }
}

class Thermal {
    Thermal() {
        JFrame F4 = new JFrame();
        JButton btnC = new JButton("*C");
        btnC.setBounds(50, 75, 100, 50);
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F4.dispose();
                new Celcius();
            }
        });

        JButton btnF = new JButton("*F");
        btnF.setBounds(200, 75, 100, 50);
        btnF.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F4.dispose();
                new Fahrenheit();
            }
        });

        JButton btnK = new JButton("K");
        btnK.setBounds(50, 150, 100, 50);
        btnK.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F4.dispose();
                new Kelvin();
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F4.dispose();
                new Dashboard();
            }
        });

        F4.add(btnC);
        F4.add(btnK);
        F4.add(btnF);
        F4.add(Dash);
        F4.setTitle("Thermal Calculator");
        F4.setSize(400, 500);
        F4.setLayout(null);
        F4.setVisible(true);
        F4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Celcius {
    Celcius() {
        JLabel c = new JLabel("*C");
        c.setBounds(320, 50, 35, 50);
        JLabel Exp = new JLabel();
        Exp.setBounds(250, 50, 150, 50);
        JLabel Result = new JLabel();
        Result.setBounds(300, 110, 100, 50);
        StringBuffer s1 = new StringBuffer();
        JFrame F3 = new JFrame();

        JButton F = new JButton("*F");
        F.setBounds(280, 380, 60, 60);
        F.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = Calculate(s1.toString(), "*F");
                Result.setText(Double.toString(answer) + " *F");
            }
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(200, 380, 60, 60);
        Dot.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(".");
                Exp.setText(s1.toString());
            }
        });

        JButton Zero = new JButton("0");
        Zero.setBounds(120, 380, 60, 60);
        Zero.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("0");
                Exp.setText(s1.toString());
            }
        });

        JButton Change = new JButton("AC");
        Change.setBounds(40, 380, 60, 60);
        Change.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.delete(0, (s1.length()));
                Exp.setText(s1.toString());
            }
        });

        JButton K = new JButton("K");
        K.setBounds(280, 310, 60, 60);
        K.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = Calculate(s1.toString(), "K");
                Result.setText(Double.toString(answer) + " K");
            }
        });

        JButton Three = new JButton("3");
        Three.setBounds(200, 310, 60, 60);
        Three.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("3");
                Exp.setText(s1.toString());
            }
        });

        JButton Two = new JButton("2");
        Two.setBounds(120, 310, 60, 60);
        Two.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("2");
                Exp.setText(s1.toString());
            }
        });

        JButton One = new JButton("1");
        One.setBounds(40, 310, 60, 60);
        One.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("1");
                Exp.setText(s1.toString());
            }
        });

        JButton Back = new JButton("< -");
        Back.setBounds(280, 240, 60, 60);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.deleteCharAt(s1.length()-1);
                Exp.setText(s1.toString());
            }
        });

        JButton Six = new JButton("6");
        Six.setBounds(200, 240, 60, 60);
        Six.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("6");
                Exp.setText(s1.toString());
            }
        });

        JButton Five = new JButton("5");
        Five.setBounds(120, 240, 60, 60);
        Five.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("5");
                Exp.setText(s1.toString());
            }
        });

        JButton Four = new JButton("4");
        Four.setBounds(40, 240, 60, 60);
        Four.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("4");
                Exp.setText(s1.toString());
            }
        });

        JButton Dispose = new JButton("#< -");
        Dispose.setBounds(280, 170, 60, 60);
        Dispose.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Thermal();
            }
        });

        JButton Nine = new JButton("9");
        Nine.setBounds(200, 170, 60, 60);
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("9");
                Exp.setText(s1.toString());
            }
        });

        JButton Eight = new JButton("8");
        Eight.setBounds(120, 170, 60, 60);
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("8");
                Exp.setText(s1.toString());
            }
        });

        JButton Seven = new JButton("7");
        Seven.setBounds(40, 170, 60, 60);
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("7");
                Exp.setText(s1.toString());
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Dashboard();
            }
        });

        F3.add(c);
        F3.add(K);
        F3.add(F);
        F3.add(Dot);
        F3.add(Zero);
        F3.add(Change);
        F3.add(Three);
        F3.add(Two);
        F3.add(One);
        F3.add(Back);
        F3.add(Six);
        F3.add(Five);
        F3.add(Four);
        F3.add(Dispose);
        F3.add(Nine);
        F3.add(Eight);
        F3.add(Seven);
        F3.add(Dash);
        F3.add(Exp);
        F3.add(Result);
        F3.setTitle("Calculator");
        F3.setSize(400, 500);
        F3.setLayout(null);
        F3.setVisible(true);
        F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public double Calculate(String e, String r){
        double d = Double.parseDouble(e);
        if (r.equals("K"))
            return (d + 273.15);
        if (r.equals("*F")){
            double i = (d * 1.8);
            return (i + 32);
        }
        return d;
    }
}

class Fahrenheit {
    Fahrenheit() {
        JLabel f = new JLabel("*F");
        f.setBounds(320, 50, 35, 50);
        JLabel Exp = new JLabel();
        Exp.setBounds(250, 50, 150, 50);
        JLabel Result = new JLabel();
        Result.setBounds(300, 110, 100, 50);
        StringBuffer s1 = new StringBuffer();
        JFrame F3 = new JFrame();

        JButton C = new JButton("*C");
        C.setBounds(280, 380, 60, 60);
        C.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = Calculate(s1.toString(), "*C");
                Result.setText(Double.toString(answer) + " *C");
            }
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(200, 380, 60, 60);
        Dot.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(".");
                Exp.setText(s1.toString());
            }
        });

        JButton Zero = new JButton("0");
        Zero.setBounds(120, 380, 60, 60);
        Zero.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("0");
                Exp.setText(s1.toString());
            }
        });

        JButton Change = new JButton("AC");
        Change.setBounds(40, 380, 60, 60);
        Change.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.delete(0, (s1.length()));
                Exp.setText(s1.toString());
            }
        });

        JButton K = new JButton("K");
        K.setBounds(280, 310, 60, 60);
        K.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = Calculate(s1.toString(), "K");
                Result.setText(Double.toString(answer) + " K");
            }
        });

        JButton Three = new JButton("3");
        Three.setBounds(200, 310, 60, 60);
        Three.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("3");
                Exp.setText(s1.toString());
            }
        });

        JButton Two = new JButton("2");
        Two.setBounds(120, 310, 60, 60);
        Two.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("2");
                Exp.setText(s1.toString());
            }
        });

        JButton One = new JButton("1");
        One.setBounds(40, 310, 60, 60);
        One.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("1");
                Exp.setText(s1.toString());
            }
        });

        JButton Back = new JButton("< -");
        Back.setBounds(280, 240, 60, 60);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.deleteCharAt(s1.length()-1);
                Exp.setText(s1.toString());
            }
        });

        JButton Six = new JButton("6");
        Six.setBounds(200, 240, 60, 60);
        Six.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("6");
                Exp.setText(s1.toString());
            }
        });

        JButton Five = new JButton("5");
        Five.setBounds(120, 240, 60, 60);
        Five.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("5");
                Exp.setText(s1.toString());
            }
        });

        JButton Four = new JButton("4");
        Four.setBounds(40, 240, 60, 60);
        Four.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("4");
                Exp.setText(s1.toString());
            }
        });

        JButton Dispose = new JButton("#< -");
        Dispose.setBounds(280, 170, 60, 60);
        Dispose.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Thermal();
            }
        });

        JButton Nine = new JButton("9");
        Nine.setBounds(200, 170, 60, 60);
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("9");
                Exp.setText(s1.toString());
            }
        });

        JButton Eight = new JButton("8");
        Eight.setBounds(120, 170, 60, 60);
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("8");
                Exp.setText(s1.toString());
            }
        });

        JButton Seven = new JButton("7");
        Seven.setBounds(40, 170, 60, 60);
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("7");
                Exp.setText(s1.toString());
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Dashboard();
            }
        });

        F3.add(f);
        F3.add(K);
        F3.add(C);
        F3.add(Dot);
        F3.add(Zero);
        F3.add(Change);
        F3.add(Three);
        F3.add(Two);
        F3.add(One);
        F3.add(Back);
        F3.add(Six);
        F3.add(Five);
        F3.add(Four);
        F3.add(Dispose);
        F3.add(Nine);
        F3.add(Eight);
        F3.add(Seven);
        F3.add(Dash);
        F3.add(Exp);
        F3.add(Result);
        F3.setTitle("Calculator");
        F3.setSize(400, 500);
        F3.setLayout(null);
        F3.setVisible(true);
        F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public double Calculate(String e, String r){
        double d = Double.parseDouble(e);
        if (r.equals("K")){
            double i = (d - 32);
            i = i * 0.555556;
            return (i + 273.15);
        }
        if (r.equals("*C")){
            double i = (d - 32);
            return (i * 0.555556);
        }
        return d;
    }
}

class Kelvin {
    Kelvin() {
        JLabel k = new JLabel("K");
        k.setBounds(320, 50, 35, 50);
        JLabel Exp = new JLabel();
        Exp.setBounds(250, 50, 150, 50);
        JLabel Result = new JLabel();
        Result.setBounds(300, 110, 100, 50);
        StringBuffer s1 = new StringBuffer();
        JFrame F3 = new JFrame();

        JButton C = new JButton("*C");
        C.setBounds(280, 380, 60, 60);
        C.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = Calculate(s1.toString(), "*C");
                Result.setText(Double.toString(answer) + " *C");
            }
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(200, 380, 60, 60);
        Dot.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append(".");
                Exp.setText(s1.toString());
            }
        });

        JButton Zero = new JButton("0");
        Zero.setBounds(120, 380, 60, 60);
        Zero.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("0");
                Exp.setText(s1.toString());
            }
        });

        JButton Change = new JButton("AC");
        Change.setBounds(40, 380, 60, 60);
        Change.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.delete(0, (s1.length()));
                Exp.setText(s1.toString());
            }
        });

        JButton F = new JButton("*F");
        F.setBounds(280, 310, 60, 60);
        F.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double answer = Calculate(s1.toString(), "F");
                Result.setText(Double.toString(answer) + " F");
            }
        });

        JButton Three = new JButton("3");
        Three.setBounds(200, 310, 60, 60);
        Three.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("3");
                Exp.setText(s1.toString());
            }
        });

        JButton Two = new JButton("2");
        Two.setBounds(120, 310, 60, 60);
        Two.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("2");
                Exp.setText(s1.toString());
            }
        });

        JButton One = new JButton("1");
        One.setBounds(40, 310, 60, 60);
        One.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("1");
                Exp.setText(s1.toString());
            }
        });

        JButton Back = new JButton("< -");
        Back.setBounds(280, 240, 60, 60);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.deleteCharAt(s1.length()-1);
                Exp.setText(s1.toString());
            }
        });

        JButton Six = new JButton("6");
        Six.setBounds(200, 240, 60, 60);
        Six.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("6");
                Exp.setText(s1.toString());
            }
        });

        JButton Five = new JButton("5");
        Five.setBounds(120, 240, 60, 60);
        Five.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("5");
                Exp.setText(s1.toString());
            }
        });

        JButton Four = new JButton("4");
        Four.setBounds(40, 240, 60, 60);
        Four.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("4");
                Exp.setText(s1.toString());
            }
        });

        JButton Dispose = new JButton("#< -");
        Dispose.setBounds(280, 170, 60, 60);
        Dispose.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Thermal();
            }
        });

        JButton Nine = new JButton("9");
        Nine.setBounds(200, 170, 60, 60);
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("9");
                Exp.setText(s1.toString());
            }
        });

        JButton Eight = new JButton("8");
        Eight.setBounds(120, 170, 60, 60);
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("8");
                Exp.setText(s1.toString());
            }
        });

        JButton Seven = new JButton("7");
        Seven.setBounds(40, 170, 60, 60);
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                s1.append("7");
                Exp.setText(s1.toString());
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Dashboard();
            }
        });

        F3.add(k);
        F3.add(F);
        F3.add(C);
        F3.add(Dot);
        F3.add(Zero);
        F3.add(Change);
        F3.add(Three);
        F3.add(Two);
        F3.add(One);
        F3.add(Back);
        F3.add(Six);
        F3.add(Five);
        F3.add(Four);
        F3.add(Dispose);
        F3.add(Nine);
        F3.add(Eight);
        F3.add(Seven);
        F3.add(Dash);
        F3.add(Exp);
        F3.add(Result);
        F3.setTitle("Calculator");
        F3.setSize(400, 500);
        F3.setLayout(null);
        F3.setVisible(true);
        F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public double Calculate(String e, String r){
        double d = Double.parseDouble(e);
        if (r.equals("*F")){
            double i = (d - 273.15);
            i = i * 1.8;
            return (i + 32);
        }
        if (r.equals("*C"))
            return (d - 273.15);
        return d;
    }
}

class BMI {
    volatile boolean i = false;
    BMI() {
        JButton H = new JButton("Height in meters :");
        H.setBounds(200, 50, 150, 30);
        H.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                i = true;
            }
        });

        JButton W = new JButton("Weight in Kg :");
        W.setBounds(40, 50, 150, 30);
        W.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                i = false;
            }
        });

        JLabel Height = new JLabel();
        Height.setBounds(200, 90, 150, 30);
        JLabel Weight = new JLabel();
        Weight.setBounds(40, 90, 150, 30);
        JLabel Result = new JLabel();
        Result.setBounds(300, 130, 100, 30);
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        JFrame F3 = new JFrame();

        JButton Ans = new JButton("Ans");
        Ans.setBounds(280, 380, 60, 60);
        Ans.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                double r = Calculate(s1.toString(), s2.toString());
                Result.setText(Double.toString(r) + "Kg per sq.m");
            }
        });

        JButton Dot = new JButton(".");
        Dot.setBounds(200, 380, 60, 60);
        Dot.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append(".");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append(".");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Zero = new JButton("0");
        Zero.setBounds(120, 380, 60, 60);
        Zero.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("0");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("0");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Change = new JButton("AC");
        Change.setBounds(40, 380, 60, 60);
        Change.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.delete(0, (s1.length()));
                    Height.setText(s1.toString());
                }
                else {
                    s2.delete(0, (s2.length()));
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Three = new JButton("3");
        Three.setBounds(200, 310, 60, 60);
        Three.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("3");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("3");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Two = new JButton("2");
        Two.setBounds(120, 310, 60, 60);
        Two.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("2");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("2");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton One = new JButton("1");
        One.setBounds(40, 310, 60, 60);
        One.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("1");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("1");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Back = new JButton("< -");
        Back.setBounds(280, 170, 60, 60);
        Back.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.deleteCharAt(s1.length()-1);
                    Height.setText(s1.toString());
                }
                else {
                    s2.deleteCharAt(s2.length()-1);
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Six = new JButton("6");
        Six.setBounds(200, 240, 60, 60);
        Six.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("6");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("6");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Five = new JButton("5");
        Five.setBounds(120, 240, 60, 60);
        Five.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("5");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("5");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Four = new JButton("4");
        Four.setBounds(40, 240, 60, 60);
        Four.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("4");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("4");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Nine = new JButton("9");
        Nine.setBounds(200, 170, 60, 60);
        Nine.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("9");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("9");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Eight = new JButton("8");
        Eight.setBounds(120, 170, 60, 60);
        Eight.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("8");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("8");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Seven = new JButton("7");
        Seven.setBounds(40, 170, 60, 60);
        Seven.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                if (i){
                    s1.append("7");
                    Height.setText(s1.toString());
                }
                else {
                    s2.append("7");
                    Weight.setText(s2.toString());
                }
            }
        });

        JButton Dash = new JButton("Dashboard");
        Dash.setBounds(280, 5, 100, 30);
        Dash.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent ae){
                F3.dispose();
                new Dashboard();
            }
        });

        F3.add(Ans);
        F3.add(Height);
        F3.add(Weight);
        F3.add(H);
        F3.add(W);
        F3.add(Dot);
        F3.add(Zero);
        F3.add(Change);
        F3.add(Three);
        F3.add(Two);
        F3.add(One);
        F3.add(Back);
        F3.add(Six);
        F3.add(Five);
        F3.add(Four);
        F3.add(Nine);
        F3.add(Eight);
        F3.add(Seven);
        F3.add(Dash);
        F3.add(Result);
        F3.setTitle("Calculator");
        F3.setSize(400, 500);
        F3.setLayout(null);
        F3.setVisible(true);
        F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public double Calculate(String e, String r){
        double H = Double.parseDouble(e);
        double W = Double.parseDouble(r);
        double R = H * H;
        return (W / R);
    }
}