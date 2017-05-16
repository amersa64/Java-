
--------------------------------------------------------------------------------

// Euler's Method, coded by David Protas, c.2002
// Any corrections or suggestions for improvement of this code will be 
// appreciated and should be sent to david.protas@csun.edu
// Latest revision: November 12, 2003

/*********************
* Document: EuM.java 
*********************/

import java.applet.*;
import java.awt.*;
import expr.*;

public class EuM extends Applet {

   final int MaxN = 100; //Maximum number of subintervals
   double x_0D, y_0D, bD, ymin, ymax, h, a, b;
   int nI, counter = -1, last;
   double[] xArray = new double[MaxN+1];
   double[] yArray = new double[MaxN+1];
   double[] fArray = new double[MaxN+1];
   Panel top, pan1, pan2, pan3, bottom, pan4, pan5;
   Label functionLabel, inputLabelX ,inputLabelY, inputLabelB, inputLabelN, message;
   TextField functionField, inputFieldX, inputFieldY, inputFieldB, inputFieldN;
   TextArea results;
   Button enter, approx;
   EuM_G graph;
   Color babyBlue;
   
   public void init() {
      
      setLayout(new BorderLayout(4,0));
      top = new Panel();
      top.setLayout(new GridLayout(3,1));
      bottom = new Panel();
      bottom.setLayout(new GridLayout(3,1));
      pan1 = new Panel();
      pan2 = new Panel();
      pan3 = new Panel();
      pan4 = new Panel();
      pan5 = new Panel();
      functionLabel = new Label("f(x,y) = ");
      functionField = new TextField(20);
      inputLabelX = new Label("  x_0 =");
      inputLabelY = new Label("  y_0 =");
      inputLabelB = new Label("  b =");
      inputLabelN = new Label("  n =");
      inputFieldX = new TextField(5);
      inputFieldY = new TextField(5);
      inputFieldB = new TextField(5);
      inputFieldN = new TextField(5);
      enter = new Button("Enter");
      approx = new Button("Approximate");
      results = new TextArea("     x_n            y_n ", 10, 30);
      results.setEditable(false);
      message = new Label("                                                  " +
                          "                                                       ");
      graph = new EuM_G();
      babyBlue = new Color(204,255,255);
    
      pan1.add(functionLabel);
      pan1.add(functionField);
      top.add(pan1);
      pan2.add(inputLabelX);
      pan2.add(inputFieldX);
      pan2.add(inputLabelY);
      pan2.add(inputFieldY);
      top.add(pan2);
      pan3.add(inputLabelB);
      pan3.add(inputFieldB);
      pan3.add(inputLabelN);
      pan3.add(inputFieldN);
      pan3.add(enter);
      pan3.add(approx);
      top.add(pan3);
      add("North",top);
      add("Center",graph);
      add("East",results);
      pan5.add(message);
      bottom.add(pan5);
      add("South",bottom);
      
      setBackground(babyBlue);
      pan1.setBackground(babyBlue);
      pan2.setBackground(babyBlue);
      pan3.setBackground(babyBlue);
      pan4.setBackground(babyBlue);
      pan5.setBackground(babyBlue);
      message.setForeground(Color.red);
      message.setBackground(babyBlue);
      results.setFont(new Font("Courier",Font.PLAIN,10));
   }
    
   public boolean action(Event evt, Object arg) {
      Variable x = null;
      Variable y = null;
      Expr function = null, inputX = null, inputY = null, inputB = null;
      if (evt.target == enter) {
         counter = 0;
         graph.counter = counter;

         message.setText("");
         try { 
            x = Variable.make ("x");
            y = Variable.make ("y");
            function = Parser.parse (functionField.getText());
            inputX = Parser.parse(inputFieldX.getText());
            inputY = Parser.parse(inputFieldY.getText());
            inputB = Parser.parse(inputFieldB.getText());
         }
         catch (Syntax_error e) {
            message.setText("" + e);
         }
         Variable.make ("pi").set_value (Math.PI);
         Variable.make ("e").set_value (Math.E);
         x_0D = inputX.value();
         y_0D = inputY.value();
         bD = inputB.value();
         if (entryValid(inputFieldN.getText()) == false)
            message.setText("n needs to be an integer. Try again.");
         else {
            nI = intFromString(inputFieldN.getText());
            last = nI;
            if((nI < 1) || (nI > MaxN))
               message.setText("Applet requires n to be a positive integer <= " + MaxN);
            else if (x_0D < bD) {
               h = (bD - x_0D)/nI;
               graph.h = h;
               graph.nI = nI;
               if (nI > 10)
                  approx.setLabel("Run");
               else
                  approx.setLabel("Step");
               results.setText("     x_n            y_n " +
                               "\n" + rndOff(x_0D) + "   " + rndOff(y_0D));
               graph.x_0D = x_0D;
               graph.y_0D = y_0D;
               graph.bD = bD;
               xArray[0] = x_0D;
               yArray[0] = y_0D;
               graph.xArray[0] = xArray[0];
               graph.yArray[0] = yArray[0];
               ymin = Math.min(y_0D,-.5);
               ymax = Math.max(y_0D,.2);
               for (int i = 1; i <= nI; i++) {
                  x.set_value(xArray[i-1]);
                  y.set_value(yArray[i-1]);
                  fArray[i-1] = function.value();    //Array of slopes
                  if (fArray[i-1] != fArray[i-1]) {  //tests whether fArray[i-1] is a number
                     message.setText("y'(" + rndOff(xArray[i-1]).trim() +
                                     ") is undefined. Computation ends there.");
                     last = i-1;
                     break;
                  }
                  yArray[i] = yArray[i-1] + h*fArray[i-1];  //Array of y values
                  xArray[i] = x_0D + i*h;  //Array of x values
                  if (yArray[i] < ymin)
                     ymin = yArray[i];       //find min value of y
                  if (yArray[i] > ymax)
                     ymax = yArray[i];       //find max value of y
               }
               graph.ymin = ymin;
               graph.ymax = ymax;
               graph.repaint();
            } //end of else if x_0D < bD
         else
            message.setText("Need x_0 < b. Try again.");
         }  //end of else entry valid
         return true;
      } //end of evt.target == enter
      if (evt.target == approx) {
         if (nI > 10) {
            graph.counter = last;
            for (int i = 1; i <= last; i++) {
               graph.xArray[i] = xArray[i];
               graph.yArray[i] = yArray[i];
               results.appendText("\n" + rndOff(xArray[i]) + "   " + rndOff(yArray[i]));
            }
            graph.repaint();
         }
         else {
            if (counter < last) {
               graph.nI = last;
               counter = counter + 1;
               results.appendText("\n" + rndOff(xArray[counter]) + "   " 
                                  + rndOff(yArray[counter]));
               graph.counter = counter;
               for (int i = 1; i <= counter; i++) {
                  graph.xArray[i] = xArray[i];
                  graph.yArray[i] = yArray[i];
               }
               if (counter < last)
                  graph.dir = fArray[counter];
               graph.repaint();
            }
         }
         return true;
      } //end of evt.target == approx
      return false;    
   } //end of action

   public static int intFromString(String str) {
      Integer intObj = new Integer(str);
      return intObj.intValue();
   }
   
   private boolean entryValid(String entry) {
      boolean status;
      try {
         double number = intFromString(entry);
         status = true;
      }
      catch(NumberFormatException e) {
         status =false;
      }
      return status;
   }
   
   public static String rndOff(double number)  //to 5 places past the decimal
   {
      String strnum, bigstrnum, substrnum = "     0.00000";
      int period, lngth;
      long longnum;
      
      if ((number >= 0.001) || (number <= -0.001) || (number != number)) {
         number = Math.pow(0.1,5)*Math.round(Math.pow(10,5)*number);
         strnum = String.valueOf(number);
         bigstrnum = "      " + strnum + "     ";
         period = bigstrnum.indexOf('.');
         substrnum = bigstrnum.substring(period -6, period + 6);
         if ((number >= 1000000) || (number <= -100000) || (number != number))
            substrnum = "big magnitude";
      }
      else {
         longnum = Math.round(Math.pow(10,5)*number);
         if (longnum == 0)
            substrnum = "     0.00000";
         else {
            strnum = String.valueOf(longnum);
            if (longnum < 0)
               strnum = strnum.substring(1);
            lngth = strnum.length();
            switch (lngth) {
               case 1:
                  substrnum = "     0.0000" + strnum;
                  break;
               case 2:
                  substrnum = "     0.000" + strnum;
                  break;
               default:
                  substrnum = "     error";
            }
            if (longnum < 0)
               substrnum = "    -" + substrnum.substring(5);
         }
      }
      return substrnum;
   }
   
}  //end of EuM

/***********************
* Document: EuM_G.java 
***********************/

import java.awt.*;

public class EuM_G extends Canvas
{      
   final int MaxN = 100; //Maximum number of subintervals
   
   Dimension d;   
   double[] xArray = new double[MaxN+1];
   double[] yArray = new double[MaxN+1];
   double x_0D, y_0D, bD, ymin, ymax, h, dir;
   int tick, deltaTick, nI, counter = -1;
   
   public void paint(Graphics g) 
   {
      if (counter > -1) {
         d = this.size();
         g.setColor(Color.black);
         g.drawLine(0, yScaler(0.0), d.width, yScaler(0.0));   //x-axis
         if (x_0D*bD <= 0)
            g.drawLine(xScaler(0.0), 0, xScaler(0.0), d.height - 6);  //y-axis
         tick = (int)x_0D;    // start of x-ticks
         deltaTick = 1 + (int)(bD - x_0D)/12;
         do {
            if (tick != 0) {
               g.drawString(tick+"", xScaler(tick) - 4, yScaler(0.0) + 11);
               g.drawLine(xScaler(tick), yScaler(0.0) - 2, xScaler(tick), yScaler(0.0));
            }
            tick = tick + deltaTick;
         }
         while (tick <= bD);  //end of x-ticks
         if (counter > 0) {
            for (int i = 1; i <= counter; i++) {
               if (i%2 == 0)
                  g.setColor(Color.red);
               else
                  g.setColor(Color.magenta);
               g.drawLine(xScaler(xArray[i-1]), yScaler(yArray[i-1]), 
                          xScaler(xArray[i]), yScaler(yArray[i]));
            }
            if ((nI <= 10) && (counter < nI)) {
               g.setColor(Color.lightGray);
               g.drawLine(xScaler(xArray[counter]), yScaler(yArray[counter]), 
                          xScaler(xArray[counter] + h/5), 
                          yScaler(yArray[counter] + h*dir/5));
            }
         }
      }
   }

   private int xScaler(double x)
   {  
      return (int)(5 + (d.width - 10)*(x - x_0D)/(bD - x_0D));
   }
   
   private int yScaler(double y)
   {
      return (int)((d.height - 11)*(ymax - y)/(ymax - ymin));
   } 
      
}  //end of EuM_G

/**************************************
* Folder: expr    Document: Expr.java 
**************************************/

// Mathematical expressions.
// Copyright 1996 by Darius Bacon; see the file COPYING.

// 14May96: added constant folding
// 6June02: changes made by David Protas indicated by /*DP*/

package expr;

/**
 * A mathematical expression, built out of literal numbers, variables,
 * arithmetic operators, and elementary functions.  The operator names
 * are from java.lang.Math.
 */
public abstract class Expr {

  /** @return the value given the current variable values */
  public abstract double value ();

  /** Binary operator. */  public static final int ADD = 0;  
  /** Binary operator. */  public static final int SUB = 1;
  /** Binary operator. */  public static final int MUL = 2;
  /** Binary operator. */  public static final int DIV = 3;
  /** Binary operator. */  public static final int POW = 4;
  
  /** Unary operator. */        public static final int ABS   = 100;
  /** Unary operator. */        public static final int ACOS  = 101;
  /** Unary operator. */        public static final int ASIN  = 102;
  /** Unary operator. */        public static final int ATAN  = 103;
  /** Unary operator. */        public static final int CEIL  = 104;
  /** Unary operator. */        public static final int COS   = 105;
  /** Unary operator. */        public static final int EXP   = 106;
  /** Unary operator. */        public static final int FLOOR = 107;
  /** Unary operator. */        public static final int LN    = 114;   /*DP*/
  /** Unary operator. */        public static final int LOG   = 108;
  /** Unary minus operator. */  public static final int NEG   = 109;
  /** Unary operator. */        public static final int ROUND = 110;
  /** Unary operator. */        public static final int SIN   = 111;
  /** Unary operator. */        public static final int SQRT  = 112;
  /** Unary operator. */        public static final int TAN   = 113;

  public static Expr make_literal (double v) { 
    return new Literal (v); 
  }
  public static Expr make_var_ref (Variable var) {
    return new Var_ref (var);
  }
  /** 
   * @param rator unary operator
   * @param rand operand
   */
  public static Expr make_app1 (int rator, Expr rand) {
    Expr app = new App1 (rator, rand);
    return rand instanceof Literal ? new Literal (app.value ()) : app;
  }
  /** 
   * @param rator binary operator
   * @param rand0 left operand
   * @param rand1 right operand
   */
  public static Expr make_app2 (int rator, Expr rand0, Expr rand1) {
    Expr app = new App2 (rator, rand0, rand1);
    return rand0 instanceof Literal && rand1 instanceof Literal
      ? new Literal (app.value ()) 
      : app;
  }
}

// These classes are all private to this module so that I can get rid
// of them later.  For applets you want to use as few classes as
// possible to avoid http connections at load time; it'd be profitable
// to replace all these subtypes with bytecodes for a stack machine,
// or perhaps a type that's the union of all of them (see class Node
// in java/demo/SpreadSheet/SpreadSheet.java).

class Literal extends Expr {
  double v;
  Literal (double _v) { v = _v; }
  public double value () { return v; }
}

class Var_ref extends Expr {
  Variable var;
  Var_ref (Variable _var) { var = _var; }
  public double value () { return var.value (); }
}

class App1 extends Expr {
  int rator;
  Expr rand;

  App1 (int _rator, Expr _rand) { rator = _rator; rand = _rand; }

  public double value () {
    double arg = rand.value ();
    switch (rator) {
    case ABS:   return Math.abs (arg);
    case ACOS:  return Math.acos (arg);
    case ASIN:  return Math.asin (arg);
    case ATAN:  return Math.atan (arg);
    case CEIL:  return Math.ceil (arg);
    case COS:   return Math.cos (arg);
    case EXP:   return Math.exp (arg);
    case FLOOR: return Math.floor (arg);
    case LN:    return Math.log (arg);                   /*DP*/
    case LOG:   return Math.log (arg)/Math.log (10);     /*DP*/
    case NEG:   return -arg;
    case ROUND: return Math.round (arg);
    case SIN:   return Math.sin (arg);
    case SQRT:  return Math.sqrt (arg);
    case TAN:   return Math.tan (arg);
    default: throw new RuntimeException ("BUG: bad rator");
    }
  }
}

class App2 extends Expr {
  int rator;
  Expr rand0, rand1;

  App2 (int _rator, Expr _rand0, Expr _rand1) { 
    rator = _rator; rand0 = _rand0; rand1 = _rand1;
  }
  public double value () {
    double arg0 = rand0.value ();
    double arg1 = rand1.value ();
    switch (rator) {
    case ADD:  return arg0 + arg1;
    case SUB:  return arg0 - arg1;
    case MUL:  return arg0 * arg1;
    case DIV:  return arg0 / arg1;   // check for division by 0?
    case POW:  return Math.pow (arg0, arg1);
    default: throw new RuntimeException ("BUG: bad rator");
    }
  }
}

/****************************************
* Folder: expr    Document: Parser.java 
****************************************/

// Operator-precedence parser.
// Copyright 1996 by Darius Bacon; see the file COPYING.

// 14May96: bugfix. 
// StreamTokenizer treated '-' as a numeric token, not a minus
// operator followed by a number.  Fix: make '-' an ordinaryChar.

// 12May97: Changed the precedence of unary minus to be lower than 
//      multiplication, so -y^2 is like -(y^2), not (-y)^2.

package expr;

import java.io.*;

/** 
  Parses strings representing mathematical formulas with variables.
  The following operators, in descending order of precedence, are
  defined:


  ^ (raise to a power)
  * /
  Unary minus (-x)
  + -


  ^ associates right-to-left; other operators associate left-to-right.

  These functions are defined: 
    abs, acos, asin, atan, 
    ceil, cos, exp, floor, (ln added by DP)
    log, round, sin, sqrt, 
    tan.  Each requires one argument enclosed in parentheses.

  Whitespace outside identifiers is ignored.

  The syntax-error messages aren't very informative, unfortunately.
  IWBNI it indicated where in the input string the parse failed, but 
  that'd be kind of a pain since our scanner is a StreamTokenizer.  A
  hook for that info should've been built into StreamTokenizer.

  Examples:
  
  42
  2-3
  cos(x^2) + sin(x^2)
  
 */
public class Parser {
  static StreamTokenizer tokens;

  public static Expr parse (String input) throws Syntax_error {
    tokens = new StreamTokenizer (new StringBufferInputStream (input));
    tokens.ordinaryChar ('/');
    tokens.ordinaryChar ('-');
    next ();
    Expr expr = parse_expr (0);
    if (tokens.ttype != StreamTokenizer.TT_EOF)
      throw new Syntax_error ("Incomplete expression: " + input);
    return expr;
  }

  static void next () {
    try { tokens.nextToken (); }
    catch (IOException e) { throw new RuntimeException ("I/O error: " + e); }
  }

  static void expect (int ttype) throws Syntax_error {
    if (tokens.ttype != ttype)
      throw new Syntax_error ("'" + (char) ttype + "' expected");
    next ();
  }

  static Expr parse_expr (int precedence) throws Syntax_error {
    Expr expr = parse_factor ();
  loop: for (;;) {
      int l, r, rator;   

      // The operator precedence table.
      // l = left precedence, r = right precedence, rator = operator.
      // Higher precedence values mean tighter binding of arguments.
      // To associate left-to-right, let r = l+1;
      // to associate right-to-left, let r = l.

      switch (tokens.ttype) {
      case '+': l = 10; r = 11; rator = Expr.ADD; break;
      case '-': l = 10; r = 11; rator = Expr.SUB; break;
 
      case '*': l = 20; r = 21; rator = Expr.MUL; break;
      case '/': l = 20; r = 21; rator = Expr.DIV; break;
 
      case '^': l = 30; r = 30; rator = Expr.POW; break; 
 
      default: break loop;
      }

      if (l < precedence)
 break loop;

      next ();
      expr = Expr.make_app2 (rator, expr, parse_expr (r));
    }
    return expr;
  }

  static String[] procs = {
    "abs", "acos", "asin", "atan", 
    "ceil", "cos", "exp", "floor", "ln",    // ln added by DP 
    "log", "round", "sin", "sqrt", 
    "tan"
  };
  static int[] rators = {
    Expr.ABS, Expr.ACOS, Expr.ASIN, Expr.ATAN, 
    Expr.CEIL, Expr.COS, Expr.EXP, Expr.FLOOR, Expr.LN,  // Expr.LN added by DP
    Expr.LOG, Expr.ROUND, Expr.SIN, Expr.SQRT, 
    Expr.TAN
  };
 
  static Expr parse_factor () throws Syntax_error {
    switch (tokens.ttype) {
    case StreamTokenizer.TT_NUMBER: {
      Expr lit = Expr.make_literal (tokens.nval);
      next ();
      return lit;
    }
    case StreamTokenizer.TT_WORD: {
      for (int i = 0; i < procs.length; ++i)
 if (procs [i].equals (tokens.sval)) {
   next ();
   expect ('(');
   Expr rand = parse_expr (0);
   expect (')');
   return Expr.make_app1 (rators [i], rand);
 }

      Expr var = Expr.make_var_ref (Variable.make (tokens.sval));
      next ();
      return var;
    }
    case '(': {
      next ();
      Expr enclosed = parse_expr (0);
      expect (')');
      return enclosed;
    }
    case '-': 
      next ();
      return Expr.make_app1 (Expr.NEG, parse_expr (15));
    default:
      throw new Syntax_error ("Expected a factor");
    }
  }
}

/**********************************************
* Folder: expr    Document: Syntax_error.java 
**********************************************/

// Syntax-error exception.
// Copyright 1996 by Darius Bacon; see the file COPYING.

package expr;

public class Syntax_error extends Exception {
  public Syntax_error (String complaint) { super (complaint); }
}

/******************************************
* Folder: expr    Document: Variable.java 
******************************************/

// Variables associate values with names.
// Copyright 1996 by Darius Bacon; see the file COPYING.

// 01Jun96: made `make' synchronized.

package expr;

import java.util.Hashtable;

/**
 * Variables associate values with names.
 */
public class Variable {
  static Hashtable variables = new Hashtable ();

  /**
   * Return the variable named `_name'.  
   * make (s1) == make (s2) iff s1.equals (s2).
   */
  static public synchronized Variable make (String _name) {
    Variable result = (Variable) variables.get (_name);
    if (result == null)
      variables.put (_name, result = new Variable (_name));
    return result;
  }

  String name;
  double val;

  public Variable (String _name) { name = _name; val = 0; }

  public String toString () { return name; }
  public double value () { return val; }
  public void set_value (double _val) { val = _val; }
}




Back to applet
