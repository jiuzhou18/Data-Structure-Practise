package lab02;

import java.text.DecimalFormat;
public class FullTimeEmployee implements Employee
{
private String name;
private double grossPay;
/**
* Initializes this FullTimeEmployee object to have an empty string for the
* name and 0.00 for the gross pay.
*
*/
public FullTimeEmployee()
{
final String EMPTY_STRING = "";
name = EMPTY_STRING;
grossPay = 0.00;
} // default constructor
/**
* Initializes this FullTimeEmployee object¡¯s name and gross pay from a
* a specified name and gross pay.
*
* @param name - the specified name.
* @param grossPay - the specified gross pay.
*
*/
public FullTimeEmployee (String name, double grossPay)
{
this.name = name;
this.grossPay = grossPay;
} // 2-parameter constructor
/**
* Returns the name of this FullTimeEmployee object.
*
* @return the name of this FullTimeEmployee object.
*
*/
public String getName()
{return name;
} // method getName
/**
* Returns the gross pay of this FullTimeEmployee object.
*
* @return the gross pay of this FullTimeEmployee object.
*
*/
public double getGrossPay()
{
return grossPay;
} // method getGrossPay
/**
* Returns a String representation of this FullTimeEmployee object with the
* name followed by a space followed by a dollar sign followed by the gross
* weekly pay, with two fractional digits (rounded), followed by "FULL TIME".
*
* @return a String representation of this FullTimeEmployee object.
*
*/
public String toString()
{
final String EMPLOYMENT_STATUS = "FULL TIME";
return name + MONEY.format (grossPay) + EMPLOYMENT_STATUS;
// the format method returns a String representation of grossPay.
} // method toString
public boolean equals (FullTimeEmployee full)
{
	if(full == null && this == null) return true;
	else if(full == null) return false;
	else if(this == null) return false;
	return name.equals (full.name) && MONEY.format (grossPay).equals (MONEY.format (full.grossPay));
} // overloading method equals
} // class FullTimeEmployee