/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author Akatsuki
 */

import java.util.Scanner; //scanner class use to scan administrator's input
public class assignment1 {
    public static void main(String[]arg)
    {   
        String name, identityCardNo, bloodType, weightStatus, dob, gender="";
        String s_height,s_weight; //store height and weight in string datatype in order to validate that administrator input is a valid number
        double height=0, weight=0;
        char decision; //administrator's decision to continue key in next patient's details or not
        boolean validName=false, validIC=false, validHeight, validWeight, validBloodType, validDecision; //for input validation
        boolean heightNumeric=true,weightNumeric=true; //for weight and height input validation (try catch)
        Scanner sc = new Scanner(System.in);
        do
        {
        System.out.println("Please enter the patient's details.");
        do
        {
        System.out.print("Name: ");
        name = sc.nextLine();
        if (name.isBlank()==true) //check if the name input is blank
                {
                    System.out.print("Invalid name, it should not be blank.\nPlease input again.\n");
                    validName=false;
                }
        else
                {
                    for (int i=0;i<name.length();i++) //checking if the name only contain space and alphabet
                    {
                        char character = name.charAt(i);
                        if (!Character.isLetter(character) && !Character.isWhitespace(character))  
                            {
                                System.out.print("Invalid name, it should not contain special characters or numbers.\nPlease input again.\n");
                                validName=false;
                                break;
                            }
                        else
                        {validName=true;}
                    }
                
                }
        }while(validName==false);
        do
        {
        System.out.print("Identity card number(no dash needed): ");
        identityCardNo = sc.nextLine();
        if(identityCardNo.length()!=12) //ic validation, ic must contain 12 digits
        {
            System.out.print("Invalid IC, it should contain 12 digits.\nPlease input again.\n");
            validIC=false;
        }
        else
        {
            for (int i=0;i<12;i++) //checking if the identityCardNo only contain numbers
            {
                char chara = identityCardNo.charAt(i);
                if (!Character.isDigit(chara))  
                    {
                        System.out.print("Invalid IC, it should contain only numbers.\nPlease input again.\n");
                        validIC=false;
                        break;
                    }
                else
                {validIC=true;}
            }
        }
         
        }while(validIC==false);
        dob =identityCardNo.substring(4,6)+"/"
                +identityCardNo.substring(2,4)+"/"
                +identityCardNo.substring(0,2);         //store dob in format of DD/MM/YY
        if(identityCardNo.charAt(11)%2!=0)      //last digit even number is female, odd number is male
        {
           gender = "Male";
        }
        else
        {
            gender = "Female";
        }
        do
        {
        System.out.print("Height(in meter): ");
        s_height = sc.nextLine();
        try //check if the height input by administrator is number
        {
          height = Double.parseDouble(s_height);  //convert string to numeric type
        }
        catch (NumberFormatException e) //indicate the string is not in numeric format
        {
          heightNumeric=false;
        }
        if(heightNumeric==true) //validate true height value which should not be negative or zero or higher than 3m.
        {
            if (height>0 && height<=3)
            {
                validHeight=true;
            }
            else
            {
                System.out.print("Invalid height, it should not be negative value or higher than 3m.\nPlease input again.\n");
                validHeight=false;
            }
        }
        else
        {
            System.out.print("Invalid height, please enter a valid height which is a number.\n");
            validHeight=false;
            heightNumeric=true; //reset heightNumeric to true for try catch
        }
        }while(validHeight==false);
        do
        {
        System.out.print("Weight(in kilogram): ");
        s_weight = sc.nextLine();
        try //check if the weight input by administrator is number
        {
          weight = Double.parseDouble(s_weight);  //convert string to numeric type
        }
        catch (NumberFormatException e) //indicate the string is not in numeric format
        {
          weightNumeric=false;
        }
        if(weightNumeric==true)
        {
            if (weight>0 && weight<=640 ) //validate true weight value which should not be negative or zero or heavier than 640kg.
            {   
                validWeight=true;
            }
            else
            {
                System.out.print("Invalid weight, it should not be 0 or lower than 0 or heavier than 640kg.\nPlease input again.\n");
                validWeight=false;
            }
        }    
        else
        {       
                System.out.print("Invalid weight, please enter a valid height which is a number.\n");
                validWeight=false;
                weightNumeric=true; //reset weightNumeric to true for try catch
        }
        }while(validWeight==false);
        do
        {
        System.out.print("Blood type(A+,A-,B+,B-,O+,O-,AB+,AB-): ");
        bloodType = sc.nextLine();
        if(bloodType.equals("A+") || bloodType.equals("A-")|| 
                bloodType.equals("B+")|| bloodType.equals("B-")|| 
                bloodType.equals("O+")|| bloodType.equals("O-")|| 
                bloodType.equals("AB+")|| bloodType.equals("AB-"))   //validate blood type input
        {   
            validBloodType=true;
        }
        else
        {
            System.out.print("Invalid blood type.\nPlease input again.\n");
            validBloodType=false;
        }
        }while (validBloodType==false);
        double bmi=weight/(Math.pow(height,2));         //calculate bmi value
        if(bmi>=30)     //assigning weight status
        {
            weightStatus="Obese";
        }
        else if(bmi<30 && bmi>=25)
        {
            weightStatus="Overweight";
        }
        else if(bmi<25 && bmi>=18.5)
        {
            weightStatus="Healthy Weight";
        }
        else
        {
             weightStatus="Underweight";
        }
        System.out.println("=============================================");    //print out patient's information
        System.out.println("Name: \t\t\t "+name);
        System.out.println("Identity card number:    "+identityCardNo);
        System.out.printf("Height: \t\t %.2f m",height);
        System.out.printf("\nWeight: \t\t %.1f kg",weight);
        System.out.println("\nBlood type: \t\t "+bloodType);
        System.out.println("Date of birth[DD/MM/YY]: "+dob);
        System.out.println("Gender: \t\t "+gender);
        System.out.printf("BMI: \t\t\t %.1f",bmi);
        System.out.println("\nWeight status: \t\t "+weightStatus);
        System.out.println("=============================================");
        do
        {
        System.out.print("Continue for the next patient's details?[Y/N]: ");    //asking if administrator want to continue for the next patient's details
        decision = sc.next().charAt(0);
        sc.nextLine(); // Consume newline left-over
        if(decision!='Y'&& decision!='y'&&decision!='N'&&decision!='n')
        {
            System.out.println("Invalid input, please key in either Y or N.");
            validDecision=false;
        }
        else
        {
            validDecision=true;
        }
        }while(validDecision==false);
        }while(decision=='Y'||decision=='y');
    }
}
