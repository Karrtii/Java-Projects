package sample;

public class CalculatorModel
{
  private double leftValue;
  private String rightValueAsString;
  private char operator;
  private int state; // 0=clear, 1=input, 2=operation, 3=equals

  private static final String COMMA = ".";

  public CalculatorModel()
  {
    clearAll();
  }

  public void clearAll()
  {
    this.rightValueAsString = "";
    this.leftValue = 0;
    this.operator = '?';
    this.state = 0;
  }

  public void clear()
  {
    rightValueAsString = "";
  }

  public String removeLast()
  {
    if (rightValueAsString.length() > 0)
    {
      rightValueAsString = rightValueAsString.substring(0,
          rightValueAsString.length() - 1);
      if (rightValueAsString.isEmpty())
      {
        return "0";
      }
      return rightValueAsString;
    }
    String left = "" + leftValue;
    if (left.endsWith(".0"))
    {
      left = left.substring(0, left.length() - 2);
    }
    return left;
  }

  public String addDigit(int digit)
  {
    if (state == 3)
    {
      clearAll();
    }
    state = 1;
    rightValueAsString += digit;
    return rightValueAsString;
  }

  public String addComma()
  {
    if (state == 3)
    {
      clearAll();
    }
    state = 1;
    if (rightValueAsString.contains(COMMA))
    {
      throw new IllegalStateException("Cannot add one more comma");
    }
    rightValueAsString += COMMA;
    if (rightValueAsString.equals(COMMA))
    {
      rightValueAsString = "0" + COMMA;
    }
    return rightValueAsString;
  }

  public String addSign()
  {
    state = 1;
    if (!rightValueAsString.isEmpty())
    {
      if (rightValueAsString.startsWith("-"))
      {
        rightValueAsString = rightValueAsString.substring(1);
      }
      else
      {
        rightValueAsString = "-" + rightValueAsString;
      }
      return rightValueAsString;
    }
    else
    {
      leftValue = -leftValue;
      String result = String.valueOf(leftValue);
      if (result.endsWith(COMMA + "0"))
      {
        result = result.substring(0, result.indexOf(COMMA));
      }
      return result;
    }
  }

  public double plus()
  {
    state = 2;
    operate('+');
    return leftValue;
  }

  public double minus()
  {
    state = 2;
    operate('-');
    return leftValue;
  }

  public double times()
  {
    state = 2;
    operate('*');
    return leftValue;
  }

  public double divide()
  {
    state = 2;
    operate('/');
    return leftValue;
  }

  public double equals()
  {
    state = 3;
    operate('=');
    return leftValue;
  }

  private void operate(char operator)
  {
    switch (this.operator)
    {
      case '+':
        leftValue += getRightValue();
        break;
      case '-':
        leftValue -= getRightValue();
        break;
      case '*':
        leftValue *= getRightValue();
        break;
      case '/':
        leftValue /= getRightValue();
        break;
      case '=':
        break;
      case '?':
        leftValue = getRightValue();
        break;
    }
    leftValue = round(leftValue, 12);
    rightValueAsString = "";
    this.operator = operator;
  }

  private double getRightValue()
  {
    String s = rightValueAsString;
    if (s.equals("") || s.equals("-"))
    {
      s = "0";
    }
    if (s.startsWith(COMMA))
    {
      s = "0" + s;
    }
    if (s.endsWith(COMMA))
    {
      s += "0";
    }
    return Double.parseDouble(s);
  }

  private double round(double value, int decimals)
  {
    String resultAsAString = "" + value;
    int indexOfComma = resultAsAString.indexOf(".");
    int indexOfExp = resultAsAString.indexOf("E");
    if (indexOfExp == -1)
    {
      indexOfExp = resultAsAString.indexOf("e");
    }
    if (indexOfComma > -1 && indexOfExp == -1)
    {
      resultAsAString = resultAsAString.substring(0,
          Math.min(indexOfComma + decimals,
              resultAsAString.length()));
      return Double.parseDouble(resultAsAString);
    }
    return value;
  }

  @Override
  public String toString()
  {
    return getStatus();
  }

  public String getStatus()
  {
    String right = "";
    String left = "" + round(leftValue, 12);
    if (left.endsWith(".0"))
    {
      left = left.substring(0, left.length() - 2);
    }
    if (state == 0)
    {
      return "0";
    }
    else if (state == 1)
    {
      right = rightValueAsString;
      if (right.startsWith("-"))
      {
        right = "(" + right + ")";
      }
      if (operator != '?')
      {
        left = "" + round(leftValue, 12);
        if (left.endsWith(".0"))
        {
          left = left.substring(0, left.length() - 2);
        }
        if (operator != '=')
        {
          return left + " " + operator + " " + right;
        }
        else
        {
          return operator + " " + left;
        }
      }
      else
      {
        return rightValueAsString;
      }
    }
    else if (state == 2)
    {
      return left + " " + operator;
    }
    else // if (state == 3)
    {
      return "= " + left;
    }
  }
}
